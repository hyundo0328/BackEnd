package com.grepp.jdbc.app.book.dao;

import com.grepp.jdbc.app.book.code.Category;
import com.grepp.jdbc.app.book.dto.BookDto;
import com.grepp.jdbc.infra.db.JdbcTemplate;
import com.grepp.jdbc.infra.exception.DataAccessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao {

  private static final BookDao instance = new BookDao();
  private final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

  public static BookDao getInstance() { return instance; }


  public List<BookDto> selectAll(Connection conn) {
    String sql = "select * from book";
    List<BookDto> books = new ArrayList<>();

    try(PreparedStatement pt = conn.prepareStatement(sql)){
      try(ResultSet rset = pt.executeQuery()){
        while(rset.next()){
          books.add(generateBookDto(rset));
        }

        return books;
      }
    } catch (SQLException e) {
      throw new DataAccessException(e.getMessage(), e);
    }
  }

  private BookDto generateBookDto(ResultSet rset) throws SQLException {
    BookDto res = new BookDto();
    res.setBkIdx(rset.getInt("bk_idx"));
    res.setIsbn(rset.getString("isbn"));
    res.setCategory(Category.valueOf(rset.getString("category")));
    res.setTitle(rset.getString("title"));
    res.setAuthor(rset.getString("author"));
    res.setInfo(rset.getString("info"));
    res.setAmount(rset.getInt("book_amt"));
    res.setRegDate(rset.getObject("reg_date", LocalDateTime.class));

    return res;
  }

  public BookDto insertBook(Connection conn, BookDto dto) {
    String sql = "insert into book(isbn, category, title, author, info, book_amt, reg_date, rent_cnt) "
        + "values(?,?,?,?,?,?,?,?)";

    try(PreparedStatement pt = conn.prepareStatement(sql)){
      pt.setString(1, dto.getIsbn());
      pt.setString(2, dto.getCategory().name());
      pt.setString(3, dto.getTitle());
      pt.setString(4, dto.getAuthor());
      pt.setString(5, dto.getInfo());
      pt.setInt(6, dto.getAmount());
      pt.setObject(7, dto.getRegDate());
      pt.setInt(8, 0);

      pt.executeUpdate();
      return dto;
    } catch (SQLException e) {
      throw new DataAccessException(e.getMessage(), e);
    }
  }

  public void deleteBook(Connection conn, int bkIdx) {
    String sql = "delete from book where bk_idx = ?";

    try(PreparedStatement pt = conn.prepareStatement(sql)){
      pt.setInt(1, bkIdx);
      pt.executeUpdate();
    } catch (SQLException e) {
      throw new DataAccessException(e.getMessage(), e);
    }
  }

  public void updateBook(Connection conn, Integer bkIdx, String info) {
    String sql = "update book set info = ? where bk_idx = ?";

    try(PreparedStatement pt = conn.prepareStatement(sql)){
      pt.setString(1, info);
      pt.setInt(2, bkIdx);
      pt.executeUpdate();
    } catch (SQLException e) {
      throw new DataAccessException(e.getMessage(), e);
    }
  }
}
