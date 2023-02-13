package dmucs.dmu.controller;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.repository.JpaNoticeRepository;
import dmucs.dmu.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    private final JpaNoticeRepository jpaNoticeRepository;

    @PostMapping("/notice")
    public List<Notice> notice () {
        noticeService.noticeUpdate();
        return jpaNoticeRepository.findAll();
    }
    @PostMapping("/notice/create")
    public void noticeCreate (@RequestBody Notice notice) {
        noticeService.save(notice);
    }
}
