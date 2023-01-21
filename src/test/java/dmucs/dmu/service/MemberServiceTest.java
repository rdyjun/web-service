package dmucs.dmu.service;

import dmucs.dmu.member.Grade;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest{


    MemberRepository memberRepository;

    MemberServiceImpl memberService = new MemberServiceImpl(memberRepository);

    @Test
    public void 중복회원예외 () {
        Member member1 = new Member(Grade.Admin, "주성준", "1234", "20222296", "010-6686-5836", "rdyjun00@gmail.com", "컴퓨터소프트웨어", "컴퓨터공학부");

        Member member2 = new Member(Grade.Admin, "주성준", "1234", "20222296", "010-6686-5836", "rdyjun00@gmail.com", "컴퓨터소프트웨어", "컴퓨터공학부");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {  // 위 코드랑 같음
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

    }
}
