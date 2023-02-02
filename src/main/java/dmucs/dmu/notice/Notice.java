package dmucs.dmu.notice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jsoup.select.Elements;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@RequiredArgsConstructor
public class Notice {
    @Id
    @Column(name = "noticenumber")
    private Long noticeNumber;
    @Column(name = "noticetitle")
    private String noticeTitle;
    @Column(name = "noticeAuthor")
    private String noticeAuthor;
    @Column(name = "noticeAuthor")
    private String noticeDate;

    public Notice (Elements noticeElements) {
        this.noticeTitle = noticeElements.get(0).text();
        this.noticeAuthor = noticeElements.get(1).text();
        this.noticeDate = noticeElements.get(2).text();
    }
}
