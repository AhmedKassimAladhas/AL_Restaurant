package com.aladhas.ALrestaurant.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Bill;
import com.aladhas.ALrestaurant.model.Chartview;
import com.aladhas.ALrestaurant.repository.BillRepository;

@Service
public class BillServices {

	@Autowired
	private BillRepository billRepository;

	public void addBill(Bill bill) {
		billRepository.save(bill);
	}

	public List<Bill> getAllBill() {
		return billRepository.findAll();
	}

	public Long getAllOneBill(String bill_emp, String bill_status) {
		return billRepository.getAllemp(bill_emp, bill_status);
	}
	
	public String getNumberBill(String bill_emp, String bill_status) {
		return billRepository.getBillNumemp(bill_emp, bill_status);
	}

	public Bill getBill(Long id) {
		return billRepository.findById(id).get();
	}

	public List<Bill> getAlldelivStatus(String status) {
		return billRepository.getAlldelivStatus(status);
	}
	
	public List<Bill> getAllBillByType(Date date, String type) {
		return billRepository.getAllbillByType(date, type);
	}
	
	public List<Bill> getAllDayBill(Date date) {
		return billRepository.getAllDayBills(date);
	}
	
	public int getBillNumber(String emp , Date date ,String time_from ,String time_to) {
		return billRepository.getBillNumber(emp, date, time_from, time_to);
	}
	
	public int getBillTypeNumber(String emp , Date date ,String time_from ,String time_to,String type) {
		return billRepository.getBillTypeNumber(emp, date, time_from, time_to, type);
	}
	
	public Double getBillTotal(String emp , Date date ,String time_from ,String time_to) {
		return billRepository.getBillTotal(emp, date, time_from, time_to);
	}
	
	public Double getBillTypeTotal(String emp , Date date ,String time_from ,String time_to,String type) {
		return billRepository.getBillTypeTotal(emp, date, time_from, time_to, type);
	}
	
	public List<Chartview> getAllCountsAndDates() {
		return billRepository.getAllCountsAndDates();
	}
	
	public int getCountBillType( Date date ,String type) {
		return billRepository.getCountBillType(date, type);
	}
	
}
