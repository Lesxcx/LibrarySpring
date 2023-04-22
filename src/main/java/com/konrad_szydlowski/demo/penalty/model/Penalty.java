package com.konrad_szydlowski.demo.penalty.model;

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
@Table(name = "penalty")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id = getUser_id();

    @Column(name = "penalty_start_day")
    private LocalDate penaltyDayStart;

    @Column(name = "penalty_expiry_day")
    private LocalDate penaltyExpiryDay;

    @Column(name = "active")
    private boolean active;
}
