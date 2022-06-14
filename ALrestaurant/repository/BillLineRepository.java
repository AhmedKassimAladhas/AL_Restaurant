package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Bill_Line;

@Repository
public interface BillLineRepository extends JpaRepository<Bill_Line, Long> {

	@Query("SELECT max(l.lin_number) from Bill_Line l where l.bill_id.bill_id = ?1")
	String line_num(Long bill_id);
	
	@Query("SELECT l from Bill_Line l where l.bill_id.bill_id = ?1")
	List<Bill_Line> getAllLineByBillId(Long bill_id);
	
	@Query("SELECT sum(l.lin_totalsale) FROM Bill_Line l WHERE l.bill_id.bill_emp =?1 and l.bill_id.bill_Status =?2")
	Double getsumTotalSale(String bill_emp, String bill_status); 
	
	@Query("SELECT sum(l.lin_totalbuy) FROM Bill_Line l WHERE l.bill_id.bill_emp =?1 and l.bill_id.bill_Status =?2")
	Double getsumTotalBuy(String bill_emp, String bill_status); 
	
	@Query("SELECT sum(l.lin_totalsale) FROM Bill_Line l WHERE l.bill_id.bill_id =?1")
	Double getsumTotalSaleById(Long bill_id);
	
	@Query("SELECT sum(l.lin_totalbuy) FROM Bill_Line l WHERE l.bill_id.bill_id =?1")
	Double getsumTotalBuyById(Long bill_id);
}
