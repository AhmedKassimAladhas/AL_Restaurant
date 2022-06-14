package com.aladhas.ALrestaurant.controller;

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

import com.aladhas.ALrestaurant.services.DatesServices;
import com.aladhas.ALrestaurant.model.Dates;
import com.aladhas.ALrestaurant.model.Users;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class DatesController {

	@Autowired
	private DatesServices dateServices;

	@GetMapping("/Dates")
	public ModelAndView Dates() {
		ModelAndView mv = new ModelAndView();
		Dates date = new Dates();
		mv.addObject("date", date);
		Users user = new Users();
		mv.addObject("user", user);
		List<Dates> allDates = dateServices.getAllDatesWhere();
		mv.addObject("allDates", allDates);
		mv.addObject("title", "المواعيد");

		mv.setViewName("Dates");
		return mv;
	}

	@PostMapping("/Dates")
	public String addNewDate(@ModelAttribute("dates") Dates dates , RedirectAttributes mv) {
		
		try {
			dateServices.addDates(dates);

			String m = "تم حفظ الموعد رقم : " + dates.getDat_number();
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String m = "هذا الموعد موجود بالفعل لم يتم حفظ البيانات";
			mv.addFlashAttribute("error", m);
		}
		return "redirect:/ALRestaurant/Dates";
	}

	/*@PostMapping("/Dates")
	public String editDate(@RequestParam("dat_id") Long dat_id, @RequestParam("dat_number") int dat_number,
			@RequestParam("time_from") String time_from, @RequestParam("time_to") String time_to) {
		Dates dates = new Dates(dat_id, dat_number, time_from, time_to);
		dateServices.addDates(dates);
		return "redirect:/ALRestaurant/Dates";
	}*/

	@GetMapping("/Dates/Delete")
	public String deleteDate(@RequestParam("dat_id") Long dat_id, RedirectAttributes mv) {
		Dates num = dateServices.getDate(dat_id);
		dateServices.deleteDate(dat_id);
		String m = "تم حذف الميعاد رقم " + num.getDat_number() + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Dates";
	}
}
