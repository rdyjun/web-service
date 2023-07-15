package dmucs.dmu.classroomreservation.entity;

import dmucs.dmu.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "openClassroom")
public class OpenClassroomReservation{
    @Id
    private Long id;
    @JoinColumn(name = "rentalId")
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ClassroomReservation classroomReservation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberCode")
    private Member member;
    @Column(name = "purpose")
    private String purpose;

    public OpenClassroomReservation (ClassroomReservation classroomReservation, Member member, String purpose) {
        this.classroomReservation = classroomReservation;
        this.member = member;
        this.purpose = purpose;
    }
}
