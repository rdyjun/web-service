package dmucs.dmu.openclassroom.dto;

import lombok.Getter;

@Getter
public class ClassroomReservationDTO {

    private Long memberCode;
    private String date;
    private String roomId;
    private String type;
    private String purpose;
}
