package dmucs.dmu.service;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final JpaNoticeRepository jpaNoticeRepository;
    private final String univercityURL = "https://www.dongyang.ac.kr";
    private final String univercityNoticeURL = "/dongyang/129/subview.do";

    public void save (Notice notice) {
        validateDuplicateManager(notice);
        jpaNoticeRepository.save(notice);
    }


    public void noticeUpdate () {
        Notice[] noticeArray;
        Document univercityDocument = noticeConnect(univercityURL + univercityNoticeURL);
        noticeArray = getNoticeArray(univercityDocument, "대학");

        for(Notice noticeList : noticeArray){
            save(noticeList);
        }
    }

    public Document noticeConnect (String noticeURL) {
        Connection conn = Jsoup.connect(noticeURL);
        try {
            Document document = conn.get();
            return document;
        } catch (IOException e) {
            log.trace(e.getMessage());
        }
        return null;
    }

    public Notice[] getNoticeArray (Document document, String division) {
        Elements tableRows = document.select("tr:not(.notice)");  // 공지 테이블 내 tr태그들
        System.out.println(tableRows.size());
        Notice[] noticeArray = new Notice[tableRows.size()];  // tr 태그를 변환&저장할 Notice 객체의 배열
        for(int i = 1; i < tableRows.size(); i++){
            Elements tableElement = tableRows.get(i).select("td");  // i번째 tr 태그 라인의 td 태그들

            noticeArray[i - 1] = new Notice(
                    tableElement.get(1).text(),  // 제목
                    division,  // 작성자
                    getContent(univercityURL + tableElement.get(1).select("a").attr("href")),  // 링크 주소 내 컨텐츠
                    tableElement.get(3).text()  // 작성일
            );
        }
        return noticeArray;
    }

    public String getContent (String contentURL) {
        Document document = noticeConnect(contentURL);
        return document.select(".view-con").text();
    }


    public void validateDuplicateManager (Notice notice) {
        jpaNoticeRepository.findByNoticeTitle(notice.getNoticeTitle())
                .ifPresent(n -> {
                    jpaNoticeRepository.findByNoticeDate(notice.getNoticeDate())
                            .ifPresent(m -> {
                                throw new IllegalStateException("이미 존재하는 공지입니다.");
                            });
                });
    }
}