/**
 * 
 */

var deleetDat = document.getElementById('deleteDateModel')
deleetDat.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget
	var num = button.getAttribute('data-bs-Num')
	var id = button.getAttribute('data-bs-id')

	var modalNum = deleetDat.querySelector('.modal-body #dUNum')

	var modalId = deleetDat.querySelector('.modal-body input')

	modalNum.textContent = num
	modalId.value = id
});
var dateModel = document.getElementById('addDateModal')
dateModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var datId = button.getAttribute('data-bs-id')
	var datNumber = button.getAttribute('data-bs-number')
	var datFrom = button.getAttribute('data-bs-from')
	var datTo = button.getAttribute('data-bs-to')
	
	var dat_id = dateModel.querySelector('.modal-body #dat_id')
	var dat_Num = dateModel.querySelector('.modal-body #dat_number')
	var dat_from = dateModel.querySelector('.modal-body #time_from')
	var dat_to = dateModel.querySelector('.modal-body #time_to')
	
	dat_id.value = datId
	dat_Num.value = datNumber
	dat_from.value = datFrom
	dat_to.value = datTo

});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 4000);