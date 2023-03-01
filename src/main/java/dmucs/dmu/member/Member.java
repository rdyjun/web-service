package dmucs.dmu.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "dmu_member")
@Getter
@ToString
public class Member implements UserDetails {
    @Id @Column(name = "memberCode", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCode = 0L;         // 고유번호
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "memberGradeId", nullable = false, insertable = false)
    @ColumnDefault(value = "5")
    private Grade grade;            // 권한
    @Column(name = "memberPassword", nullable = false)
    private String memberPassword;        // 비밀번호
    @Column(name = "email", nullable = false)
    private String email;                 // 이메일
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deptId", nullable = false)
    private Department department;        // 학과

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public Member () {}
    public Member (String memberPassword, String email, Department department){
        this.memberPassword = memberPassword;
        this.email = email;
        this.department = department;
    }
    public Member (Member member, String pw) {
        this.memberCode = member.getMemberCode();
        this.grade = member.getGrade();
        this.memberPassword = pw;
        this.email = member.getEmail();
        this.department = member.getDepartment();
    }
    public Member (String email, String memberPassword) {
        this.email = email;
        this.memberPassword = memberPassword;
    }
    public String getEmailId () {
        return this.email.substring(0, this.email.lastIndexOf("@"));
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return memberPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
