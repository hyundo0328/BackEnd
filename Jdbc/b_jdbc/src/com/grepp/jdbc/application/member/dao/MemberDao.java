package com.grepp.jdbc.application.member.dao;

import com.grepp.jdbc.application.member.code.Grade;
import com.grepp.jdbc.application.member.dto.MemberDto;
import com.grepp.jdbc.infra.db.JdbcTemplate;
import com.grepp.jdbc.infra.exception.DataAccessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

// NOTE 02 DAO
// Data Access Object
public class MemberDao {

  private final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

  private static void select(MemberDao dao){
    Optional<MemberDto> res = dao.selectByIdAndPassword("test", "9999");

    if(res.isPresent()){
      System.out.println(res.get());
      return;
    }

    System.out.println("존재하지 않는 사용자 입니다.");
  }

  // Optional을 사용하여 이것을 사용하는 사람이 에러가 발생하는 경우를 줄여줌
  public Optional<MemberDto> insert(MemberDto dto){
    String sql = "insert into member(user_id, password, email, grade, tell) "
        + "values(?,?,?,?,?)";
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    try(
        Connection conn = jdbcTemplate.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        // Statement stmt = conn.createStatement();
    ) {

      stmt.setString(1, dto.getUserId());
      stmt.setString(2, dto.getPassword());
      stmt.setString(3, dto.getEmail());
      stmt.setString(4, dto.getGrade().name());
      stmt.setString(5, dto.getTell());

      System.out.println(stmt);

      int res = stmt.executeUpdate();
      return res > 0 ? Optional.of(dto) : Optional.empty();
    } catch (SQLException ex) {
      // 컴퓨터 데이터 처리 과정에서 발생하는 에러라 우리가 대처할 수 없음
      throw new DataAccessException(ex.getMessage(), ex);
    }

    // 그래서 return new MemberDto()가 필요없음 무조건 try문에서 처리 됨
  }

  public Optional<MemberDto> selectByIdAndPassword(String id, String password){
    String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
    String sql = "select * from member where user_id = ? and password = ?";

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    try(
        Connection conn = DriverManager.getConnection(url, "bm", "1q2w3e!@#");
        PreparedStatement stmt = conn.prepareStatement(sql);
        // Statement stmt = conn.createStatement();
    ) {

      stmt.setString(1, id);
      stmt.setString(2, password);
      MemberDto dto = null; // return이 1개만 있다고 확신하기 때문에

      try(ResultSet rset = stmt.executeQuery()) {
        while(rset.next()){ // (1개이므로 if로 사용해도 됨)
          dto = new MemberDto(); // 이렇게 사용
          dto.setUserId(rset.getString("user_id"));
          dto.setPassword(rset.getString("password"));
          dto.setEmail(rset.getString("email"));
          dto.setTell(rset.getString("tell"));
          dto.setLeave(rset.getBoolean("is_leave"));
          dto.setGrade(Grade.valueOf(rset.getString("grade")));
        }

      }

      return Optional.ofNullable(dto);
    } catch (SQLException ex) {
      throw new DataAccessException(ex.getMessage(), ex);
    }

  }

  public Optional<MemberDto> update(MemberDto dto){
    String sql = "update member set password = ? where user_id = ?";

    try(
        Connection conn = jdbcTemplate.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
    ) {
      stmt.setString(1, dto.getPassword());
      stmt.setString(2, dto.getUserId());
      System.out.println(stmt);
      int res = stmt.executeUpdate();

      return res > 0 ? Optional.of(dto) : Optional.empty();
    } catch (SQLException ex) {
      throw new DataAccessException(ex.getMessage(), ex);
    }
  }

  public Optional<MemberDto> delete(MemberDto dto){
    String sql = "delete from member where user_id = ?";

    try(
        Connection conn = jdbcTemplate.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
    ) {
      stmt.setString(1, dto.getUserId());
      int res = stmt.executeUpdate();
      return res > 0 ? Optional.of(dto) : Optional.empty();
    } catch (SQLException ex) {
      throw new DataAccessException(ex.getMessage(), ex);
    }

  }

}