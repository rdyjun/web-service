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
@Table(name = "classroomReservation")
@IdClass(ClassRoomReservationKey.class)
public class ClassRoomReservation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberCode")
    private Member member;
    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date date;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "category")
    private String category;
    @Column(name = "purpose")
    private String purpose;

    public ClassRoomReservation (ClassRoomReservationKey classRoomReservationKey, String roomNumber, String category, String purpose) {
        this.member = classRoomReservationKey.getMember();
        this.date = classRoomReservationKey.getDate();
        this.roomNumber = roomNumber;
        this.category = category;
        this.purpose = purpose;
    }
}
