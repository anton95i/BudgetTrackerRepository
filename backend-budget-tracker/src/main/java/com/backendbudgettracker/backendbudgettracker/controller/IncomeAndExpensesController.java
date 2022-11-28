package com.backendbudgettracker.backendbudgettracker.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backendbudgettracker.backendbudgettracker.entity.IncomeAndExpenses;
import com.backendbudgettracker.backendbudgettracker.repository.IncomeAndExpensesRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/incomeAndExpenses")
@CrossOrigin
public class IncomeAndExpensesController {

    private IncomeAndExpensesRepository incomeAndExpensesRepository;

    @Autowired
    private JwtHelper jwtHelper;

    public IncomeAndExpensesController(IncomeAndExpensesRepository incomeAndExpensesRepository) {
        this.incomeAndExpensesRepository = incomeAndExpensesRepository;
    }

    @GetMapping("")
    public List<IncomeAndExpenses> getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        if (userId != null) {
            List<IncomeAndExpenses> incomeAndExpenses = incomeAndExpensesRepository.findAll();
            List<IncomeAndExpenses> tempList = new ArrayList<IncomeAndExpenses>();
            for (IncomeAndExpenses incomeAndExpenses2 : incomeAndExpenses) {
                if (incomeAndExpenses2.getUserId() == userId) {
                    tempList.add(incomeAndExpenses2);
                }
            }
            return tempList;
        }
        response.sendError(401);
        return null;
    }

}
        