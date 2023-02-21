package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dmuservice_dmu_member")
@Getter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberCode")
    private Long memberCode = 0L;
    @Column(name = "membergrade")
    private Grade memberGrade;         // 권한
    @Column(name = "memberpassword")
    private String memberPassword;     // 비밀번호
    @Column(name = "email")
    private String email;              // 이메일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    @Column(name = "department")
    private Department department;        // 학과
    @Column(name = "division")
    private String division;           // 학부

    public Member() {}
    public Member(Grade memberGrade, String memberPassword, String email, Department department, String division){
        this.memberGrade = memberGrade;
        this.memberPassword = memberPassword;
        this.email = email;
        this.department = department;
        this.division = division;
    }
    public Member(Member member, String pw) {
        this.memberCode = member.getMemberCode();
        this.memberGrade = member.getMemberGrade();
        this.memberPassword = pw;
        this.email = member.getEmail();
        this.department = member.getDepartment();
        this.division = member.getDivision();
    }
    public Member (String email, String memberPassword) {
        this.email = email;
        this.memberPassword = memberPassword;
    }
    public String getEmailId () {
        return this.email.substring(0,this.email.lastIndexOf("@"));
    }
}
