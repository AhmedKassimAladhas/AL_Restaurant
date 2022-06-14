/**
 *
 */
var account = document.getElementById('endAccountModal')
account.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var date = button.getAttribute('data-bs-date')
	var shif = button.getAttribute('data-bs-shif')
	var bil = button.getAttribute('data-bs-bil')
	var deliv = button.getAttribute('data-bs-deliv')
	var take = button.getAttribute('data-bs-take')
	var rec = button.getAttribute('data-bs-rec')
	var totalBill = button.getAttribute('data-bs-totalBill')
	var totaldeliv = button.getAttribute('data-bs-totaldeliv')
	var totaltake = button.getAttribute('data-bs-totaltake')
	var totalrec = button.getAttribute('data-bs-totalrec')
	var totalexp = button.getAttribute('data-bs-totalexp')
	
	var acc_date = account.querySelector('.modal-body #acc_date')
	var shift = account.querySelector('.modal-body #shift')
	var bills = account.querySelector('.modal-body #bills')
	var deleviry = account.querySelector('.modal-body #deleviry')
	var take_away = account.querySelector('.modal-body #take_away')
	var reception = account.querySelector('.modal-body #reception')
	var total_bills = account.querySelector('.modal-body #total_bills')
	var total_deleviry = account.querySelector('.modal-body #total_deleviry')
	var total_take_away = account.querySelector('.modal-body #total_take_away')
	var total_reception = account.querySelector('.modal-body #total_reception')
	var total_expenses = account.querySelector('.modal-body #total_expenses')
	acc_date.value = date
	shift.value = shif
	bills.value = bil
	deleviry.value = deliv
	take_away.value = take
	reception.value = rec
	total_bills.value = totalBill
	total_deleviry.value = totaldeliv
	total_take_away.value = totaltake
	total_reception.value = totalrec
	total_expenses.value = totalexp

});	
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 6000);