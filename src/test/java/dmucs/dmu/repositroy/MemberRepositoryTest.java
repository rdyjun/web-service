package dmucs.dmu.repositroy;

import dmucs.dmu.member.Grade;
import dmucs.dmu.member.MemberDTO;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.JpaMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@WebAppConfiguration
@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    JpaMemberRepository JpaMemberRepository;
    //저장 테스트
    @Test
    void save() {
        Member member = new Member(Grade.Admin, "주성준", "pwd","20222296","emai", "컴퓨터소프트웨어", "컴퓨터공학부");
        Member savedMember = JpaMemberRepository.save(member);

        Assertions.assertThat(savedMember.getStudentId()).isEqualTo("20222296");
    }

}