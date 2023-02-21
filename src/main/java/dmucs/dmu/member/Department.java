package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Department {
    @Id @GeneratedValue
    @Column(name = "dept_id")
    private Long dept_id;
    @Column(name = "dept_name")
    private String dept_name;

    public Department (Long dept_id) {
        this.dept_id = dept_id;
    }
    @OneToMany(mappedBy = "department")
    @Column(name = "dept_id")
    private List<Member> member;
}
