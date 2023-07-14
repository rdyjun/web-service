package dmucs.dmu.openclassroom.service;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import dmucs.dmu.openclassroom.entity.Classroom;
import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.repository.ClassroomReservationJPA;
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
    private final OpenClassroomReservationService openClassroomReservationService;
    private final NomalyClassroomReservationService nomalyClassroomReservationService;
    public ClassroomReservation reservationToRoom (ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(classroomReservationDTO.getDate());
        ClassroomReservation classroomReservation = new ClassroomReservation(
                0L,
                new Classroom(classroomReservationDTO.getRoomId(), false),
                date,
                classroomReservationDTO.getType()
        );
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
}
