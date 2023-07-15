package dmucs.dmu.classroomreservation.controller;

import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.service.ClassroomReservationService;
import dmucs.dmu.classroomreservation.service.NomalyClassroomReservationService;
import dmucs.dmu.classroomreservation.service.OpenClassroomReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Api(value="ApiController v1")
@RestController
@RequiredArgsConstructor
public class ClassroomReservationController {
    private final ClassroomReservationService classroomReservationService;
    private final OpenClassroomReservationService openClassroomReservationService;
    private final NomalyClassroomReservationService nomalyClassroomReservationService;
    @ApiOperation(value = "공개 강의실 대여", notes = "공개 강의실 대여에 대한 정보 저장")
    @PostMapping("/reservation/room/oepn")
    public void saveOpenClassReservation (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        openClassroomReservationService.reservationToRoom(classroomReservationService.reservationToRoom(classroomReservationDTO), classroomReservationDTO);
    }

    @ApiOperation(value = "공개 강의실 대여", notes = "공개 강의실 대여에 대한 정보 저장")
    @PostMapping("/reservation/room/nomaly")
    public void saveNomalyClassReservation (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        nomalyClassroomReservationService.reservationToRoom(classroomReservationService.reservationToRoom(classroomReservationDTO), classroomReservationDTO.getPurpose());
    }
    @ApiOperation(value = "일반 강의실 대여 목록", notes = "특정 날짜에 대한 강의실 대여 목록 출력")
    @PostMapping("/reservation/room/duplicated-reservation")
    public List<ClassroomReservation> getDuplicatedReservation (Date date, String classId) {
        return classroomReservationService.getClassByDateAndClassId(date, classId);
    }
}
