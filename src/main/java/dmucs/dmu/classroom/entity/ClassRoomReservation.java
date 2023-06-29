package dmucs.dmu.classroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dmucs.dmu.member.entity.Member;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
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

}
