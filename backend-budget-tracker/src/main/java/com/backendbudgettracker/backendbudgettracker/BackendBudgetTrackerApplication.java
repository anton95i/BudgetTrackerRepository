package com.backendbudgettracker.backendbudgettracker;

import javax.annotation.PostConstruct;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.backendbudgettracker.backendbudgettracker.entity.Image;
import com.backendbudgettracker.backendbudgettracker.entity.IncomeAndExpenses;
import com.backendbudgettracker.backendbudgettracker.entity.Image.Type;
import com.backendbudgettracker.backendbudgettracker.entity.User;
import com.backendbudgettracker.backendbudgettracker.repository.ImageRepository;
import com.backendbudgettracker.backendbudgettracker.repository.IncomeAndExpensesRepository;
import com.backendbudgettracker.backendbudgettracker.repository.UserRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtTokenProvider;

@SpringBootApplication
public class BackendBudgetTrackerApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private IncomeAndExpensesRepository incomeAndExpensesRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendBudgetTrackerApplication.class, args);
	}

	@PostConstruct
	public void init() {

		IncomeAndExpenses incomeAndExpenses = new IncomeAndExpenses();
		incomeAndExpenses.setUserId(Long.parseLong("1"));
		incomeAndExpenses.setTitle("Salary - May 2022");
		incomeAndExpenses.setAmount(6543.52);
		incomeAndExpenses.setDate(Timestamp.valueOf("2022-05-01 12:00:00"));
		incomeAndExpenses.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses);

		IncomeAndExpenses incomeAndExpenses2 = new IncomeAndExpenses();
		incomeAndExpenses2.setUserId(Long.parseLong("1"));
		incomeAndExpenses2.setTitle("Salary - June 2022");
		incomeAndExpenses2.setAmount(6543.52);
		incomeAndExpenses2.setDate(Timestamp.valueOf("2022-06-01 12:00:00"));
		incomeAndExpenses2.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses2.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses2);

		IncomeAndExpenses incomeAndExpenses3 = new IncomeAndExpenses();
		incomeAndExpenses3.setUserId(Long.parseLong("1"));
		incomeAndExpenses3.setTitle("Salary - July 2022");
		incomeAndExpenses3.setAmount(12918.58);
		incomeAndExpenses3.setDate(Timestamp.valueOf("2022-07-01 12:00:00"));
		incomeAndExpenses3.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses3.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses3);

		IncomeAndExpenses incomeAndExpenses4 = new IncomeAndExpenses();
		incomeAndExpenses4.setUserId(Long.parseLong("1"));
		incomeAndExpenses4.setTitle("Salary - August 2022");
		incomeAndExpenses4.setAmount(6543.52);
		incomeAndExpenses4.setDate(Timestamp.valueOf("2022-08-01 12:00:00"));
		incomeAndExpenses4.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses4.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses4);

		IncomeAndExpenses incomeAndExpenses5 = new IncomeAndExpenses();
		incomeAndExpenses5.setUserId(Long.parseLong("1"));
		incomeAndExpenses5.setTitle("Salary - September 2022");
		incomeAndExpenses5.setAmount(6543.52);
		incomeAndExpenses5.setDate(Timestamp.valueOf("2022-09-01 12:00:00"));
		incomeAndExpenses5.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses5.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses5);

		IncomeAndExpenses incomeAndExpenses6 = new IncomeAndExpenses();
		incomeAndExpenses6.setUserId(Long.parseLong("1"));
		incomeAndExpenses6.setTitle("Billa");
		incomeAndExpenses6.setAmount(68.93);
		incomeAndExpenses6.setDate(Timestamp.valueOf("2022-05-03 12:00:00"));
		incomeAndExpenses6.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses6.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses6);

		IncomeAndExpenses incomeAndExpenses7 = new IncomeAndExpenses();
		incomeAndExpenses7.setUserId(Long.parseLong("1"));
		incomeAndExpenses7.setTitle("Billa");
		incomeAndExpenses7.setAmount(41.51);
		incomeAndExpenses7.setDate(Timestamp.valueOf("2022-05-08 12:00:00"));
		incomeAndExpenses7.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses7.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses7);

		IncomeAndExpenses incomeAndExpenses8 = new IncomeAndExpenses();
		incomeAndExpenses8.setUserId(Long.parseLong("1"));
		incomeAndExpenses8.setTitle("Spar");
		incomeAndExpenses8.setAmount(85.64);
		incomeAndExpenses8.setDate(Timestamp.valueOf("2022-05-18 12:00:00"));
		incomeAndExpenses8.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses8.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses8);

		IncomeAndExpenses incomeAndExpenses9 = new IncomeAndExpenses();
		incomeAndExpenses9.setUserId(Long.parseLong("1"));
		incomeAndExpenses9.setTitle("Spar");
		incomeAndExpenses9.setAmount(15.52);
		incomeAndExpenses9.setDate(Timestamp.valueOf("2022-05-20 12:00:00"));
		incomeAndExpenses9.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses9.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses9);

		IncomeAndExpenses incomeAndExpenses10 = new IncomeAndExpenses();
		incomeAndExpenses10.setUserId(Long.parseLong("1"));
		incomeAndExpenses10.setTitle("Spar");
		incomeAndExpenses10.setAmount(27.64);
		incomeAndExpenses10.setDate(Timestamp.valueOf("2022-05-22 12:00:00"));
		incomeAndExpenses10.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses10.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses10);

		IncomeAndExpenses incomeAndExpenses11 = new IncomeAndExpenses();
		incomeAndExpenses11.setUserId(Long.parseLong("1"));
		incomeAndExpenses11.setTitle("Spar");
		incomeAndExpenses11.setAmount(41.51);
		incomeAndExpenses11.setDate(Timestamp.valueOf("2022-05-29 12:00:00"));
		incomeAndExpenses11.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses11.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses11);

		IncomeAndExpenses incomeAndExpenses12 = new IncomeAndExpenses();
		incomeAndExpenses12.setUserId(Long.parseLong("1"));
		incomeAndExpenses12.setTitle("Spar");
		incomeAndExpenses12.setAmount(15.52);
		incomeAndExpenses12.setDate(Timestamp.valueOf("2022-05-31 12:00:00"));
		incomeAndExpenses12.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses12.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses12);

		IncomeAndExpenses incomeAndExpenses13 = new IncomeAndExpenses();
		incomeAndExpenses13.setUserId(Long.parseLong("1"));
		incomeAndExpenses13.setTitle("Spar");
		incomeAndExpenses13.setAmount(27.64);
		incomeAndExpenses13.setDate(Timestamp.valueOf("2022-06-02 12:00:00"));
		incomeAndExpenses13.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses13.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses13);

		IncomeAndExpenses incomeAndExpenses14 = new IncomeAndExpenses();
		incomeAndExpenses14.setUserId(Long.parseLong("1"));
		incomeAndExpenses14.setTitle("Spar");
		incomeAndExpenses14.setAmount(41.51);
		incomeAndExpenses14.setDate(Timestamp.valueOf("2022-06-09 12:00:00"));
		incomeAndExpenses14.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses14.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses14);

		IncomeAndExpenses incomeAndExpenses15 = new IncomeAndExpenses();
		incomeAndExpenses15.setUserId(Long.parseLong("1"));
		incomeAndExpenses15.setTitle("Spar");
		incomeAndExpenses15.setAmount(15.52);
		incomeAndExpenses15.setDate(Timestamp.valueOf("2022-06-11 12:00:00"));
		incomeAndExpenses15.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses15.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses15);

		IncomeAndExpenses incomeAndExpenses16 = new IncomeAndExpenses();
		incomeAndExpenses16.setUserId(Long.parseLong("1"));
		incomeAndExpenses16.setTitle("Spar");
		incomeAndExpenses16.setAmount(27.64);
		incomeAndExpenses16.setDate(Timestamp.valueOf("2022-06-13 12:00:00"));
		incomeAndExpenses16.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses16.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses16);

		IncomeAndExpenses incomeAndExpenses17 = new IncomeAndExpenses();
		incomeAndExpenses17.setUserId(Long.parseLong("1"));
		incomeAndExpenses17.setTitle("Spar");
		incomeAndExpenses17.setAmount(41.51);
		incomeAndExpenses17.setDate(Timestamp.valueOf("2022-06-20 12:00:00"));
		incomeAndExpenses17.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses17.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses17);

		IncomeAndExpenses incomeAndExpenses18 = new IncomeAndExpenses();
		incomeAndExpenses18.setUserId(Long.parseLong("1"));
		incomeAndExpenses18.setTitle("Spar");
		incomeAndExpenses18.setAmount(15.52);
		incomeAndExpenses18.setDate(Timestamp.valueOf("2022-06-22 12:00:00"));
		incomeAndExpenses18.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses18.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses18);

		IncomeAndExpenses incomeAndExpenses19 = new IncomeAndExpenses();
		incomeAndExpenses19.setUserId(Long.parseLong("1"));
		incomeAndExpenses19.setTitle("Spar");
		incomeAndExpenses19.setAmount(27.64);
		incomeAndExpenses19.setDate(Timestamp.valueOf("2022-06-24 12:00:00"));
		incomeAndExpenses19.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses19.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses19);

		IncomeAndExpenses incomeAndExpenses20 = new IncomeAndExpenses();
		incomeAndExpenses20.setUserId(Long.parseLong("1"));
		incomeAndExpenses20.setTitle("Spar");
		incomeAndExpenses20.setAmount(41.51);
		incomeAndExpenses20.setDate(Timestamp.valueOf("2022-07-01 12:00:00"));
		incomeAndExpenses20.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses20.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses20);

		IncomeAndExpenses incomeAndExpenses21 = new IncomeAndExpenses();
		incomeAndExpenses21.setUserId(Long.parseLong("1"));
		incomeAndExpenses21.setTitle("Spar");
		incomeAndExpenses21.setAmount(15.52);
		incomeAndExpenses21.setDate(Timestamp.valueOf("2022-07-03 12:00:00"));
		incomeAndExpenses21.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses21.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses21);

		IncomeAndExpenses incomeAndExpenses22 = new IncomeAndExpenses();
		incomeAndExpenses22.setUserId(Long.parseLong("1"));
		incomeAndExpenses22.setTitle("Spar");
		incomeAndExpenses22.setAmount(27.64);
		incomeAndExpenses22.setDate(Timestamp.valueOf("2022-07-05 12:00:00"));
		incomeAndExpenses22.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses22.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses22);

		IncomeAndExpenses incomeAndExpenses23 = new IncomeAndExpenses();
		incomeAndExpenses23.setUserId(Long.parseLong("1"));
		incomeAndExpenses23.setTitle("Spar");
		incomeAndExpenses23.setAmount(41.51);
		incomeAndExpenses23.setDate(Timestamp.valueOf("2022-07-12 12:00:00"));
		incomeAndExpenses23.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses23.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses23);

		IncomeAndExpenses incomeAndExpenses24 = new IncomeAndExpenses();
		incomeAndExpenses24.setUserId(Long.parseLong("1"));
		incomeAndExpenses24.setTitle("Spar");
		incomeAndExpenses24.setAmount(15.52);
		incomeAndExpenses24.setDate(Timestamp.valueOf("2022-07-14 12:00:00"));
		incomeAndExpenses24.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses24.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses24);

		IncomeAndExpenses incomeAndExpenses25 = new IncomeAndExpenses();
		incomeAndExpenses25.setUserId(Long.parseLong("1"));
		incomeAndExpenses25.setTitle("Spar");
		incomeAndExpenses25.setAmount(27.64);
		incomeAndExpenses25.setDate(Timestamp.valueOf("2022-07-16 12:00:00"));
		incomeAndExpenses25.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses25.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses25);

		IncomeAndExpenses incomeAndExpenses26 = new IncomeAndExpenses();
		incomeAndExpenses26.setUserId(Long.parseLong("1"));
		incomeAndExpenses26.setTitle("Spar");
		incomeAndExpenses26.setAmount(41.51);
		incomeAndExpenses26.setDate(Timestamp.valueOf("2022-07-20 12:00:00"));
		incomeAndExpenses26.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses26.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses26);

		IncomeAndExpenses incomeAndExpenses27 = new IncomeAndExpenses();
		incomeAndExpenses27.setUserId(Long.parseLong("1"));
		incomeAndExpenses27.setTitle("Spar");
		incomeAndExpenses27.setAmount(15.52);
		incomeAndExpenses27.setDate(Timestamp.valueOf("2022-07-22 12:00:00"));
		incomeAndExpenses27.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses27.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses27);

		IncomeAndExpenses incomeAndExpenses28 = new IncomeAndExpenses();
		incomeAndExpenses28.setUserId(Long.parseLong("1"));
		incomeAndExpenses28.setTitle("Spar");
		incomeAndExpenses28.setAmount(27.64);
		incomeAndExpenses28.setDate(Timestamp.valueOf("2022-07-24 12:00:00"));
		incomeAndExpenses28.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses28.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses28);

		IncomeAndExpenses incomeAndExpenses29 = new IncomeAndExpenses();
		incomeAndExpenses29.setUserId(Long.parseLong("1"));
		incomeAndExpenses29.setTitle("Spar");
		incomeAndExpenses29.setAmount(41.51);
		incomeAndExpenses29.setDate(Timestamp.valueOf("2022-07-31 12:00:00"));
		incomeAndExpenses29.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses29.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses29);

		IncomeAndExpenses incomeAndExpenses30 = new IncomeAndExpenses();
		incomeAndExpenses30.setUserId(Long.parseLong("1"));
		incomeAndExpenses30.setTitle("Spar");
		incomeAndExpenses30.setAmount(15.52);
		incomeAndExpenses30.setDate(Timestamp.valueOf("2022-08-02 12:00:00"));
		incomeAndExpenses30.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses30.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses30);

		IncomeAndExpenses incomeAndExpenses31 = new IncomeAndExpenses();
		incomeAndExpenses31.setUserId(Long.parseLong("1"));
		incomeAndExpenses31.setTitle("Spar");
		incomeAndExpenses31.setAmount(27.64);
		incomeAndExpenses31.setDate(Timestamp.valueOf("2022-08-04 12:00:00"));
		incomeAndExpenses31.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses31.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses31);

		IncomeAndExpenses incomeAndExpenses32 = new IncomeAndExpenses();
		incomeAndExpenses32.setUserId(Long.parseLong("1"));
		incomeAndExpenses32.setTitle("Spar");
		incomeAndExpenses32.setAmount(41.51);
		incomeAndExpenses32.setDate(Timestamp.valueOf("2022-08-09 12:00:00"));
		incomeAndExpenses32.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses32.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses32);

		IncomeAndExpenses incomeAndExpenses33 = new IncomeAndExpenses();
		incomeAndExpenses33.setUserId(Long.parseLong("1"));
		incomeAndExpenses33.setTitle("Spar");
		incomeAndExpenses33.setAmount(15.52);
		incomeAndExpenses33.setDate(Timestamp.valueOf("2022-08-11 12:00:00"));
		incomeAndExpenses33.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses33.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses33);

		IncomeAndExpenses incomeAndExpenses34 = new IncomeAndExpenses();
		incomeAndExpenses34.setUserId(Long.parseLong("1"));
		incomeAndExpenses34.setTitle("Spar");
		incomeAndExpenses34.setAmount(27.64);
		incomeAndExpenses34.setDate(Timestamp.valueOf("2022-08-13 12:00:00"));
		incomeAndExpenses34.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses34.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses34);

		IncomeAndExpenses incomeAndExpenses35 = new IncomeAndExpenses();
		incomeAndExpenses35.setUserId(Long.parseLong("1"));
		incomeAndExpenses35.setTitle("Spar");
		incomeAndExpenses35.setAmount(41.51);
		incomeAndExpenses35.setDate(Timestamp.valueOf("2022-08-20 12:00:00"));
		incomeAndExpenses35.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses35.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses35);

		IncomeAndExpenses incomeAndExpenses36 = new IncomeAndExpenses();
		incomeAndExpenses36.setUserId(Long.parseLong("1"));
		incomeAndExpenses36.setTitle("Spar");
		incomeAndExpenses36.setAmount(15.52);
		incomeAndExpenses36.setDate(Timestamp.valueOf("2022-08-22 12:00:00"));
		incomeAndExpenses36.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses36.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses36);

		IncomeAndExpenses incomeAndExpenses37 = new IncomeAndExpenses();
		incomeAndExpenses37.setUserId(Long.parseLong("1"));
		incomeAndExpenses37.setTitle("Spar");
		incomeAndExpenses37.setAmount(27.64);
		incomeAndExpenses37.setDate(Timestamp.valueOf("2022-08-24 12:00:00"));
		incomeAndExpenses37.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses37.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses37);

		IncomeAndExpenses incomeAndExpenses38 = new IncomeAndExpenses();
		incomeAndExpenses38.setUserId(Long.parseLong("1"));
		incomeAndExpenses38.setTitle("OMV");
		incomeAndExpenses38.setAmount(96.38);
		incomeAndExpenses38.setDate(Timestamp.valueOf("2022-05-02 12:00:00"));
		incomeAndExpenses38.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses38.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses38);

		IncomeAndExpenses incomeAndExpenses39 = new IncomeAndExpenses();
		incomeAndExpenses39.setUserId(Long.parseLong("1"));
		incomeAndExpenses39.setTitle("JET");
		incomeAndExpenses39.setAmount(93.84);
		incomeAndExpenses39.setDate(Timestamp.valueOf("2022-05-13 12:00:00"));
		incomeAndExpenses39.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses39.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses39);

		IncomeAndExpenses incomeAndExpenses40 = new IncomeAndExpenses();
		incomeAndExpenses40.setUserId(Long.parseLong("1"));
		incomeAndExpenses40.setTitle("BP");
		incomeAndExpenses40.setAmount(91.25);
		incomeAndExpenses40.setDate(Timestamp.valueOf("2022-05-24 12:00:00"));
		incomeAndExpenses40.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses40.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses40);

		IncomeAndExpenses incomeAndExpenses41 = new IncomeAndExpenses();
		incomeAndExpenses41.setUserId(Long.parseLong("1"));
		incomeAndExpenses41.setTitle("OMV");
		incomeAndExpenses41.setAmount(98.14);
		incomeAndExpenses41.setDate(Timestamp.valueOf("2022-06-04 12:00:00"));
		incomeAndExpenses41.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses41.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses41);

		IncomeAndExpenses incomeAndExpenses42 = new IncomeAndExpenses();
		incomeAndExpenses42.setUserId(Long.parseLong("1"));
		incomeAndExpenses42.setTitle("JET");
		incomeAndExpenses42.setAmount(95.56);
		incomeAndExpenses42.setDate(Timestamp.valueOf("2022-06-15 12:00:00"));
		incomeAndExpenses42.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses42.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses42);

		IncomeAndExpenses incomeAndExpenses43 = new IncomeAndExpenses();
		incomeAndExpenses43.setUserId(Long.parseLong("1"));
		incomeAndExpenses43.setTitle("BP");
		incomeAndExpenses43.setAmount(92.93);
		incomeAndExpenses43.setDate(Timestamp.valueOf("2022-06-26 12:00:00"));
		incomeAndExpenses43.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses43.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses43);

		IncomeAndExpenses incomeAndExpenses44 = new IncomeAndExpenses();
		incomeAndExpenses44.setUserId(Long.parseLong("1"));
		incomeAndExpenses44.setTitle("OMV");
		incomeAndExpenses44.setAmount(99.86);
		incomeAndExpenses44.setDate(Timestamp.valueOf("2022-07-07 12:00:00"));
		incomeAndExpenses44.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses44.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses44);

		IncomeAndExpenses incomeAndExpenses45 = new IncomeAndExpenses();
		incomeAndExpenses45.setUserId(Long.parseLong("1"));
		incomeAndExpenses45.setTitle("JET");
		incomeAndExpenses45.setAmount(97.24);
		incomeAndExpenses45.setDate(Timestamp.valueOf("2022-07-18 12:00:00"));
		incomeAndExpenses45.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses45.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses45);

		IncomeAndExpenses incomeAndExpenses46 = new IncomeAndExpenses();
		incomeAndExpenses46.setUserId(Long.parseLong("1"));
		incomeAndExpenses46.setTitle("BP");
		incomeAndExpenses46.setAmount(94.92);
		incomeAndExpenses46.setDate(Timestamp.valueOf("2022-07-29 12:00:00"));
		incomeAndExpenses46.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses46.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses46);

		IncomeAndExpenses incomeAndExpenses47 = new IncomeAndExpenses();
		incomeAndExpenses47.setUserId(Long.parseLong("1"));
		incomeAndExpenses47.setTitle("OMV");
		incomeAndExpenses47.setAmount(101.56);
		incomeAndExpenses47.setDate(Timestamp.valueOf("2022-08-09 12:00:00"));
		incomeAndExpenses47.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses47.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses47);

		IncomeAndExpenses incomeAndExpenses48 = new IncomeAndExpenses();
		incomeAndExpenses48.setUserId(Long.parseLong("1"));
		incomeAndExpenses48.setTitle("JET");
		incomeAndExpenses48.setAmount(98.9);
		incomeAndExpenses48.setDate(Timestamp.valueOf("2022-08-20 12:00:00"));
		incomeAndExpenses48.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses48.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses48);

		IncomeAndExpenses incomeAndExpenses49 = new IncomeAndExpenses();
		incomeAndExpenses49.setUserId(Long.parseLong("1"));
		incomeAndExpenses49.setTitle("BP");
		incomeAndExpenses49.setAmount(96.6);
		incomeAndExpenses49.setDate(Timestamp.valueOf("2022-08-31 12:00:00"));
		incomeAndExpenses49.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses49.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses49);

		IncomeAndExpenses incomeAndExpenses50 = new IncomeAndExpenses();
		incomeAndExpenses50.setUserId(Long.parseLong("1"));
		incomeAndExpenses50.setTitle("OMV");
		incomeAndExpenses50.setAmount(103.24);
		incomeAndExpenses50.setDate(Timestamp.valueOf("2022-09-11 12:00:00"));
		incomeAndExpenses50.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses50.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses50);

		IncomeAndExpenses incomeAndExpenses51 = new IncomeAndExpenses();
		incomeAndExpenses51.setUserId(Long.parseLong("1"));
		incomeAndExpenses51.setTitle("JET");
		incomeAndExpenses51.setAmount(100.56);
		incomeAndExpenses51.setDate(Timestamp.valueOf("2022-09-22 12:00:00"));
		incomeAndExpenses51.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses51.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses51);

		IncomeAndExpenses incomeAndExpenses52 = new IncomeAndExpenses();
		incomeAndExpenses52.setUserId(Long.parseLong("1"));
		incomeAndExpenses52.setTitle("BP");
		incomeAndExpenses52.setAmount(98.28);
		incomeAndExpenses52.setDate(Timestamp.valueOf("2022-10-03 12:00:00"));
		incomeAndExpenses52.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses52.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses52);

		IncomeAndExpenses incomeAndExpenses53 = new IncomeAndExpenses();
		incomeAndExpenses53.setUserId(Long.parseLong("1"));
		incomeAndExpenses53.setTitle("Rent for apartment");
		incomeAndExpenses53.setAmount(1851.12);
		incomeAndExpenses53.setDate(Timestamp.valueOf("2022-05-01 12:00:00"));
		incomeAndExpenses53.setAbo(true);
		incomeAndExpenses53.setAboInterval(12);
		incomeAndExpenses53.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses53.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses53);

		IncomeAndExpenses incomeAndExpenses54 = new IncomeAndExpenses();
		incomeAndExpenses54.setUserId(Long.parseLong("1"));
		incomeAndExpenses54.setTitle("Rent for apartment");
		incomeAndExpenses54.setAmount(1851.12);
		incomeAndExpenses54.setDate(Timestamp.valueOf("2022-06-01 12:00:00"));
		incomeAndExpenses54.setAbo(true);
		incomeAndExpenses54.setAboInterval(12);
		incomeAndExpenses54.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses54.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses54);

		IncomeAndExpenses incomeAndExpenses55 = new IncomeAndExpenses();
		incomeAndExpenses55.setUserId(Long.parseLong("1"));
		incomeAndExpenses55.setTitle("Rent for apartment");
		incomeAndExpenses55.setAmount(1851.12);
		incomeAndExpenses55.setDate(Timestamp.valueOf("2022-07-01 12:00:00"));
		incomeAndExpenses55.setAbo(true);
		incomeAndExpenses55.setAboInterval(12);
		incomeAndExpenses55.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses55.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses55);

		IncomeAndExpenses incomeAndExpenses56 = new IncomeAndExpenses();
		incomeAndExpenses56.setUserId(Long.parseLong("1"));
		incomeAndExpenses56.setTitle("Rent for apartment");
		incomeAndExpenses56.setAmount(1851.12);
		incomeAndExpenses56.setDate(Timestamp.valueOf("2022-08-01 12:00:00"));
		incomeAndExpenses56.setAbo(true);
		incomeAndExpenses56.setAboInterval(12);
		incomeAndExpenses56.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses56.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses56);

		IncomeAndExpenses incomeAndExpenses57 = new IncomeAndExpenses();
		incomeAndExpenses57.setUserId(Long.parseLong("1"));
		incomeAndExpenses57.setTitle("Rent for apartment");
		incomeAndExpenses57.setAmount(1851.12);
		incomeAndExpenses57.setDate(Timestamp.valueOf("2022-09-01 12:00:00"));
		incomeAndExpenses57.setAbo(true);
		incomeAndExpenses57.setAboInterval(12);
		incomeAndExpenses57.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses57.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses57);

		IncomeAndExpenses incomeAndExpenses58 = new IncomeAndExpenses();
		incomeAndExpenses58.setUserId(Long.parseLong("1"));
		incomeAndExpenses58.setTitle("Doc. Sommer");
		incomeAndExpenses58.setAmount(188.0);
		incomeAndExpenses58.setDate(Timestamp.valueOf("2022-07-21 12:00:00"));
		incomeAndExpenses58.setCategory(IncomeAndExpenses.Category.HEALTH);
		incomeAndExpenses58.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses58);

		IncomeAndExpenses incomeAndExpenses59 = new IncomeAndExpenses();
		incomeAndExpenses59.setUserId(Long.parseLong("1"));
		incomeAndExpenses59.setTitle("DDDoc. Kneissl - Implantat");
		incomeAndExpenses59.setAmount(7188.52);
		incomeAndExpenses59.setDate(Timestamp.valueOf("2022-08-02 12:00:00"));
		incomeAndExpenses59.setCategory(IncomeAndExpenses.Category.HEALTH);
		incomeAndExpenses59.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses59);

		IncomeAndExpenses incomeAndExpenses60 = new IncomeAndExpenses();
		incomeAndExpenses60.setUserId(Long.parseLong("1"));
		incomeAndExpenses60.setTitle("Netflix");
		incomeAndExpenses60.setAmount(15.99);
		incomeAndExpenses60.setDate(Timestamp.valueOf("2022-05-11 12:00:00"));
		incomeAndExpenses60.setAbo(true);
		incomeAndExpenses60.setAboInterval(12);
		incomeAndExpenses60.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses60.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses60);

		IncomeAndExpenses incomeAndExpenses61 = new IncomeAndExpenses();
		incomeAndExpenses61.setUserId(Long.parseLong("1"));
		incomeAndExpenses61.setTitle("Netflix");
		incomeAndExpenses61.setAmount(15.99);
		incomeAndExpenses61.setDate(Timestamp.valueOf("2022-06-11 12:00:00"));
		incomeAndExpenses61.setAbo(true);
		incomeAndExpenses61.setAboInterval(12);
		incomeAndExpenses61.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses61.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses61);

		IncomeAndExpenses incomeAndExpenses62 = new IncomeAndExpenses();
		incomeAndExpenses62.setUserId(Long.parseLong("1"));
		incomeAndExpenses62.setTitle("Netflix");
		incomeAndExpenses62.setAmount(15.99);
		incomeAndExpenses62.setDate(Timestamp.valueOf("2022-07-11 12:00:00"));
		incomeAndExpenses62.setAbo(true);
		incomeAndExpenses62.setAboInterval(12);
		incomeAndExpenses62.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses62.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses62);

		IncomeAndExpenses incomeAndExpenses63 = new IncomeAndExpenses();
		incomeAndExpenses63.setUserId(Long.parseLong("1"));
		incomeAndExpenses63.setTitle("Netflix");
		incomeAndExpenses63.setAmount(15.99);
		incomeAndExpenses63.setDate(Timestamp.valueOf("2022-08-11 12:00:00"));
		incomeAndExpenses63.setAbo(true);
		incomeAndExpenses63.setAboInterval(12);
		incomeAndExpenses63.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses63.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses63);

		IncomeAndExpenses incomeAndExpenses64 = new IncomeAndExpenses();
		incomeAndExpenses64.setUserId(Long.parseLong("1"));
		incomeAndExpenses64.setTitle("Netflix");
		incomeAndExpenses64.setAmount(15.99);
		incomeAndExpenses64.setDate(Timestamp.valueOf("2022-09-11 12:00:00"));
		incomeAndExpenses64.setAbo(true);
		incomeAndExpenses64.setAboInterval(12);
		incomeAndExpenses64.setCategory(incomeAndExpenses64.getCategory().ENTERTAINMENT);
		incomeAndExpenses64.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses64);

		IncomeAndExpenses incomeAndExpenses65 = new IncomeAndExpenses();
		incomeAndExpenses65.setUserId(Long.parseLong("1"));
		incomeAndExpenses65.setTitle("AppleMusic");
		incomeAndExpenses65.setAmount(19.99);
		incomeAndExpenses65.setDate(Timestamp.valueOf("2022-05-25 12:00:00"));
		incomeAndExpenses65.setAbo(true);
		incomeAndExpenses65.setAboInterval(12);
		incomeAndExpenses65.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses65.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses65);

		IncomeAndExpenses incomeAndExpenses66 = new IncomeAndExpenses();
		incomeAndExpenses66.setUserId(Long.parseLong("1"));
		incomeAndExpenses66.setTitle("AppleMusic");
		incomeAndExpenses66.setAmount(19.99);
		incomeAndExpenses66.setDate(Timestamp.valueOf("2022-06-25 12:00:00"));
		incomeAndExpenses66.setAbo(true);
		incomeAndExpenses66.setAboInterval(12);
		incomeAndExpenses66.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses66.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses66);

		IncomeAndExpenses incomeAndExpenses67 = new IncomeAndExpenses();
		incomeAndExpenses67.setUserId(Long.parseLong("1"));
		incomeAndExpenses67.setTitle("AppleMusic");
		incomeAndExpenses67.setAmount(19.99);
		incomeAndExpenses67.setDate(Timestamp.valueOf("2022-07-25 12:00:00"));
		incomeAndExpenses67.setAbo(true);
		incomeAndExpenses67.setAboInterval(12);
		incomeAndExpenses67.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses67.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses67);

		IncomeAndExpenses incomeAndExpenses68 = new IncomeAndExpenses();
		incomeAndExpenses68.setUserId(Long.parseLong("1"));
		incomeAndExpenses68.setTitle("AppleMusic");
		incomeAndExpenses68.setAmount(19.99);
		incomeAndExpenses68.setDate(Timestamp.valueOf("2022-08-25 12:00:00"));
		incomeAndExpenses68.setAbo(true);
		incomeAndExpenses68.setAboInterval(12);
		incomeAndExpenses68.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses68.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses68);

		IncomeAndExpenses incomeAndExpenses69 = new IncomeAndExpenses();
		incomeAndExpenses69.setUserId(Long.parseLong("1"));
		incomeAndExpenses69.setTitle("AppleMusic");
		incomeAndExpenses69.setAmount(19.99);
		incomeAndExpenses69.setDate(Timestamp.valueOf("2022-09-25 12:00:00"));
		incomeAndExpenses69.setAbo(true);
		incomeAndExpenses69.setAboInterval(12);
		incomeAndExpenses69.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses69.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses69);

		IncomeAndExpenses incomeAndExpenses70 = new IncomeAndExpenses();
		incomeAndExpenses70.setUserId(Long.parseLong("1"));
		incomeAndExpenses70.setTitle("Old Balance");
		incomeAndExpenses70.setAmount(6112.64);
		incomeAndExpenses70.setDate(Timestamp.valueOf("2022-04-31 12:00:00"));
		incomeAndExpenses70.setCategory(IncomeAndExpenses.Category.OTHER);
		incomeAndExpenses70.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses70);

		IncomeAndExpenses incomeAndExpenses71 = new IncomeAndExpenses();
		incomeAndExpenses71.setUserId(Long.parseLong("1"));
		incomeAndExpenses71.setTitle("Salary - Oktober 2022");
		incomeAndExpenses71.setAmount(6543.52);
		incomeAndExpenses71.setDate(Timestamp.valueOf("2022-10-01 12:00:00"));
		incomeAndExpenses71.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses71.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses71);

		IncomeAndExpenses incomeAndExpenses72 = new IncomeAndExpenses();
		incomeAndExpenses72.setUserId(Long.parseLong("1"));
		incomeAndExpenses72.setTitle("Salary - November 2022");
		incomeAndExpenses72.setAmount(6543.52);
		incomeAndExpenses72.setDate(Timestamp.valueOf("2022-11-01 12:00:00"));
		incomeAndExpenses72.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses72.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses72);

		IncomeAndExpenses incomeAndExpenses73 = new IncomeAndExpenses();
		incomeAndExpenses73.setUserId(Long.parseLong("1"));
		incomeAndExpenses73.setTitle("Salary - Dezember 2022");
		incomeAndExpenses73.setAmount(6543.52);
		incomeAndExpenses73.setDate(Timestamp.valueOf("2022-12-01 12:00:00"));
		incomeAndExpenses73.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses73.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses73);

		IncomeAndExpenses incomeAndExpenses74 = new IncomeAndExpenses();
		incomeAndExpenses74.setUserId(Long.parseLong("1"));
		incomeAndExpenses74.setTitle("Salary - Januar 2023");
		incomeAndExpenses74.setAmount(6543.52);
		incomeAndExpenses74.setDate(Timestamp.valueOf("2023-01-01 12:00:00"));
		incomeAndExpenses74.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses74.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses74);

		IncomeAndExpenses incomeAndExpenses75 = new IncomeAndExpenses();
		incomeAndExpenses75.setUserId(Long.parseLong("1"));
		incomeAndExpenses75.setTitle("Billa");
		incomeAndExpenses75.setAmount(12.99);
		incomeAndExpenses75.setDate(Timestamp.valueOf("2022-08-30 12:00:00"));
		incomeAndExpenses75.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses75.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses75);

		IncomeAndExpenses incomeAndExpenses76 = new IncomeAndExpenses();
		incomeAndExpenses76.setUserId(Long.parseLong("1"));
		incomeAndExpenses76.setTitle("Billa");
		incomeAndExpenses76.setAmount(65.61);
		incomeAndExpenses76.setDate(Timestamp.valueOf("2022-09-05 12:00:00"));
		incomeAndExpenses76.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses76.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses76);

		IncomeAndExpenses incomeAndExpenses77 = new IncomeAndExpenses();
		incomeAndExpenses77.setUserId(Long.parseLong("1"));
		incomeAndExpenses77.setTitle("Spar");
		incomeAndExpenses77.setAmount(52.14);
		incomeAndExpenses77.setDate(Timestamp.valueOf("2022-09-12 12:00:00"));
		incomeAndExpenses77.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses77.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses77);

		IncomeAndExpenses incomeAndExpenses78 = new IncomeAndExpenses();
		incomeAndExpenses78.setUserId(Long.parseLong("1"));
		incomeAndExpenses78.setTitle("Billa");
		incomeAndExpenses78.setAmount(43.62);
		incomeAndExpenses78.setDate(Timestamp.valueOf("2022-09-19 12:00:00"));
		incomeAndExpenses78.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses78.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses78);

		IncomeAndExpenses incomeAndExpenses79 = new IncomeAndExpenses();
		incomeAndExpenses79.setUserId(Long.parseLong("1"));
		incomeAndExpenses79.setTitle("Billa");
		incomeAndExpenses79.setAmount(45.47);
		incomeAndExpenses79.setDate(Timestamp.valueOf("2022-09-26 12:00:00"));
		incomeAndExpenses79.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses79.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses79);

		IncomeAndExpenses incomeAndExpenses80 = new IncomeAndExpenses();
		incomeAndExpenses80.setUserId(Long.parseLong("1"));
		incomeAndExpenses80.setTitle("Billa");
		incomeAndExpenses80.setAmount(42.72);
		incomeAndExpenses80.setDate(Timestamp.valueOf("2022-10-03 12:00:00"));
		incomeAndExpenses80.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses80.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses80);

		IncomeAndExpenses incomeAndExpenses81 = new IncomeAndExpenses();
		incomeAndExpenses81.setUserId(Long.parseLong("1"));
		incomeAndExpenses81.setTitle("Billa");
		incomeAndExpenses81.setAmount(43.62);
		incomeAndExpenses81.setDate(Timestamp.valueOf("2022-10-10 12:00:00"));
		incomeAndExpenses81.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses81.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses81);

		IncomeAndExpenses incomeAndExpenses82 = new IncomeAndExpenses();
		incomeAndExpenses82.setUserId(Long.parseLong("1"));
		incomeAndExpenses82.setTitle("Billa");
		incomeAndExpenses82.setAmount(45.47);
		incomeAndExpenses82.setDate(Timestamp.valueOf("2022-10-17 12:00:00"));
		incomeAndExpenses82.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses82.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses82);

		IncomeAndExpenses incomeAndExpenses83 = new IncomeAndExpenses();
		incomeAndExpenses83.setUserId(Long.parseLong("1"));
		incomeAndExpenses83.setTitle("Billa");
		incomeAndExpenses83.setAmount(42.72);
		incomeAndExpenses83.setDate(Timestamp.valueOf("2022-10-24 12:00:00"));
		incomeAndExpenses83.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses83.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses83);

		IncomeAndExpenses incomeAndExpenses84 = new IncomeAndExpenses();
		incomeAndExpenses84.setUserId(Long.parseLong("1"));
		incomeAndExpenses84.setTitle("Billa");
		incomeAndExpenses84.setAmount(43.62);
		incomeAndExpenses84.setDate(Timestamp.valueOf("2022-10-31 12:00:00"));
		incomeAndExpenses84.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses84.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses84);

		IncomeAndExpenses incomeAndExpenses85 = new IncomeAndExpenses();
		incomeAndExpenses85.setUserId(Long.parseLong("1"));
		incomeAndExpenses85.setTitle("Billa");
		incomeAndExpenses85.setAmount(45.47);
		incomeAndExpenses85.setDate(Timestamp.valueOf("2022-11-07 12:00:00"));
		incomeAndExpenses85.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses85.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses85);

		IncomeAndExpenses incomeAndExpenses86 = new IncomeAndExpenses();
		incomeAndExpenses86.setUserId(Long.parseLong("1"));
		incomeAndExpenses86.setTitle("Billa");
		incomeAndExpenses86.setAmount(42.72);
		incomeAndExpenses86.setDate(Timestamp.valueOf("2022-11-14 12:00:00"));
		incomeAndExpenses86.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses86.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses86);

		IncomeAndExpenses incomeAndExpenses87 = new IncomeAndExpenses();
		incomeAndExpenses87.setUserId(Long.parseLong("1"));
		incomeAndExpenses87.setTitle("Billa");
		incomeAndExpenses87.setAmount(43.62);
		incomeAndExpenses87.setDate(Timestamp.valueOf("2022-11-21 12:00:00"));
		incomeAndExpenses87.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses87.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses87);

		IncomeAndExpenses incomeAndExpenses88 = new IncomeAndExpenses();
		incomeAndExpenses88.setUserId(Long.parseLong("1"));
		incomeAndExpenses88.setTitle("Billa");
		incomeAndExpenses88.setAmount(45.47);
		incomeAndExpenses88.setDate(Timestamp.valueOf("2022-11-28 12:00:00"));
		incomeAndExpenses88.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses88.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses88);

		IncomeAndExpenses incomeAndExpenses89 = new IncomeAndExpenses();
		incomeAndExpenses89.setUserId(Long.parseLong("1"));
		incomeAndExpenses89.setTitle("Billa");
		incomeAndExpenses89.setAmount(42.72);
		incomeAndExpenses89.setDate(Timestamp.valueOf("2022-12-05 12:00:00"));
		incomeAndExpenses89.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses89.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses89);

		IncomeAndExpenses incomeAndExpenses90 = new IncomeAndExpenses();
		incomeAndExpenses90.setUserId(Long.parseLong("1"));
		incomeAndExpenses90.setTitle("Billa");
		incomeAndExpenses90.setAmount(43.62);
		incomeAndExpenses90.setDate(Timestamp.valueOf("2022-12-12 12:00:00"));
		incomeAndExpenses90.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses90.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses90);

		IncomeAndExpenses incomeAndExpenses91 = new IncomeAndExpenses();
		incomeAndExpenses91.setUserId(Long.parseLong("1"));
		incomeAndExpenses91.setTitle("Billa");
		incomeAndExpenses91.setAmount(45.47);
		incomeAndExpenses91.setDate(Timestamp.valueOf("2022-12-19 12:00:00"));
		incomeAndExpenses91.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses91.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses91);

		IncomeAndExpenses incomeAndExpenses92 = new IncomeAndExpenses();
		incomeAndExpenses92.setUserId(Long.parseLong("1"));
		incomeAndExpenses92.setTitle("Billa");
		incomeAndExpenses92.setAmount(42.72);
		incomeAndExpenses92.setDate(Timestamp.valueOf("2022-12-26 12:00:00"));
		incomeAndExpenses92.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses92.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses92);

		IncomeAndExpenses incomeAndExpenses93 = new IncomeAndExpenses();
		incomeAndExpenses93.setUserId(Long.parseLong("1"));
		incomeAndExpenses93.setTitle("Billa");
		incomeAndExpenses93.setAmount(43.62);
		incomeAndExpenses93.setDate(Timestamp.valueOf("2023-01-02 12:00:00"));
		incomeAndExpenses93.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses93.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses93);

		IncomeAndExpenses incomeAndExpenses94 = new IncomeAndExpenses();
		incomeAndExpenses94.setUserId(Long.parseLong("1"));
		incomeAndExpenses94.setTitle("Billa");
		incomeAndExpenses94.setAmount(45.47);
		incomeAndExpenses94.setDate(Timestamp.valueOf("2023-01-09 12:00:00"));
		incomeAndExpenses94.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses94.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses94);

		IncomeAndExpenses incomeAndExpenses95 = new IncomeAndExpenses();
		incomeAndExpenses95.setUserId(Long.parseLong("1"));
		incomeAndExpenses95.setTitle("Billa");
		incomeAndExpenses95.setAmount(42.72);
		incomeAndExpenses95.setDate(Timestamp.valueOf("2023-01-16 12:00:00"));
		incomeAndExpenses95.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses95.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses95);

		IncomeAndExpenses incomeAndExpenses96 = new IncomeAndExpenses();
		incomeAndExpenses96.setUserId(Long.parseLong("1"));
		incomeAndExpenses96.setTitle("Doc. Sommer");
		incomeAndExpenses96.setAmount(188.0);
		incomeAndExpenses96.setDate(Timestamp.valueOf("2022-11-21 12:00:00"));
		incomeAndExpenses96.setCategory(IncomeAndExpenses.Category.HEALTH);
		incomeAndExpenses96.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses96);

		IncomeAndExpenses incomeAndExpenses97 = new IncomeAndExpenses();
		incomeAndExpenses97.setUserId(Long.parseLong("1"));
		incomeAndExpenses97.setTitle("AppleMusic");
		incomeAndExpenses97.setAmount(19.99);
		incomeAndExpenses97.setDate(Timestamp.valueOf("2022-10-25 12:00:00"));
		incomeAndExpenses97.setAbo(true);
		incomeAndExpenses97.setAboInterval(12);
		incomeAndExpenses97.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses97.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses97);

		IncomeAndExpenses incomeAndExpenses98 = new IncomeAndExpenses();
		incomeAndExpenses98.setUserId(Long.parseLong("1"));
		incomeAndExpenses98.setTitle("AppleMusic");
		incomeAndExpenses98.setAmount(19.99);
		incomeAndExpenses98.setDate(Timestamp.valueOf("2022-11-25 12:00:00"));
		incomeAndExpenses98.setAbo(true);
		incomeAndExpenses98.setAboInterval(12);
		incomeAndExpenses98.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses98.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses98);

		IncomeAndExpenses incomeAndExpenses99 = new IncomeAndExpenses();
		incomeAndExpenses99.setUserId(Long.parseLong("1"));
		incomeAndExpenses99.setTitle("AppleMusic");
		incomeAndExpenses99.setAmount(19.99);
		incomeAndExpenses99.setDate(Timestamp.valueOf("2022-12-25 12:00:00"));
		incomeAndExpenses99.setAbo(true);
		incomeAndExpenses99.setAboInterval(12);
		incomeAndExpenses99.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses99.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses99);

		IncomeAndExpenses incomeAndExpenses100 = new IncomeAndExpenses();
		incomeAndExpenses100.setUserId(Long.parseLong("1"));
		incomeAndExpenses100.setTitle("AppleMusic");
		incomeAndExpenses100.setAmount(19.99);
		incomeAndExpenses100.setDate(Timestamp.valueOf("2023-01-25 12:00:00"));
		incomeAndExpenses100.setAbo(true);
		incomeAndExpenses100.setAboInterval(12);
		incomeAndExpenses100.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses100.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses100);

		IncomeAndExpenses incomeAndExpenses101 = new IncomeAndExpenses();
		incomeAndExpenses101.setUserId(Long.parseLong("1"));
		incomeAndExpenses101.setTitle("Netflix");
		incomeAndExpenses101.setAmount(15.99);
		incomeAndExpenses101.setDate(Timestamp.valueOf("2022-09-11 12:00:00"));
		incomeAndExpenses101.setAbo(true);
		incomeAndExpenses101.setAboInterval(12);
		incomeAndExpenses101.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses101.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses101);

		IncomeAndExpenses incomeAndExpenses102 = new IncomeAndExpenses();
		incomeAndExpenses102.setUserId(Long.parseLong("1"));
		incomeAndExpenses102.setTitle("Netflix");
		incomeAndExpenses102.setAmount(15.99);
		incomeAndExpenses102.setDate(Timestamp.valueOf("2022-10-11 12:00:00"));
		incomeAndExpenses102.setAbo(true);
		incomeAndExpenses102.setAboInterval(12);
		incomeAndExpenses102.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses102.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses102);

		IncomeAndExpenses incomeAndExpenses103 = new IncomeAndExpenses();
		incomeAndExpenses103.setUserId(Long.parseLong("1"));
		incomeAndExpenses103.setTitle("Netflix");
		incomeAndExpenses103.setAmount(15.99);
		incomeAndExpenses103.setDate(Timestamp.valueOf("2022-11-11 12:00:00"));
		incomeAndExpenses103.setAbo(true);
		incomeAndExpenses103.setAboInterval(12);
		incomeAndExpenses103.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses103.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses103);

		IncomeAndExpenses incomeAndExpenses104 = new IncomeAndExpenses();
		incomeAndExpenses104.setUserId(Long.parseLong("1"));
		incomeAndExpenses104.setTitle("Netflix");
		incomeAndExpenses104.setAmount(15.99);
		incomeAndExpenses104.setDate(Timestamp.valueOf("2022-12-11 12:00:00"));
		incomeAndExpenses104.setAbo(true);
		incomeAndExpenses104.setAboInterval(12);
		incomeAndExpenses104.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses104.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses104);

		IncomeAndExpenses incomeAndExpenses105 = new IncomeAndExpenses();
		incomeAndExpenses105.setUserId(Long.parseLong("1"));
		incomeAndExpenses105.setTitle("Netflix");
		incomeAndExpenses105.setAmount(15.99);
		incomeAndExpenses105.setDate(Timestamp.valueOf("2023-01-11 12:00:00"));
		incomeAndExpenses105.setAbo(true);
		incomeAndExpenses105.setAboInterval(12);
		incomeAndExpenses105.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses105.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses105);

		IncomeAndExpenses incomeAndExpenses106 = new IncomeAndExpenses();
		incomeAndExpenses106.setUserId(Long.parseLong("1"));
		incomeAndExpenses106.setTitle("Rent for apartment");
		incomeAndExpenses106.setAmount(1851.12);
		incomeAndExpenses106.setDate(Timestamp.valueOf("2022-09-01 12:00:00"));
		incomeAndExpenses106.setAbo(true);
		incomeAndExpenses106.setAboInterval(12);
		incomeAndExpenses106.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses106.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses106);

		IncomeAndExpenses incomeAndExpenses107 = new IncomeAndExpenses();
		incomeAndExpenses107.setUserId(Long.parseLong("1"));
		incomeAndExpenses107.setTitle("Rent for apartment");
		incomeAndExpenses107.setAmount(1851.12);
		incomeAndExpenses107.setDate(Timestamp.valueOf("2022-10-01 12:00:00"));
		incomeAndExpenses107.setAbo(true);
		incomeAndExpenses107.setAboInterval(12);
		incomeAndExpenses107.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses107.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses107);

		IncomeAndExpenses incomeAndExpenses108 = new IncomeAndExpenses();
		incomeAndExpenses108.setUserId(Long.parseLong("1"));
		incomeAndExpenses108.setTitle("Rent for apartment");
		incomeAndExpenses108.setAmount(1851.12);
		incomeAndExpenses108.setDate(Timestamp.valueOf("2022-11-01 12:00:00"));
		incomeAndExpenses108.setAbo(true);
		incomeAndExpenses108.setAboInterval(12);
		incomeAndExpenses108.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses108.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses108);

		IncomeAndExpenses incomeAndExpenses109 = new IncomeAndExpenses();
		incomeAndExpenses109.setUserId(Long.parseLong("1"));
		incomeAndExpenses109.setTitle("Rent for apartment");
		incomeAndExpenses109.setAmount(1851.12);
		incomeAndExpenses109.setDate(Timestamp.valueOf("2022-12-01 12:00:00"));
		incomeAndExpenses109.setAbo(true);
		incomeAndExpenses109.setAboInterval(12);
		incomeAndExpenses109.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses109.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses109);

		IncomeAndExpenses incomeAndExpenses110 = new IncomeAndExpenses();
		incomeAndExpenses110.setUserId(Long.parseLong("1"));
		incomeAndExpenses110.setTitle("OMV");
		incomeAndExpenses110.setAmount(83.65);
		incomeAndExpenses110.setDate(Timestamp.valueOf("2022-10-14 12:00:00"));
		incomeAndExpenses110.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses110.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses110);

		IncomeAndExpenses incomeAndExpenses111 = new IncomeAndExpenses();
		incomeAndExpenses111.setUserId(Long.parseLong("1"));
		incomeAndExpenses111.setTitle("BP");
		incomeAndExpenses111.setAmount(94.37);
		incomeAndExpenses111.setDate(Timestamp.valueOf("2022-10-26 12:00:00"));
		incomeAndExpenses111.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses111.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses111);

		IncomeAndExpenses incomeAndExpenses112 = new IncomeAndExpenses();
		incomeAndExpenses112.setUserId(Long.parseLong("1"));
		incomeAndExpenses112.setTitle("JET");
		incomeAndExpenses112.setAmount(72.85);
		incomeAndExpenses112.setDate(Timestamp.valueOf("2022-11-07 12:00:00"));
		incomeAndExpenses112.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses112.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses112);

		IncomeAndExpenses incomeAndExpenses113 = new IncomeAndExpenses();
		incomeAndExpenses113.setUserId(Long.parseLong("1"));
		incomeAndExpenses113.setTitle("OMV");
		incomeAndExpenses113.setAmount(86.54);
		incomeAndExpenses113.setDate(Timestamp.valueOf("2022-11-19 12:00:00"));
		incomeAndExpenses113.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses113.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses113);

		IncomeAndExpenses incomeAndExpenses114 = new IncomeAndExpenses();
		incomeAndExpenses114.setUserId(Long.parseLong("1"));
		incomeAndExpenses114.setTitle("BP");
		incomeAndExpenses114.setAmount(84.21);
		incomeAndExpenses114.setDate(Timestamp.valueOf("2022-12-01 12:00:00"));
		incomeAndExpenses114.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses114.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses114);

		IncomeAndExpenses incomeAndExpenses115 = new IncomeAndExpenses();
		incomeAndExpenses115.setUserId(Long.parseLong("1"));
		incomeAndExpenses115.setTitle("JET");
		incomeAndExpenses115.setAmount(79.54);
		incomeAndExpenses115.setDate(Timestamp.valueOf("2022-12-13 12:00:00"));
		incomeAndExpenses115.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses115.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses115);

		IncomeAndExpenses incomeAndExpenses116 = new IncomeAndExpenses();
		incomeAndExpenses116.setUserId(Long.parseLong("1"));
		incomeAndExpenses116.setTitle("OMV");
		incomeAndExpenses116.setAmount(87.12);
		incomeAndExpenses116.setDate(Timestamp.valueOf("2022-12-25 12:00:00"));
		incomeAndExpenses116.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses116.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses116);

		IncomeAndExpenses incomeAndExpenses117 = new IncomeAndExpenses();
		incomeAndExpenses117.setUserId(Long.parseLong("1"));
		incomeAndExpenses117.setTitle("BP");
		incomeAndExpenses117.setAmount(84.21);
		incomeAndExpenses117.setDate(Timestamp.valueOf("2023-01-06 12:00:00"));
		incomeAndExpenses117.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses117.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses117);

		
		User user1 = new User();
		user1.setEmail("user1@mail.at");
		user1.setPassword(passwordEncoder.encode("user1"));
		user1.setFirstName("Branislav");
		user1.setLastName("Vasic");
		user1.setAdmin(false);
		userRepository.save(user1);

		User user2 = new User();
		user2.setEmail("user2@mail.at");
		user2.setPassword(passwordEncoder.encode("user2"));
		user2.setFirstName("Alexander");
		user2.setLastName("Goldinger");
		user2.setAdmin(false);
		userRepository.save(user2);

		User admin1 = new User();
		admin1.setEmail("admin1@mail.at");
		admin1.setPassword(passwordEncoder.encode("admin1"));
		admin1.setFirstName("Anton");
		admin1.setLastName("Steiner");
		admin1.setAdmin(true);
		userRepository.save(admin1);

		User user3 = new User();
		user3.setEmail("user3@mail.at");
		user3.setPassword(passwordEncoder.encode("user3"));
		user3.setFirstName("Markus");
		user3.setLastName("Kreuzer");
		user3.setAdmin(false);
		userRepository.save(user3);

		User user4 = new User();
		user4.setEmail("user4@mail.at");
		user4.setPassword(passwordEncoder.encode("user4"));
		user4.setFirstName("Thomas");
		user4.setLastName("Funser");
		user4.setAdmin(false);
		userRepository.save(user4);

		Image img2 = new Image();
		img2.setType(Type.USER);
		img2.setExternalId(Long.parseLong("1"));
		img2.setImgUrl("profile_picture_user1.jpg");
		imageRepository.save(img2);

		Image img3 = new Image();
		img3.setType(Type.USER);
		img3.setExternalId(Long.parseLong("2"));
		img3.setImgUrl("profile_picture_user2.jpg");
		imageRepository.save(img3);

		Image img4 = new Image();
		img4.setType(Type.USER);
		img4.setExternalId(Long.parseLong("3"));
		img4.setImgUrl("profile_picture_admin1.png");
		imageRepository.save(img4);

		Image img5 = new Image();
		img5.setType(Type.USER);
		img5.setExternalId(Long.parseLong("4"));
		img5.setImgUrl("default_profile_picture.jpg");
		imageRepository.save(img5);

		Image img6 = new Image();
		img6.setType(Type.PRODUCT);
		img6.setExternalId(Long.parseLong("1"));
		img6.setImgUrl("ottakringer.jpg");
		imageRepository.save(img6);

		Image img7 = new Image();
		img7.setType(Type.PRODUCT);
		img7.setExternalId(Long.parseLong("2"));
		img7.setImgUrl("heineken.jpg");
		imageRepository.save(img7);

		Image img8 = new Image();
		img8.setType(Type.PRODUCT);
		img8.setExternalId(Long.parseLong("3"));
		img8.setImgUrl("staropramen.png");
		imageRepository.save(img8);

		Image img9 = new Image();
		img9.setType(Type.PRODUCT);
		img9.setExternalId(Long.parseLong("4"));
		img9.setImgUrl("corona.jpg");
		imageRepository.save(img9);

		Image img10 = new Image();
		img10.setType(Type.PRODUCT);
		img10.setExternalId(Long.parseLong("5"));
		img10.setImgUrl("tuborg.png");
		imageRepository.save(img10);

		Image img11 = new Image();
		img11.setType(Type.PRODUCT);
		img11.setExternalId(Long.parseLong("6"));
		img11.setImgUrl("budweiser.jpg");
		imageRepository.save(img11);

		Image img12 = new Image();
		img12.setType(Type.PRODUCT);
		img12.setExternalId(Long.parseLong("7"));
		img12.setImgUrl("guinness.png");
		imageRepository.save(img12);

		Image img13 = new Image();
		img13.setType(Type.PRODUCT);
		img13.setExternalId(Long.parseLong("8"));
		img13.setImgUrl("kronenbourg.jpg");
		imageRepository.save(img13);

		Image img14 = new Image();
		img14.setType(Type.PRODUCT);
		img14.setExternalId(Long.parseLong("9"));
		img14.setImgUrl("peroni.jpg");
		imageRepository.save(img14);

		Image img15 = new Image();
		img15.setType(Type.PRODUCT);
		img15.setExternalId(Long.parseLong("10"));
		img15.setImgUrl("budlight.jpg");
		imageRepository.save(img15);

		Image img16 = new Image();
		img16.setType(Type.PRODUCT);
		img16.setExternalId(Long.parseLong("11"));
		img16.setImgUrl("carlsberg.jpg");
		imageRepository.save(img16);
	}
}