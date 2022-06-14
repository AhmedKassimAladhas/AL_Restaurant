package com.aladhas.ALrestaurant.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aladhas.ALrestaurant.model.Dates;
import com.aladhas.ALrestaurant.model.Employees;
import com.aladhas.ALrestaurant.model.Role;
import com.aladhas.ALrestaurant.model.Shifts;
import com.aladhas.ALrestaurant.model.Users;
import com.aladhas.ALrestaurant.repository.RolesRepository;
import com.aladhas.ALrestaurant.services.DatesServices;
import com.aladhas.ALrestaurant.services.EmployeesServices;
import com.aladhas.ALrestaurant.services.ShiftesServices;
import com.aladhas.ALrestaurant.services.UsersServices;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class EmployeesController {

	@Autowired
	private EmployeesServices employeesServices;

	@Autowired
	private UsersServices usersServices;

	@Autowired
	private ShiftesServices shiftesServices;

	@Autowired
	private DatesServices DatesServices;

	@Autowired
	private RolesRepository roleRepo;

	java.util.Date utilDate = new java.util.Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String stringDate = dateFormat.format(utilDate);
	Date date = Date.valueOf(stringDate);

	@GetMapping("/Employees")
	public ModelAndView Employees() {
		ModelAndView mv = new ModelAndView();
		Employees emp = new Employees();
		mv.addObject("emp", emp);
		Users user = new Users();
		mv.addObject("user", user);
		List<Employees> allEmp = employeesServices.getAllEmp();
		mv.addObject("allEmp", allEmp);
		List<Users> usr = usersServices.getAllUsers();
		mv.addObject("usr", usr);
		Shifts shift = new Shifts();
		mv.addObject("shift", shift);
		List<Shifts> allShift = shiftesServices.getShiftByDate(date);
		mv.addObject("allShift", allShift);
		List<Dates> allDate = DatesServices.getAllDates();
		mv.addObject("allDate", allDate);
		List<Role> AllRole = usersServices.getAllRole();
		mv.addObject("AllRole", AllRole);
		mv.addObject("title", "الموظفين");

		mv.setViewName("Employees");
		return mv;
	}

	@PostMapping("/Employees")
	public String addNewEmp(@ModelAttribute("emp") Employees emp, RedirectAttributes mv) {
		employeesServices.addEmp(emp);
		String m = "تم حفظ البيانات بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:Employees";
	}

	@GetMapping("/Employees/delete")
	public String deleteEmp(@RequestParam("emp_id") Long emp_id, RedirectAttributes mv) {
		employeesServices.deleteEmp(emp_id);
		String m = "تم حذف الموظف رقم " + emp_id + " " + "بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Employees";
	}

	@PostMapping("/Users")
	public String addNewUser(@ModelAttribute("users") Users users, RedirectAttributes mv) {
		try {
			users.getEmp_id().setUser("true");
			usersServices.addUser(users);

			String m = "تم اضافة اسم مستخدم  بنجاح  للموظف : " + users.getEmp_id().getEmp_name();
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String m = "اسم المستخدم موجود بالفعل لم تم اضافة اسم مستخدم  ! ";
			mv.addFlashAttribute("error", m);
		}
		return "redirect:/ALRestaurant/Employees";
	}

	@GetMapping("/Users")
	public ModelAndView Users() {
		ModelAndView mv = new ModelAndView();
		Users user = new Users();
		mv.addObject("user", user);
		List<Role> AllRole = usersServices.getAllRole();
		mv.addObject("AllRole", AllRole);
		List<Users> usr = usersServices.getAllUsers();
		mv.addObject("allUser", usr);
		mv.addObject("title", "المستخدمين");
		mv.setViewName("Users");
		return mv;
	}

	@PostMapping("/Users/edit")
	public String editUsers(@RequestParam("user_id") Long user_id, @RequestParam("user_Role") String role,
			RedirectAttributes mv) {
		try {
			Users user = usersServices.getUser(user_id);
			Role roleUser = roleRepo.findByname(role);
			user.addRoles(roleUser);
			usersServices.addUser(user);
			String m = "تم تعديل الصلاحيات";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String m = "لم يتم تعديل الصلاحيات";
			mv.addFlashAttribute("error", m);
		}
		return "redirect:/ALRestaurant/Users";
	}

	@GetMapping("/Users/delete")
	public String deleteUser(@RequestParam("user_id") Long user_id,RedirectAttributes mv) {
		Users user = usersServices.getUser(user_id);
		user.getEmp_id().setUser("false");
		user.removeRoles(user.getRoles());
		usersServices.addUser(user);
		usersServices.deleteUsers(user_id);
		String m = "تم حذف المستخدم";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Users";
	}
	
	@GetMapping("/Themes")
	public ModelAndView Themes() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "الاعدادات");
		mv.setViewName("Themes");
		return mv;
	}
	
	@GetMapping("/Themes/Save")
	public String ChangeThemes(@RequestParam("flexRadioDefault") String change1,ModelMap md,
			@RequestParam("userName") String userName,RedirectAttributes mv) {
		Users user = usersServices.getByUserName(userName);
		user.setThemes(change1);
		usersServices.saveUser(user);
		
		md.addAttribute("themes", change1);
		
		String m = "تم تغيير السيمز";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Themes";
	}
}
