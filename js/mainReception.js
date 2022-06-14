/**
 * 
 */
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 6000);
$(document).ready(function() {
	$("#rSave").click(function() {

		var id = $("#i").val();
		var type = $("#t").val();
		setTimeout(function() { // Delay for Chrome
			if (id != null ) {				
				window.open("/ALRestaurant/print?id=" + id +"&type="+ type, "_blank");
			}
		}, 200);
	})
})
$(document).ready(function() {
	$("#bill_discount").change(function() {
		var discount = $("#bill_discount").val();
		var bTotal = $("#bill_total_Sale").val();
		var btax = $("#delevery_cost").val();
		if(discount == ""){
			$("#bill_total").val(parseFloat(bTotal) + parseFloat(btax));
		}else{
		$("#bill_total").val(parseFloat(bTotal) + parseFloat(btax) - parseFloat(discount));
		}
	})
})
var change = document.getElementById('changeTableModel')
change.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget
	var Tid = button.getAttribute('data-bs-table')
	var Bid = button.getAttribute('data-bs-bill')
	
	var tab = change.querySelector('.modal-body #old_tab_id')
	var bill = change.querySelector('.modal-body #bill_id')

	tab.value = Tid
	bill.value = Bid
});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 4000);
var endreserved = document.getElementById('endReservationModel')
endreserved.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget
	var Tpid = button.getAttribute('data-bs-Tpid')


	var tab_reserved = endreserved.querySelector('.modal-body #id')

	tab_reserved.value = Tpid
	
	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8081/ALRestaurant/resev";
	
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
});
var reserved = document.getElementById('reservationTablesModel')
reserved.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget
	var Tpid = button.getAttribute('data-bs-Tpid')


	var tab_reserved = reserved.querySelector('.modal-body #tab_reserved')

	tab_reserved.value = Tpid
	
	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8081/ALRestaurant/resev";
	
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
});
var Reception = document.getElementById('endReceptionModal')
Reception.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var id = button.getAttribute('data-bs-id')
	var btype = button.getAttribute('data-bs-type')
	var btax = button.getAttribute('data-bs-tax')
	var bTabl = button.getAttribute('data-bs-tabl')
	var btNum = button.getAttribute('data-bs-tNum')
	
	var t = Reception.querySelector('.modal-body #t')
	var i = Reception.querySelector('.modal-body #i')
	var b_id = Reception.querySelector('.modal-body #bill_id')
	var b_type = Reception.querySelector('.modal-body #bill_type')
	var b_sale = Reception.querySelector('.modal-body #bill_total_Sale')
	var b_tax = Reception.querySelector('.modal-body #tax')
	var b_total = Reception.querySelector('.modal-body #bill_total')
	var b_tabl = Reception.querySelector('.modal-body #table')
	var b_tabN = Reception.querySelector('.modal-body #tabN')
	
	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8081/ALRestaurant/ReceptionBill?billId="+id;
	var myArr = "";
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	    myArr = JSON.parse(this.responseText);
	    myFunction(myArr);   
	  }
	};
	xmlhttp.open("GET", url, true);
	xmlhttp.send();

	function myFunction(arr) {
		t.value = btype
		i.value = id
		b_id.value = id	
		b_type.value = btype
		b_sale.value = arr
		b_tax.value = parseFloat(b_sale.value * btax)
		var total = Math.abs(parseFloat(b_sale.value) + parseFloat(b_tax.value))
		b_total.value = total
		b_tabl.value = bTabl
		b_tabN.value = btNum
	}

});
$(document).ready(function() {
	$("#bill_discount").change(function() {
		var discount = $("#bill_discount").val();
		var bTotal = $("#bill_total_Sale").val();
		var btax = $("#tax").val();
		if(discount == ""){
			$("#bill_total").val(parseFloat(bTotal) + parseFloat(btax));
		}else{
			$("#bill_total").val(parseFloat(bTotal) + parseFloat(btax) - parseFloat(discount));
		}
	})
});
var secReception = document.getElementById('sectionTablesModel')
secReception.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget
	var idbill = button.getAttribute('data-bs-blid')


	var Id_B = secReception.querySelector('.modal-body #bill_id')

	Id_B.value = idbill
});
var NewR = document.getElementById('newLineModel')
NewR.addEventListener('show.bs.modal', function(event) {
	var button2 = event.relatedTarget
	var lid = button2.getAttribute('data-bs-id')
	var menBuy = button2.getAttribute('data-bs-buy')
	var menSale = button2.getAttribute('data-bs-sale')
	var menName = button2.getAttribute('data-bs-name')
	var bId = button2.getAttribute('data-bs-bilId')

	var men_id = NewR.querySelector('.modal-body #men_id')
	var men_buy = NewR.querySelector('.modal-body #men_buy')
	var men_sale = NewR.querySelector('.modal-body #men_sale')
	var men_name = NewR.querySelector('.modal-body #men_name')
	var b_id = NewR.querySelector('.modal-body #b_id')
	
	men_id.value = lid
	men_buy.value = menBuy
	men_sale.value = menSale
	men_name.textContent = menName
	b_id.value = bId
	
});