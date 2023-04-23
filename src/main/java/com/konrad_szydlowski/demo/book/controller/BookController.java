package com.konrad_szydlowski.demo.book.controller;

import com.konrad_szydlowski.demo.book.exception.BookException;
import com.konrad_szydlowski.demo.book.model.dto.BookDto;
import com.konrad_szydlowski.demo.book.model.dto.BookGenreInfo;
import com.konrad_szydlowski.demo.book.model.dto.BookLanguageInfo;
import com.konrad_szydlowski.demo.book.repository.table.Book;
import com.konrad_szydlowski.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    final BookService bookService;

    @PostMapping("")
    public Book addBook(@RequestBody Book book){

        return bookService.addBook(book);
    }

    @GetMapping("/genre/{genre}")
    public List<BookGenreInfo> findBookByGenre(@PathVariable(value = "genre")String genre){
        return bookService.findByGenre(genre);
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable(value = "id")Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/language/{language}")
    public List<BookLanguageInfo> findBookByLanguage(@PathVariable(value = "language")String language) {
        return bookService.findByLanguage(language);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBookById(@PathVariable(value = "id")Long id) throws BookException {
        return bookService.deleteById(id);
    }
}
