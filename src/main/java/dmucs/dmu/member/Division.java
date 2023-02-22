package dmucs.dmu.member;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "division")
@NoArgsConstructor
public class Division {
    @Id @Column(name = "div_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long div_id = 0L;
    @Column(name = "div_name")
    private String div_name;

    public Division (String div_name) {
        this.div_name = div_name;
    }
}
