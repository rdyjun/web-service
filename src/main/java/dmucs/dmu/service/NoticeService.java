package dmucs.dmu.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class NoticeService {
    String URL = "https://www.dongyang.ac.kr/dongyang/129/subview.do";

    public void getNotice () {
        Connection conn = Jsoup.connect(URL);

        try {
            Document document = conn.get();
            Elements UrlElements = document.getElementsByClass("notice");

        } catch (IOException e){
            log.trace(e.getMessage());
        }
    }
}
