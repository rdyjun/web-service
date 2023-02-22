package dmucs.dmu.member;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dmuservice_dmu_member")
@Getter
@ToString
public class Member {
    @Id @Column(name = "memberCode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberCode = 0L;         // 고유번호
    @Column(name = "membergrade", nullable = false)
    private Grade memberGrade;            // 권한
    @Column(name = "memberpassword", nullable = false)
    private String memberPassword;        // 비밀번호
    @Column(name = "email", nullable = false)
    private String email;                 // 이메일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department", nullable = false)
    private Department department;        // 학과

    public Member () {}
    public Member (Grade memberGrade, String memberPassword, String email, Department department){
        this.memberGrade = memberGrade;
        this.memberPassword = memberPassword;
        this.email = email;
        this.department = department;
    }
    public Member (Member member, String pw) {
        this.memberCode = member.getMemberCode();
        this.memberGrade = member.getMemberGrade();
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
