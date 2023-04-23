package com.konrad_szydlowski.demo.library.model;

import java.time.LocalDate;

public record LibraryRentDateInfo(Long userId, Long bookId, LocalDate rentDate) {
}
