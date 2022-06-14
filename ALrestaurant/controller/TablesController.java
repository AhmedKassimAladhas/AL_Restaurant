package com.aladhas.ALrestaurant.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.aladhas.ALrestaurant.services.AutonumberServices;
import com.aladhas.ALrestaurant.services.BillLineServices;
import com.aladhas.ALrestaurant.services.BillServices;
import com.aladhas.ALrestaurant.services.MenuServices;
import com.aladhas.ALrestaurant.services.OtherServices;
import com.aladhas.ALrestaurant.services.ReservationServices;
import com.aladhas.ALrestaurant.services.TablesServices;
import com.aladhas.ALrestaurant.model.Autonumber;
import com.aladhas.ALrestaurant.model.Bill;
import com.aladhas.ALrestaurant.model.Bill_Line;
import com.aladhas.ALrestaurant.model.Menu;
import com.aladhas.ALrestaurant.model.Other;
import com.aladhas.ALrestaurant.model.Reservation;
import com.aladhas.ALrestaurant.model.Tables;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class TablesController {

	@Autowired
	private TablesServices tablesServices;

	@Autowired
	private MenuServices menuServices;

	@Autowired
	private BillServices billServices;

	@Autowired
	private BillLineServices lineServices;

	@Autowired
	private AutonumberServices autoServices;

	@Autowired
	private ReservationServices reservationServices;
	
	@Autowired
	private OtherServices otherServices;

	@GetMapping("/Tables")
	public ModelAndView Tables() {
		ModelAndView mv = new ModelAndView();
		Tables tab = new Tables();
		mv.addObject("tab", tab);
		List<Tables> allTables = tablesServices.getAllTables();
		mv.addObject("allTables", allTables);
		mv.addObject("title", "الطاولات");

		mv.setViewName("Tables");
		return mv;
	}

	@PostMapping("/Tables")
	public String addNewTables(@ModelAttribute("tables") Tables tables, RedirectAttributes mv) {
		try {
			tables.setTab_statues("empty");
			tablesServices.addTable(tables);
			String m = "تم الحفظ بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String m = "هذه الطاولة موجوده بالفعل لم يتم حفظ البيانات";
			mv.addFlashAttribute("error", m);
		}
		return "redirect:/ALRestaurant/Tables";
	}

	@GetMapping("/Tables/delete")
	public String deleteTable(@RequestParam("tab_id") Long tab_id, RedirectAttributes mv) {
		tablesServices.deleteTable(tab_id);
		String m = "تم الحذف بنجاح";
		mv.addFlashAttribute("message", m);
		return "redirect:/ALRestaurant/Tables";
	}

	@GetMapping("/Reception")
	public ModelAndView Reception() {
		ModelAndView mv = new ModelAndView();
		Tables tab = new Tables();
		mv.addObject("tab", tab);
		List<Tables> allTables = tablesServices.getAllTables();
		mv.addObject("allTables", allTables);
		List<Tables> allEmpty = tablesServices.getAllTablesByStatus("empty");
		mv.addObject("allEmpty", allEmpty);
		mv.addObject("title", "الصالة");
		Other allOther = otherServices.getOtherById((long) 1);
		mv.addObject("taxOther", allOther.getTax());
		List<Reservation> allRes = reservationServices.getAllReservationByOld();
		mv.addObject("allRes", allRes);
		Reservation resrevation = new Reservation();
		mv.addObject("resrevation", resrevation);
		Bill bill = new Bill();
		List<String> sec = menuServices.getMenuSections();
		mv.addObject("bill", bill);
		mv.addObject("allsections", sec);
		mv.setViewName("Reception");
		reservationServices.StartReservation();
		return mv;
	}

	@GetMapping("/Reception/allMenu")
	public ModelAndView ShowMenu(@RequestParam("sec_name") String sec_name, @RequestParam("bill_id") Long bill_id) {
		ModelAndView mv = new ModelAndView();
		Bill bill = new Bill();
		List<Menu> menu = menuServices.getAllMenuBySection(sec_name);
		Bill billId = billServices.getBill(bill_id);
		mv.addObject("billId", billId);
		Double totalSale = lineServices.getTotalSaleById(bill_id);
		mv.addObject("totalSale", totalSale);
		
		List<Bill_Line> allLine = lineServices.getAllLineByBillId(billId.getBill_id());
		mv.addObject("allLine", allLine);
		mv.addObject("allmenus", menu);

		mv.addObject("bill", bill);
		mv.addObject("title", "قائمة الطعام");
		mv.addObject("secName", sec_name);
		mv.setViewName("SalesReception");
		return mv;
	}

	@PostMapping("/Reception/addNew")
	public ModelAndView newLineReception(@RequestParam("secName") String secName, @RequestParam("men_id") Long men_id,
			@RequestParam("men_buy") Double pricS_buy, @RequestParam("men_sale") Double pric_sale,
			@RequestParam("men_count") int count, @RequestParam("b_id") Long bill_id) {
		try {
			Bill id = billServices.getBill(bill_id);
			Bill_Line bl = new Bill_Line();

			if (id == null) {
				System.out.println("Null");

			} else {
				System.out.println("Yes");
				Bill bil = billServices.getBill(id.getBill_id());
				System.out.println("id :"+id.getBill_id());
				bl.setBill_id(bil);
				bl.setPrice_buy(pricS_buy);
				bl.setPrice_sale(pric_sale);
				Menu men = menuServices.getMenu(men_id);
				bl.setMen_id(men);
				bl.setLin_count(count);
				Double totalsale_Line = pric_sale * count;
				Double totalbuy_Line = pricS_buy * count;
				bl.setLin_totalsale(totalsale_Line);
				bl.setLin_totalbuy(totalbuy_Line);
				lineServices.addBillLine(bl);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ShowMenu(secName, bill_id);
	}

	@PostMapping("/Reception/allMenu/delete")
	public ModelAndView removedLine(@RequestParam("secName") String secName, @RequestParam("menId") Long lineId,
			@RequestParam("bId") Long bill_id, RedirectAttributes mv) {
		try {
			lineServices.deleteLine(lineId);
			String m = "تم الحذف بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ShowMenu(secName, bill_id);
	}

	@GetMapping("/Reception/save")
	public String saveReception(@ModelAttribute("bill") Bill bill,@RequestParam("empName") String empName, 
			RedirectAttributes mv) {
		if (bill.getBill_id() == null) {
			String m = "يجب اختيار الطلابات اولا";
			mv.addFlashAttribute("error", m);
		} else {
			SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat fh = new SimpleDateFormat("HH:mm");
			Date d = new Date();
			String stringDate = fd.format(d);
			java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
			try {
				bill.setBill_emp(empName);
				bill.setBill_Status("close");
				bill.setBill_date(d1);
				bill.setBill_time(fh.format(d));
				Tables tab = tablesServices.getTable(bill.getTab_id().getTab_id());
				bill.setTab_id(tab);
				bill.getTab_id().setTab_bill(0);
				bill.getTab_id().setTab_statues("empty");
				bill.getTab_id().setDate_reserved(null);
				bill.getTab_id().setName_reserved(null);
				bill.getTab_id().setRes_id(null);
				bill.getTab_id().setTime_reserved(null);
				bill.setBill_total_Buy(lineServices.getTotalBuyById(bill.getBill_id()));
				if(bill.getBill_discount() == null) {
					bill.setBill_discount(0.0);
				}
				Bill b = billServices.getBill(bill.getBill_id());
				bill.setBill_number(b.getBill_number());
				billServices.addBill(bill);
				String m = "تم حفظ الفاتورة  بنجاح";
				mv.addFlashAttribute("message", m);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return "redirect:/ALRestaurant/Reception";
	}

	@PostMapping("/Reception/reseved")
	public String reservationReception(@ModelAttribute("reservation") Reservation res,
			RedirectAttributes mv) {
		try {
			reservationServices.save(res);
			String m = "تم حجز الطاولة  بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return "redirect:/ALRestaurant/Reception";
	}
	
	@GetMapping("/Reception/endreseved")
	public String endReservation(@RequestParam("id") Long id,
			RedirectAttributes mv) {
		try {
			Tables tab = tablesServices.getTable(id);
			tab.setDate_reserved(null);
			tab.setName_reserved(null);
			tab.setTime_reserved(null);
			tab.setTab_statues("empty");
			tab.getRes_id().setOld("cancel");
			tab.setRes_id(null);
			tablesServices.addTable(tab);
			String m = "تم إنهاء حجز الطاولة  بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return "redirect:/ALRestaurant/Reception";
	}
	
	@PostMapping("/Reception/addNewBill")
	public String newBillReception(@RequestParam("tab_id") Long tab_id,@RequestParam("empName") String empName) {
			
		try {
			
			Bill bill = new Bill();
			Tables tab = tablesServices.getTable(tab_id);
			System.out.println(tab_id);
			bill.setTab_id(tab);
			bill.setBill_type("Reception");
			bill.setBill_Status("Reception");
			bill.setBill_emp(empName);
			billServices.addBill(bill);
			tab.setTab_bill(bill.getBill_id().intValue());
			tab.setTab_statues("busy");
			tab.getRes_id().setOld("done");
			int bilNum = autoServices.getName();
			Autonumber ao = new Autonumber();
			bill.setBill_number(bilNum);
			ao.setNumber(bilNum);
			autoServices.save(ao);
			tablesServices.addTable(tab);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/ALRestaurant/Reception";
	}
	
	@GetMapping("/Reception/change")
	public String changeTable(@RequestParam("bill_id") Long bill_id,@RequestParam("old_tab_id") Long old_tab_id,
			@RequestParam("tab_id") Long tab_id,RedirectAttributes mv) {
		try {
			Tables tab = tablesServices.getTable(tab_id);
			tab.setTab_statues("busy");
			tab.setTab_bill(bill_id.intValue());
			Bill bill = billServices.getBill(bill_id);
			bill.setTab_id(tab);
			billServices.addBill(bill);
			tablesServices.addTable(tab);
			Tables oldTab = tablesServices.getTable(old_tab_id);
			oldTab.setTab_statues("empty");
			oldTab.setTab_bill(0);
			tablesServices.addTable(oldTab);			
			String m = "تم تغيير الطاولة  بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return "redirect:/ALRestaurant/Reception";
	}
	
	@GetMapping("/Reservation")
	public ModelAndView Reservation() {
		ModelAndView mv = new ModelAndView();
		List<Reservation> allreservation = reservationServices.getAllReservation();
		mv.addObject("allreservation", allreservation);
		mv.addObject("title", "الحجوزات");
		mv.setViewName("Reservations");
		return mv;
	}
}
