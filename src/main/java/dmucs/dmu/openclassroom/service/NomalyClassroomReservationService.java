package dmucs.dmu.openclassroom.service;

import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.NomalyClassroomReservation;
import dmucs.dmu.openclassroom.repository.NomalyClassroomReservationJPA;
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
