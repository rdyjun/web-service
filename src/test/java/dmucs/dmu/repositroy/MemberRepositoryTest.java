package dmucs.dmu.repositroy;

import dmucs.dmu.member.Grade;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.SpringDataJpaMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    SpringDataJpaMemberRepository springDataJpaMemberRepository;

    //저장 테스트
    @Test
    void save() {
        Member member = new Member(Grade.Admin, "주성준", "pwd","20222296","emai", "컴퓨터소프트웨어", "컴퓨터공학부");
        springDataJpaMemberRepository.save(member);
    }
}