package dmucs.dmu.notice;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dmu_notice")
@Getter
@ToString
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noticeNumber")
    private Long noticeNumber = 0L;
    @Column(name = "noticeTitle")
    private String noticeTitle;
    @Column(name = "noticeAuthor")
    private String noticeAuthor;
    @Column(name = "noticeContent", length = 500000)
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
