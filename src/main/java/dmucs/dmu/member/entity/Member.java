package dmucs.dmu.member.entity;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name = "dmu_member")
@DynamicInsert
@Getter
@ToString
public class Member
        implements UserDetails {
    @Id @Column(name = "memberCode", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCode = 0L;         // 고유번호
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "memberGradeId", nullable = false)
    @ColumnDefault(value = "5")
    private Grade grade = new Grade(5L);            // 권한
    @Column(name = "memberPassword", nullable = false)
    private String memberPassword;        // 비밀번호
    @Column(name = "email", nullable = false)
    private String email;                 // 이메일
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deptId", nullable = false)
    private Department department;        // 학과

    public Member () {}
    public Member (String memberPassword, String email, Department department){
        this.memberPassword = memberPassword;
        this.email = email;
        this.department = department;
    }
    public Member (Member member, String pw) {
        this.memberPassword = pw;
        this.email = member.getEmail();
        this.department = member.getDepartment();
    }
    public String getEmailId () {
        return this.email.substring(0, this.email.lastIndexOf("@"));
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(this.grade.getName()));
        return Arrays.asList(this.grade.getName()).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
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
