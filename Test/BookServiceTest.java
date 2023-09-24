import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import seminars.fourth.book.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookById() {
        // Создаем мок-объект Book и устанавливаем его поведение при вызове findById
        Book expectedBook = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(expectedBook);

        // Вызываем метод findBookById
        Book result = bookService.findBookById("1");

        // Проверяем, что возвращенная книга совпадает с ожидаемой
        assertEquals(expectedBook, result);
    }

    @Test
    void testFindAllBooks() {
        // Создаем мок-список книг и устанавливаем его поведение при вызове findAll
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book1", "Author1"));
        expectedBooks.add(new Book("2", "Book2", "Author2"));
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Вызываем метод findAllBooks
        List<Book> result = bookService.findAllBooks();

        // Проверяем, что возвращенный список книг совпадает с ожидаемым
        assertEquals(expectedBooks, result);
    }
}
