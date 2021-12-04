package org.climatepolicyradar.policyapi.repository;

import org.climatepolicyradar.policyapi.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchRepositoryJdbc implements SearchRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Policy> fetch(List<String> terms) {

        // TODO validate against sql injection
        String termString = String.join("|",terms);

        String sql = "SELECT id, title, description\n" +
                "FROM policyapi.policies\n" +
                "WHERE to_tsvector(description) @@ to_tsquery(:terms);";

        List<Policy> policies = namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource().addValue("terms", termString),
                new BeanPropertyRowMapper<>(Policy.class));

        return policies;
    }
}
