package dmucs.dmu.classroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OpenClassRoomReservationKey implements Serializable {
    private Long member;
    private Date date;
}
