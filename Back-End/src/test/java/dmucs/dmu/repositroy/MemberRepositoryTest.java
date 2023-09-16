package dmucs.dmu.repositroy;

import dmucs.dmu.member.entity.Department;
import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.repository.JpaMemberRepository;
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
}