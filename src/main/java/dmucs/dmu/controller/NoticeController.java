package dmucs.dmu.controller;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import dmucs.dmu.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    private final JpaNoticeRepository jpaNoticeRepository;

    @PostMapping("")
    public List<Notice> notice () {
        noticeService.noticeUpdate();
        return jpaNoticeRepository.findAll();
    }
    @PostMapping("/pagelist")
    public List<Notice> getPageNotice (@RequestBody Map<String, Long> map) {
        return noticeService.getNoticeList(map.get("less"), map.get("greater"));
    }

    @PostMapping("/{nId}")
    public List<Notice> getPageNotice (@PathVariable("nId") long nId) {
        return noticeService.getNoticePage(nId);
    }
    @PostMapping("/create")
    public void noticeCreate (@RequestBody Notice notice) {
        noticeService.save(notice);
    }
}
