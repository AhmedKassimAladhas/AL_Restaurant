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

import com.aladhas.ALrestaurant.services.ExpensesService;
import com.aladhas.ALrestaurant.model.Expenses;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class ExpensesController {

	@Autowired
	private ExpensesService expensesService;

	@GetMapping("/Expenses")
	public ModelAndView Expenses() {
		ModelAndView mv = new ModelAndView();
		Expenses exp = new Expenses();
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String stringDate = fd.format(d);
		java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
		List<Expenses> allExp = expensesService.getAllByDateExpenses(d1);
		mv.addObject("exp", exp);
		mv.addObject("allExp", allExp);
		mv.addObject("title", "المصروفات");
		mv.setViewName("Expenses");
		return mv;
	}

	@PostMapping("/Expenses")
	public String addNewExpense(@ModelAttribute("exp") Expenses exp,
			@RequestParam("exp_empName") String exp_empName, RedirectAttributes mv) {
		try {
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fh = new SimpleDateFormat("HH:mm");
		Date d = new Date();
		String stringDate = fd.format(d);
		String stringTime = fh.format(d);
		java.sql.Date date = java.sql.Date.valueOf(stringDate);
		exp.setExp_date(date);
		exp.setExp_time(stringTime);
		exp.setExp_empName(exp_empName);
		expensesService.addExpense(exp);

		String m = "تم اضافة المصروف بنجاح" ;
		mv.addFlashAttribute("message", m);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		String m = "لم يتم اضافة المصروف ";
		mv.addFlashAttribute("error", m);
	}
		return "redirect:/ALRestaurant/Expenses";
	}



	@GetMapping("/Expenses/delete")
	public String deleteExpense(@RequestParam("exp_id") Long exp_id, RedirectAttributes mv) {
		expensesService.deleteExpense(exp_id);
		String m = "تم حذف المصروف رقم " + exp_id + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Expenses";
	}
}
