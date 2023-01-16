package dmucs.dmu;

import dmucs.dmu.service.MemberService;

public class MemberApp {
    SpringConfig springConfig = new SpringConfig();
    MemberService memberService = springConfig.memberService();

}
