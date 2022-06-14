/**
 * 
 */
var exampleModal = document.getElementById('deleteUserModel')
exampleModal.addEventListener('show.bs.modal', function(event) {
	
	var button = event.relatedTarget

	var recipient = button.getAttribute('data-bs-deid')
	
	var modalTitle = exampleModal.querySelector('.modal-body #dUid')

	var modalBodyInput = exampleModal.querySelector('.modal-body input')

	modalTitle.textContent = recipient
	modalBodyInput.value = recipient
});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 5000);
