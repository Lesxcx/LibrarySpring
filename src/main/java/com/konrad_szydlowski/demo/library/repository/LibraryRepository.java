package com.konrad_szydlowski.demo.library.repository;

import com.konrad_szydlowski.demo.library.repository.table.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    public void getReturningDate();
}
