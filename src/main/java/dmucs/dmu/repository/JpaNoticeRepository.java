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
    @Query("SELECT n FROM Notice n WHERE n.noticeNumber <= :less AND n.noticeNumber >= :greater")
    List<Notice> findPage(@Param("less") Long less, @Param("greater") Long greater);
}
