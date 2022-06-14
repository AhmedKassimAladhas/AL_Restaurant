package com.aladhas.ALrestaurant.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

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

import com.aladhas.ALrestaurant.model.Autonumber;
import com.aladhas.ALrestaurant.model.Bill;
import com.aladhas.ALrestaurant.model.Bill_Line;
import com.aladhas.ALrestaurant.model.Menu;
import com.aladhas.ALrestaurant.model.Tables;
import com.aladhas.ALrestaurant.services.AutonumberServices;
import com.aladhas.ALrestaurant.services.BillLineServices;
import com.aladhas.ALrestaurant.services.BillServices;
import com.aladhas.ALrestaurant.services.MenuServices;
import com.aladhas.ALrestaurant.services.TablesServices;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;

@Controller
@SessionAttributes("themes")
@RequestMapping("/ALRestaurant")
public class SaleController {

	@Autowired
	private BillServices billServices;

	@Autowired
	private MenuController menuController;

	@Autowired
	private BillLineServices lineServices;

	@Autowired
	private MenuServices menuServices;

	@Autowired
	private AutonumberServices autoServices;

	@Autowired
	private TablesServices tablesServices;

	@PostMapping("/addNew")
	public ModelAndView newBill(@RequestParam("secName") String secName, @RequestParam("men_id") Long men_id,
			@RequestParam("men_buy") Double pricS_buy, @RequestParam("men_sale") Double pric_sale,
			@RequestParam("men_count") int count,@RequestParam("empName") String empName) {
		try {
			Long id = billServices.getAllOneBill(empName, "open");
			System.out.println(id+"aaa");
			Bill b = new Bill();
			Bill_Line bl = new Bill_Line();

			if (id == null) {
				System.out.println("Null");
				b.setBill_emp(empName);
				b.setBill_Status("open");
				billServices.addBill(b);
				bl.setBill_id(b);
				bl.setLin_number(1);
				bl.setPrice_buy(pricS_buy);
				bl.setPrice_sale(pric_sale);
				Menu men = menuServices.getMenu(men_id);
				bl.setMen_id(men);
				bl.setLin_count(count);
				Double totalsale_Line = pric_sale * count;
				Double totalbuy_Line = pricS_buy * count;
				bl.setLin_totalsale(totalsale_Line);
				bl.setLin_totalbuy(totalbuy_Line);
				Autonumber ao = new Autonumber();
				int bilNum = autoServices.getName();
				b.setBill_number(bilNum);
				ao.setNumber(bilNum);
				autoServices.save(ao);
				lineServices.addBillLine(bl);
			} else {
				System.out.println("Yes");
				String max = lineServices.getMaxNum(id);
				System.out.println(max);
				Bill bil = billServices.getBill(id);
				bl.setBill_id(bil);
				if(max == null){
					bl.setLin_number(1);
				}else {
					bl.setLin_number(Integer.parseInt(max));
				}
				billServices.addBill(b);
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
		return menuController.ShowMenu(secName,empName);
	}

	@PostMapping("/allmenu")
	public ModelAndView removedLine(@RequestParam("secName") String secName,@RequestParam("empName") String empname, @RequestParam("menId") Long lineId,
			RedirectAttributes mv) {
		try {
			lineServices.deleteLine(lineId);
			String m = "تم الحذف بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return menuController.ShowMenu(secName,empname);
	}

	@PostMapping("/show")
	public ModelAndView removedLine2(@RequestParam("menId") Long lineId,@RequestParam("empName") String empname, RedirectAttributes mv) {
		try {
			lineServices.deleteLine(lineId);
			String m = "تم الحذف بنجاح";
			mv.addFlashAttribute("message", m);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return menuController.ShowMenuSections(empname);
	}

	@PostMapping("/Show")
	public ModelAndView saveBill(@ModelAttribute("bill") Bill bill,@RequestParam("empName") String empName, 
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
				
				if (bill.getBill_discount() == null) {
					bill.setBill_discount(0.0);
				}
				
				billServices.addBill(bill);
				String m = "تم حفظ الفاتورة  بنجاح";
				mv.addFlashAttribute("message", m);
				mv.addFlashAttribute("bi", bill.getBill_id());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return menuController.ShowMenuSections(empName);
	}

	@GetMapping("/Reception/new")
	public String saveReception(@RequestParam("bill_id") String bill_id, @RequestParam("bill_type") String bill_type,
			@RequestParam("tab_id") Long tab_id,@RequestParam("empName") String empName,
			@RequestParam("bill_number") int bill_number,RedirectAttributes mv) {
		if (bill_id == "") {
			String m = "يجب اختيار الطلابات اولا";
			mv.addFlashAttribute("error", m);
		} else {
			SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			String stringDate = fd.format(d);
			java.sql.Date d1 = java.sql.Date.valueOf(stringDate);
			Bill bill = new Bill();
			Tables tab = tablesServices.getTable(tab_id);
			try {
				bill.setBill_id(Long.valueOf(bill_id));
				bill.setBill_date(d1);
				bill.setBill_type(bill_type);
				bill.setTab_id(tab);
				bill.setBill_Status("Reception");
				bill.getTab_id().setTab_statues("busy");
				bill.getTab_id().setTab_bill(Integer.valueOf(bill_id));
				bill.setBill_number(bill_number);
				billServices.addBill(bill);
				String m = "تم فتح الفاتورة  بنجاح";
				mv.addFlashAttribute("message", m);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return "redirect:/ALRestaurant/Reception";
	}

	@RequestMapping(value = "/print")
	public void print(@PathParam("id") Long id, @PathParam("type") String type, HttpServletResponse response)
			throws IOException, Exception {
		System.out.println(id+"id");
		Bill bi = billServices.getBill(id);
		System.out.println(bi.getBill_id()+"ssss");
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				lineServices.getAllLineByBillId(bi.getBill_id()));

		JasperReport report = null;

		report = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/static/invoice/" + type + ".jrxml"));
		report.setWhenNoDataType(WhenNoDataTypeEnum.NO_DATA_SECTION);

		HashMap<String, Object> parm = new HashMap<>();
		parm.put("param_id", id);
		JasperPrint jasperPrint = null;

		jasperPrint = JasperFillManager.fillReport(report, null, beanCollectionDataSource);

		OutputStream outputStream = response.getOutputStream();
		response.setContentType("application/pdf");
		response.setHeader("Cache-Control", "max-age=0");
		
		JRExporter export = new JRPdfExporter();
		export.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		export.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);

		export.exportReport();
		
		if (outputStream != null) {
			outputStream.flush();
			outputStream.close();
			
		}

	}
	
}
