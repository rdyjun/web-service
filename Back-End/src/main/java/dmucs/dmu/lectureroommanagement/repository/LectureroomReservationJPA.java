package dmucs.dmu.lectureroommanagement.repository;

import dmucs.dmu.lectureroommanagement.entity.Lectureroom;
import dmucs.dmu.lectureroommanagement.entity.LectureroomReservation;
import dmucs.dmu.lectureroommanagement.entity.RentalType;
import dmucs.dmu.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface LectureroomReservationJPA extends JpaRepository<LectureroomReservation, Long> {
    @Query("SELECT s FROM LectureroomReservation s WHERE DATE(s.date) = DATE(:date) and s.roomId = :roomId and s.type = :type")
    ArrayList<LectureroomReservation>findByDateAndRoomIdAndType(@Param("date") Date date, @Param("roomId") Lectureroom roomId, @Param("type") RentalType type);
    @Query("SELECT s FROM LectureroomReservation s WHERE DATE(s.date) = DATE(:date) and s.member = :member")
    Optional<LectureroomReservation> findByMemberAndDate(@Param("member") Member member, @Param("date") Date date);
}
