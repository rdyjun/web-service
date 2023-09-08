package dmucs.dmu.classroommanagement.dto;

import dmucs.dmu.classroommanagement.entity.ClassroomReservation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Getter
@NoArgsConstructor
public class ClassroomReservationDTO {

    private String roomId;
    private String date;
    private String type;
    private String purpose;
    private Long memberCode;

    public ClassroomReservationDTO (ClassroomReservation classroomReservation) {
        this.roomId = classroomReservation.getRoomId().getClassroomId();
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(classroomReservation.getDate());
        this.type = classroomReservation.getType().toString();
        this.purpose = classroomReservation.getPurpose();
        this.memberCode = classroomReservation.getMember().getMemberCode();
    }
}
