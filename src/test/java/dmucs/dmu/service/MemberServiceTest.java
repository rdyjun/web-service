package dmucs.dmu.service;

import dmucs.dmu.bcrypt.EncryptHelper;
import dmucs.dmu.member.Grade;
import dmucs.dmu.member.MemberDTO;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.JpaMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceTest{
    @Autowired
    JpaMemberRepository jpaMemberRepository;
    @Autowired
    MemberService memberService;

    @Autowired
    EncryptHelper encryptHelper;

    @Test
    public void 회원조회 () {
        Member m1 = new Member(Grade.Student, "주성준", "0000", "20222296", "@dongyang.ac.kr", "컴퓨터소프트웨어", "컴퓨터공학부");
        String encryptPw = encryptHelper.encrypt(m1.getMemberPassword());
        Member m2 = new Member(m1, encryptPw);
        Member find = jpaMemberRepository.findByEmail(m2.getEmail()).get();
        Assertions.assertThat(find).isEqualTo(m2);
    }
//
//    @AfterEach
//    public void afterEach () {
//        memberRepository.clearStore();
//    }
//    @Test
//    public void 중복회원예외 () {
//        Member member1 = new Member(Grade.Admin, "주성준", "1234", "20222296", "rdyjun00@gmail.com", "컴퓨터소프트웨어", "컴퓨터공학부");
//
//        Member member2 = new Member(Grade.Admin, "주성준", "1234", "20222296", "rdyjun00@gmail.com", "컴퓨터소프트웨어", "컴퓨터공학부");
//
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////        try {  // 위 코드랑 같음
////            memberService.join(member2);
////            fail();
////        } catch (IllegalStateException e) {
////            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////        }
//
//    }
}
