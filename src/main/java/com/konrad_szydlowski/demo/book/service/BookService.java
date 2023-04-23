package com.konrad_szydlowski.demo.book.service;

import com.konrad_szydlowski.demo.book.exception.BookException;
import com.konrad_szydlowski.demo.book.model.dto.BookDto;
import com.konrad_szydlowski.demo.book.model.dto.BookGenreInfo;
import com.konrad_szydlowski.demo.book.model.dto.BookLanguageInfo;
import com.konrad_szydlowski.demo.book.repository.BookRepository;
import com.konrad_szydlowski.demo.book.repository.table.Book;
import com.konrad_szydlowski.demo.exception.ResourseNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookDto findBookById(final Long id){
        final Book bookById = bookRepository.findById(id).stream().filter(book -> Objects.equals(book.getId(), id)).findFirst()
                .orElseThrow(() -> new BookException("There is no book of that id " + id));

        return new BookDto(bookById.getName(), bookById.getAuthor());
    }

    public List<BookGenreInfo> findByGenre(final String genre){
        final List<Book> bookByGenre = bookRepository.findAll().stream()
                .filter(book -> Objects.equals(book.getBookGenre(), genre)).toList();

        return bookByGenre.stream().map(book -> new BookGenreInfo(book.getName(), book.getAuthor(), book.getBookGenre()))
                .toList();
    }

    public List<BookLanguageInfo> findByLanguage(final String language) {
        final List<Book> bookByLanguage = bookRepository.findAll().stream()
                .filter(book -> Objects.equals(book.getLanguage(), language)).toList();

        return bookByLanguage.stream().map(book -> new BookLanguageInfo(book.getName(), book.getAuthor(), book.getBookGenre()))
                .toList();
    }

    public Book addBook(Book book){

        return bookRepository.save(book);
    }

    public Map<String, Boolean> deleteById(Long bookId) throws BookException{
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException("Book not found on: "
        + bookId));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
