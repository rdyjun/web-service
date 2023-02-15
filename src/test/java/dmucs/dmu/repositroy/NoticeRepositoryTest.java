package dmucs.dmu.repositroy;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@RequiredArgsConstructor
public class NoticeRepositoryTest {
    public static JpaNoticeRepository jpaNoticeRepository;
    @Test
    public void getNotice () {
    }
}
