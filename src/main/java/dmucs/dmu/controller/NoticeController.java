package dmucs.dmu.controller;

import dmucs.dmu.notice.Notice;
import dmucs.dmu.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/notice")
    public Notice[] notice () {
        return noticeService.noticeUpdate();
    }
}
