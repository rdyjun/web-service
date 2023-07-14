package dmucs.dmu.openclassroom.repository;

import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.NomalyClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomalyClassroomReservationJPA extends JpaRepository<NomalyClassroomReservation, ClassroomReservation> {

}
