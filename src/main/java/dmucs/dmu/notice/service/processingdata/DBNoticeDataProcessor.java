package dmucs.dmu.notice.service.processingdata;

import dmucs.dmu.notice.entity.Notice;
import dmucs.dmu.notice.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DBNoticeDataProcessor implements NoticeDataProcessor {
    private final JpaNoticeRepository jpaNoticeRepository;

    @Override
    public void updateNotice(Notice[] notices) {
        jpaNoticeRepository.saveAll(notices);
    }

    public List<Notice> getNoticeByList (int page, int pageListSize) {
        return jpaNoticeRepository.findPageList(page * pageListSize);
    }
}
