package dmucs.dmu.openclassroom.controller;

import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import dmucs.dmu.openclassroom.service.ClassroomReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Api(value="ApiController v1")
@RestController
@RequiredArgsConstructor
public class OpenClassReservationController {
    private final ClassroomReservationService classRoomReservationService;
    @ApiOperation(value = "공개 강의실 대여", notes = "공개 강의실 대여에 대한 정보 저장")
    @PostMapping("/reservation-room")
    public void saveClassReservation (@RequestBody ClassroomReservationDTO classRoomReservationDTO) throws ParseException {
        classRoomReservationService.reservationToRoom(classRoomReservationDTO);
    }
}
