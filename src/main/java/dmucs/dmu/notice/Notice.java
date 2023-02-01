package dmucs.dmu.notice;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Notice {
    public static void main(String[] args) {
        String URL = "https://www.dongyang.ac.kr/dongyang/129/subview.do";
        Connection conn = Jsoup.connect(URL);

        try {
            Document document = conn.get();
            Elements UrlElements = document.getElementsByClass("notice");

            for (Element element : UrlElements){
                System.out.println(element);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
