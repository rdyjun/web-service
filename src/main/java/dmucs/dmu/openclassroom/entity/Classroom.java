package dmucs.dmu.openclassroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
public class Classroom {
    @Id
    private String classroomId;
}
