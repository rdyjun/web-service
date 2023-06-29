package dmucs.dmu.classroom.controller;

import dmucs.dmu.classroom.entity.ClassRoomReservation;
import dmucs.dmu.classroom.repository.ClassRoomReservationJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClassReservationController {
    private final ClassRoomReservationJpa classRoomReservationJpa;
    @PostMapping
    @RequestMapping("/reservation-room")
    public void saveClassReservation (@RequestBody ClassRoomReservation classRoomReservation) {
        classRoomReservationJpa.save(classRoomReservation);
        System.out.println("성공!");
    }
}
