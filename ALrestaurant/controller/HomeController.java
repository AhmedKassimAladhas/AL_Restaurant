package com.aladhas.ALrestaurant.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aladhas.ALrestaurant.services.BillServices;
import com.aladhas.ALrestaurant.services.DatesServices;



@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class HomeController {
	
	
	
	@Autowired
	private DatesServices da;
	
	@Autowired
	private BillServices billServices;
	
	@GetMapping("/")
	public ModelAndView h() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "الصفحة الرئيسية");
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String stringDate = fd.format(d);
		java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
		int takeawayC = billServices.getCountBillType(d1, "TakeAway");
		int deleveryC = billServices.getCountBillType(d1, "Delevery");
		int receptionC = billServices.getCountBillType(d1, "Reception");
		mv.addObject("TakeAway", takeawayC);
		mv.addObject("Delevery", deleveryC);
		mv.addObject("Reception", receptionC);
		mv.setViewName("Home");
		return mv;
	}
	
	@GetMapping("/Home")
	public ModelAndView home(Model mo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "الصفحة الرئيسية");
		System.out.println(da.getShiftNumber());
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String stringDate = fd.format(d);
		java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
		int takeawayC = billServices.getCountBillType(d1, "TakeAway");
		int deleveryC = billServices.getCountBillType(d1, "Delevery");
		int receptionC = billServices.getCountBillType(d1, "Reception");
		mv.addObject("TakeAway", takeawayC);
		mv.addObject("Delevery", deleveryC);
		mv.addObject("Reception", receptionC);
		mv.setViewName("Home");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "تسجيل الدخول");
		mv.setViewName("Login");
		return mv;
	}
	
	@GetMapping("/error")
	public ModelAndView loginerror(RedirectAttributes m) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "تسجيل الدخول");
		mv.addObject("error", "خطاء في اسم المستخدم او كلمة المرور !");
//		m.addFlashAttribute("error", "خطاء");
		mv.setViewName("Login");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(RedirectAttributes m) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "تسجيل الدخول");
		mv.addObject("massage", "تم تسجيل خروج");
		mv.setViewName("Login");
		return mv;
	}
	
}
