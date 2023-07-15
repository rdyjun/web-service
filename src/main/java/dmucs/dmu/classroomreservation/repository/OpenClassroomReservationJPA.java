package dmucs.dmu.classroomreservation.repository;

import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.OpenClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpenClassroomReservationJPA extends JpaRepository<OpenClassroomReservation, ClassroomReservation> {
    Optional<OpenClassroomReservation> findById(ClassroomReservation classroomReservation);
}
