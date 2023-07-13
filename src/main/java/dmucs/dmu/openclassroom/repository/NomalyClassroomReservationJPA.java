package dmucs.dmu.openclassroom.repository;

import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.NomalyClassRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomalyClassroomReservationJPA extends JpaRepository<NomalyClassRoomReservation, ClassroomReservation> {

}
