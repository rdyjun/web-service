package dmucs.dmu.classroom.service;

import dmucs.dmu.classroom.dto.ClassRoomReservationDTO;
import dmucs.dmu.classroom.entity.ClassRoomReservation;
import dmucs.dmu.classroom.entity.ClassRoomReservationKey;
import dmucs.dmu.classroom.repository.ClassRoomReservationJpa;
import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassRoomReservationService {
    private final JpaMemberRepository jpaMemberRepository;
    private final ClassRoomReservationJpa classRoomReservationJpa;
    public void reservationToRoom (ClassRoomReservationDTO classRoomReservationDTO) throws ParseException {
        Optional<Member> member = jpaMemberRepository.findById(classRoomReservationDTO.getMemberCode());
        if (member.isEmpty()) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ClassRoomReservationKey classRoomReservationKey = new ClassRoomReservationKey(member.get(), formatter.parse(classRoomReservationDTO.getDate()));

        ClassRoomReservation classRoomReservation = new ClassRoomReservation(
                classRoomReservationKey,
                classRoomReservationDTO.getRoomNumber(),
                classRoomReservationDTO.getCategory(),
                classRoomReservationDTO.getPurpose());
        validateDuplicateManager(classRoomReservationKey);
        classRoomReservationJpa.save(classRoomReservation);
    }
    public void validateDuplicateManager (ClassRoomReservationKey classRoomReservationKey) {
        classRoomReservationJpa.findById(classRoomReservationKey).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 예약입니다.");
        });
    }
}
