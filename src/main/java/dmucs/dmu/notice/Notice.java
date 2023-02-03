package dmucs.dmu.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jsoup.select.Elements;

import javax.persistence.*;

@Entity
@Table(name = "DMU_notice")
@Getter
@ToString
@AllArgsConstructor
public class Notice {

    @Id
    @Column(name = "noticeNumber")
    private Long noticeNumber = 0L;
    @Column(name = "noticeTitle")
    private String noticeTitle;
    @Column(name = "noticeAuthor")
    private String noticeAuthor;
    @Column(name = "noticeDate")
    private String noticeDate;

    public Notice () {}
    public Notice (Elements noticeElements) {
        this.noticeNumber++;
        this.noticeTitle = noticeElements.get(0).text();
        this.noticeAuthor = noticeElements.get(1).text();
        this.noticeDate = noticeElements.get(2).text();
    }
}
