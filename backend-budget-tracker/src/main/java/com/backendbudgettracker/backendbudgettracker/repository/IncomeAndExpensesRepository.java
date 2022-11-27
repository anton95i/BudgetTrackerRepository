package com.backendbudgettracker.backendbudgettracker.repository;

import com.backendbudgettracker.backendbudgettracker.entity.IncomeAndExpenses;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeAndExpensesRepository extends JpaRepository<IncomeAndExpenses, Long> {

    Optional<IncomeAndExpenses> findByUserId(Long userId);

}