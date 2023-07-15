package dmucs.dmu.classroomreservation.service;

import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.Classroom;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.repository.ClassroomReservationJPA;
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
