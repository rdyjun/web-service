package dmucs.dmu.classroom.controller;

import dmucs.dmu.classroom.dto.OpenClassRoomReservationDTO;
import dmucs.dmu.classroom.service.OpenClassRoomReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
public class OpenClassReservationController {
    private final OpenClassRoomReservationService classRoomReservationService;
    @PostMapping
    @RequestMapping("/reservation-room")
    public void saveClassReservation (@RequestBody OpenClassRoomReservationDTO classRoomReservationDTO) throws ParseException {
        classRoomReservationService.reservationToRoom(classRoomReservationDTO);
        System.out.println("성공!");
    }
}
