package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Member extends MemberDTO {
    public Member () {}
    public Member (Grade grade, String memberName, String memberPassword, String studentId, String email, String department, String division) {
        super(grade,memberName,memberPassword,studentId,email, department,division);
    }
}
