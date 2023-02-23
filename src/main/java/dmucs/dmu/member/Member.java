package dmucs.dmu.member;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dmu_member")
@Getter
@ToString
public class Member {
    @Id @Column(name = "memberCode", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCode = 0L;         // 고유번호
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "memberGradeId", nullable = false)
    private Grade grade;            // 권한
    @Column(name = "memberPassword", nullable = false)
    private String memberPassword;        // 비밀번호
    @Column(name = "email", nullable = false)
    private String email;                 // 이메일
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "deptId", nullable = false)
    private Department department;        // 학과

    public Member () {}
    public Member (Grade grade, String memberPassword, String email, Department department){
        this.grade = grade;
        this.memberPassword = memberPassword;
        this.email = email;
        this.department = department;
    }
    public Member (Member member, String pw) {
        this.memberCode = member.getMemberCode();
        this.grade = member.getGrade();
        this.memberPassword = pw;
        this.email = member.getEmail();
        this.department = member.getDepartment();
    }
    public Member (String email, String memberPassword) {
        this.email = email;
        this.memberPassword = memberPassword;
    }
    public String getEmailId () {
        return this.email.substring(0,this.email.lastIndexOf("@"));
    }
}
