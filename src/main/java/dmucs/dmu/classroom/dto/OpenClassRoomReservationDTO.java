package dmucs.dmu.classroom.dto;

public class OpenClassRoomReservationDTO {

    private Long memberCode;
    private String date;
    private String roomNumber;
    private String category;
    private String purpose;

    public Long getMemberCode() {
        return memberCode;
    }

    public String getDate() {
        return date;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getPurpose() {
        return purpose;
    }
}
