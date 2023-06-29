package dmucs.dmu.classroom.entity;

import dmucs.dmu.member.entity.Member;

import java.io.Serializable;
import java.sql.Date;

public class ClassRoomReservationKey implements Serializable {
    private Member member;
    private Date date;
}
