package dmucs.dmu.openclassroom.service;

import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import dmucs.dmu.openclassroom.entity.Classroom;
import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassRoomReservation;
import dmucs.dmu.openclassroom.repository.ClassroomReservationJPA;
import dmucs.dmu.openclassroom.repository.OpenClassRoomReservationJPA;
import dmucs.dmu.member.entity.Member;
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
            }
        }
    }
}
