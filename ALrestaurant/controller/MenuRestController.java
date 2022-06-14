package com.aladhas.ALrestaurant.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aladhas.ALrestaurant.model.Chartview;
import com.aladhas.ALrestaurant.model.Customers;
import com.aladhas.ALrestaurant.services.BillLineServices;
import com.aladhas.ALrestaurant.services.BillServices;
import com.aladhas.ALrestaurant.services.CustomersServices;
import com.aladhas.ALrestaurant.services.Menu_DetailsServices;
import com.aladhas.ALrestaurant.services.ReservationServices;


@RestController
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class MenuRestController {

	@Autowired
	private Menu_DetailsServices detailsServices;

	@Autowired
	private BillLineServices lineServices;
	
	@Autowired
	private BillServices billServices;

	@Autowired
	private ReservationServices reservationServices;

	@Autowired
	private CustomersServices customersServices;
	


	@GetMapping("/getIngredients")
	public List<String> getIngredients(@RequestParam String name) {
		return detailsServices.getIngredients(name);
	}

	@GetMapping("/ReceptionBill")
	public Double sale(@RequestParam Long billId) {
		return lineServices.getTotalSaleById(billId);
	}

	@GetMapping("/resev")
	public void test() {
		reservationServices.StartReservation();
	}

	@GetMapping("/saveCustomer")
	public Customers cust(@RequestParam("cu_id") String cust_id,@RequestParam("cust_name") String cust_name, @RequestParam String cust_phone,
			@RequestParam String cust_address, @RequestParam String cust_notes) throws Exception {
		
		Customers cust = new Customers();
		if(cust_id.equals("")) {
			cust.setCust_name(cust_name);
			cust.setCust_phone(cust_phone);
			cust.setCust_address(cust_address);
			cust.setCust_notes(cust_notes);
			customersServices.addCustomer(cust);
		}else {
			cust.setCust_id(Long.valueOf(cust_id));
			cust.setCust_name(cust_name);
			cust.setCust_phone(cust_phone);
			cust.setCust_address(cust_address);
			cust.setCust_notes(cust_notes);
			customersServices.addCustomer(cust);
		}
		
		Customers cu = customersServices.getCustomerByPhone(cust_phone);
		return cu;
		
	}

	@GetMapping("/getCustomer")
	public Customers getCustomer(@RequestParam("cust_phone") String cust_phone) {
		Customers cu = customersServices.getCustomerByPhone(cust_phone);
		return cu;
	}

	@GetMapping("/getChartTake")
	public Map<String, Integer> getChart() {
		List<Chartview> chview = billServices.getAllCountsAndDates();

		Map<String, Integer> test1 = new LinkedHashMap<>();
		for (Chartview ch : chview) {
			test1.put((String) ch.getMonth(), ch.getTakeAway());
		}
		return test1;
	}
	
	@GetMapping("/getChartDelevery")
	public Map<String, Integer> getChartDelevery() {
		List<Chartview> chview = billServices.getAllCountsAndDates();

		Map<String, Integer> test1 = new LinkedHashMap<>();
		for (Chartview ch : chview) {
			test1.put((String) ch.getMonth(), ch.getDelevery());
		}
		return test1;
	}
	
	@GetMapping("/getChartReception")
	public Map<String, Integer> getChartReception() {
		List<Chartview> chview = billServices.getAllCountsAndDates();

		Map<String, Integer> test1 = new LinkedHashMap<>();
		for (Chartview ch : chview) {
			test1.put((String) ch.getMonth(), ch.getReception());
		}
		return test1;
	}

}
