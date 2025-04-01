package com.grepp.jdbc;

import com.grepp.jdbc.infra.db.JdbcTemplate;
import com.grepp.jdbc.infra.exception.DataAccessException;
import com.grepp.jdbc.view.Index;

// NOTE 01 JDBC API
public class Run {
    
    public static void main(String[] args) {
        
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
            String user = "bm";
            String password = "1q2w3e!@#";
            
            JdbcTemplate.init(url, user, password);
            
            new Index().menu();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
