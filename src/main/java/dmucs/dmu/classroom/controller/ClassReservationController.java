package dmucs.dmu.classroom.controller;

import dmucs.dmu.classroom.dto.ClassRoomReservationDTO;
import dmucs.dmu.classroom.entity.ClassRoomReservation;
import dmucs.dmu.classroom.repository.ClassRoomReservationJpa;
import dmucs.dmu.classroom.service.ClassRoomReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
public class ClassReservationController {
    private final ClassRoomReservationService classRoomReservationService;
    @PostMapping
    @RequestMapping("/reservation-room")
    public void saveClassReservation (@RequestBody ClassRoomReservationDTO classRoomReservationDTO) throws ParseException {
        classRoomReservationService.reservationToRoom(classRoomReservationDTO);
        System.out.println("성공!");
    }
}
