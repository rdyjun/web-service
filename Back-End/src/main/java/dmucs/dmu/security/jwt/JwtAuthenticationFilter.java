package dmucs.dmu.security.jwt;

import dmucs.dmu.member.service.LoginService;
import dmucs.dmu.security.Component.JwtTokenProvider;
import dmucs.dmu.security.entity.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;
    private final LoginService loginService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1. Request Header 에서 JWT 토큰 추출
        String token = resolveToken((HttpServletRequest) request, "Authorization");

        // 2. validateToken 으로 토큰 유효성 검사
        if (token != null) {
            if (jwtTokenProvider.validateToken(token)) {
                // 토큰이 유효할 경우 토큰에서 Authentication 객체를 가지고 와서 SecurityContext 에 저장
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                //토큰이 유효하지 않을 경우 리프레시 토큰 검사
                String refToken = resolveToken((HttpServletRequest) request, "Set-Cookie");
                if (jwtTokenProvider.validateToken(refToken)) {
                    SecurityContext securityContext = (SecurityContext) SecurityContextHolder.getContext().getAuthentication();
                    TokenInfo tk =  jwtTokenProvider.generateToken(securityContext.getAuthentication());
                }
            }
        }
        chain.doFilter(request, response);
    }


    // Request Header 에서 토큰 정보 추출
    private String resolveToken(HttpServletRequest request, String headerName) {
        String bearerToken = request.getHeader(headerName);  // 서블릿 헤더에서 Authorization 값 가져오기
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {  // 문자열이 null값인지 + Bearer로 시작하는지 검사
            return bearerToken.substring(7);  // 토큰 리턴
        }
        return null;
    }
}
