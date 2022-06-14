package com.aladhas.ALrestaurant.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aladhas.ALrestaurant.model.Bill;
import com.aladhas.ALrestaurant.model.Bill_Line;
import com.aladhas.ALrestaurant.services.BillLineServices;
import com.aladhas.ALrestaurant.services.BillServices;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class FollowUpControlller {

	@Autowired
	private BillServices billServices;
	
	@Autowired
	private BillLineServices lineServices;
	
	@GetMapping("/Delivery")
	public ModelAndView Delivery() {
		ModelAndView mv = new ModelAndView();
		Bill bill = new Bill();
		List<Bill> allDelivery = billServices.getAlldelivStatus("wait");

		mv.addObject("allDelivery", allDelivery);
		mv.addObject("bill", bill);
		mv.addObject("title", "الدليفري");
		mv.setViewName("Delivery");
		return mv;
	}

	@GetMapping("/Delivery/save")
	public String saveDeliveryStatus(@RequestParam("bill_id") Long id, RedirectAttributes mv) {
		
		try {
			Bill bill = billServices.getBill(id);
			bill.setDelivery_status("done");
			billServices.addBill(bill);
			String m = "تم الحفظ";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/ALRestaurant/Delivery";
	}
	
	@GetMapping("/Kitchen")
	public ModelAndView Kitchen() {
		ModelAndView mv = new ModelAndView();
		
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String stringDate = fd.format(d);
		java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
		
		List<Bill> allDelivery = billServices.getAllBillByType(d1, "Delevery");
		mv.addObject("allDelivery", allDelivery);
		List<Bill> allReseption = billServices.getAllBillByType(d1, "Reception");
		mv.addObject("allReseption", allReseption);
		List<Bill> allTakeAway = billServices.getAllBillByType(d1, "TakeAway");
		mv.addObject("allTakeAway", allTakeAway);
		List<Bill_Line> lin = lineServices.getAllLine();
		mv.addObject("line", lin);
		mv.addObject("title", "المطبخ");
		mv.setViewName("Kitchen");
		return mv;
	}
	
	@GetMapping("/DayBills")
	public ModelAndView dayBills() {
		ModelAndView mv = new ModelAndView();
		
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String stringDate = fd.format(d);
		java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
		
		List<Bill> allDayBills = billServices.getAllDayBill(d1);
		mv.addObject("allDayBills", allDayBills);
		mv.addObject("title", "فواتير اليوم");
		mv.setViewName("DayBill");
		return mv;
	}
	
	@GetMapping("/Bills")
	public ModelAndView Bills() {
		ModelAndView mv = new ModelAndView();
		
		List<Bill> allBills = billServices.getAllBill();
		mv.addObject("allBills", allBills);
		mv.addObject("title", "الفواتير");
		mv.setViewName("Bills");
		return mv;
	}
}
