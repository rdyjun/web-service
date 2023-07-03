package dmucs.dmu.classroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dmucs.dmu.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classroomReservation")
@IdClass(OpenClassRoomReservationKey.class)
public class OpenClassRoomReservation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberCode")
    private Member member;
    @Id @Column(name = "rentalDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Seoul")
    private Date date;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "category")
    private String category;
    @Column(name = "purpose")
    private String purpose;

}
