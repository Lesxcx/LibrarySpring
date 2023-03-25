package com.konrad_szydlowski.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user_id = getUser_id();

    @Column(name = "book_id")
    private Long book_id = getBook_id();

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "max_term")
    private LocalDate maxTerm;

    @Column(name = "returning_date")
    private LocalDate returningDate;

}
