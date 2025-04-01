package com.grepp.jdbc.app.book;

import com.grepp.jdbc.app.book.dao.BookDao;
import com.grepp.jdbc.app.book.dto.BookDto;
import com.grepp.jdbc.app.member.dto.MemberDto;
import com.grepp.jdbc.infra.db.JdbcTemplate;
import com.grepp.jdbc.infra.exception.DataAccessException;
import java.sql.Connection;
import java.util.List;

public class BookService {
  private static final BookService instance = new BookService();
  private final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
  private final BookDao bookDao = new BookDao();

  public static BookService getInstance() { return instance; }

  public List<BookDto> selectAllbook(){
    Connection conn = jdbcTemplate.getConnection();
    try{
      return bookDao.selectAll(conn);
    } finally {
      jdbcTemplate.close(conn);
    }
  }

  public BookDto insertBook(BookDto dto){
    Connection conn = jdbcTemplate.getConnection();
    try{
      bookDao.insertBook(conn, dto);
      jdbcTemplate.commit(conn);

      return dto;
    } catch (DataAccessException e){
      jdbcTemplate.rollback(conn);
      throw e;
    } finally {
      jdbcTemplate.close(conn);
    }
  }

  public BookDto deleteBook(int bkIdx){
    Connection conn = jdbcTemplate.getConnection();
    try{
      bookDao.deleteBook(conn, bkIdx);
      jdbcTemplate.commit(conn);

      BookDto dto = new BookDto();
      dto.setBkIdx(bkIdx);

      return dto;
    } catch (DataAccessException e){
      jdbcTemplate.rollback(conn);
      throw e;
    } finally {
      jdbcTemplate.close(conn);
    }
  }

  public BookDto updateBook(int bkIdx, String info){
    Connection conn = jdbcTemplate.getConnection();
    try{
      bookDao.updateBook(conn, bkIdx, info);
      jdbcTemplate.commit(conn);

      BookDto dto = new BookDto();
      dto.setBkIdx(bkIdx);
      dto.setInfo(info);

      return dto;
    } catch (DataAccessException e){
      jdbcTemplate.rollback(conn);
      throw e;
    } finally {
      jdbcTemplate.close(conn);
    }
  }
}
