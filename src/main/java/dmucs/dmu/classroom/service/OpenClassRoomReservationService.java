package dmucs.dmu.classroom.service;

import dmucs.dmu.classroom.dto.OpenClassRoomReservationDTO;
import dmucs.dmu.classroom.entity.OpenClassRoomReservation;
import dmucs.dmu.classroom.entity.OpenClassRoomReservationKey;
import dmucs.dmu.classroom.repository.OpenClassRoomReservationJpa;
import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OpenClassRoomReservationService {
    private final JpaMemberRepository jpaMemberRepository;
    private final OpenClassRoomReservationJpa classRoomReservationJpa;
    public void reservationToRoom (OpenClassRoomReservationDTO classRoomReservationDTO) throws ParseException {
        Optional<Member> member = jpaMemberRepository.findById(classRoomReservationDTO.getMemberCode());
        if (member.isEmpty()) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        OpenClassRoomReservationKey classRoomReservationKey = new OpenClassRoomReservationKey(member.get().getMemberCode(), formatter.parse(classRoomReservationDTO.getDate()));

        OpenClassRoomReservation classRoomReservation = new OpenClassRoomReservation(
                member.get(),
                classRoomReservationKey.getDate(),
                classRoomReservationDTO.getRoomNumber(),
                classRoomReservationDTO.getCategory(),
                classRoomReservationDTO.getPurpose());
        validateDuplicateManager(classRoomReservationKey);
        classRoomReservationJpa.save(classRoomReservation);
    }
    public void validateDuplicateManager (OpenClassRoomReservationKey classRoomReservationKey) {
        classRoomReservationJpa.findById(classRoomReservationKey).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 예약입니다.");
        });
    }
}
