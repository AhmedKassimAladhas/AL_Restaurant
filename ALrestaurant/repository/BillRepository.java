package com.aladhas.ALrestaurant.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Bill;
import com.aladhas.ALrestaurant.model.Chartview;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	@Query("SELECT b.bill_id FROM Bill b WHERE b.bill_emp =?1 and b.bill_Status =?2")
	Long getAllemp(String bill_emp, String bill_status);
	
	@Query("SELECT b.bill_number FROM Bill b WHERE b.bill_emp =?1 and b.bill_Status =?2")
	String getBillNumemp(String bill_emp, String bill_status);

	@Query("SELECT b FROM Bill b WHERE b.delivery_status =?1")
	List<Bill> getAlldelivStatus(String delivery_status);

	@Query("SELECT b FROM Bill b WHERE b.bill_date =?1 and b.bill_type = ?2")
	List<Bill> getAllbillByType(Date date ,String type);
	
	@Query("SELECT b FROM Bill b WHERE b.bill_date =?1")
	List<Bill> getAllDayBills(Date date);
	
	@Query("SELECT count(b.bill_id) FROM Bill b WHERE b.bill_emp = ?1 AND b.bill_date >= ?2 AND b.bill_time between ?3 and ?4")
	int getBillNumber(String emp , Date date ,String time_from ,String time_to);

	@Query("SELECT count(b.bill_id) FROM Bill b WHERE b.bill_emp = ?1 AND b.bill_date >= ?2 AND b.bill_time between ?3 and ?4 And b.bill_type = ?5")
	int getBillTypeNumber(String emp , Date date ,String time_from ,String time_to,String type);
	
	@Query("SELECT sum(b.bill_total) FROM Bill b WHERE b.bill_emp = ?1 AND b.bill_date >= ?2 AND b.bill_time between ?3 and ?4")
	Double getBillTotal(String emp , Date date ,String time_from ,String time_to);
	
	@Query("SELECT sum(b.bill_total) FROM Bill b WHERE b.bill_emp = ?1 AND b.bill_date >= ?2 AND b.bill_time between ?3 and ?4 And b.bill_type = ?5")
	Double getBillTypeTotal(String emp , Date date ,String time_from ,String time_to,String type);
	
	@Query(nativeQuery = true, value = "SELECT DATE_FORMAT(b.bill_date,'%M') as Month, count(case when b.bill_type = 'Delevery' then 1 else null end) AS Delevery, count(case when b.bill_type = 'TakeAway' then 1 else null end) AS TakeAway, count(case when b.bill_type = 'Reception' then 1 else null end) AS Reception from Bill b where DATE_FORMAT(b.bill_date,'%Y') = YEAR(CURDATE()) group by DATE_FORMAT(b.bill_date,'%M %Y') ORDER BY b.bill_date")
	List<Chartview> getAllCountsAndDates();
	
	@Query("SELECT count(b.bill_id) FROM Bill b WHERE b.bill_date = ?1 And b.bill_type = ?2")
	int getCountBillType( Date date ,String type);
	
}
