package dmucs.dmu.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "division")
@NoArgsConstructor
public class Division {
    @Id @Column(name = "divId", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "divName")
    private String name;

    public Division (String name) {
        this.name = name;
    }
    public Division (Long id) {
        this.id = id;
    }
}