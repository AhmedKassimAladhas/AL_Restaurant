/**
 * 
 */
function printTake() {
	var id = $("#is").val();
	var type = $("#ts").val();
	setTimeout(function() { // Delay for Chrome
		if (id != null ) {				
			window.open("/ALRestaurant/print?id=" + id +"&type="+ type, "_blank");
		}
	}, 150);
};
$(document).ready(function() {
	
	$("#mdSave").click(function() {
		var cust_id = $("#cust_id").val();
		var b_delevery = $("#delevery_cost").val();
		if(b_delevery != "" && cust_id != ""){
			
		var id = $("#i").val();
		var type = $("#t").val();
		var cus_address = $("#cus_address").val();
		var cus_name = $("#cus_name").val();
		setTimeout(function() { // Delay for Chrome
			if (id != null && cus_address != "" && cus_name != "") {			
				window.open("/ALRestaurant/print?id=" + id +"&type="+ type, "_blank");
			}
		}, 150);
		
		}
	})

});
$(document).ready(
		function() {
			$("#delevery_cost")
					.change(
							function() {
								var discount = $("#Dbill_discount").val();
								var bTotal = $("#bill_total_Sale").val();
								var bdelevery = $("#delevery_cost").val();
								if (bdelevery == "" & discount == "") {
									$("#bill_total").val(parseFloat(bTotal));
								} else if (discount == "") {
									$("#bill_total").val(
											parseFloat(bTotal)
													+ parseFloat(bdelevery));
								} else if (bdelevery == "" & discount != "") {
									$("#bill_total").val(
											parseFloat(bTotal)
													- parseFloat(discount));
								} else {
									$("#bill_total").val(
											parseFloat(bTotal)
													+ parseFloat(bdelevery)
													- parseFloat(discount));
								}
							})
		});
$(document).ready(
		function() {
			$("#Dbill_discount")
					.change(
							function() {
								var discount = $("#Dbill_discount").val();
								var bTotal = $("#bill_total_Sale").val();
								var bdelevery = $("#delevery_cost").val();
								if (discount == "" & bdelevery == "") {
									$("#bill_total").val(parseFloat(bTotal));
								} else if (discount == "") {
									$("#bill_total").val(
											parseFloat(bTotal)
													+ parseFloat(bdelevery));
								} else if (bdelevery == "") {
									$("#bill_total").val(
											parseFloat(bTotal)
													- parseFloat(discount));
								} else {
									$("#bill_total").val(
											parseFloat(bTotal)
													+ parseFloat(bdelevery)
													- parseFloat(discount));
								}
							})
		});
$(document)
		.ready(
				function() {
					$("#cust_phone")
							.change(
									function() {
										var cust_phone = $("#cust_phone").val();

										var xmlhttp = new XMLHttpRequest();
										var url = "http://localhost:8081/ALRestaurant/getCustomer?cust_phone="
												+ cust_phone;

										var myArr = "";
										xmlhttp.onreadystatechange = function() {
											if (this.readyState == 4
													&& this.status == 200) {
												myArr2 = JSON
														.parse(this.responseText);
												myFunction(myArr2);
											}
										};

										xmlhttp.open("GET", url, true);
										xmlhttp.send();

										function myFunction(arr) {
											$("#cu_id").val(arr.cust_id);
											$("#cust_name").val(arr.cust_name);
											$("#cust_address").val(
													arr.cust_address);
											$("#cust_notes")
													.val(arr.cust_notes);
											document.getElementById("csave").disabled = false;
										}
										document.getElementById("csave").disabled = false;
									})
				});
$(document)
		.ready(
				function() {
					$("#csave")
							.click(
									function() {
										var cust_id = $("#cu_id").val();
										var cust_name = $("#cust_name").val();
										var cust_phone = $("#cust_phone").val();
										var cust_address = $("#cust_address")
												.val();
										var cust_notes = $("#cust_notes").val();

										var xmlhttp = new XMLHttpRequest();
										var url = "http://localhost:8081/ALRestaurant/saveCustomer?cu_id="
												+ cust_id
												+ "&cust_name="
												+ cust_name
												+ "&cust_phone="
												+ cust_phone
												+ "&cust_address="
												+ cust_address
												+ "&cust_notes="
												+ cust_notes;

										var myArr = "";
										xmlhttp.onreadystatechange = function() {
											if (this.readyState == 4
													&& this.status == 200) {
												myArr = JSON
														.parse(this.responseText);
												myFunction(myArr);
											}
										};

										xmlhttp.open("GET", url, true);
										xmlhttp.send();

										function myFunction(arr) {
											$("#cust_id").val(arr.cust_id);
											$("#cus_name").val(arr.cust_name);
											$("#cus_address").val(arr.cust_address);
										}

									})
				});
