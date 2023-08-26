package dmucs.dmu.notice.entity;

import dmucs.dmu.crawler.Crawler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Primary
public class DBNoticeProcessor implements NoticeProcessing {

    private static final String univercityURL = "https://www.dongyang.ac.kr";
    private static final String univercityNoticeURL = "/dongyang/129/subview.do";
    private static Crawler crawler;

    @Override
    public long recentNoticeId() {
        return 0;
    }

    /** 사이트에서 특정 공지의 내용을 String으로 반환 */
    public String getContentAtWeb (Document noticeContentDocument) {
        return noticeContentDocument
                .select(".view-con")
                .html();
    }

    public int fetchNewNoticeCount (Elements tableRows, Long nowNoticeNumber) {
        Long webLastNoticeNum = Long.parseLong(tableRows
                .get(0)
                .select("td")
                .get(0)
                .text());
        int newNoticeAmount = (int)(webLastNoticeNum - nowNoticeNumber);

        return newNoticeAmount;
    }

    /** DB에 없는 공지(최신) Notice 객체로 반환 */
    @Override
    public Notice[] getRecentNotice (String division, Long nowNoticeNumber) {
        Document DMUWebDocument = crawler.getDocument(this.univercityURL + this.univercityNoticeURL);
        Elements tableRows = DMUWebDocument.select("tr:not(.notice)");  // 공지 테이블 내 tr태그들
        int noticeArrayLength = fetchNewNoticeCount(tableRows, nowNoticeNumber);

        Notice[] noticeArray = new Notice[noticeArrayLength];
        int page = 2;

        for(int i = 0; i < noticeArrayLength; i++){
             Elements tableElement = tableRows.get(i).select("td");  // i번째 tr 태그 라인의 td 태그들
             String noticeContentURL = this.univercityURL + tableElement.get(1) // 링크 주소 내 컨텐츠
                    .select("a")
                    .attr("href");
             Document noticeContentDocument = crawler.getDocument(noticeContentURL);

             noticeArray[noticeArray.length - 1 - i] = Notice.builder()
                    .noticeTitle(tableElement.get(1).text())
                    .noticeAuthor(division) // 작성자
                    .noticeContent(getContentAtWeb(noticeContentDocument))
                    .noticeDate(tableElement.get(3).text()) // 작성일
                    .build();
             if (i >= tableRows.size() - 1 && i < noticeArrayLength - 1) {
                 DMUWebDocument = crawler.getDocument("javascript:page_link('" + page++ + "')");
                 tableRows = DMUWebDocument.select("tr:not(.notice)");
             }
        }
        return noticeArray;
    }
}
