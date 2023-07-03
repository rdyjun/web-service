package dmucs.dmu.classroom.repository;

import dmucs.dmu.classroom.entity.OpenClassRoomReservation;
import dmucs.dmu.classroom.entity.OpenClassRoomReservationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpenClassRoomReservationJpa extends JpaRepository<OpenClassRoomReservation, OpenClassRoomReservationKey> {
    Optional<OpenClassRoomReservation> findById(OpenClassRoomReservationKey classRoomReservationKey);
}
