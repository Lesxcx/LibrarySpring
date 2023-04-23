package com.konrad_szydlowski.demo.library.service;

import com.konrad_szydlowski.demo.book.repository.BookRepository;
import com.konrad_szydlowski.demo.library.exception.LibraryException;
import com.konrad_szydlowski.demo.library.repository.LibraryRepository;
import com.konrad_szydlowski.demo.library.repository.table.Library;
import com.konrad_szydlowski.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class LibraryService {

    final LibraryRepository libraryRepository;
    final UserRepository userRepository;
    final BookRepository bookRepository;

    public Library rentBook(Long bookId, Long userId) throws LibraryException {
        Long uId = userRepository.findById(userId)
                .orElseThrow(() -> new LibraryException("Not found user on: " + userId)).getId();

        Long bId = bookRepository.findById(bookId).orElseThrow(() -> new LibraryException("Not found book on: " + bookId))
                .getId();


        if(libraryRepository.findById(bId).orElseThrow(() -> new LibraryException("")).getReturningDate().equals(null) ){
            throw new LibraryException("Book on " + bId + " is rent by now.");
        } else {
            return libraryRepository.save(new Library(uId, bId));
        }




    }

}
