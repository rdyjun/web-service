package dmucs.dmu.member.dto;

import dmucs.dmu.member.entity.Grade;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberDTO{
    private Long memberCode;
    private Grade memberGrade;         // 권한
    private String memberPassword;     // 비밀번호
    private String email;              // 이메일
    private String department;        // 학과
    private String division;           // 학부
}
