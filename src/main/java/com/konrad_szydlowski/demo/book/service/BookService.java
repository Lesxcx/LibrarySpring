package com.konrad_szydlowski.demo.book.service;

import com.konrad_szydlowski.demo.book.model.dto.BookDto;
import com.konrad_szydlowski.demo.book.repository.BookRepository;
import com.konrad_szydlowski.demo.book.repository.table.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookDto findBookById(final Long id){
        final Book bookById = bookRepository.getBookById(id);

        return new BookDto(bookById.getName(), bookById.getAuthor());

    }



}
