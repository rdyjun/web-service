package dmucs.dmu.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;


@Getter
@RequiredArgsConstructor
public class MemberDTO{
    private Grade memberGrade;         // 권한
    private String memberName;         // 이름
    private String memberPassword;     // 비밀번호
    private String studentId;          // 학번
    private String email;              // 이메일
    private String department;        // 학과
    private String division;           // 학부

}
