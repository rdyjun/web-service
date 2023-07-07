package dmucs.dmu.openclassroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
public class ClassroomReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "roomId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom roomId;
    @Column(name = "rentalDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Seoul")
    private Date date;
    @Column(name = "rentalType")
    private String type;
}
