package dmucs.dmu.notice.service.crawledprocessor;

import dmucs.dmu.crawler.Crawler;
import dmucs.dmu.notice.entity.Notice;
import dmucs.dmu.notice.service.noticecrawled.NoticeCrawling;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@AllArgsConstructor
@Service
@Primary
public class CrawledNoticeProcessorImpl implements CrawledNoticeProcessor {
    private final NoticeCrawling noticeCrawling;

    /**최신 공지 수 리턴 */
    private int fetchNewNoticeCount (Elements tableRows, Long nowNoticeNumber) {
        Long webLastNoticeNum = Long.parseLong(tableRows
                .get(0)
                .select("td")
                .get(0)
                .text());
        int newNoticeAmount = (int)(webLastNoticeNum - nowNoticeNumber);

        return newNoticeAmount;
    }

    private Document getDocumentByPage (int pageNumber) {
        return noticeCrawling.getNoticeDocumentByPage(pageNumber);
    }

    /** DB에 없는 공지(최신) DB에 저장 */
    @Override
    public Notice[] getRecentNotice (Document DMUWebDocument, String division, Long nowNoticeNumber) {
        Elements tableRows = DMUWebDocument.select("tr:not(.notice)");  // 공지 테이블 내 tr태그들
        int noticeArrayLength = fetchNewNoticeCount(tableRows, nowNoticeNumber);
        Notice[] notices = new Notice[noticeArrayLength];
        int page = 2;
        int count = 0;

        for(int i = 0; i < noticeArrayLength; i++){
            Elements tableElement = tableRows.get(i - count).select("td");  // i번째 tr 태그 라인의 td 태그들

            notices[i - count] = Notice.builder()
                    .noticeTitle(tableElement.get(1).text())
                    .noticeAuthor(division) // 작성자
                    .noticeContent(tableElement.get(1) // 링크 주소 내 컨텐츠
                            .select("a")
                            .attr("href"))
                    .noticeDate(tableElement.get(3).text()) // 작성일
                    .build();
             if (i >= tableRows.size() - 1 && i < noticeArrayLength - 1) {
                 DMUWebDocument = getDocumentByPage(page++);
                 tableRows = DMUWebDocument.select("tr:not(.notice)");
                 count = i;
             }
        }
        return notices;
    }
}
