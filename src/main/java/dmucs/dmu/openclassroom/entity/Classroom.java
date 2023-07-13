package dmucs.dmu.openclassroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Classroom {
    @Id @Column(name = "rentalId")
    private String classroomId;
    @Column(name = "classStatus")
    private boolean classroomStatus;
}
