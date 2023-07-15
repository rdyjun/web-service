package dmucs.dmu.classroomreservation.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "normal_classroom")

public class NomalyClassroomReservation {
    @Id
    private Long id;

    @JoinColumn(name = "rentalId")
    @OneToOne
    @MapsId
    private ClassroomReservation classroomReservation;
    @Column(name = "purpose")
    private String purpose;

    public NomalyClassroomReservation (ClassroomReservation classroomReservation, String purpose) {
        this.classroomReservation = classroomReservation;
        this.purpose = purpose;
    }
}
