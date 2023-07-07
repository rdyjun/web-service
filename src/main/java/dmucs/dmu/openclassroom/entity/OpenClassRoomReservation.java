package dmucs.dmu.openclassroom.entity;

import dmucs.dmu.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classroomReservation")
public class OpenClassRoomReservation {
    @Id @Column(name = "rentalId")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClassroomReservation classroomReservation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberCode")
    private Member member;
    @Column(name = "purpose")
    private String purpose;
}
