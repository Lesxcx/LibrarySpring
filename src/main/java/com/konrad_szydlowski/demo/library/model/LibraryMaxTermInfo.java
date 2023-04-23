package com.konrad_szydlowski.demo.library.model;

import java.time.LocalDate;

public record LibraryMaxTermInfo(Long userId, Long bookId, LocalDate maxTerm) {
}
