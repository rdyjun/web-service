package dmucs.dmu;

import dmucs.dmu.repository.MemberRepository;
import dmucs.dmu.repository.MemberRepositoryImpl;
import dmucs.dmu.service.MemberService;
import dmucs.dmu.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberRepository () {
        return new MemberRepositoryImpl();
    }

    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }
}
