package dmucs.dmu.repositroy;

import dmucs.dmu.SpringConfig;
import dmucs.dmu.member.Grade;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

    MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach () {
        SpringConfig springConfig = new SpringConfig();
        memberRepository = springConfig.memberRepository();
    }
    //저장 테스트
    @Test
    void save() {
        Member member = new Member(Grade.Admin, "주성준", "pwd","20222296","010-1111-1111", "email", "컴퓨터소프트웨어", "컴퓨터공학부");
        memberRepository.save(member);
        Member m = memberRepository.findById(member.getStudentId()).get();
        Assertions.assertThat(m).isEqualTo(member);

    }
}