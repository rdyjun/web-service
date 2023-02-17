package dmucs.dmu.repository;

import dmucs.dmu.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaNoticeRepository extends JpaRepository<Notice, Long> {
    Optional<Notice> findByNoticeTitle(String noticeTitle);
    Optional<Notice> findByNoticeDate(String noticeDate);

    @Query("SELECT n FROM Notice n WHERE n.noticeTitle = :noticeTitle AND n.noticeDate = :noticeDate")
    Optional<Notice> findByNoticeTitleDate(@Param("noticeTitle") String noticeTitle, @Param("noticeDate") String noticeDate);
    @Query("SELECT n.noticeId, n.noticeTitle, n.noticeAuthor, n.noticeDate FROM Notice n WHERE n.noticeId <= :less AND n.noticeId >= :greater")
    List<Notice> findPageList(@Param("less") Long less, @Param("greater") Long greater);

    @Query("SELECT n FROM Notice n WHERE n.noticeId = :nId")
    List<Notice> findPage(@Param("nId") Long nId);
}
