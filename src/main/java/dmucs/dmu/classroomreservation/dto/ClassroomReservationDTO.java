package dmucs.dmu.classroomreservation.dto;

import dmucs.dmu.classroomreservation.entity.RentalType;
import lombok.Getter;

@Getter
public class ClassroomReservationDTO {

    private String roomId;
    private String date;
    private RentalType type;
    private String purpose;
    private Long memberCode;
}
