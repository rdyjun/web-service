package dmucs.dmu.openclassroom.repository;

import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpenClassroomReservationJPA extends JpaRepository<OpenClassroomReservation, ClassroomReservation> {
    Optional<OpenClassroomReservation> findById(ClassroomReservation classroomReservation);
}
