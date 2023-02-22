package dmucs.dmu.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "department")
@NoArgsConstructor
public class Department {
    @Id @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dept_id = 0L;
    @Column(name = "dept_name")
    private String dept_name;

    @ManyToOne
    @JoinColumn(name = "div_id")
    private Division division;

    public Department (String dept_name) {
        this.dept_name = dept_name;
    }
}
