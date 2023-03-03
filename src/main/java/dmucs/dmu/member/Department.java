package dmucs.dmu.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "department")
@NoArgsConstructor
public class Department{
    @Id @Column(name = "deptId", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "deptName", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "divId")
    private Division division;

    public Department (String name, Division divId) {
        this.name = name;
        this.division = divId;
    }
}
