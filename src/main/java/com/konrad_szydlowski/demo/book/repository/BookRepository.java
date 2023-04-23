package com.konrad_szydlowski.demo.book.repository;

import com.konrad_szydlowski.demo.book.repository.table.Book;
import com.konrad_szydlowski.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
