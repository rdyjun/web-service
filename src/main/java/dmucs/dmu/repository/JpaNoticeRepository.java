package dmucs.dmu.repository;

import dmucs.dmu.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface JpaNoticeRepository extends JpaRepository<Notice, Long>, JpaSpecificationExecutor<Notice> {
    Optional<Notice> findByNoticeTitle(String noticeTitle);
    Optional<Notice> findByNoticeDate(String noticeDate);
}
