package dmucs.dmu.classroomreservation.repository;

import dmucs.dmu.classroomreservation.entity.Classroom;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.RentalType;
import dmucs.dmu.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ClassroomReservationJPA extends JpaRepository<ClassroomReservation, Long> {
    @Query("SELECT s FROM ClassroomReservation s WHERE DATE(s.date) = DATE(:date) and s.roomId = :roomId and s.type = :type")
    ArrayList<ClassroomReservation>findByDateAndRoomIdAndType(@Param("date") Date date, @Param("roomId") Classroom roomId, @Param("type") RentalType type);
    @Query("SELECT s FROM ClassroomReservation s WHERE DATE(s.date) = DATE(:date) and s.member = :member")
    Optional<ClassroomReservation> findByMemberAndDate(@Param("member") Member member, @Param("date") Date date);
}
