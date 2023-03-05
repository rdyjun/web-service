package dmucs.dmu.notice.repository;

import dmucs.dmu.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaNoticeRepository extends JpaRepository<Notice, Long> {
    @Query("SELECT n FROM Notice n WHERE n.noticeTitle = :noticeTitle AND n.noticeDate = :noticeDate")
    Optional<Notice> findByNoticeTitleDate(@Param("noticeTitle") String noticeTitle, @Param("noticeDate") String noticeDate);
    @Query("SELECT n.noticeId, n.noticeTitle, n.noticeAuthor, n.noticeDate FROM Notice n WHERE n.noticeId <= (:page * 10)")
    List<Notice> findPageList(@Param("page") int page);
    @Query("SELECT n.noticeContent FROM Notice n WHERE n.noticeId = :nId")
    Optional<String> findContent(@Param("nId") Long nId);
}
