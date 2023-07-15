package dmucs.dmu.classroomreservation.repository;

import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.OpenClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpenClassroomReservationJPA extends JpaRepository<OpenClassroomReservation, ClassroomReservation> {
    Optional<OpenClassroomReservation> findById(ClassroomReservation classroomReservation);
}
