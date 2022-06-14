package com.aladhas.ALrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aladhas.ALrestaurant.services.ShiftesServices;
import com.aladhas.ALrestaurant.model.Shifts;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class ShiftesController {

	@Autowired
	private ShiftesServices shiftesServices;
	
	/*@GetMapping("/Shifts")
	public ModelAndView Shifts() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}*/
	
	@PostMapping("/Shifts")
	public String addNewShift(@ModelAttribute("shifts") Shifts shifts, RedirectAttributes mv) {
		try {
		shiftesServices.addShift(shifts);
		String m = "تم حفظ البيانات بنجاح";
		mv.addFlashAttribute("message", m);
		}catch(Exception e) {
			String m = "تم اضافة الشيفت من قبل  لم يتم حفظ البيانات";
			mv.addFlashAttribute("error", m);
		}
		return "redirect:/ALRestaurant/Employees";
	}
	
	@DeleteMapping("/Shifts")
	public String deleteShift(Long id) {
		shiftesServices.deleteSift(id);
		return "redirect:/ALRestaurant/Shifts";
	}
}
