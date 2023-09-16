package dmucs.dmu.classroommanagement.controller;

import dmucs.dmu.classroommanagement.dto.ClassroomReservationDTO;
import dmucs.dmu.classroommanagement.service.ClassroomReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;

@Api(value="ApiController v1")
@RequestMapping("/reservation/room")
@RestController
@RequiredArgsConstructor
public class ClassroomReservationController {
    private final ClassroomReservationService classroomReservationService;
    @ApiOperation(value = "강의실 대여", notes = "강의실 대여에 대한 정보 저장")
    @PostMapping("/")
    public void saveOpenClassReservation (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        classroomReservationService.reservationToRoom(classroomReservationDTO);
    }
    @ApiOperation(value = "대여목록 확인", notes = "특정 날짜에 대한 대여 정보 출력")
    @PostMapping("/list")
    public ArrayList<ClassroomReservationDTO> getClassReservationList (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        return classroomReservationService.getClassReservationList(classroomReservationDTO);
    }
}
