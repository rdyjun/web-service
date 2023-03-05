package dmucs.dmu.member.vo;

import dmucs.dmu.member.entity.Department;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DepartmentVO {
    private Long id;
    private String name;
    private Long divId;

    public DepartmentVO (Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.divId = department.getDivision().getId();
    }
}
