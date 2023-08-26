package dmucs.dmu.notice.Service;

import dmucs.dmu.crawler.Crawler;
import dmucs.dmu.notice.entity.Notice;
import dmucs.dmu.notice.entity.NoticeProcessing;
import dmucs.dmu.notice.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class NoticeWithDataBaseService implements NoticeService {
    private final JpaNoticeRepository jpaNoticeRepository;
    private final NoticeProcessing noticeProcessing;
    private final Crawler crawler;
    private final int pageListSize = 10;
    public void save (Notice notice) {
        jpaNoticeRepository.save(notice);
    }

    @Override
    public String getContent (long nId) {
        Optional<String> content = jpaNoticeRepository.findContent(nId);
        if (content.isPresent())
            throw new NoSuchElementException("존재하지 않는 공지사항번호입니다.");
        return content.get();
    }
    
    /** 페이지 번호에 해당하는 공지 목록 반환 */
    @Override
    public List<Notice> getNoticeList(int page) {
        return jpaNoticeRepository.findPageList(page * pageListSize);
    }

    /** 새로운 공지사항 DB 저장 */
//    @Scheduled(cron = "0 0 * * * *")
    public void noticeUpdate () {
        Optional<Long> lastNoticeNumber = jpaNoticeRepository.findByNoticeIdMax();
        Long dbLastNoticeNumber = 0L;

        if (lastNoticeNumber.isPresent())
            dbLastNoticeNumber = lastNoticeNumber.get();

        Notice[] newNotice = noticeProcessing.getRecentNotice("대학", dbLastNoticeNumber);
        for(Notice noticeList : newNotice)
            save(noticeList);
    }
}