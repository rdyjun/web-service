package dmucs.dmu.member;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "DMU_Member")
@Getter
public class Member {
    @Column(name = "MemberGrade")
    private Grade MemberGrade;         // 권한
    @Column(name = "MemberName")
    private String MemberNAme;         // 이름
    @Column(name = "MemberPassword")
    private String MemberPassword;     // 비밀번호
    @Id
    @Column(name = "StudentId")
    private String StudentId;    // 학번
    @Column(name = "Email")
    private String Email;        // 이메일
    @Column(name = "Department")
    private String Department;   // 학과
    @Column(name = "Division")
    private String Division;     // 학부

    public Member () {

    }

    public Member(Grade memberGrade, String memberNAme, String memberPassword, String studentId, String email, String department, String division) {
        MemberGrade = memberGrade;
        MemberNAme = memberNAme;
        MemberPassword = memberPassword;
        StudentId = studentId;
        Email = email;
        Department = department;
        Division = division;
    }

    @Override
    public String toString() {
        return "Member{" +
                "MemberGrade=" + MemberGrade +
                ", MemberNAme='" + MemberNAme + '\'' +
                ", MemberPassword='" + MemberPassword + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", Email='" + Email + '\'' +
                ", Department='" + Department + '\'' +
                ", Division='" + Division + '\'' +
                '}';
    }
}
