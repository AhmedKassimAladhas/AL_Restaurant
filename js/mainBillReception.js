/**
 * 
 */
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
var exampleModal = document.getElementById('deleteLineModel')
exampleModal.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget

	var id = button.getAttribute('data-bs-id')
	var name = button.getAttribute('data-bs-name')
	var bil = button.getAttribute('data-bs-bil')
	
	var men_name = exampleModal.querySelector('.modal-body #men_name')

	var Lineid = exampleModal.querySelector('.modal-body #menId')
	var bId = exampleModal.querySelector('.modal-body #bId')

	men_name.textContent = name
	Lineid.value = id
	bId.value = bil
});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 4000);