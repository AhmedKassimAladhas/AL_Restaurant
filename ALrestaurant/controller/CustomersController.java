package com.aladhas.ALrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aladhas.ALrestaurant.services.CustomersServices;
import com.aladhas.ALrestaurant.model.Customers;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class CustomersController {

	@Autowired
	private CustomersServices customesServices;

	@GetMapping("/Customers")
	public ModelAndView Customers() {
		ModelAndView mv = new ModelAndView();

		return mv;
	}

	@PutMapping("/Customers")
	public String addNewCustomer(@ModelAttribute("cust") Customers cust) {
		customesServices.addCustomer(cust);
		return "redirect:/ALRestaurant/Customers";
	}

	@PostMapping("/Customers")
	public String editCustomer(@RequestParam("cust_id") Long cust_id, @RequestParam("cust_name") String cust_name,
			@RequestParam("cust_phone") String cust_phone, @RequestParam("cust_address") String cust_address,
			@RequestParam("cust_notes") String cust_notes) {
		Customers cust = new Customers(cust_id, cust_name, cust_phone, cust_address, cust_notes);
		customesServices.addCustomer(cust);
		return "redirect:/ALRestaurant/Customers";
	}

	@DeleteMapping("/Customers")
	public String deleteCustomer(@RequestParam("cust_id") Long cust_id) {
		customesServices.deleteCustomer(cust_id);
		return "redirect:/ALRestaurant/Customers";
	}
}
