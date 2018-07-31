package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 1カラムの1件
    // Idから名前を引っ張ってくる
    public String getSampleName(Long id) {
        String sql = "SELECT NAME FROM SAMPLE WHERE ID=:id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
    }

    // 1カラムの複数件
    // 名前からIdを引っ張ってくる
    public List<Integer> findSampleIdByName(String name) {
        String sql = "SELECT ID FROM SAMPLE WHERE NAME=:name";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", name);

        return namedParameterJdbcTemplate.queryForList(sql, params, Integer.class);
    }

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
    }


}
