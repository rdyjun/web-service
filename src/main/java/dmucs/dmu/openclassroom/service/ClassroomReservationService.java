package dmucs.dmu.openclassroom.service;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.openclassroom.dto.ClassroomReservationDTO;
import dmucs.dmu.openclassroom.entity.Classroom;
import dmucs.dmu.openclassroom.entity.ClassroomReservation;
import dmucs.dmu.openclassroom.entity.NomalyClassRoomReservation;
import dmucs.dmu.openclassroom.entity.OpenClassroomReservation;
import dmucs.dmu.openclassroom.repository.ClassroomReservationJPA;
import dmucs.dmu.openclassroom.repository.NomalyClassroomReservationJPA;
import dmucs.dmu.openclassroom.repository.OpenClassroomReservationJPA;
import dmucs.dmu.member.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ClassroomReservationService {
    private final JpaMemberRepository jpaMemberRepository;
    private final ClassroomReservationJPA classroomReservationJPA;
    private final OpenClassroomReservationService openClassroomReservationService;
    private final OpenClassroomReservationJPA openClassroomReservationJPA;
    private final NomalyClassroomReservationJPA nomalyClassroomReservationJPA;
    public void reservationToRoom (ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(classroomReservationDTO.getDate());

        ClassroomReservation classroomReservation = new ClassroomReservation(
                0L,
                new Classroom(classroomReservationDTO.getRoomId(), false),
                date,
                classroomReservationDTO.getType()
        );

        if (classroomReservationDTO.getType() == "공개") {
            Member member = openClassroomReservationService.checked(classroomReservationDTO);
            ClassroomReservation classroomReservationSaved = classroomReservationJPA.save(classroomReservation);

            OpenClassroomReservation openClassroomReservation = new OpenClassroomReservation(
                    classroomReservationSaved,
                    member,
                    classroomReservationDTO.getPurpose()
            );
            openClassroomReservationJPA.save(openClassroomReservation);
        } else if (classroomReservationDTO.getType() == "일반") {

            ClassroomReservation classroomReservationSaved = classroomReservationJPA.save(classroomReservation);
            NomalyClassRoomReservation nomalyClassroomReservation = new NomalyClassRoomReservation(
                    classroomReservationSaved,
                    classroomReservationDTO.getPurpose()
            );
            nomalyClassroomReservationJPA.save(nomalyClassroomReservation);
        }
    }
}
