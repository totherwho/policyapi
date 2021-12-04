package org.climatepolicyradar.policyapi.repository;

import org.climatepolicyradar.policyapi.model.Policy;
import org.climatepolicyradar.policyapi.model.PolicySector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtlRepositoryJdbc implements EtlRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void flush() {
        namedParameterJdbcTemplate.getJdbcTemplate().update("delete from policyapi.policies");
        namedParameterJdbcTemplate.getJdbcTemplate().update("delete from policyapi.policy_sectors");
    }

    @Override
    public void savePolicies(List<Policy> policies) {

        String sql = "insert into policyapi.policies (id, title, description) values (:id, :title, :description)";

        SqlParameterSource[] parameters = policies.stream()
                .map(value -> {

                    MapSqlParameterSource map = new MapSqlParameterSource();

                    map.addValue("id", value.getId());
                    map.addValue("title", value.getTitle());
                    map.addValue("description", value.getDescription());

                    return map;
                }).toArray(SqlParameterSource[]::new);

        namedParameterJdbcTemplate.batchUpdate(sql, parameters);

    }

    @Override
    public void savePolicySectors(List<PolicySector> policySectors) {

        String sql = "insert into policyapi.policy_sectors (policy_id, sector) values (:policy_id, :sector)";

        SqlParameterSource[] parameters = policySectors.stream()
                .map(value -> {

                    MapSqlParameterSource map = new MapSqlParameterSource();

                    map.addValue("policy_id", value.getPolicyId());
                    map.addValue("sector", value.getSector());

                    return map;
                }).toArray(SqlParameterSource[]::new);

        namedParameterJdbcTemplate.batchUpdate(sql, parameters);

    }






}
