package dmucs.dmu.classroomreservation.service;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.repository.JpaMemberRepository;
import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.OpenClassroomReservation;
import dmucs.dmu.classroomreservation.repository.OpenClassroomReservationJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OpenClassroomReservationService {
    private final JpaMemberRepository jpaMemberRepository;
    private final ClassroomReservationService classroomReservationService;
    private final OpenClassroomReservationJPA openClassroomReservationJPA;
    public void reservationToRoom (ClassroomReservation classroomReservation, ClassroomReservationDTO classroomReservationDTO) {
        Member reservationer = checked(classroomReservationDTO);
        if (isNotDuplicate(classroomReservation.getDate(), reservationer)) {
            OpenClassroomReservation openClassroomReservation = new OpenClassroomReservation(
                    classroomReservation,
                    reservationer,
                    classroomReservationDTO.getPurpose()
            );
            openClassroomReservationJPA.save(openClassroomReservation);
        } else {
            throw new IllegalStateException("해당 날짜에 이미 대여한 기록이 존재합니다.");
        }

    }
    public boolean isNotDuplicate (Date date, Member member) {
        ArrayList<ClassroomReservation> classroomReservationArrayList = classroomReservationService.findByDate(date);
        for (ClassroomReservation cr : classroomReservationArrayList) {
            Optional<OpenClassroomReservation> opcls = openClassroomReservationJPA.findById(cr);
            if (opcls.isPresent() && opcls.get().getMember().getMemberCode().equals(member.getMemberCode())) {
                return true;
            }
        }
        return false;
    }
    public Member checked(ClassroomReservationDTO classroomReservationDTO) {
        Optional<Member> member = jpaMemberRepository.findById(classroomReservationDTO.getMemberCode());
        if (member.isEmpty())
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        return member.get();
    }
}
