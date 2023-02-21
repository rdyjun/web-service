package dmucs.dmu.member;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Division {
    @Id
    @Column(name = "div_id")
    private Long div_id;
    @Column(name = "div_name")
    private String div_name;

    @OneToMany(mappedBy = "division")
    @Column(name = "division")
    private List<Member> member;
}
