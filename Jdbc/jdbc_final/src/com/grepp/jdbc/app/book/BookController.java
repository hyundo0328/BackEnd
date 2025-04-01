package com.grepp.jdbc.app.book;

import com.google.gson.Gson;
import com.grepp.jdbc.app.book.dto.form.RegistForm;
import com.grepp.jdbc.app.book.validator.BkIdxValidator;
import com.grepp.jdbc.app.book.validator.RegistValidator;
import com.grepp.jdbc.infra.json.GsonProvider;

public class BookController {

  private static final BookController instance = new BookController();
  private final BookService bookService = BookService.getInstance();
  private final RegistValidator registValidator = new RegistValidator();
  private final BkIdxValidator bkIdxValidator = new BkIdxValidator();
  private final Gson gson = GsonProvider.get();

  public static BookController getInstance(){ return instance; }

  public String getAll() {
    return gson.toJson(bookService.selectAllbook());
  }

  public String registBook(RegistForm registForm) {
    registValidator.validate(registForm);
    return gson.toJson(bookService.insertBook(registForm.toDto()));
  }

  public String modifyBookInfo(Integer bkIdx, String info) {
    bkIdxValidator.validate(bkIdx);
    return gson.toJson(bookService.updateBook(bkIdx, info));
  }

  public String deleteBook(Integer bkIdx) {
    bkIdxValidator.validate(bkIdx);
    return gson.toJson(bookService.deleteBook(bkIdx));
  }
}
