package dmucs.dmu.classroom.entity;

import dmucs.dmu.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomReservationKey implements Serializable {
    private Member member;
    private Date date;
}
