package dmucs.dmu.notice.service.noticecrawled;

import dmucs.dmu.crawler.Crawler;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;

@RequiredArgsConstructor
public class NoticeCrawling {
    private final Crawler crawler;
    private static final String univercityURL = "https://www.dongyang.ac.kr";
    private static final String univercityNoticeURL = "/dongyang/129/subview.do";

    public Document getNoticeDocument () {
        return crawler.getDocument(this.univercityURL + this.univercityNoticeURL);
    }
    public Document getNoticeDocumentByPage (int pageNumber) {
        return crawler.getDocument(this.univercityURL + this.univercityNoticeURL + "page=" + pageNumber);
    }
    public Document getNoticeContentByURL (String noticeURL) {
        return crawler.getDocument(this.univercityURL + noticeURL);
    }
}
