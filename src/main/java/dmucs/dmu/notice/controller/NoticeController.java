package dmucs.dmu.notice.controller;

import dmucs.dmu.notice.service.NoticeService;
import dmucs.dmu.notice.entity.Notice;
import dmucs.dmu.notice.repository.JpaNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final JpaNoticeRepository jpaNoticeRepository;
    private final NoticeService noticeService;

    @PostMapping("/{page}")
    public List<Notice> getPageNotice (@PathVariable("page") int page) {
        return noticeService.getNoticeList(page);
    }

    @PostMapping("/content/{nId}")
    public String getPageNotice (@PathVariable("nId") long nId) {
        return noticeService.getContent(nId);
    }
}
