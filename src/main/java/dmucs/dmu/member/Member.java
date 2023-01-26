package dmucs.dmu.member;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "DMU_Member")
@Getter
public class Member {
    @Column(name = "MemberGrade")
    private Grade memberGrade;         // 권한
    @Column(name = "MemberName")
    private String memberName;         // 이름
    @Column(name = "MemberPassword")
    private String memberPassword;     // 비밀번호
    @Id
    @Column(name = "StudentId")
    private String studentId;    // 학번
    @Column(name = "Email")
    private String email;        // 이메일
    @Column(name = "Department")
    private String department;   // 학과
    @Column(name = "Division")
    private String division;     // 학부

    public Member () {

    }

    public Member(Grade memberGrade, String memberName, String memberPassword, String studentId, String email, String department, String division) {
        this.memberGrade = memberGrade;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.studentId = studentId;
        this.email = email;
        this.department = department;
        this.division = division;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberGrade=" + memberGrade +
                ", memberName='" + memberName + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
