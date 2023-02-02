package dmucs.dmu.repository;

import dmucs.dmu.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaNoticeRepository extends JpaRepository<Notice, Long> {
    public Optional<Notice> findByTitleDate(String noticeTitle, String noticeDate);
}
