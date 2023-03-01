package dmucs.dmu.controller;

import dmucs.dmu.member.Department;
import dmucs.dmu.member.DepartmentVO;
import dmucs.dmu.member.Division;
import dmucs.dmu.repository.JpaDepartmentRepository;
import dmucs.dmu.repository.JpaDivisionRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final JpaDepartmentRepository jpaDepartmentRepository;
    private final JpaDivisionRepository jpaDivisionRepository;

    @PostMapping("/department")
    public List<DepartmentVO> getAllDepartment () {
        Hibernate.initialize(jpaDivisionRepository.findAll());
        List<DepartmentVO> departmentDTO = new ArrayList<>();
        for(Department dept : jpaDepartmentRepository.findAll()){
            departmentDTO.add(new DepartmentVO(dept));
        }

        return departmentDTO;
    }
    @PostMapping("/division")
    public List<Division> getAllDivision () {
        return jpaDivisionRepository.findAll();
    }
}
