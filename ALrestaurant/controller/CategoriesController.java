package com.aladhas.ALrestaurant.controller;

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

import com.aladhas.ALrestaurant.services.CategoriesServices;
import com.aladhas.ALrestaurant.services.Menu_DetailsServices;
import com.aladhas.ALrestaurant.model.Categories;
import com.aladhas.ALrestaurant.model.Menu_Details;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class CategoriesController {

	@Autowired
	private CategoriesServices categoriesServices;

	@Autowired
	private Menu_DetailsServices detailsServices;
	
	@GetMapping("/Categories")
	public ModelAndView Categories() {
		ModelAndView mv = new ModelAndView();

		return mv;
	}

	@PostMapping("/Categories")
	public String addCategorie(@ModelAttribute("cat") Categories cat, RedirectAttributes mv) {
	try {
		categoriesServices.addCategorie(cat);
		String m = "تم حفظ البيانات بنجاح";
		mv.addFlashAttribute("message", m);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		String m = "اسم الصنف موجود بالفعل لم تم اضافة الصنف  ! ";
		mv.addFlashAttribute("error", m);
	}
		return "redirect:/ALRestaurant/Sections";
	}

//	@PostMapping("/Categories")
//	public String editCategorie(@RequestParam("cat_id") Long cat_id, @RequestParam("sec_id") Sections sec_id,
//			@RequestParam("cat_name") String cat_name, @RequestParam("cat_count") Double cat_count,
//			@RequestParam("expierd_date") Date expierd_date) {
//		Categories cat = new Categories(cat_id, sec_id, cat_name, cat_count, expierd_date);
//		categoriesServices.addCategorie(cat);
//		return "redirect:/ALRestaurant/Categories";
//	}

	@GetMapping("/Categories/delete")
	public String deleteCategorie(@RequestParam("cat_id") Long cat_id, RedirectAttributes mv) {
		categoriesServices.deleteCategorie(cat_id);
		String m = "تم حذف الصنف رقم " + cat_id + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Sections";
	}
	
	@PostMapping("/details")
	public String addDetails(@ModelAttribute("det") Menu_Details details, RedirectAttributes mv) {
	try {
		detailsServices.adddetails(details);
		String m = "تم حفظ البيانات بنجاح";
		mv.addFlashAttribute("message", m);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		String m = "اسم الصنف موجود بالفعل لم تم اضافة الصنف  ! ";
		mv.addFlashAttribute("error", m);
	}
		return "redirect:/ALRestaurant/Sections";
	}

}
