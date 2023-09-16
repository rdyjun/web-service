package dmucs.dmu.notice.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoticeResponseDTO {
    private Long noticeId;
    private String noticeTitle;
    private String noticeAuthor;
    private String noticeContent;
    private String noticeDate;
}
