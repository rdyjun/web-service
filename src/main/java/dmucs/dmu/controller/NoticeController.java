package dmucs.dmu.controller;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import dmucs.dmu.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    private final JpaNoticeRepository jpaNoticeRepository;

    @PostMapping("/update")
    public List<Notice> notice () {
        noticeService.noticeUpdate();
        return jpaNoticeRepository.findAll();
    }
    @PostMapping("/all")
    public List<Notice> findall(){
        return noticeService.findAll();
    }
    @PostMapping("/{page}")
    public List<Notice> getPageNotice (@PathVariable("page") int page) {
        return noticeService.getNoticeList(page);
    }

    @PostMapping("/content/{nId}")
    public Optional<String> getPageNotice (@PathVariable("nId") long nId) {
        return noticeService.getNoticeContent(nId);
    }
    @PostMapping("/create")
    public void noticeCreate (@RequestBody Notice notice) {
        noticeService.save(notice);
    }
}
