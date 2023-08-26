package dmucs.dmu.notice.entity;

public interface NoticeProcessing {
    public long recentNoticeId ();

    Notice[] getRecentNotice(String division, Long nowNoticeNumber);
}
