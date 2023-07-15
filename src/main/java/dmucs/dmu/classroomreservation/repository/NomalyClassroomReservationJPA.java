package dmucs.dmu.classroomreservation.repository;

import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.NomalyClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomalyClassroomReservationJPA extends JpaRepository<NomalyClassroomReservation, ClassroomReservation> {

}
