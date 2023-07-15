package dmucs.dmu.classroomreservation.service;

import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.NomalyClassroomReservation;
import dmucs.dmu.classroomreservation.repository.NomalyClassroomReservationJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NomalyClassroomReservationService {
    private final NomalyClassroomReservationJPA nomalyClassroomReservationJPA;
    public void reservationToRoom (ClassroomReservation classroomReservation, String purpose) {
        NomalyClassroomReservation nomalyClassroomReservation = new NomalyClassroomReservation(
                classroomReservation,
                purpose
        );
        nomalyClassroomReservationJPA.save(nomalyClassroomReservation);
    }
}
