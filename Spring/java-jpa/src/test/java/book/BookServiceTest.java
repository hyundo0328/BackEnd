package book;

import org.junit.jupiter.api.Test;

class BookServiceTest {

  private final BookService bookService = new BookService();

  @Test
  public void add(){
    Book book = new Book();
    book.setTitle("해리포터22222");
    book.setAuthor("조앤롤링");
    bookService.add(book);
  }

}