package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dmu_member")
@Getter
@ToString
@AllArgsConstructor
public class Member {
    @Column(name = "membergrade")
    private Grade memberGrade;         // 권한
    @Column(name = "membername")
    private String memberName;         // 이름
    @Column(name = "memberpassword")
    private String memberPassword;     // 비밀번호
    @Id
    @Column(name = "studentid")
    private String studentId;          // 학번
    @Column(name = "email")
    private String email;              // 이메일
    @Column(name = "department")
    private String department;        // 학과
    @Column(name = "division")
    private String division;           // 학부

    public Member() {}

    public Member(Member member, String pw) {
        this.memberGrade = member.getMemberGrade();
        this.memberName = member.getMemberName();
        this.memberPassword = pw;
        this.studentId = member.getStudentId();
        this.email = member.getEmail();
        this.department = member.getDepartment();
        this.division = member.getDivision();
    }
    public Member (String email, String memberPassword) {
        this.email = email;
        this.memberPassword = memberPassword;
    }

}
