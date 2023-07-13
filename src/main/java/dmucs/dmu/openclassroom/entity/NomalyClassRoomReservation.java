package dmucs.dmu.openclassroom.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "normal_classroom")
public class NomalyClassRoomReservation {
    @Id @Column(name = "rentalId")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClassroomReservation classroomReservation;
    @Column(name = "purpose")
    private String purpose;
}
