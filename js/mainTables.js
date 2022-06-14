/**
 * 
 */
var deleetTab = document.getElementById('deleteTableModel')
deleetTab.addEventListener('show.bs.modal', function(event) {

	var button = event.relatedTarget
	var num = button.getAttribute('data-bs-tnum')
	var id = button.getAttribute('data-bs-tid')

	var modalNum = deleetTab.querySelector('.modal-body #Tnam')

	var modalId = deleetTab.querySelector('.modal-body input')

	modalNum.textContent = num
	modalId.value = id
});
var tableModel = document.getElementById('addTableModal')
tableModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var title = button.getAttribute('data-bs-title')
	var tabId = button.getAttribute('data-bs-id')
	var tabname = button.getAttribute('data-bs-name')

	var modalTitle = tableModel.querySelector('.modal-header #title')
	var tab_id = tableModel.querySelector('.modal-body #tab_id')
	var tab_nam = tableModel.querySelector('.modal-body #tab_num')

	modalTitle.textContent = title
	tab_id.value = tabId
	tab_nam.value = tabname

});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 4000);