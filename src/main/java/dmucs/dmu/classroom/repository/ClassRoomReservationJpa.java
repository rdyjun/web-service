package dmucs.dmu.classroom.repository;

import dmucs.dmu.classroom.entity.ClassRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomReservationJpa extends JpaRepository<ClassRoomReservation, Long>  {

}
