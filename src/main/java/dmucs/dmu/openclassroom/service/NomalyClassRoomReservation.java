package dmucs.dmu.openclassroom.service;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NomalyClassRoomReservation {
    public boolean checked(ClassroomReservationDTO classroomReservationDTO) {
        Optional<Member> member = jpaMemberRepository.findById(classroomReservationDTO.getMemberCode());
        if (member.isEmpty()) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return true;
    }
}
