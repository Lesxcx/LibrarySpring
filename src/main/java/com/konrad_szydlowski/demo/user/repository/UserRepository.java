package com.konrad_szydlowski.demo.user.repository;

import com.konrad_szydlowski.demo.user.repository.table.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
