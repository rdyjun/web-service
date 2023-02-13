package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberSigninDto {
    private String email;
    private String MemberPassword;
}
