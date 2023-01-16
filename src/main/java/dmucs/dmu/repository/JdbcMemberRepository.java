package dmucs.dmu.repository;

import dmucs.dmu.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcMemberRepository implements MemberRepositoryInterface{

    private final JdbcTemplate jdbcTemplate;

    public JdbcMemberRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("studentId");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("studenId", member.getStudentId());

        String key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters)).toString();
        member.setStudentId(key);
        return member;
    }

    @Override
    public Optional<Member> findById(String studentId) {
        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), studentId);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper () {
        return (rs, rowNum) -> {
                Member member = new Member();
                member.setStudentId(rs.getString("studentId"));
                member.setName(rs.getString("name"));
                return member;
        };
    }
}
