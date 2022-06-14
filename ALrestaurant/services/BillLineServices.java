package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Bill_Line;
import com.aladhas.ALrestaurant.repository.BillLineRepository;

@Service
public class BillLineServices {

	@Autowired
	private BillLineRepository billLineRepository;

	public void addBillLine(Bill_Line bill_Line) {
		billLineRepository.save(bill_Line);
	}
	
	public List<Bill_Line> getAllLine(){
		return billLineRepository.findAll();
	}
	
	public String getMaxNum(Long bill_id) {
		return billLineRepository.line_num(bill_id);
	}
	
	public List<Bill_Line> getAllLineByBillId(Long bill_id){
		return billLineRepository.getAllLineByBillId(bill_id);
	}
	
	public void deleteLine(Long lineId) {
		billLineRepository.deleteById(lineId);
	}
	
	public Double getTotalSale(String bill_emp, String bill_status) {
		return billLineRepository.getsumTotalSale(bill_emp, bill_status);
	}
	
	public Double getTotalBuy(String bill_emp, String bill_status) {
		return billLineRepository.getsumTotalBuy(bill_emp, bill_status);
	}
	
	public Double getTotalSaleById(Long bill_id) {
		return billLineRepository.getsumTotalSaleById(bill_id);
	}
	
	public Double getTotalBuyById(Long bill_id) {
		return billLineRepository.getsumTotalBuyById(bill_id);
	}
}
