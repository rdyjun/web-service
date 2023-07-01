package dmucs.dmu.classroom.repository;

import dmucs.dmu.classroom.entity.ClassRoomReservation;
import dmucs.dmu.classroom.entity.ClassRoomReservationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRoomReservationJpa extends JpaRepository<ClassRoomReservation, ClassRoomReservationKey> {
    Optional<ClassRoomReservation> findById(ClassRoomReservationKey classRoomReservationKey);
}
