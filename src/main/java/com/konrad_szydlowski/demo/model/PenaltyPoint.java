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
@Table(name = "penalty_point")
public class PenaltyPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_point_id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id = getUser_id();

    @Column(name = "penalty_point_start_day")
    private LocalDate penaltyPointDayStart;

    @Column(name = "penalty_point_expiry_day")
    private LocalDate penaltyPointExpiryDay;

    @Column(name = "amount")
    private int amount;
}
