package dmucs.dmu.controller;

import dmucs.dmu.member.Department;
import dmucs.dmu.member.Division;
import dmucs.dmu.repository.JpaDepartmentRepository;
import dmucs.dmu.repository.JpaDivisionRepository;
import dmucs.dmu.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final JpaDepartmentRepository jpaDepartmentRepository;
    private final JpaDivisionRepository jpaDivisionRepository;
    private final DepartmentService departmentService;

    @PostMapping("/update")
    public void save(){
        departmentService.update();
    }

    @PostMapping("/department")
    public List<Department> getAllDepartment () {
        return jpaDepartmentRepository.findAll();
    }
    @PostMapping("/division")
    public List<Division> getAllDivision () {
        return jpaDivisionRepository.findAll();
    }
}
