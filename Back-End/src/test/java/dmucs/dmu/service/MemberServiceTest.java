package dmucs.dmu.service;


import dmucs.dmu.member.repository.JpaMemberRepository;
import dmucs.dmu.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;



@SpringBootTest
@Transactional
class MemberServiceTest{
    @Autowired
    JpaMemberRepository jpaMemberRepository;
    @Autowired
    MemberService memberService;

    @Test
    public void 회원조회 () {

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