var delevery = document.getElementById('DeleveryModel')
delevery.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var id = button.getAttribute('data-bs-id')
	var bnum = button.getAttribute('data-bs-bnum')
	var btype = button.getAttribute('data-bs-type')
	var bBuy = button.getAttribute('data-bs-buy')
	var bSale = button.getAttribute('data-bs-sale')
	var deliv = button.getAttribute('data-bs-deliv')
	var costDeliv = button.getAttribute('data-bs-costDeliv')
	
	var t = delevery.querySelector('.modal-body #t')
	var i = delevery.querySelector('.modal-body #i')
	var b_id = delevery.querySelector('.modal-body #bill_id')
	var b_num = delevery.querySelector('.modal-body #bill_number')
	var b_type = delevery.querySelector('.modal-body #bill_type')
	var b_buy = delevery.querySelector('.modal-body #bill_total_Buy')
	var b_sale = delevery.querySelector('.modal-body #bill_total_Sale')
	var b_delevery = delevery.querySelector('.modal-body #delevery_cost')
	var b_total = delevery.querySelector('.modal-body #bill_total')
	var d_status = delevery.querySelector('.modal-body #delivery_status')
	t.value = btype
	i.value = id
	b_id.value = id
	b_num.value = bnum
	b_type.value = btype
	b_buy.value = bBuy
	b_sale.value = bSale
	b_delevery.value = costDeliv
	b_total.value = parseFloat(bSale) + parseFloat(costDeliv)
	d_status.value = deliv

});				
var deleteLine = document.getElementById('deleteLineModel')
deleteLine.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget

	var id = button.getAttribute('data-bs-id')
	var name = button.getAttribute('data-bs-name')

	var men_name = deleteLine.querySelector('.modal-body #men_name')

	var Lineid = deleteLine.querySelector('.modal-body input')

	men_name.textContent = name
	Lineid.value = id
});
var takeAwy = document.getElementById('takeAwayModel')
takeAwy.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var id = button.getAttribute('data-bs-id')
	var bnum = button.getAttribute('data-bs-btN')
	var btype = button.getAttribute('data-bs-type')
	var bBuy = button.getAttribute('data-bs-buy')
	var bSale = button.getAttribute('data-bs-sale')

	var t = takeAwy.querySelector('.modal-body #ts')
	var i = takeAwy.querySelector('.modal-body #is')
	var b_id = takeAwy.querySelector('.modal-body #bill_id')
	var b_num = takeAwy.querySelector('.modal-body #bill_number')
	var b_type = takeAwy.querySelector('.modal-body #bill_type')
	var b_buy = takeAwy.querySelector('.modal-body #bill_total_Buy')
	var b_sale = takeAwy.querySelector('.modal-body #Tbill_total_Sale')
	var b_total = takeAwy.querySelector('.modal-body #Tbill_total')
	t.value = btype
	i.value = id
	b_id.value = id
	b_num.value = bnum
	b_type.value = btype
	b_buy.value = bBuy
	b_sale.value = bSale
	var total = parseFloat(b_sale.value)
	b_total.value = total

	if(id == null){
		document.getElementById("tSave").disabled = true;
	}
	
});
$(document).ready(function() {
	$("#Tbill_discount").change(function() {
		var Tdiscount = $("#Tbill_discount").val();
		var TbTotal = $("#Tbill_total_Sale").val();
		if (Tdiscount == "") {
			$("#Tbill_total").val(parseFloat(TbTotal));
		} else {
			$("#Tbill_total").val(parseFloat(TbTotal) - parseFloat(Tdiscount));
		}
	})
});
var cust = document.getElementById('custModel')
cust.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var cust_id = $("#cust_id").val();
	var cust_name = cust.querySelector('.modal-body #cust_name')
	var cust_address = cust.querySelector('.modal-body #cust_address')

	var cu_id = cust.querySelector('.modal-body #cu_id')
	cu_id.value = cust_id

	if(cu_id.value == "" ){
		document.getElementById("csave").disabled = true;
	}else {
		document.getElementById("csave").disabled = false;
	}
});
var receptionModel = document.getElementById('receptionModel')
receptionModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var reId = button.getAttribute('data-bs-id')
	var bnum = button.getAttribute('data-bs-bnum')
	var retype = button.getAttribute('data-bs-type')

	var re_id = receptionModel.querySelector('.modal-body #bill_id')
	var b_num = receptionModel.querySelector('.modal-body #bill_number')
	var re_type = receptionModel.querySelector('.modal-body #bill_type')

	re_id.value = reId
	b_num.value = bnum
	re_type.value = retype

});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 6000);