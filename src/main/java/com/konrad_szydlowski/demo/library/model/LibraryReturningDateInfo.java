package com.konrad_szydlowski.demo.library.model;

import java.time.LocalDate;

public record LibraryReturningDateInfo (Long userId, Long bookId, LocalDate returningDate){
}
