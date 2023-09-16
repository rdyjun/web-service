package dmucs.dmu.repositroy;

import dmucs.dmu.notice.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
public class NoticeRepositoryTest {
    public static JpaNoticeRepository jpaNoticeRepository;
    @Test
    public void getNotice () {
    }
}
