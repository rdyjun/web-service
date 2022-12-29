package dmucs.dmu.service;

import dmucs.dmu.member.Member;
import dmucs.dmu.repository.MemberRepositoryInterface;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class MemberServiceTest{

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepositoryInterface memberRepositoryInterface;

    @Test
    void 회원가입 () {
        Member member = new Member();
        member.setStudentId("20222296");

        String saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    void 중복회원예외 () {
        Member member1 = new Member();
        member1.setStudentId("33333333");

        Member member2 = new Member();
        member2.setStudentId("33333333");

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
