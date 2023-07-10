package dmucs.dmu.openclassroom.service;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.repository.JpaMemberRepository;
import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassroomReservation;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.Optional;


@RequiredArgsConstructor
public class OpenClassroomReservationService {
    private final JpaMemberRepository jpaMemberRepository;
    public void reservationToRoom (ClassroomReservation classroomReservation) throws ParseException {
        OpenClassroomReservation classRoomReservation = new OpenClassroomReservation(
                member.get(),
                classRoomReservationKey.getDate(),
                classRoomReservationDTO.getRoomNumber(),
                classRoomReservationDTO.getCategory(),
                classRoomReservationDTO.getPurpose());
        validateDuplicateManager(classRoomReservationKey);
        classRoomReservationJpa.save(classRoomReservation);
    }
    public boolean checked(ClassroomReservationDTO classroomReservationDTO) {
        Optional<Member> member = jpaMemberRepository.findById(classroomReservationDTO.getMemberCode());
        if (member.isEmpty()) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return true;
    }
}
