package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "memberGrade")
@NoArgsConstructor
@Getter
public class Grade {
    @Id @Column(name = "memberGradeId", insertable = false)
    @ColumnDefault(value = "5")  //학생
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "memberGradeName", nullable = false)
    private String name;

    public Grade(String name) {
        this.name = name;
    }
    public Grade(Long id) {
        this.id = id;
    }
}


//1 admin
//2 staff
//3 sup
//4 cp
//5 student