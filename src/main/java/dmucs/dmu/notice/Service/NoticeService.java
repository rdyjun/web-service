package dmucs.dmu.notice.Service;

import dmucs.dmu.notice.entity.Notice;
import dmucs.dmu.notice.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
    private final int pageListSize = 10;
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
        return jpaNoticeRepository.findPageList(page * pageListSize);
    }
    
    /** URL에 대한 커넥터 가져오기 */
    public Document noticeConnect (String noticeURL) {
        try {
            return Jsoup.connect(noticeURL).get();
        } catch (Exception e) {
            log.trace(e.getMessage());
        }
        return null;
    }
    /** 최근 공지 가져오기 */
    public Notice[] getRecentNotice (Document document, String division) {
        Elements tableRows = document.select("tr:not(.notice)");  // 공지 테이블 내 tr태그들
        int noticeArrayLenth = fetchNewNoticeCount(tableRows);

        Notice[] noticeArray = new Notice[noticeArrayLenth];
        for(int i = 1; i < noticeArrayLenth; i++){
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


    public int fetchNewNoticeCount (Elements tableRows) {
        Optional<Notice> noticeOptional = null;
        int i;
        for(i = tableRows.size() - 1; i > 0 || noticeOptional.isPresent(); i++){
            Element tableRowValues = tableRows.get(i);
            Elements tableElement = tableRowValues.select("td");
            Element titleElement = tableElement.get(1);
            String title = titleElement.text();

            Element dateElement = tableElement.get(3);
            String date = dateElement.text();
            noticeOptional = jpaNoticeRepository.findByNoticeTitleDate(title, date);
        }
        return i + 1;
    }
}