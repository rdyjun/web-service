package dmucs.dmu.openclassroom.repository;

import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomReservationJPA extends JpaRepository<ClassroomReservation, Long> {
}
