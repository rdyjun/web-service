package dmucs.dmu.notice.service.processingdata;

import dmucs.dmu.notice.entity.Notice;

public interface NoticeDataProcessor {
    /** 새로운 공지사항에 대한 처리 */
    void updateNotice (Notice[] notices);
}
