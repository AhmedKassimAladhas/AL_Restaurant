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

import com.aladhas.ALrestaurant.services.CategoriesServices;
import com.aladhas.ALrestaurant.services.MenuServices;
import com.aladhas.ALrestaurant.services.Menu_DetailsServices;
import com.aladhas.ALrestaurant.services.OtherServices;
import com.aladhas.ALrestaurant.services.SectionsServices;
import com.aladhas.ALrestaurant.model.Categories;
import com.aladhas.ALrestaurant.model.Menu;
import com.aladhas.ALrestaurant.model.Menu_Details;
import com.aladhas.ALrestaurant.model.Other;
import com.aladhas.ALrestaurant.model.Sections;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class SectionsController {

	@Autowired
	private SectionsServices sectionsServices;
	
	@Autowired
	private CategoriesServices categoriesServices;
	
	@Autowired
	private Menu_DetailsServices detailsServices;
	
	@Autowired
	private MenuServices menuServices;

	@Autowired
	private OtherServices otherServices;

	@GetMapping("/Sections")
	public ModelAndView Sections() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Sections");
		Sections sec = new Sections();
		mv.addObject("sec", sec);
		List<Sections> allSec = sectionsServices.getAllSections();
		mv.addObject("allSec", allSec);
		List<Categories> allCat = categoriesServices.getAllCategoris();
		mv.addObject("allCat", allCat);
		Categories cat = new Categories();
		mv.addObject("cat", cat);
		Menu menu = new Menu();
		mv.addObject("men", menu);
		List<Menu> allMenu = menuServices.getAllMenu();
		mv.addObject("allMenu", allMenu);
		List<String> menuName = detailsServices.getMenuName();
		mv.addObject("menuName", menuName);
		List<Menu_Details> allDet = detailsServices.getِllDetails();
		mv.addObject("allDet", allDet);
		Other allOther = otherServices.getOtherById((long) 1);
		mv.addObject("idOther", allOther.getId());
		mv.addObject("taxOther", allOther.getTax());
		mv.addObject("deliveryOther", allOther.getDelivery());
		Other other = new Other();
		mv.addObject("other", other);
		Menu_Details detils = new Menu_Details();
		mv.addObject("det", detils);
		mv.addObject("title", "الاقسام");
		return mv;
	}

	@PostMapping("/Sections")
	public String addSection(@ModelAttribute("sec") Sections sec, RedirectAttributes mv) {
		try {
		sectionsServices.addSection(sec);
		String m = "تم حفظ البيانات بنجاح";
		mv.addFlashAttribute("message", m);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		String m = "اسم القسم موجود بالفعل لم تم اضافة القسم  ! ";
		mv.addFlashAttribute("error", m);
	}
		return "redirect:/ALRestaurant/Sections";
	}

//	@PostMapping("/Sections")
//	public String editSection(@RequestParam("sec_id") Long sec_id, @RequestParam("sec_name") String sec_name) {
//		Sections sec = new Sections(sec_id, sec_name);
//		sectionsServices.addSection(sec);
//		return "redirect:/ALRestaurant/Sections";
//	}

	@GetMapping("/Sections/delete")
	public String deleteSection(@RequestParam("sec_id") Long sec_id, RedirectAttributes mv) {
		sectionsServices.deleteSection(sec_id);
		String m = "تم حذف القسم رقم " + sec_id + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Sections";
	}

	
	@GetMapping("/addOther")
	public String addOther(@ModelAttribute("other") Other other, RedirectAttributes mv) {
		try {
			otherServices.saveOther(other);
			String m = "تم حفظ البيانات بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		return "redirect:/ALRestaurant/Sections";
	}
}
