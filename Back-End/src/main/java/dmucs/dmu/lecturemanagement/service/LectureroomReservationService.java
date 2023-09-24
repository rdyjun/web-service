package dmucs.dmu.lecturemanagement.service;

import dmucs.dmu.lecturemanagement.dto.LectureroomReservationDTO;
import dmucs.dmu.lecturemanagement.entity.Lectureroom;
import dmucs.dmu.lecturemanagement.entity.LectureroomReservation;
import dmucs.dmu.lecturemanagement.entity.RentalType;
import dmucs.dmu.lecturemanagement.repository.LectureroomReservationJPA;
import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class LectureroomReservationService {
    private final LectureroomReservationJPA classroomReservationJPA;
    private final MemberService memberService;
    @Transactional
    public void reservationToRoom (LectureroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(classroomReservationDTO.getDate());
        LectureroomReservation classroomReservation;

        if (RentalType.valueOf(classroomReservationDTO.getType()) == RentalType.OPEN) {
            Member member = memberService.getMemberById(classroomReservationDTO.getMemberCode());
            reservationDuplicateManager(date, member);
            classroomReservation = new LectureroomReservation(
                    0L,
                    new Lectureroom(classroomReservationDTO.getRoomId(), false),
                    date,
                    RentalType.valueOf(classroomReservationDTO.getType()),
                    member,
                    classroomReservationDTO.getPurpose()
            );
        } else {
            classroomReservation = new LectureroomReservation(
                0L,
                new Lectureroom(classroomReservationDTO.getRoomId(), false),
                date,
                RentalType.valueOf(classroomReservationDTO.getType()),
                null,
                classroomReservationDTO.getPurpose()
            );
        }

        classroomReservationJPA.save(classroomReservation);
    }
    /** 날짜에 따른 특정 강의실 대여 정보 반환*/
    public ArrayList<LectureroomReservation> getByDateAndClassIdAndType(Date date, Lectureroom roomId, RentalType type) {
        return classroomReservationJPA.findByDateAndRoomIdAndType(date, roomId, type);
    }

    /** [공개 강의실] 날짜와 회원 기록을 조회 */
    public void reservationDuplicateManager (Date date, Member memberId) {
        if (classroomReservationJPA.findByMemberAndDate(memberId, date).isPresent())
            throw new IllegalStateException("해당 날짜에 대여한 기록이 존재합니다.");
    }

    public ArrayList<LectureroomReservationDTO> getClassReservationList (LectureroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = format.parse(classroomReservationDTO.getDate());
        ArrayList<LectureroomReservationDTO> classroomReservationDTOS = new ArrayList<>();
        for (LectureroomReservation c : getByDateAndClassIdAndType(
                date,
                new Lectureroom(classroomReservationDTO.getRoomId(), false),
                RentalType.OPEN)) {
            classroomReservationDTOS.add(new LectureroomReservationDTO(c));
        }
        return classroomReservationDTOS;
    }
}
