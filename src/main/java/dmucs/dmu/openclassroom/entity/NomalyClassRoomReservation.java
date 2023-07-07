package dmucs.dmu.openclassroom.entity;

import javax.persistence.*;

@Entity
public class NomalyClassRoomReservation {
    @Id @Column(name = "rentalId")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClassroomReservation classroomReservation;
    @Column(name = "orgId")
    private String orgId;
    @Column(name = "purpose")
    private String purpose;
}
