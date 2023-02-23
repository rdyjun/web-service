package dmucs.dmu.member;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "division")
@NoArgsConstructor
public class Division {
    @Id @Column(name = "divId", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "divName", nullable = false)
    private String name;

    public Division (String name) {
        this.name = name;
    }
    public Division (Long id) {
        this.id = id;
    }
}