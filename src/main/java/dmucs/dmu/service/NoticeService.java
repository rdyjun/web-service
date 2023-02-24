package dmucs.dmu.service;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final JpaNoticeRepository jpaNoticeRepository;
    private final String univercityURL = "https://www.dongyang.ac.kr";
    private final String univercityNoticeURL = "/dongyang/129/subview.do";

    public void save (Notice notice) {
        jpaNoticeRepository.save(notice);
    }

    public List<Notice> findAll(){
        return jpaNoticeRepository.findAll();
    }
    public void noticeUpdate () {

        for(Notice noticeList : getRecentNotice(noticeConnect(univercityURL + univercityNoticeURL), "대학")){
            save(noticeList);
        }
    }

    public Optional<String> getNoticeContent(long nId) {
        return jpaNoticeRepository.findContent(nId);
    }
    public List<Notice> getNoticeList(int page) {
        return jpaNoticeRepository.findPageList(page);
    }

    public Document noticeConnect (String noticeURL) {
        try {
            return Jsoup.connect(noticeURL).get();
        } catch (Exception e) {
            log.trace(e.getMessage());
        }
        return null;
    }

    public Notice[] getRecentNotice (Document document, String division) {
        Elements tableRows = document.select("tr:not(.notice)");  // 공지 테이블 내 tr태그들
        Notice[] noticeArray = new Notice[0];
        for(int i = tableRows.size() - 1; i > 0; i++){
            Elements tableElement = tableRows.get(i).select("td");
            if(!validateDuplicateManager(tableElement.get(1).text(), tableElement.get(3).text())) {
                noticeArray = new Notice[i + 1];  // tr 태그를 변환&저장할 Notice 객체의 배열
                break;
            }
        }

        for(int i = 1; i < noticeArray.length; i++){
            Elements tableElement = tableRows.get(i).select("td");  // i번째 tr 태그 라인의 td 태그들

            noticeArray[noticeArray.length - 1 - i] = new Notice(
                    tableElement.get(1).text(),  // 제목
                    division,  // 작성자
                    getContent(univercityURL + tableElement.get(1).select("a").attr("href")),  // 링크 주소 내 컨텐츠
                    tableElement.get(3).text()  // 작성일
            );
        }
        return noticeArray;
    }

    public String getContent (String contentURL) {
        return noticeConnect(contentURL).select(".view-con").html();
    }


    public boolean validateDuplicateManager (String noticeTitle, String noticeDate) {
        return jpaNoticeRepository.findByNoticeTitleDate(noticeTitle, noticeDate).isPresent();
    }
}