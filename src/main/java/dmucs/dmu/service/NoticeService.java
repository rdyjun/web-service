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
    private final String noticeURL = "https://www.dongyang.ac.kr/dongyang/129/subview.do";

    public void noticeUpdate () {
        Notice[] noticeArray;
        Document document = noticeConnect(noticeURL);
        noticeArray = getNoticeArray(document);

        for(Notice noticeList : noticeArray){
            validateDuplicateManager(noticeList);
            jpaNoticeRepository.saveAndFlush(noticeList);
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

    public Notice[] getNoticeArray (Document document) {
        Elements tableRows = document.select("tr:not(.notice)");  // 공지 테이블 내 tr태그들
        Notice[] noticeArray = new Notice[tableRows.size()];  // tr 태그를 변환&저장할 Notice 객체의 배열
        for(int i = 1; i < tableRows.size(); i++){
            Elements tableElement = tableRows.get(i).select("td");  // i번째 tr 태그 라인의 td 태그들
            noticeArray[i - 1] = new Notice(tableElement);
        }
        return noticeArray;
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
