package dmucs.dmu.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private Long divId;

    public DepartmentDTO (Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.divId = department.getDivision().getId();
    }
}
