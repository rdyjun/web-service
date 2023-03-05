package dmucs.dmu.notice.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "notice")
@Getter
@ToString
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noticeId")
    private Long noticeId = 0L;
    @Column(name = "noticeTitle")
    private String noticeTitle;
    @Column(name = "noticeAuthor")
    private String noticeAuthor;
    @Column(name = "noticeContent")
    private String noticeContent;
    @Column(name = "noticeDate")
    private String noticeDate;

    public Notice () {}

    public Notice(String noticeTitle, String noticeAuthor, String noticeContent, String noticeDate) {
        this.noticeTitle = noticeTitle;
        this.noticeAuthor = noticeAuthor;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
    }
}
