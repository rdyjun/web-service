package dmucs.dmu.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@AllArgsConstructor
public class Member extends MemberDTO{

    public Member() {}
}
