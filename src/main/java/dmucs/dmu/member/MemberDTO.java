package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "DMU_Member")
@Getter
@AllArgsConstructor
@ToString
public class MemberDTO{
    @Column(name = "membergrade")
    private Grade memberGrade;         // 권한
    @Column(name = "membername")
    private String memberName;         // 이름
    @Column(name = "memberpassword")
    private String memberPassword;     // 비밀번호
    @Id
    @Column(name = "studentid")
    private String studentId;          // 학번
    @Column(name = "phone")
    private String phone;              // 이메일
    @Column(name = "department")
    private String department;        // 학과
    @Column(name = "division")
    private String division;           // 학부

    public MemberDTO () {}

    public MemberDTO(Member member, String pw) {
        this.memberGrade = member.getMemberGrade();
        this.memberName = member.getMemberName();
        this.memberPassword = pw;
        this.studentId = member.getStudentId();
        this.phone = member.getPhone();
        this.department = member.getDepartment();
        this.division = member.getDivision();
    }
}
