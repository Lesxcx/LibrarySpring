package com.konrad_szydlowski.demo.library.repository.table;

import com.konrad_szydlowski.demo.book.repository.BookRepository;
import com.konrad_szydlowski.demo.user.repository.UserRepository;
import com.konrad_szydlowski.demo.user.repository.table.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "max_term")
    private LocalDate maxTerm;

    @Column(name = "returning_date")
    private LocalDate returningDate;

    public Library(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.rentDate = LocalDate.now();
        this.maxTerm = LocalDate.now().plusDays(30);
        this.returningDate = null;
    }
}
