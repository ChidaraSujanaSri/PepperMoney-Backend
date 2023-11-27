package com.peppermoney.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peppermoney.dto.ExpensesDto;
import com.peppermoney.entity.Expenses;
import com.peppermoney.exception.CustomException;
import com.peppermoney.repository.ExpensesRepository;
import com.peppermoney.services.ExpensesService;
import com.peppermoney.util.ExpensesDtoConvertor;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    ExpensesService expensesService;
	
	@Autowired
	ExpensesRepository expensesRepository;
	
	@Autowired
	ExpensesDtoConvertor expensesDtoConvertor;
	
	public ExpensesController() {
		logger.info("expenses controller");
		System.err.println("expenses controller");
	}
	
	@PostMapping("/add")
	public ResponseEntity<ExpensesDto> saveExpenses(@RequestBody Expenses expenses) throws Exception {
		Expenses savedExpenses = expensesService.addExpenses(expenses);
		logger.info(" --->> Expenses saved " + savedExpenses);

		if (savedExpenses != null) {
			ExpensesDto dtoObj = expensesDtoConvertor.getExpensesdto(savedExpenses);
			return new ResponseEntity<ExpensesDto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}
	
	
	@GetMapping("/getExpenses")
	public ResponseEntity<List<ExpensesDto>> getAllExpenses()
	{
		List<Expenses> allExpensesInDB = expensesService.getAllExpenses();

		List<ExpensesDto> dtoList = new ArrayList<>();
		for (Expenses expenses : allExpensesInDB) {

			ExpensesDto dtoObj = expensesDtoConvertor.getExpensesdto(expenses);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<ExpensesDto>>(dtoList,HttpStatus.OK);
	}
	
	
	@GetMapping("/getExpenses/{expensesId}")
	public ResponseEntity<?> getExpensesById(@PathVariable int expensesId) {
		return ResponseEntity.ok(expensesService.getExpensesById(expensesId));
	}
	
	
	
	@PutMapping("/updateExpenses/{expensesId}")
		public ResponseEntity<Expenses> updateExpenses(@RequestBody Expenses expenses,
				@PathVariable int expensesId) throws CustomException {
			return ResponseEntity.ok(expensesService.updateExpenses(expenses, expensesId));
		}
	@DeleteMapping("/deleteExpenses/{expensesId}")
	public ResponseEntity<Void> deleteExpenses(@PathVariable int expensesId) {
	    expensesService.deleteExpenses(expensesId);
	    return ResponseEntity.noContent().build();
	}

	

}
