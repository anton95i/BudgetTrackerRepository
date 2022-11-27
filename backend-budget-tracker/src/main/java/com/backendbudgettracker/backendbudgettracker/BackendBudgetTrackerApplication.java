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
import com.backendbudgettracker.backendbudgettracker.entity.Auction;
import com.backendbudgettracker.backendbudgettracker.entity.Bid;
import com.backendbudgettracker.backendbudgettracker.entity.Product;
import com.backendbudgettracker.backendbudgettracker.entity.User;
import com.backendbudgettracker.backendbudgettracker.entity.Auction.Status;
import com.backendbudgettracker.backendbudgettracker.repository.AuctionRepository;
import com.backendbudgettracker.backendbudgettracker.repository.BidRepository;
import com.backendbudgettracker.backendbudgettracker.repository.ImageRepository;
import com.backendbudgettracker.backendbudgettracker.repository.IncomeAndExpensesRepository;
import com.backendbudgettracker.backendbudgettracker.repository.ProductRepository;
import com.backendbudgettracker.backendbudgettracker.repository.UserRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtTokenProvider;

@SpringBootApplication
public class BackendBudgetTrackerApplication {

	@Autowired
	private AuctionRepository auctionRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BidRepository bidRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IncomeAndExpensesRepository incomeAndExpensesRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendBudgetTrackerApplication.class, args);
	}

	@PostConstruct
	public void init() {

		IncomeAndExpenses incomeAndExpenses = new IncomeAndExpenses();
		incomeAndExpenses.setUserId(Long.parseLong("1"));
		incomeAndExpenses.setTitle("Salary - May 2020");
		incomeAndExpenses.setAmount(6543.52);
		incomeAndExpenses.setDate(Timestamp.valueOf("2022-05-01 00:00:00"));
		incomeAndExpenses.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses);

		IncomeAndExpenses incomeAndExpenses2 = new IncomeAndExpenses();
		incomeAndExpenses2.setUserId(Long.parseLong("1"));
		incomeAndExpenses2.setTitle("Salary - June 2020");
		incomeAndExpenses2.setAmount(6543.52);
		incomeAndExpenses2.setDate(Timestamp.valueOf("2022-06-01 00:00:00"));
		incomeAndExpenses2.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses2.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses2);

		IncomeAndExpenses incomeAndExpenses3 = new IncomeAndExpenses();
		incomeAndExpenses3.setUserId(Long.parseLong("1"));
		incomeAndExpenses3.setTitle("Salary - July 2020");
		incomeAndExpenses3.setAmount(12918.58);
		incomeAndExpenses3.setDate(Timestamp.valueOf("2022-07-01 00:00:00"));
		incomeAndExpenses3.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses3.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses3);

		IncomeAndExpenses incomeAndExpenses4 = new IncomeAndExpenses();
		incomeAndExpenses4.setUserId(Long.parseLong("1"));
		incomeAndExpenses4.setTitle("Salary - August 2020");
		incomeAndExpenses4.setAmount(6543.52);
		incomeAndExpenses4.setDate(Timestamp.valueOf("2022-08-01 00:00:00"));
		incomeAndExpenses4.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses4.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses4);

		IncomeAndExpenses incomeAndExpenses5 = new IncomeAndExpenses();
		incomeAndExpenses5.setUserId(Long.parseLong("1"));
		incomeAndExpenses5.setTitle("Salary - September 2020");
		incomeAndExpenses5.setAmount(6543.52);
		incomeAndExpenses5.setDate(Timestamp.valueOf("2022-09-01 00:00:00"));
		incomeAndExpenses5.setCategory(IncomeAndExpenses.Category.SALARY);
		incomeAndExpenses5.setType(IncomeAndExpenses.Type.INCOME);
		incomeAndExpensesRepository.save(incomeAndExpenses5);

		IncomeAndExpenses incomeAndExpenses6 = new IncomeAndExpenses();
		incomeAndExpenses6.setUserId(Long.parseLong("1"));
		incomeAndExpenses6.setTitle("Billa");
		incomeAndExpenses6.setAmount(68.93);
		incomeAndExpenses6.setDate(Timestamp.valueOf("2022-05-03 00:00:00"));
		incomeAndExpenses6.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses6.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses6);

		IncomeAndExpenses incomeAndExpenses7 = new IncomeAndExpenses();
		incomeAndExpenses7.setUserId(Long.parseLong("1"));
		incomeAndExpenses7.setTitle("Billa");
		incomeAndExpenses7.setAmount(41.51);
		incomeAndExpenses7.setDate(Timestamp.valueOf("2022-05-08 00:00:00"));
		incomeAndExpenses7.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses7.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses7);

		IncomeAndExpenses incomeAndExpenses8 = new IncomeAndExpenses();
		incomeAndExpenses8.setUserId(Long.parseLong("1"));
		incomeAndExpenses8.setTitle("Spar");
		incomeAndExpenses8.setAmount(85.64);
		incomeAndExpenses8.setDate(Timestamp.valueOf("2022-05-18 00:00:00"));
		incomeAndExpenses8.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses8.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses8);

		IncomeAndExpenses incomeAndExpenses9 = new IncomeAndExpenses();
		incomeAndExpenses9.setUserId(Long.parseLong("1"));
		incomeAndExpenses9.setTitle("Spar");
		incomeAndExpenses9.setAmount(15.52);
		incomeAndExpenses9.setDate(Timestamp.valueOf("2022-05-20 00:00:00"));
		incomeAndExpenses9.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses9.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses9);

		IncomeAndExpenses incomeAndExpenses10 = new IncomeAndExpenses();
		incomeAndExpenses10.setUserId(Long.parseLong("1"));
		incomeAndExpenses10.setTitle("Spar");
		incomeAndExpenses10.setAmount(27.64);
		incomeAndExpenses10.setDate(Timestamp.valueOf("2022-05-22 00:00:00"));
		incomeAndExpenses10.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses10.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses10);

		IncomeAndExpenses incomeAndExpenses11 = new IncomeAndExpenses();
		incomeAndExpenses11.setUserId(Long.parseLong("1"));
		incomeAndExpenses11.setTitle("Spar");
		incomeAndExpenses11.setAmount(41.51);
		incomeAndExpenses11.setDate(Timestamp.valueOf("2022-05-29 00:00:00"));
		incomeAndExpenses11.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses11.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses11);

		IncomeAndExpenses incomeAndExpenses12 = new IncomeAndExpenses();
		incomeAndExpenses12.setUserId(Long.parseLong("1"));
		incomeAndExpenses12.setTitle("Spar");
		incomeAndExpenses12.setAmount(15.52);
		incomeAndExpenses12.setDate(Timestamp.valueOf("2022-05-31 00:00:00"));
		incomeAndExpenses12.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses12.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses12);

		IncomeAndExpenses incomeAndExpenses13 = new IncomeAndExpenses();
		incomeAndExpenses13.setUserId(Long.parseLong("1"));
		incomeAndExpenses13.setTitle("Spar");
		incomeAndExpenses13.setAmount(27.64);
		incomeAndExpenses13.setDate(Timestamp.valueOf("2022-06-02 00:00:00"));
		incomeAndExpenses13.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses13.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses13);

		IncomeAndExpenses incomeAndExpenses14 = new IncomeAndExpenses();
		incomeAndExpenses14.setUserId(Long.parseLong("1"));
		incomeAndExpenses14.setTitle("Spar");
		incomeAndExpenses14.setAmount(41.51);
		incomeAndExpenses14.setDate(Timestamp.valueOf("2022-06-09 00:00:00"));
		incomeAndExpenses14.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses14.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses14);

		IncomeAndExpenses incomeAndExpenses15 = new IncomeAndExpenses();
		incomeAndExpenses15.setUserId(Long.parseLong("1"));
		incomeAndExpenses15.setTitle("Spar");
		incomeAndExpenses15.setAmount(15.52);
		incomeAndExpenses15.setDate(Timestamp.valueOf("2022-06-11 00:00:00"));
		incomeAndExpenses15.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses15.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses15);

		IncomeAndExpenses incomeAndExpenses16 = new IncomeAndExpenses();
		incomeAndExpenses16.setUserId(Long.parseLong("1"));
		incomeAndExpenses16.setTitle("Spar");
		incomeAndExpenses16.setAmount(27.64);
		incomeAndExpenses16.setDate(Timestamp.valueOf("2022-06-13 00:00:00"));
		incomeAndExpenses16.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses16.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses16);

		IncomeAndExpenses incomeAndExpenses17 = new IncomeAndExpenses();
		incomeAndExpenses17.setUserId(Long.parseLong("1"));
		incomeAndExpenses17.setTitle("Spar");
		incomeAndExpenses17.setAmount(41.51);
		incomeAndExpenses17.setDate(Timestamp.valueOf("2022-06-20 00:00:00"));
		incomeAndExpenses17.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses17.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses17);
		
		IncomeAndExpenses incomeAndExpenses18 = new IncomeAndExpenses();
		incomeAndExpenses18.setUserId(Long.parseLong("1"));
		incomeAndExpenses18.setTitle("Spar");
		incomeAndExpenses18.setAmount(15.52);
		incomeAndExpenses18.setDate(Timestamp.valueOf("2022-06-22 00:00:00"));
		incomeAndExpenses18.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses18.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses18);

		IncomeAndExpenses incomeAndExpenses19 = new IncomeAndExpenses();
		incomeAndExpenses19.setUserId(Long.parseLong("1"));
		incomeAndExpenses19.setTitle("Spar");
		incomeAndExpenses19.setAmount(27.64);
		incomeAndExpenses19.setDate(Timestamp.valueOf("2022-06-24 00:00:00"));
		incomeAndExpenses19.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses19.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses19);

		IncomeAndExpenses incomeAndExpenses20 = new IncomeAndExpenses();
		incomeAndExpenses20.setUserId(Long.parseLong("1"));
		incomeAndExpenses20.setTitle("Spar");
		incomeAndExpenses20.setAmount(41.51);
		incomeAndExpenses20.setDate(Timestamp.valueOf("2022-07-01 00:00:00"));
		incomeAndExpenses20.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses20.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses20);

		IncomeAndExpenses incomeAndExpenses21 = new IncomeAndExpenses();
		incomeAndExpenses21.setUserId(Long.parseLong("1"));
		incomeAndExpenses21.setTitle("Spar");
		incomeAndExpenses21.setAmount(15.52);
		incomeAndExpenses21.setDate(Timestamp.valueOf("2022-07-03 00:00:00"));
		incomeAndExpenses21.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses21.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses21);

		IncomeAndExpenses incomeAndExpenses22 = new IncomeAndExpenses();
		incomeAndExpenses22.setUserId(Long.parseLong("1"));
		incomeAndExpenses22.setTitle("Spar");
		incomeAndExpenses22.setAmount(27.64);
		incomeAndExpenses22.setDate(Timestamp.valueOf("2022-07-05 00:00:00"));
		incomeAndExpenses22.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses22.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses22);

		IncomeAndExpenses incomeAndExpenses23 = new IncomeAndExpenses();
		incomeAndExpenses23.setUserId(Long.parseLong("1"));
		incomeAndExpenses23.setTitle("Spar");
		incomeAndExpenses23.setAmount(41.51);
		incomeAndExpenses23.setDate(Timestamp.valueOf("2022-07-12 00:00:00"));
		incomeAndExpenses23.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses23.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses23);

		IncomeAndExpenses incomeAndExpenses24 = new IncomeAndExpenses();
		incomeAndExpenses24.setUserId(Long.parseLong("1"));
		incomeAndExpenses24.setTitle("Spar");
		incomeAndExpenses24.setAmount(15.52);
		incomeAndExpenses24.setDate(Timestamp.valueOf("2022-07-14 00:00:00"));
		incomeAndExpenses24.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses24.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses24);

		IncomeAndExpenses incomeAndExpenses25 = new IncomeAndExpenses();
		incomeAndExpenses25.setUserId(Long.parseLong("1"));
		incomeAndExpenses25.setTitle("Spar");
		incomeAndExpenses25.setAmount(27.64);
		incomeAndExpenses25.setDate(Timestamp.valueOf("2022-07-16 00:00:00"));
		incomeAndExpenses25.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses25.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses25);

		IncomeAndExpenses incomeAndExpenses26 = new IncomeAndExpenses();
		incomeAndExpenses26.setUserId(Long.parseLong("1"));
		incomeAndExpenses26.setTitle("Spar");
		incomeAndExpenses26.setAmount(41.51);
		incomeAndExpenses26.setDate(Timestamp.valueOf("2022-07-20 00:00:00"));
		incomeAndExpenses26.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses26.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses26);

		IncomeAndExpenses incomeAndExpenses27 = new IncomeAndExpenses();
		incomeAndExpenses27.setUserId(Long.parseLong("1"));
		incomeAndExpenses27.setTitle("Spar");
		incomeAndExpenses27.setAmount(15.52);
		incomeAndExpenses27.setDate(Timestamp.valueOf("2022-07-22 00:00:00"));
		incomeAndExpenses27.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses27.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses27);

		IncomeAndExpenses incomeAndExpenses28 = new IncomeAndExpenses();
		incomeAndExpenses28.setUserId(Long.parseLong("1"));
		incomeAndExpenses28.setTitle("Spar");
		incomeAndExpenses28.setAmount(27.64);
		incomeAndExpenses28.setDate(Timestamp.valueOf("2022-07-24 00:00:00"));
		incomeAndExpenses28.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses28.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses28);

		IncomeAndExpenses incomeAndExpenses29 = new IncomeAndExpenses();
		incomeAndExpenses29.setUserId(Long.parseLong("1"));
		incomeAndExpenses29.setTitle("Spar");
		incomeAndExpenses29.setAmount(41.51);
		incomeAndExpenses29.setDate(Timestamp.valueOf("2022-07-31 00:00:00"));
		incomeAndExpenses29.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses29.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses29);

		IncomeAndExpenses incomeAndExpenses30 = new IncomeAndExpenses();
		incomeAndExpenses30.setUserId(Long.parseLong("1"));
		incomeAndExpenses30.setTitle("Spar");
		incomeAndExpenses30.setAmount(15.52);
		incomeAndExpenses30.setDate(Timestamp.valueOf("2022-08-02 00:00:00"));
		incomeAndExpenses30.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses30.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses30);

		IncomeAndExpenses incomeAndExpenses31 = new IncomeAndExpenses();
		incomeAndExpenses31.setUserId(Long.parseLong("1"));
		incomeAndExpenses31.setTitle("Spar");
		incomeAndExpenses31.setAmount(27.64);
		incomeAndExpenses31.setDate(Timestamp.valueOf("2022-08-04 00:00:00"));
		incomeAndExpenses31.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses31.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses31);

		IncomeAndExpenses incomeAndExpenses32 = new IncomeAndExpenses();
		incomeAndExpenses32.setUserId(Long.parseLong("1"));
		incomeAndExpenses32.setTitle("Spar");
		incomeAndExpenses32.setAmount(41.51);
		incomeAndExpenses32.setDate(Timestamp.valueOf("2022-08-09 00:00:00"));
		incomeAndExpenses32.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses32.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses32);

		IncomeAndExpenses incomeAndExpenses33 = new IncomeAndExpenses();
		incomeAndExpenses33.setUserId(Long.parseLong("1"));
		incomeAndExpenses33.setTitle("Spar");
		incomeAndExpenses33.setAmount(15.52);
		incomeAndExpenses33.setDate(Timestamp.valueOf("2022-08-11 00:00:00"));
		incomeAndExpenses33.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses33.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses33);

		IncomeAndExpenses incomeAndExpenses34 = new IncomeAndExpenses();
		incomeAndExpenses34.setUserId(Long.parseLong("1"));
		incomeAndExpenses34.setTitle("Spar");
		incomeAndExpenses34.setAmount(27.64);
		incomeAndExpenses34.setDate(Timestamp.valueOf("2022-08-13 00:00:00"));
		incomeAndExpenses34.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses34.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses34);

		IncomeAndExpenses incomeAndExpenses35 = new IncomeAndExpenses();
		incomeAndExpenses35.setUserId(Long.parseLong("1"));
		incomeAndExpenses35.setTitle("Spar");
		incomeAndExpenses35.setAmount(41.51);
		incomeAndExpenses35.setDate(Timestamp.valueOf("2022-08-20 00:00:00"));
		incomeAndExpenses35.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses35.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses35);

		IncomeAndExpenses incomeAndExpenses36 = new IncomeAndExpenses();
		incomeAndExpenses36.setUserId(Long.parseLong("1"));
		incomeAndExpenses36.setTitle("Spar");
		incomeAndExpenses36.setAmount(15.52);
		incomeAndExpenses36.setDate(Timestamp.valueOf("2022-08-22 00:00:00"));
		incomeAndExpenses36.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses36.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses36);

		IncomeAndExpenses incomeAndExpenses37 = new IncomeAndExpenses();
		incomeAndExpenses37.setUserId(Long.parseLong("1"));
		incomeAndExpenses37.setTitle("Spar");
		incomeAndExpenses37.setAmount(27.64);
		incomeAndExpenses37.setDate(Timestamp.valueOf("2022-08-24 00:00:00"));
		incomeAndExpenses37.setCategory(IncomeAndExpenses.Category.FOOD);
		incomeAndExpenses37.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses37);

		IncomeAndExpenses incomeAndExpenses38 = new IncomeAndExpenses();
		incomeAndExpenses38.setUserId(Long.parseLong("1"));
		incomeAndExpenses38.setTitle("OMV");
		incomeAndExpenses38.setAmount(96.38);
		incomeAndExpenses38.setDate(Timestamp.valueOf("2022-05-02 00:00:00"));
		incomeAndExpenses38.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses38.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses38);

		IncomeAndExpenses incomeAndExpenses39 = new IncomeAndExpenses();
		incomeAndExpenses39.setUserId(Long.parseLong("1"));
		incomeAndExpenses39.setTitle("JET");
		incomeAndExpenses39.setAmount(93.84);
		incomeAndExpenses39.setDate(Timestamp.valueOf("2022-05-13 00:00:00"));
		incomeAndExpenses39.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses39.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses39);

		IncomeAndExpenses incomeAndExpenses40 = new IncomeAndExpenses();
		incomeAndExpenses40.setUserId(Long.parseLong("1"));
		incomeAndExpenses40.setTitle("BP");
		incomeAndExpenses40.setAmount(91.25);
		incomeAndExpenses40.setDate(Timestamp.valueOf("2022-05-24 00:00:00"));
		incomeAndExpenses40.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses40.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses40);

		IncomeAndExpenses incomeAndExpenses41 = new IncomeAndExpenses();
		incomeAndExpenses41.setUserId(Long.parseLong("1"));
		incomeAndExpenses41.setTitle("OMV");
		incomeAndExpenses41.setAmount(98.14);
		incomeAndExpenses41.setDate(Timestamp.valueOf("2022-06-04 00:00:00"));
		incomeAndExpenses41.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses41.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses41);

		IncomeAndExpenses incomeAndExpenses42 = new IncomeAndExpenses();
		incomeAndExpenses42.setUserId(Long.parseLong("1"));
		incomeAndExpenses42.setTitle("JET");
		incomeAndExpenses42.setAmount(95.56);
		incomeAndExpenses42.setDate(Timestamp.valueOf("2022-06-15 00:00:00"));
		incomeAndExpenses42.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses42.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses42);

		IncomeAndExpenses incomeAndExpenses43 = new IncomeAndExpenses();
		incomeAndExpenses43.setUserId(Long.parseLong("1"));
		incomeAndExpenses43.setTitle("BP");
		incomeAndExpenses43.setAmount(92.93);
		incomeAndExpenses43.setDate(Timestamp.valueOf("2022-06-26 00:00:00"));
		incomeAndExpenses43.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses43.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses43);

		IncomeAndExpenses incomeAndExpenses44 = new IncomeAndExpenses();
		incomeAndExpenses44.setUserId(Long.parseLong("1"));
		incomeAndExpenses44.setTitle("OMV");
		incomeAndExpenses44.setAmount(99.86);
		incomeAndExpenses44.setDate(Timestamp.valueOf("2022-07-07 00:00:00"));
		incomeAndExpenses44.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses44.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses44);

		IncomeAndExpenses incomeAndExpenses45 = new IncomeAndExpenses();
		incomeAndExpenses45.setUserId(Long.parseLong("1"));
		incomeAndExpenses45.setTitle("JET");
		incomeAndExpenses45.setAmount(97.24);
		incomeAndExpenses45.setDate(Timestamp.valueOf("2022-07-18 00:00:00"));
		incomeAndExpenses45.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses45.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses45);

		IncomeAndExpenses incomeAndExpenses46 = new IncomeAndExpenses();
		incomeAndExpenses46.setUserId(Long.parseLong("1"));
		incomeAndExpenses46.setTitle("BP");
		incomeAndExpenses46.setAmount(94.92);
		incomeAndExpenses46.setDate(Timestamp.valueOf("2022-07-29 00:00:00"));
		incomeAndExpenses46.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses46.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses46);

		IncomeAndExpenses incomeAndExpenses47 = new IncomeAndExpenses();
		incomeAndExpenses47.setUserId(Long.parseLong("1"));
		incomeAndExpenses47.setTitle("OMV");
		incomeAndExpenses47.setAmount(101.56);
		incomeAndExpenses47.setDate(Timestamp.valueOf("2022-08-09 00:00:00"));
		incomeAndExpenses47.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses47.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses47);

		IncomeAndExpenses incomeAndExpenses48 = new IncomeAndExpenses();
		incomeAndExpenses48.setUserId(Long.parseLong("1"));
		incomeAndExpenses48.setTitle("JET");
		incomeAndExpenses48.setAmount(98.9);
		incomeAndExpenses48.setDate(Timestamp.valueOf("2022-08-20 00:00:00"));
		incomeAndExpenses48.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses48.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses48);

		IncomeAndExpenses incomeAndExpenses49 = new IncomeAndExpenses();
		incomeAndExpenses49.setUserId(Long.parseLong("1"));
		incomeAndExpenses49.setTitle("BP");
		incomeAndExpenses49.setAmount(96.6);
		incomeAndExpenses49.setDate(Timestamp.valueOf("2022-08-31 00:00:00"));
		incomeAndExpenses49.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses49.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses49);

		IncomeAndExpenses incomeAndExpenses50 = new IncomeAndExpenses();
		incomeAndExpenses50.setUserId(Long.parseLong("1"));
		incomeAndExpenses50.setTitle("OMV");
		incomeAndExpenses50.setAmount(103.24);
		incomeAndExpenses50.setDate(Timestamp.valueOf("2022-09-11 00:00:00"));
		incomeAndExpenses50.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses50.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses50);

		IncomeAndExpenses incomeAndExpenses51 = new IncomeAndExpenses();
		incomeAndExpenses51.setUserId(Long.parseLong("1"));
		incomeAndExpenses51.setTitle("JET");
		incomeAndExpenses51.setAmount(100.56);
		incomeAndExpenses51.setDate(Timestamp.valueOf("2022-09-22 00:00:00"));
		incomeAndExpenses51.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses51.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses51);

		IncomeAndExpenses incomeAndExpenses52 = new IncomeAndExpenses();
		incomeAndExpenses52.setUserId(Long.parseLong("1"));
		incomeAndExpenses52.setTitle("BP");
		incomeAndExpenses52.setAmount(98.28);
		incomeAndExpenses52.setDate(Timestamp.valueOf("2022-10-03 00:00:00"));
		incomeAndExpenses52.setCategory(IncomeAndExpenses.Category.TRANSPORTATION);
		incomeAndExpenses52.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses52);

		IncomeAndExpenses incomeAndExpenses53 = new IncomeAndExpenses();
		incomeAndExpenses53.setUserId(Long.parseLong("1"));
		incomeAndExpenses53.setTitle("Rent for apartment");
		incomeAndExpenses53.setAmount(1851.12);
		incomeAndExpenses53.setDate(Timestamp.valueOf("2022-05-01 00:00:00"));
		incomeAndExpenses53.setAbo(true);
		incomeAndExpenses53.setAboInterval(12);
		incomeAndExpenses53.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses53.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses53);

		IncomeAndExpenses incomeAndExpenses54 = new IncomeAndExpenses();
		incomeAndExpenses54.setUserId(Long.parseLong("1"));
		incomeAndExpenses54.setTitle("Rent for apartment");
		incomeAndExpenses54.setAmount(1851.12);
		incomeAndExpenses54.setDate(Timestamp.valueOf("2022-06-01 00:00:00"));
		incomeAndExpenses54.setAbo(true);
		incomeAndExpenses54.setAboInterval(12);
		incomeAndExpenses54.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses54.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses54);

		IncomeAndExpenses incomeAndExpenses55 = new IncomeAndExpenses();
		incomeAndExpenses55.setUserId(Long.parseLong("1"));
		incomeAndExpenses55.setTitle("Rent for apartment");
		incomeAndExpenses55.setAmount(1851.12);
		incomeAndExpenses55.setDate(Timestamp.valueOf("2022-07-01 00:00:00"));
		incomeAndExpenses55.setAbo(true);
		incomeAndExpenses55.setAboInterval(12);
		incomeAndExpenses55.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses55.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses55);

		IncomeAndExpenses incomeAndExpenses56 = new IncomeAndExpenses();
		incomeAndExpenses56.setUserId(Long.parseLong("1"));
		incomeAndExpenses56.setTitle("Rent for apartment");
		incomeAndExpenses56.setAmount(1851.12);
		incomeAndExpenses56.setDate(Timestamp.valueOf("2022-08-01 00:00:00"));
		incomeAndExpenses56.setAbo(true);
		incomeAndExpenses56.setAboInterval(12);
		incomeAndExpenses56.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses56.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses56);

		IncomeAndExpenses incomeAndExpenses57 = new IncomeAndExpenses();
		incomeAndExpenses57.setUserId(Long.parseLong("1"));
		incomeAndExpenses57.setTitle("Rent for apartment");
		incomeAndExpenses57.setAmount(1851.12);
		incomeAndExpenses57.setDate(Timestamp.valueOf("2022-09-01 00:00:00"));
		incomeAndExpenses57.setAbo(true);
		incomeAndExpenses57.setAboInterval(12);
		incomeAndExpenses57.setCategory(IncomeAndExpenses.Category.HOUSING);
		incomeAndExpenses57.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses57);

		IncomeAndExpenses incomeAndExpenses58 = new IncomeAndExpenses();
		incomeAndExpenses58.setUserId(Long.parseLong("1"));
		incomeAndExpenses58.setTitle("Doc. Sommer");
		incomeAndExpenses58.setAmount(188.0);
		incomeAndExpenses58.setDate(Timestamp.valueOf("2022-07-21 00:00:00"));
		incomeAndExpenses58.setCategory(IncomeAndExpenses.Category.HEALTH);
		incomeAndExpenses58.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses58);

		IncomeAndExpenses incomeAndExpenses59 = new IncomeAndExpenses();
		incomeAndExpenses59.setUserId(Long.parseLong("1"));
		incomeAndExpenses59.setTitle("DDDoc. Kneissl - Implantat");
		incomeAndExpenses59.setAmount(7188.52);
		incomeAndExpenses59.setDate(Timestamp.valueOf("2022-08-02 00:00:00"));
		incomeAndExpenses59.setCategory(IncomeAndExpenses.Category.HEALTH);
		incomeAndExpenses59.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses59);

		IncomeAndExpenses incomeAndExpenses60 = new IncomeAndExpenses();
		incomeAndExpenses60.setUserId(Long.parseLong("1"));
		incomeAndExpenses60.setTitle("Netflix");
		incomeAndExpenses60.setAmount(15.99);
		incomeAndExpenses60.setDate(Timestamp.valueOf("2022-05-11 00:00:00"));
		incomeAndExpenses60.setAbo(true);
		incomeAndExpenses60.setAboInterval(12);
		incomeAndExpenses60.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses60.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses60);

		IncomeAndExpenses incomeAndExpenses61 = new IncomeAndExpenses();
		incomeAndExpenses61.setUserId(Long.parseLong("1"));
		incomeAndExpenses61.setTitle("Netflix");
		incomeAndExpenses61.setAmount(15.99);
		incomeAndExpenses61.setDate(Timestamp.valueOf("2022-06-11 00:00:00"));
		incomeAndExpenses61.setAbo(true);
		incomeAndExpenses61.setAboInterval(12);
		incomeAndExpenses61.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses61.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses61);

		IncomeAndExpenses incomeAndExpenses62 = new IncomeAndExpenses();
		incomeAndExpenses62.setUserId(Long.parseLong("1"));
		incomeAndExpenses62.setTitle("Netflix");
		incomeAndExpenses62.setAmount(15.99);
		incomeAndExpenses62.setDate(Timestamp.valueOf("2022-07-11 00:00:00"));
		incomeAndExpenses62.setAbo(true);
		incomeAndExpenses62.setAboInterval(12);
		incomeAndExpenses62.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses62.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses62);

		IncomeAndExpenses incomeAndExpenses63 = new IncomeAndExpenses();
		incomeAndExpenses63.setUserId(Long.parseLong("1"));
		incomeAndExpenses63.setTitle("Netflix");
		incomeAndExpenses63.setAmount(15.99);
		incomeAndExpenses63.setDate(Timestamp.valueOf("2022-08-11 00:00:00"));
		incomeAndExpenses63.setAbo(true);
		incomeAndExpenses63.setAboInterval(12);
		incomeAndExpenses63.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses63.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses63);

		IncomeAndExpenses incomeAndExpenses64 = new IncomeAndExpenses();
		incomeAndExpenses64.setUserId(Long.parseLong("1"));
		incomeAndExpenses64.setTitle("Netflix");
		incomeAndExpenses64.setAmount(15.99);
		incomeAndExpenses64.setDate(Timestamp.valueOf("2022-09-11 00:00:00"));
		incomeAndExpenses64.setAbo(true);
		incomeAndExpenses64.setAboInterval(12);
		incomeAndExpenses64.setCategory(incomeAndExpenses64.getCategory().ENTERTAINMENT);
		incomeAndExpenses64.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses64);

		IncomeAndExpenses incomeAndExpenses65 = new IncomeAndExpenses();
		incomeAndExpenses65.setUserId(Long.parseLong("1"));
		incomeAndExpenses65.setTitle("AppleMusic");
		incomeAndExpenses65.setAmount(19.99);
		incomeAndExpenses65.setDate(Timestamp.valueOf("2022-05-25 00:00:00"));
		incomeAndExpenses65.setAbo(true);
		incomeAndExpenses65.setAboInterval(12);
		incomeAndExpenses65.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses65.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses65);

		IncomeAndExpenses incomeAndExpenses66 = new IncomeAndExpenses();
		incomeAndExpenses66.setUserId(Long.parseLong("1"));
		incomeAndExpenses66.setTitle("AppleMusic");
		incomeAndExpenses66.setAmount(19.99);
		incomeAndExpenses66.setDate(Timestamp.valueOf("2022-06-25 00:00:00"));
		incomeAndExpenses66.setAbo(true);
		incomeAndExpenses66.setAboInterval(12);
		incomeAndExpenses66.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses66.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses66);

		IncomeAndExpenses incomeAndExpenses67 = new IncomeAndExpenses();
		incomeAndExpenses67.setUserId(Long.parseLong("1"));
		incomeAndExpenses67.setTitle("AppleMusic");
		incomeAndExpenses67.setAmount(19.99);
		incomeAndExpenses67.setDate(Timestamp.valueOf("2022-07-25 00:00:00"));
		incomeAndExpenses67.setAbo(true);
		incomeAndExpenses67.setAboInterval(12);
		incomeAndExpenses67.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses67.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses67);

		IncomeAndExpenses incomeAndExpenses68 = new IncomeAndExpenses();
		incomeAndExpenses68.setUserId(Long.parseLong("1"));
		incomeAndExpenses68.setTitle("AppleMusic");
		incomeAndExpenses68.setAmount(19.99);
		incomeAndExpenses68.setDate(Timestamp.valueOf("2022-08-25 00:00:00"));
		incomeAndExpenses68.setAbo(true);
		incomeAndExpenses68.setAboInterval(12);
		incomeAndExpenses68.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses68.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses68);

		IncomeAndExpenses incomeAndExpenses69 = new IncomeAndExpenses();
		incomeAndExpenses69.setUserId(Long.parseLong("1"));
		incomeAndExpenses69.setTitle("AppleMusic");
		incomeAndExpenses69.setAmount(19.99);
		incomeAndExpenses69.setDate(Timestamp.valueOf("2022-09-25 00:00:00"));
		incomeAndExpenses69.setAbo(true);
		incomeAndExpenses69.setAboInterval(12);
		incomeAndExpenses69.setCategory(IncomeAndExpenses.Category.ENTERTAINMENT);
		incomeAndExpenses69.setType(IncomeAndExpenses.Type.EXPENSE);
		incomeAndExpensesRepository.save(incomeAndExpenses69);

	


		Auction auction1 = new Auction();
		auction1.setTitle("Brauwirt - Ottakringer Beer Auction");
		auction1.setUserId(Long.parseLong("1"));
		auction1.setProductId(Long.parseLong("1"));
		auction1.setStartingPrice(189.0);
		auction1.setMinAmount(Long.parseLong("200"));
		auction1.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 172800000));
		auction1.setEndDate(new Timestamp(System.currentTimeMillis() + 86400000));
		auction1.setStatus(Status.OPEN);
		auctionRepository.save(auction1);

		Auction auction2 = new Auction();
		auction2.setTitle("Schnapshaus - Ottakringer Beer Auction");
		auction2.setUserId(Long.parseLong("2"));
		auction2.setProductId(Long.parseLong("1"));
		auction2.setStartingPrice(8.90);
		auction2.setMinAmount(Long.parseLong("10"));
		auction2.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 122800000));
		auction2.setEndDate(new Timestamp(System.currentTimeMillis() + 300000));
		auction2.setStatus(Status.OPEN);
		auctionRepository.save(auction2);

		Auction auction3 = new Auction();
		auction3.setTitle("Heineken Beer Auction");
		auction3.setUserId(Long.parseLong("3"));
		auction3.setProductId(Long.parseLong("2"));
		auction3.setStartingPrice(1499.99);
		auction3.setMinAmount(Long.parseLong("800"));
		auction3.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 372800000));
		auction3.setEndDate(new Timestamp(System.currentTimeMillis() + 212800000));
		auction3.setStatus(Status.OPEN);
		auctionRepository.save(auction3);

		Auction auction4 = new Auction();
		auction4.setTitle("Staropramen Beer Auction");
		auction4.setUserId(Long.parseLong("1"));
		auction4.setProductId(Long.parseLong("3"));
		auction4.setStartingPrice(1370.0);
		auction4.setMinAmount(Long.parseLong("985"));
		auction4.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 172800000));
		auction4.setEndDate(new Timestamp(System.currentTimeMillis() - 86400000));
		auction4.setStatus(Status.CLOSED);
		auctionRepository.save(auction4);

		Auction auction5 = new Auction();
		auction5.setTitle("Budweiser Beer Auction");
		auction5.setUserId(Long.parseLong("2"));
		auction5.setProductId(Long.parseLong("6"));
		auction5.setStartingPrice(21.0);
		auction5.setMinAmount(Long.parseLong("20"));
		auction5.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 72800000));
		auction5.setEndDate(new Timestamp(System.currentTimeMillis() + 6400000));
		auction5.setStatus(Status.OPEN);
		auctionRepository.save(auction5);

		Auction auction6 = new Auction();
		auction6.setTitle("Guiness Beer Auction");
		auction6.setUserId(Long.parseLong("1"));
		auction6.setProductId(Long.parseLong("7"));
		auction6.setStartingPrice(2355.00);
		auction6.setMinAmount(Long.parseLong("850"));
		auction6.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 892800000));
		auction6.setEndDate(new Timestamp(System.currentTimeMillis() + 592800000));
		auction6.setStatus(Status.OPEN);
		auctionRepository.save(auction6);

		Auction auction7 = new Auction();
		auction7.setTitle("LOCKED DEMO AUCTION");
		auction7.setUserId(Long.parseLong("2"));
		auction7.setProductId(Long.parseLong("7"));
		auction7.setStartingPrice(14.0);
		auction7.setMinAmount(Long.parseLong("5"));
		auction7.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 142800000));
		auction7.setEndDate(new Timestamp(System.currentTimeMillis() + 46400000));
		auction7.setStatus(Status.LOCKED);
		auctionRepository.save(auction7);

		Auction auction8 = new Auction();
		auction8.setTitle("Corona Beer Auction");
		auction8.setUserId(Long.parseLong("4"));
		auction8.setProductId(Long.parseLong("4"));
		auction8.setStartingPrice(305.0);
		auction8.setMinAmount(Long.parseLong("115"));
		auction8.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 102800000));
		auction8.setEndDate(new Timestamp(System.currentTimeMillis() + 16400000));
		auction8.setStatus(Status.OPEN);
		auctionRepository.save(auction8);

		Auction auction9 = new Auction();
		auction9.setTitle("Bud Light Beer Auction");
		auction9.setUserId(Long.parseLong("3"));
		auction9.setProductId(Long.parseLong("10"));
		auction9.setStartingPrice(14.0);
		auction9.setMinAmount(Long.parseLong("10"));
		auction9.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 128000000));
		auction9.setEndDate(new Timestamp(System.currentTimeMillis() + 943450));
		auction9.setStatus(Status.OPEN);
		auctionRepository.save(auction9);

		Auction auction10 = new Auction();
		auction10.setTitle("Corona Beer Auction");
		auction10.setUserId(Long.parseLong("5"));
		auction10.setProductId(Long.parseLong("4"));
		auction10.setStartingPrice(230.0);
		auction10.setMinAmount(Long.parseLong("100"));
		auction10.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 128000000));
		auction10.setEndDate(new Timestamp(System.currentTimeMillis() + 2400000));
		auction10.setStatus(Status.OPEN);
		auctionRepository.save(auction10);

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

		Bid bid1 = new Bid();
		bid1.setAuctionId(Long.parseLong("1"));
		bid1.setUserId(Long.parseLong("2"));
		bid1.setPrice(185.00);
		bid1.setAmount(Long.parseLong("200"));
		bid1.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 162800000));
		bid1.setTimestamp(new Timestamp(System.currentTimeMillis() - 86400000));
		bidRepository.save(bid1);

		Bid bid2 = new Bid();
		bid2.setAuctionId(Long.parseLong("1"));
		bid2.setUserId(Long.parseLong("4"));
		bid2.setPrice(183.00);
		bid2.setAmount(Long.parseLong("200"));
		bid2.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 162800000));
		bid2.setTimestamp(new Timestamp(System.currentTimeMillis() - 76400000));
		bidRepository.save(bid2);

		Bid bid3 = new Bid();
		bid3.setAuctionId(Long.parseLong("1"));
		bid3.setUserId(Long.parseLong("2"));
		bid3.setPrice(182.00);
		bid3.setAmount(Long.parseLong("200"));
		bid3.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 162800000));
		bid3.setTimestamp(new Timestamp(System.currentTimeMillis() - 66400000));
		bidRepository.save(bid3);

		Bid bid4 = new Bid();
		bid4.setAuctionId(Long.parseLong("1"));
		bid4.setUserId(Long.parseLong("4"));
		bid4.setPrice(181.00);
		bid4.setAmount(Long.parseLong("200"));
		bid4.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 162800000));
		bid4.setTimestamp(new Timestamp(System.currentTimeMillis() - 56400000));
		bidRepository.save(bid4);

		Bid bid5 = new Bid();
		bid5.setAuctionId(Long.parseLong("1"));
		bid5.setUserId(Long.parseLong("5"));
		bid5.setPrice(175.00);
		bid5.setAmount(Long.parseLong("200"));
		bid5.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 162800000));
		bid5.setTimestamp(new Timestamp(System.currentTimeMillis() - 46400000));
		bidRepository.save(bid5);

		Bid bid6 = new Bid();
		bid6.setAuctionId(Long.parseLong("1"));
		bid6.setUserId(Long.parseLong("2"));
		bid6.setPrice(180.00);
		bid6.setAmount(Long.parseLong("220"));
		bid6.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 162800000));
		bid6.setTimestamp(new Timestamp(System.currentTimeMillis() - 6400000));
		bidRepository.save(bid6);

		Bid bid7 = new Bid();
		bid7.setAuctionId(Long.parseLong("2"));
		bid7.setUserId(Long.parseLong("1"));
		bid7.setPrice(8.90);
		bid7.setAmount(Long.parseLong("10"));
		bid7.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 112800000));
		bid7.setTimestamp(new Timestamp(System.currentTimeMillis() - 46400000));
		bidRepository.save(bid7);

		Bid bid8 = new Bid();
		bid8.setAuctionId(Long.parseLong("2"));
		bid8.setUserId(Long.parseLong("4"));
		bid8.setPrice(8.80);
		bid8.setAmount(Long.parseLong("10"));
		bid8.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 112800000));
		bid8.setTimestamp(new Timestamp(System.currentTimeMillis() - 36400000));
		bidRepository.save(bid8);

		Bid bid9 = new Bid();
		bid9.setAuctionId(Long.parseLong("2"));
		bid9.setUserId(Long.parseLong("5"));
		bid9.setPrice(8.70);
		bid9.setAmount(Long.parseLong("10"));
		bid9.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 112800000));
		bid9.setTimestamp(new Timestamp(System.currentTimeMillis() - 26400000));
		bidRepository.save(bid9);

		Bid bid10 = new Bid();
		bid10.setAuctionId(Long.parseLong("2"));
		bid10.setUserId(Long.parseLong("1"));
		bid10.setPrice(8.20);
		bid10.setAmount(Long.parseLong("10"));
		bid10.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 112800000));
		bid10.setTimestamp(new Timestamp(System.currentTimeMillis() - 16400000));
		bidRepository.save(bid10);

		Bid bid11 = new Bid();
		bid11.setAuctionId(Long.parseLong("2"));
		bid11.setUserId(Long.parseLong("4"));
		bid11.setPrice(8.10);
		bid11.setAmount(Long.parseLong("10"));
		bid11.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 112800000));
		bid11.setTimestamp(new Timestamp(System.currentTimeMillis() - 6400000));
		bidRepository.save(bid11);

		Bid bid12 = new Bid();
		bid12.setAuctionId(Long.parseLong("3"));
		bid12.setUserId(Long.parseLong("1"));
		bid12.setPrice(1499.99);
		bid12.setAmount(Long.parseLong("8000"));
		bid12.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 372700000));
		bid12.setTimestamp(new Timestamp(System.currentTimeMillis() - 46400000));
		bidRepository.save(bid12);

		Bid bid13 = new Bid();
		bid13.setAuctionId(Long.parseLong("5"));
		bid13.setUserId(Long.parseLong("1"));
		bid13.setPrice(21.0);
		bid13.setAmount(Long.parseLong("20"));
		bid13.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 72700000));
		bid13.setTimestamp(new Timestamp(System.currentTimeMillis() - 146400000));
		bidRepository.save(bid13);

		Bid bid14 = new Bid();
		bid14.setAuctionId(Long.parseLong("5"));
		bid14.setUserId(Long.parseLong("4"));
		bid14.setPrice(20.0);
		bid14.setAmount(Long.parseLong("20"));
		bid14.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 72700000));
		bid14.setTimestamp(new Timestamp(System.currentTimeMillis() - 106400000));
		bidRepository.save(bid14);

		Bid bid15 = new Bid();
		bid15.setAuctionId(Long.parseLong("6"));
		bid15.setUserId(Long.parseLong("2"));
		bid15.setPrice(2300.0);
		bid15.setAmount(Long.parseLong("8500"));
		bid15.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 892700000));
		bid15.setTimestamp(new Timestamp(System.currentTimeMillis() - 592800000));
		bidRepository.save(bid15);

		Bid bid16 = new Bid();
		bid16.setAuctionId(Long.parseLong("6"));
		bid16.setUserId(Long.parseLong("5"));
		bid16.setPrice(2200.0);
		bid16.setAmount(Long.parseLong("8500"));
		bid16.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 892700000));
		bid16.setTimestamp(new Timestamp(System.currentTimeMillis() - 492800000));
		bidRepository.save(bid16);

		Bid bid17 = new Bid();
		bid17.setAuctionId(Long.parseLong("7"));
		bid17.setUserId(Long.parseLong("1"));
		bid17.setPrice(14.0);
		bid17.setAmount(Long.parseLong("5"));
		bid17.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 142700000));
		bid17.setTimestamp(new Timestamp(System.currentTimeMillis() - 800000));
		bidRepository.save(bid17);

		Bid bid18 = new Bid();
		bid18.setAuctionId(Long.parseLong("8"));
		bid18.setUserId(Long.parseLong("5"));
		bid18.setPrice(299.99);
		bid18.setAmount(Long.parseLong("115"));
		bid18.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 102600000));
		bid18.setTimestamp(new Timestamp(System.currentTimeMillis() - 800000));
		bidRepository.save(bid18);

		Bid bid19 = new Bid();
		bid19.setAuctionId(Long.parseLong("9"));
		bid19.setUserId(Long.parseLong("1"));
		bid19.setPrice(14.0);
		bid19.setAmount(Long.parseLong("10"));
		bid19.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid19.setTimestamp(new Timestamp(System.currentTimeMillis() - 86400000));
		bidRepository.save(bid19);

		Bid bid20 = new Bid();
		bid20.setAuctionId(Long.parseLong("9"));
		bid20.setUserId(Long.parseLong("4"));
		bid20.setPrice(13.9);
		bid20.setAmount(Long.parseLong("10"));
		bid20.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid20.setTimestamp(new Timestamp(System.currentTimeMillis() - 85900000));
		bidRepository.save(bid20);

		Bid bid21 = new Bid();
		bid21.setAuctionId(Long.parseLong("9"));
		bid21.setUserId(Long.parseLong("1"));
		bid21.setPrice(13.8);
		bid21.setAmount(Long.parseLong("10"));
		bid21.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid21.setTimestamp(new Timestamp(System.currentTimeMillis() - 85400000));
		bidRepository.save(bid21);

		Bid bid22 = new Bid();
		bid22.setAuctionId(Long.parseLong("9"));
		bid22.setUserId(Long.parseLong("4"));
		bid22.setPrice(13.7);
		bid22.setAmount(Long.parseLong("10"));
		bid22.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid22.setTimestamp(new Timestamp(System.currentTimeMillis() - 84900000));
		bidRepository.save(bid22);

		Bid bid23 = new Bid();
		bid23.setAuctionId(Long.parseLong("9"));
		bid23.setUserId(Long.parseLong("1"));
		bid23.setPrice(13.6);
		bid23.setAmount(Long.parseLong("10"));
		bid23.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid23.setTimestamp(new Timestamp(System.currentTimeMillis() - 84400000));
		bidRepository.save(bid23);

		Bid bid24 = new Bid();
		bid24.setAuctionId(Long.parseLong("9"));
		bid24.setUserId(Long.parseLong("4"));
		bid24.setPrice(13.55);
		bid24.setAmount(Long.parseLong("10"));
		bid24.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid24.setTimestamp(new Timestamp(System.currentTimeMillis() - 82400000));
		bidRepository.save(bid24);

		Bid bid25 = new Bid();
		bid25.setAuctionId(Long.parseLong("9"));
		bid25.setUserId(Long.parseLong("1"));
		bid25.setPrice(13.5);
		bid25.setAmount(Long.parseLong("10"));
		bid25.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid25.setTimestamp(new Timestamp(System.currentTimeMillis() - 81400000));
		bidRepository.save(bid25);

		Bid bid26 = new Bid();
		bid26.setAuctionId(Long.parseLong("9"));
		bid26.setUserId(Long.parseLong("4"));
		bid26.setPrice(13.45);
		bid26.setAmount(Long.parseLong("10"));
		bid26.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid26.setTimestamp(new Timestamp(System.currentTimeMillis() - 70000000));
		bidRepository.save(bid26);

		Bid bid27 = new Bid();
		bid27.setAuctionId(Long.parseLong("9"));
		bid27.setUserId(Long.parseLong("1"));
		bid27.setPrice(13.4);
		bid27.setAmount(Long.parseLong("10"));
		bid27.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid27.setTimestamp(new Timestamp(System.currentTimeMillis() - 30000000));
		bidRepository.save(bid27);

		Bid bid28 = new Bid();
		bid28.setAuctionId(Long.parseLong("9"));
		bid28.setUserId(Long.parseLong("4"));
		bid28.setPrice(13.35);
		bid28.setAmount(Long.parseLong("10"));
		bid28.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid28.setTimestamp(new Timestamp(System.currentTimeMillis() - 20000000));
		bidRepository.save(bid28);

		Bid bid29 = new Bid();
		bid29.setAuctionId(Long.parseLong("9"));
		bid29.setUserId(Long.parseLong("2"));
		bid29.setPrice(13.3);
		bid29.setAmount(Long.parseLong("10"));
		bid29.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid29.setTimestamp(new Timestamp(System.currentTimeMillis() - 10000000));
		bidRepository.save(bid29);

		Bid bid30 = new Bid();
		bid30.setAuctionId(Long.parseLong("9"));
		bid30.setUserId(Long.parseLong("1"));
		bid30.setPrice(13.2);
		bid30.setAmount(Long.parseLong("10"));
		bid30.setDeliveryDate(new Timestamp(System.currentTimeMillis() + 127000000));
		bid30.setTimestamp(new Timestamp(System.currentTimeMillis() - 160000));
		bidRepository.save(bid30);

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

		Product product1 = new Product();
		product1.setName("Ottakringer");
		product1.setDescription(
				"Ottakringer is a beer brand from Vienna, Austria. It is produced by Ottakringer Brauerei, a subsidiary of the Carlsberg Group.");
		product1.setPrice(0.99);
		productRepository.save(product1);

		Product product2 = new Product();
		product2.setName("Heineken");
		product2.setDescription(
				"Heineken is a light, crisp and bitter European-style lager beer with 5% alcohol by volume.");
		product2.setPrice(1.99);
		productRepository.save(product2);

		Product product3 = new Product();
		product3.setName("Staropramen");
		product3.setDescription(
				"Staropramen is a pilsner beer produced by the Starobrno Brewery in the Czech Republic.");
		product3.setPrice(1.49);
		productRepository.save(product3);

		Product product4 = new Product();
		product4.setName("Corona");
		product4.setDescription(
				"Corona Extra is a pale lager beer produced by Cervecería Modelo in Mexico, and is the best-selling beer in Mexico.");
		product4.setPrice(2.99);
		productRepository.save(product4);

		Product product5 = new Product();
		product5.setName("Tuborg");
		product5.setDescription(
				"Tuborg is a Danish beer brand owned by Carlsberg Group. It is the best-selling beer in Denmark.");
		product5.setPrice(0.89);
		productRepository.save(product5);

		Product product6 = new Product();
		product6.setName("Budweiser");
		product6.setDescription("Budweiser is an American-style pale lager produced by Anheuser-Busch.");
		product6.setPrice(1.19);
		productRepository.save(product6);

		Product product7 = new Product();
		product7.setName("Guinness");
		product7.setDescription(
				"Guinness is a dry stout that originated in the brewery of Arthur Guinness (1725–1803) at St. James's Gate, Dublin.");
		product7.setPrice(2.99);
		productRepository.save(product7);

		Product product8 = new Product();
		product8.setName("Kronenbourg 1664");
		product8.setDescription("Kronenbourg 1664 is a pale lager beer produced by Brasseries Kronenbourg.");
		product8.setPrice(1.69);
		productRepository.save(product8);

		Product product9 = new Product();
		product9.setName("Peroni Nastro Azzurro");
		product9.setDescription("Peroni Nastro Azzurro is an Italian lager beer produced by Birra Peroni.");
		product9.setPrice(1.99);
		productRepository.save(product9);

		Product product10 = new Product();
		product10.setName("Bud Light");
		product10
				.setDescription("Bud Light is a light-bodied, crisp American-style lager with 4.2% alcohol by volume.");
		product10.setPrice(1.49);
		productRepository.save(product10);

		Product product11 = new Product();
		product11.setName("Carlsberg");
		product11.setDescription("Carlsberg is a Danish pilsner beer produced by Carlsberg Group.");
		product11.setPrice(1.99);
		productRepository.save(product11);
	}
}