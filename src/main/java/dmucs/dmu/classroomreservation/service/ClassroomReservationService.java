package dmucs.dmu.classroomreservation.service;

import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.Classroom;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.RentalType;
import dmucs.dmu.classroomreservation.repository.ClassroomReservationJPA;
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
public class ClassroomReservationService {
    private final ClassroomReservationJPA classroomReservationJPA;
    private final MemberService memberService;
    @Transactional
    public void reservationToRoom (ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(classroomReservationDTO.getDate());
        ClassroomReservation classroomReservation;

        if (RentalType.valueOf(classroomReservationDTO.getType()) == RentalType.OPEN) {
            Member member = memberService.getMemberById(classroomReservationDTO.getMemberCode());
            reservationDuplicateManager(date, member);
            classroomReservation = new ClassroomReservation(
                    0L,
                    new Classroom(classroomReservationDTO.getRoomId(), false),
                    date,
                    RentalType.valueOf(classroomReservationDTO.getType()),
                    member,
                    classroomReservationDTO.getPurpose()
            );
        } else {
            classroomReservation = new ClassroomReservation(
                0L,
                new Classroom(classroomReservationDTO.getRoomId(), false),
                date,
                RentalType.valueOf(classroomReservationDTO.getType()),
                null,
                classroomReservationDTO.getPurpose()
            );
        }

        classroomReservationJPA.save(classroomReservation);
    }
    /** 날짜에 따른 특정 강의실 대여 정보 반환*/
    public ArrayList<ClassroomReservation> getByDateAndClassIdAndType(Date date, Classroom roomId, RentalType type) {
        return classroomReservationJPA.findByDateAndRoomIdAndType(date, roomId, type);
    }

    /** [공개 강의실] 날짜와 회원 기록을 조회 */
    public void reservationDuplicateManager (Date date, Member memberId) {
        if (classroomReservationJPA.findByMemberAndDate(memberId, date).isPresent())
            throw new IllegalStateException("해당 날짜에 대여한 기록이 존재합니다.");
    }

    public ArrayList<ClassroomReservationDTO> getClassReservationList (ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = format.parse(classroomReservationDTO.getDate());
        ArrayList<ClassroomReservationDTO> classroomReservationDTOS = new ArrayList<>();
        for (ClassroomReservation c : getByDateAndClassIdAndType(
                date,
                new Classroom(classroomReservationDTO.getRoomId(), false),
                RentalType.OPEN)) {
            classroomReservationDTOS.add(new ClassroomReservationDTO(c));
        }
        return classroomReservationDTOS;
    }
}
