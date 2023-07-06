package dmucs.dmu.openclassroom.repository;

import dmucs.dmu.openclassroom.entity.OpenClassRoomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassRoomReservationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpenClassRoomReservationJpa extends JpaRepository<OpenClassRoomReservation, OpenClassRoomReservationKey> {
    Optional<OpenClassRoomReservation> findById(OpenClassRoomReservationKey classRoomReservationKey);
}
