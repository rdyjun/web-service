package dmucs.dmu.classroomreservation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dmucs.dmu.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rental")
public class ClassroomReservation implements Serializable {
    @Id @Column(name = "rental_id", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "roomId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom roomId;
    @Column(name = "rentalDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Seoul")
    private Date date;
    @Column(name = "rentalType")
    @Enumerated(EnumType.STRING)
    private RentalType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberCode")
    private Member member;
    @Column(name = "purpose")
    private String purpose;
}
