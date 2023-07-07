package dmucs.dmu.openclassroom.repository;

import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpenClassRoomReservationJPA extends JpaRepository<OpenClassRoomReservation, ClassroomReservation> {
    Optional<OpenClassRoomReservation> findById(ClassroomReservation classroomReservation);
}
