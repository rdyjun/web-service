package dmucs.dmu.notice.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "notice")
@ToString
@Builder
public class Notice {
    @Id
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
}
