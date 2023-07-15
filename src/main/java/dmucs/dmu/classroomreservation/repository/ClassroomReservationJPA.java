package dmucs.dmu.classroomreservation.repository;

import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ClassroomReservationJPA extends JpaRepository<ClassroomReservation, Long> {
    @Query("SELECT s FROM ClassroomReservation s WHERE FUNCTION('DATE', s.date) = :date")
    ArrayList<Optional<ClassroomReservation>> findByDate(@Param("date") Date date);

    @Query("SELECT s FROM ClassroomReservation s WHERE FUNCTION('DATE', s.date) = :date and s.roomId = :roomId")
    ArrayList<Optional<ClassroomReservation>> findByDateAndRoomId(@Param("date") Date date, @Param("roomId") String roomId);
}
