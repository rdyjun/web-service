package dmucs.dmu.controller;

import com.univcert.api.UnivCert;
import dmucs.dmu.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RequestMapping("/certify")
@RestController
@RequiredArgsConstructor
public class MailCertify {
    private String apiKey = "978834b8-05a0-483a-ba37-fd420c165f35";

    @PostMapping("/check")
    public void checkEmail (@RequestBody Map<String, String> map) throws IOException {
        UnivCert.certify(apiKey, map.get("email"), "동양미래대학교", (Boolean) UnivCert.check("동양미래대학교").get("success"));
    }
    @PostMapping("/code")
    public boolean checkCode (@RequestBody Map<String, String> map) throws IOException {
        return (boolean) UnivCert.certifyCode(apiKey, map.get("email"), "동양미래대학교", Integer.parseInt(map.get("code"))).get("success");
    }
}
