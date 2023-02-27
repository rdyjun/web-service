package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberSigninDTO {
    private String email;
    private String MemberPassword;
}
