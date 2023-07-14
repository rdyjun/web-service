package dmucs.dmu.openclassroom.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "normal_classroom")
public class NomalyClassroomReservation implements Serializable {
    @Id @JoinColumn(name = "rentalId")
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ClassroomReservation classroomReservation;
    @Column(name = "purpose")
    private String purpose;
}
