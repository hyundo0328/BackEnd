package com.grepp.jdbc.infra.db;

import com.grepp.jdbc.infra.exception.JdbcInitializeException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 싱글턴으로 작성: 앱 실행될 때 한 번만 실행되므로
public class JdbcTemplate {
  private String url;
  private String user;
  private String password;

  private static JdbcTemplate instance;

  public static JdbcTemplate getInstance(){
    if(instance == null) throw new JdbcInitializeException("JdbcTemplate not initialized, please call init()");

    return instance;
  }

  public static JdbcTemplate init(String url, String user, String password){
    if(instance == null){
      instance = new JdbcTemplate(url, user, password);
    }

    return instance;
  }

  public JdbcTemplate(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new JdbcInitializeException(e.getMessage(), e);
    }
  }

  public Connection getConnection(){
    Connection conn = null;

    try{
      conn = DriverManager.getConnection(url,user,password);

      return conn;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void close(Connection conn){
    try {
      if(conn != null || conn.isClosed()) return;
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
