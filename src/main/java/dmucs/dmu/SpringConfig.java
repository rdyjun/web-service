package dmucs.dmu;

import dmucs.dmu.repository.MemberRepository;
import dmucs.dmu.repository.SpringDataJpaMemberRepository;
import dmucs.dmu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;


    @Autowired
    public SpringConfig(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

}


//    @Bean
//    public MemberRepository memberRepository () {
//        return new JpaMemberRepository(em);
//    }
