package com.aladhas.ALrestaurant.controller;

import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aladhas.ALrestaurant.services.BillLineServices;
import com.aladhas.ALrestaurant.services.BillServices;
import com.aladhas.ALrestaurant.services.EmployeesServices;
import com.aladhas.ALrestaurant.services.MenuServices;
import com.aladhas.ALrestaurant.services.Menu_DetailsServices;
import com.aladhas.ALrestaurant.services.OtherServices;
import com.aladhas.ALrestaurant.services.TablesServices;
import com.aladhas.ALrestaurant.model.Bill;
import com.aladhas.ALrestaurant.model.Bill_Line;
import com.aladhas.ALrestaurant.model.Customers;
import com.aladhas.ALrestaurant.model.Employees;
import com.aladhas.ALrestaurant.model.Menu;
import com.aladhas.ALrestaurant.model.Other;
import com.aladhas.ALrestaurant.model.Tables;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class MenuController {

	@Autowired
	private MenuServices menuServices;
	
	@Autowired
	private Menu_DetailsServices detServices;
	
	@Autowired
	private BillServices billServices;
	
	@Autowired
	private BillLineServices lineServises;
	
	@Autowired
	private TablesServices tablesServices;
	
	@Autowired
	private EmployeesServices employeesServices; 
	
	@Autowired
	private OtherServices otherServices;
	
//	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/imagedata";
	
	
	@GetMapping("/Show")
	public ModelAndView ShowMenuSections(@RequestParam("empName") String empname) {
		ModelAndView mv = new ModelAndView();
		Bill bill = new Bill();
		Customers cust = new Customers();
		mv.setViewName("Menu");
		List<String> sec = menuServices.getMenuSections();
		System.out.println(empname);
		Long billId = billServices.getAllOneBill(empname, "open");
		mv.addObject("billId", billId);
		String billNum = billServices.getNumberBill(empname, "open");
		mv.addObject("billNum", billNum);
		Double totalSale = lineServises.getTotalSale(empname, "open");
		mv.addObject("totalSale", totalSale);
		Double totalBuy = lineServises.getTotalBuy(empname, "open");
		mv.addObject("totalBuy", totalBuy);
		List<Bill_Line> allLine = lineServises.getAllLineByBillId(billId);
		mv.addObject("allLine", allLine);
		List<Tables> allTables = tablesServices.getAllTablesByStatus("empty");
		mv.addObject("allTables", allTables);
		List<Employees> allDelevery = employeesServices.getAllDelevery();
		mv.addObject("allDelevery", allDelevery);
		Other allOther = otherServices.getOtherById((long) 1);
		mv.addObject("idOther", allOther.getId());
		mv.addObject("taxOther", allOther.getTax());
		mv.addObject("deliveryOther", allOther.getDelivery());
		mv.addObject("bill", bill);
		mv.addObject("cust", cust);
		mv.addObject("allsections", sec);
		mv.addObject("title", "قائمة الطعام");
		return mv;
	}
	
	@GetMapping("/allmenu")
	public ModelAndView ShowMenu(@RequestParam("sec_name") String sec_name,@RequestParam("empName") String empname) {
		ModelAndView mv = new ModelAndView();
		System.out.println(empname+"2");
		Bill bill = new Bill();
		Customers cust = new Customers();
		List<Menu> menu = menuServices.getAllMenuBySection(sec_name);
		Long billId = billServices.getAllOneBill(empname, "open");
		mv.addObject("billId", billId);
		String billNum = billServices.getNumberBill(empname, "open");
		mv.addObject("billNum", billNum);
		Double totalSale = lineServises.getTotalSale(empname, "open");
		mv.addObject("totalSale", totalSale);
		Double totalBuy = lineServises.getTotalBuy(empname, "open");
		mv.addObject("totalBuy", totalBuy);
		List<Bill_Line> allLine = lineServises.getAllLineByBillId(billId);
		mv.addObject("allLine", allLine);
		mv.addObject("allmenus", menu);
		List<Tables> allTables = tablesServices.getAllTablesByStatus("empty");
		mv.addObject("allTables", allTables);
		List<Employees> allDelevery = employeesServices.getAllDelevery();
		mv.addObject("allDelevery", allDelevery);
		Other allOther = otherServices.getOtherById((long) 1);
		mv.addObject("idOther", allOther.getId());
		mv.addObject("taxOther", allOther.getTax());
		mv.addObject("deliveryOther", allOther.getDelivery());
		mv.addObject("bill", bill);
		mv.addObject("cust", cust);
		mv.addObject("title", "قائمة الطعام");
		mv.addObject("secName",sec_name);
		mv.setViewName("Sales");
		return mv;
	}
	
	@PostMapping("/Menu")
	public String addNewMenu(@ModelAttribute("menu") Menu menu,@RequestParam("img") MultipartFile file,  RedirectAttributes mv) {

		/*try {
			StringBuilder fileNames = new StringBuilder();
			String filename = menu.getMen_name() + file.getOriginalFilename().substring(file.getOriginalFilename().length() -4);
			Path filenameandpath = Paths.get(uploadDirectory, filename); 			
			Files.write(filenameandpath, file.getBytes());
			byte[] imageData = file.getBytes();
			menu.setImage(imageData);
			menuServices.addMenu(menu);
			String m = "تم حفظ البيانات بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String m = "اسم المنيو موجود بالفعل لم تم اضافة المنيو  ! ";
			mv.addFlashAttribute("error", m);
		}*/

		try {
			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			if(filename.contains("..")) {
				System.out.println("not a valid");
			}
			menu.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			menuServices.addMenu(menu);
			String m = "تم حفظ البيانات بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String m = "اسم المنيو موجود بالفعل لم تم اضافة المنيو  ! ";
			mv.addFlashAttribute("error", m);
		}
		
		return "redirect:/ALRestaurant/Sections";
	}


	@GetMapping("/Menu/delete")
	public String deleteMenu(@RequestParam("men_id") Long men_id, RedirectAttributes mv) {
		menuServices.deleteMenu(men_id);
		String m = "تم حذف قائمة الطعام رقم " + men_id + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Sections";
	}
	
	@GetMapping("/Menu/detailDelete")
	public String deleteDetail(@RequestParam("det_id") Long det_id, RedirectAttributes mv) {
		detServices.deleteDetail(det_id);
		String m = "تم حذف العنصر رقم " + det_id + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Sections";
	}
	
	
}
