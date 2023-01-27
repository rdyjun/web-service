package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@AllArgsConstructor
public class Member{
    private Grade memberGrade;         // 권한
    private String memberName;         // 이름
    private String memberPassword;     // 비밀번호
    private String studentId;          // 학번
    private String phone;              // 이메일
    private String department;        // 학과
    private String division;           // 학부

    public Member() {}
}
