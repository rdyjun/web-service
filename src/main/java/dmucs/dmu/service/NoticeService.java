package dmucs.dmu.service;

import dmucs.dmu.member.Member;
import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final JpaNoticeRepository jpaNoticeRepository;
    String noticeURL = "https://www.dongyang.ac.kr/dongyang/129/subview.do";

    public Notice[] noticeUpdate () {
        Connection conn = Jsoup.connect(noticeURL);
        Notice[] noticeArray;
        try {
            Document document = conn.get();
            noticeArray = getNoticeArray(document);
            for(Notice noticeExam : noticeArray){
                validateDuplicateManager(noticeExam);
                jpaNoticeRepository.save(noticeExam);
            }
        } catch (IOException e){
            noticeArray = new Notice[0];
            log.trace(e.getMessage());
        }
        return noticeArray;
    }

    public Notice[] getNoticeArray (Document document) {
        Elements tableRows = document.select("tr:not(.notice)");
        Notice[] noticeArray = new Notice[tableRows.size()];
        for(int i = 1; i < tableRows.size(); i++){
            Elements tableElement = tableRows.get(i).select("td");
            for(int n = 1; n < tableElement.size() - 2; n++) {
                noticeArray[i] = new Notice(tableElement);
            }
        }
        return noticeArray;
    }

    public void validateDuplicateManager (Notice notice) {
        jpaNoticeRepository.findByTitleDate(notice.getNoticeTitle(), notice.getNoticeDate())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 공지입니다.");
                });
    }
}
