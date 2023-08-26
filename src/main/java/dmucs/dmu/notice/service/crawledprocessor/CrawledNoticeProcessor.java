package dmucs.dmu.notice.service.crawledprocessor;

import dmucs.dmu.notice.entity.Notice;
import org.jsoup.nodes.Document;

public interface CrawledNoticeProcessor {
    Notice[] getRecentNotice(Document DMUWebDocument, String division, Long nowNoticeNumber);
}
