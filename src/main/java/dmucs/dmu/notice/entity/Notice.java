package dmucs.dmu.notice.entity;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "notice")
@ToString
@Builder
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noticeId")
    private Long noticeId;
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
