package dmucs.dmu.lecturemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Lectureroom {
    @Id @Column(name = "roomId")
    private String classroomId;
    @Column(name = "classStatus")
    private boolean classroomStatus;
}
