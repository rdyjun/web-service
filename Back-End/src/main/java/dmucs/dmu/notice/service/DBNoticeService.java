package dmucs.dmu.notice.service;

import dmucs.dmu.notice.entity.Notice;
import dmucs.dmu.notice.repository.JpaNoticeRepository;
import dmucs.dmu.notice.service.crawledprocessor.CrawledNoticeProcessor;
import dmucs.dmu.notice.service.processingdata.DBNoticeDataProcessor;
import dmucs.dmu.notice.service.processingdata.NoticeDataProcessor;
import dmucs.dmu.notice.service.noticecrawled.NoticeCrawling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class DBNoticeService implements NoticeService {
    private final JpaNoticeRepository jpaNoticeRepository;
    private final CrawledNoticeProcessor crawledNoticeProcessor;
    private final NoticeDataProcessor noticeDataProcessor;
    private final DBNoticeDataProcessor dbNoticeDataProcessor;
    private final NoticeCrawling noticeCrawling;
    private final int pageListSize = 10;
    public void save (Notice notice) {
        jpaNoticeRepository.save(notice);
    }

    /** DB에서 공지 주소를 가져와 사이트의 내용을 String으로 반환 */
    @Override
    public String getContent (long nId) {
        Optional<String> content = jpaNoticeRepository.findContent(nId);
        if (content.isPresent())
            throw new NoSuchElementException("존재하지 않는 공지사항번호입니다.");
        Document noticeDocument = noticeCrawling.getNoticeContentByURL(content.get());
        return noticeDocument.select(".view-con")
                .html();
    }
    
    /** 페이지 번호에 해당하는 공지 목록 반환 */
    @Override
    public List<Notice> getNoticeList(int page) {
        noticeUpdate();
        return dbNoticeDataProcessor.getNoticeByList(page, pageListSize);
    }

    /** 새로운 공지사항 업데이트 */
    public void noticeUpdate () {
        //최신 공지
        Optional<Long> lastNoticeNumber = jpaNoticeRepository.findByNoticeIdMax();
        //최신 공지 번호
        Long dbLastNoticeNumber = lastNoticeNumber.orElse(0L);
        // 웹 document
        Document DMUWebDocument = noticeCrawling.getNoticeDocument();

        Notice[] newNotice = crawledNoticeProcessor.getRecentNotice(DMUWebDocument, "대학", dbLastNoticeNumber);

        noticeDataProcessor.updateNotice(newNotice);
    }
}