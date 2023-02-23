package dmucs.dmu.member;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "memberGrade")
@NoArgsConstructor
public class Grade {
    @Id @Column(name = "memberGradeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "memberGradeName")
    private String name;

    public Grade(String name) {
        this.name = name;
    }
    public Grade(Long id) {
        this.id = id;
    }
}
