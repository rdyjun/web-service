package dmucs.dmu.crawler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


@Log4j2
public class CrawlerImpl implements Crawler {
    /** 커넥터 가져오기 */
    @Override
    public Document getDocument (String connectURL) {
        try {
            return (Document) Jsoup.connect(connectURL).get();
        } catch (Exception e) {
            log.trace(e.getMessage());
        }
        return null;
    }
}
