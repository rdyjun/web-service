package dmucs.dmu.openclassroom.entity;

import dmucs.dmu.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "openClassroom")
public class OpenClassroomReservation implements Serializable {
    @Id @JoinColumn(name = "rentalId")
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ClassroomReservation classroomReservation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberCode")
    private Member member;
    @Column(name = "purpose")
    private String purpose;
}
