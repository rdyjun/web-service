package dmucs.dmu.classroomreservation.controller;

import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.Classroom;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.service.ClassroomReservationService;
import dmucs.dmu.classroomreservation.service.NomalyClassroomReservationService;
import dmucs.dmu.classroomreservation.service.OpenClassroomReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Api(value="ApiController v1")
@RequestMapping("/reservation/room")
@RestController
@RequiredArgsConstructor
public class ClassroomReservationController {
    private final ClassroomReservationService classroomReservationService;
    @ApiOperation(value = "공개 강의실 대여", notes = "공개 강의실 대여에 대한 정보 저장")
    @PostMapping("/open")
    public void saveOpenClassReservation (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        openClassroomReservationService.reservationToRoom(classroomReservationService.reservationToRoom(classroomReservationDTO), classroomReservationDTO);
    }
}
