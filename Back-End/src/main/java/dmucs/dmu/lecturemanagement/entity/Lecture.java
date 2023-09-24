package dmucs.dmu.lecturemanagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class Lecture {
    @EmbeddedId
    private LectureId lectureId;
    @Column(name = "lectureroom")
    @ManyToOne
    private Lectureroom lectureroom;
    @Column(name = "startTime")
    private LocalTime startTime;
    @Column(name = "endTime")
    private LocalTime endTime;

    @Embeddable
    public class LectureId implements Serializable {
        private String name;
        private int year;
        private int quarter; // 1분기 2분기
        private int classCode; // 3-YC
    }
}
