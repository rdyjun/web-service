package dmucs.dmu.openclassroom.service;

import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import dmucs.dmu.openclassroom.entity.Classroom;
import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassroomReservation;
import dmucs.dmu.openclassroom.repository.ClassroomReservationJPA;
import dmucs.dmu.openclassroom.repository.OpenClassroomReservationJPA;
import dmucs.dmu.member.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class ClassroomReservationService {
    private final JpaMemberRepository jpaMemberRepository;
    private final ClassroomReservationJPA classroomReservationJPA;
    private final OpenClassroomReservationService openClassroomReservationService;
    private final OpenClassroomReservationJPA openClassroomReservationJPA;
    public void reservationToRoom (ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        if (classroomReservationDTO.getType() == "공개") {
            if (openClassroomReservationService.checked(classroomReservationDTO)) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                ClassroomReservation classroomReservation = new ClassroomReservation(
                        0L,
                        new Classroom(classroomReservationDTO.getRoomId()),
                        formatter.parse(classroomReservationDTO.getDate()),
                        classroomReservationDTO.getType()
                );
                classroomReservationJPA.save(classroomReservation);

                OpenClassroomReservation openClassroomReservation = new OpenClassroomReservation(

                );
            }
        } if (classroomReservationDTO.getType() == "일반") {
            if (openClassroomReservationService.checked(classroomReservationDTO)) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                ClassroomReservation classroomReservation = new ClassroomReservation(
                        0L,
                        new Classroom(classroomReservationDTO.getRoomId()),
                        formatter.parse(classroomReservationDTO.getDate()),
                        classroomReservationDTO.getType()
                );
                classroomReservationJPA.save(classroomReservation);
            }
        }
    }
}
