package dmucs.dmu.classroomreservation.service;

import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.Classroom;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.RentalType;
import dmucs.dmu.classroomreservation.repository.ClassroomReservationJPA;
import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.repository.JpaMemberRepository;
import dmucs.dmu.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassroomReservationService {
    private final ClassroomReservationJPA classroomReservationJPA;
    private final JpaMemberRepository jpaMemberRepository;
    private final MemberService memberService;
    public ClassroomReservation reservationToRoom (ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(classroomReservationDTO.getDate());

        if (classroomReservationDTO.getType() == RentalType.OPEN) {
            if (memberService.isMemberPresent(classroomReservationDTO.getMemberCode())) {
                if (isNotDuplicated(date, reservationer)) {
                    ClassroomReservation classroomReservation = new ClassroomReservation(
                            0L,
                            new Classroom(classroomReservationDTO.getRoomId(), false),
                            date,
                            classroomReservationDTO.getType(),
                            reservationer,
                            classroomReservationDTO.getPurpose()
                    );
                } else {
                    ClassroomReservation classroomReservation = new ClassroomReservation(
                            0L,
                            new Classroom(classroomReservationDTO.getRoomId(), false),
                            date,
                            classroomReservationDTO.getType(),
                            null,
                            classroomReservationDTO.getPurpose()
                    );
                }
                } else {
                    throw new IllegalStateException("해당 날짜에 이미 대여한 기록이 존재합니다.");
                }
            } else {
                throw new IllegalStateException("요청한 회원이 존재하지 않습니다.");
            }

        return classroomReservationJPA.save(classroomReservation);
    }
    public ArrayList<ClassroomReservation> findByDate(Date date) {
        ArrayList<ClassroomReservation> arr = new ArrayList<>();
        for (Optional<ClassroomReservation> cr : classroomReservationJPA.findByDate(date)) {
            if (cr.isPresent())
                arr.add(cr.get());
            else
                break;
        }
        return arr;
    }
    public ArrayList<ClassroomReservation> getClassByDateAndClassId (Date date, String classId) {
        ArrayList<ClassroomReservation> arr = new ArrayList<>();
        for (Optional<ClassroomReservation> cr : classroomReservationJPA.findByDateAndRoomId(date, classId)) {
            if (cr.isPresent())
                arr.add(cr.get());
            else
                break;
        }
        return arr;
    }
    public boolean isNotDuplicated (Date date, Member member) {
        ArrayList<ClassroomReservation> classroomReservationArrayList = classroomReservationService.findByDate(date);
        for (ClassroomReservation cr : classroomReservationArrayList) {
            Optional<ClassroomReservation> opcls = ClassroomReservationJPA.findById(cr);
            if (opcls.isPresent() && opcls.get().getMember().getMemberCode().equals(member.getMemberCode())) {
                return true;
            }
        }
        return false;
    }
}
