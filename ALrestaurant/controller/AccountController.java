package com.aladhas.ALrestaurant.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aladhas.ALrestaurant.services.AccountServices;
import com.aladhas.ALrestaurant.services.AutonumberServices;
import com.aladhas.ALrestaurant.services.BillServices;
import com.aladhas.ALrestaurant.services.DatesServices;
import com.aladhas.ALrestaurant.services.ExpensesService;
import com.aladhas.ALrestaurant.model.Account;
import com.aladhas.ALrestaurant.model.Autonumber;
import com.aladhas.ALrestaurant.model.Dates;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class AccountController {

	@Autowired
	private DatesServices da;

	@Autowired
	private BillServices bill;

	@Autowired
	private AccountServices acc;

	@Autowired
	private ExpensesService exp;

	@Autowired
	private AutonumberServices auto;
	
	@GetMapping("/Account")
	public ModelAndView Account(@RequestParam("empName") String emp) {
		ModelAndView mv = new ModelAndView();
		Account account = new Account();
		mv.addObject("acc", account);
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String stringDate = fd.format(d);
		java.sql.Date d1 = java.sql.Date.valueOf(stringDate);

		mv.addObject("dateDay", d1);

		int shift = da.getShiftNumber();
		mv.addObject("shift", shift);

		List<Account> allAcc = acc.getAllaccountByDate(d1);
		mv.addObject("allAcc", allAcc);

		Dates dates = da.getDateByShiftNum(shift);
//		if(dates != null) {
		int billNumber = bill.getBillNumber(emp, d1, dates.getTime_from(), dates.getTime_to());
		int deleviryNum = bill.getBillTypeNumber(emp, d1, dates.getTime_from(), dates.getTime_to(), "Delevery");
		int TakeNum = bill.getBillTypeNumber(emp, d1, dates.getTime_from(), dates.getTime_to(), "TakeAway");
		int ReceptionNum = bill.getBillTypeNumber(emp, d1, dates.getTime_from(), dates.getTime_to(), "Reception");
		mv.addObject("billNumber", billNumber);
		mv.addObject("deleviryNum", deleviryNum);
		mv.addObject("TakeNum", TakeNum);
		mv.addObject("ReceptionNum", ReceptionNum);

		Double billTotal = bill.getBillTotal(emp, d1, dates.getTime_from(), dates.getTime_to());
		Double deleviryTotal = bill.getBillTypeTotal(emp, d1, dates.getTime_from(), dates.getTime_to(), "Delevery");
		Double TakeTotal = bill.getBillTypeTotal(emp, d1, dates.getTime_from(), dates.getTime_to(), "TakeAway");
		Double ReceptionTotal = bill.getBillTypeTotal(emp, d1, dates.getTime_from(), dates.getTime_to(), "Reception");
		mv.addObject("billTotal", billTotal);
		mv.addObject("deleviryTotal", deleviryTotal);
		mv.addObject("TakeTotal", TakeTotal);
		mv.addObject("ReceptionTotal", ReceptionTotal);

		Double expensesTotal = exp.getExpensesTotal(emp, d1, dates.getTime_from(), dates.getTime_to());
		mv.addObject("expensesTotal", expensesTotal);
//		}
		mv.addObject("title", "الحسابات");
		mv.setViewName("Account");
		return mv;
	}

	@PostMapping("/Account")
	public String endAccount(@ModelAttribute("acc") Account account, 
			@RequestParam("empName") String empName,
			RedirectAttributes mv) {
		try {
			
			account.setEmp(empName);
			acc.save(account);
			
			auto.deleteAll();
			Autonumber au = new Autonumber();
			au.setNumber(0);
			auto.save(au);
			
			String m = "تم الحفظ";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
			String m = "تم الحفظ من قبل";
			mv.addFlashAttribute("error", m);
		}
		return "redirect:/ALRestaurant/Account?empName="+empName;
	}
}
