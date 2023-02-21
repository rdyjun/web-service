package dmucs.dmu.repositroy;

import dmucs.dmu.member.Department;
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

    }

}