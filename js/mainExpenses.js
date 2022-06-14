/**
 *
 */

var exampleModal = document.getElementById('deleteExpensesModel')
exampleModal.addEventListener('show.bs.modal', function(event) {
	// Button that triggered the modal
	var button = event.relatedTarget
	// Extract info from data-bs-* attributes
	var recipient = button.getAttribute('data-bs-deid')
	// If necessary, you could initiate an AJAX request here
	// and then do the updating in a callback.
	//
	// Update the modal's content.
	var modalTitle = exampleModal.querySelector('.modal-body #dUid')

	var modalBodyInput = exampleModal.querySelector('.modal-body input')

	modalTitle.textContent = recipient
	modalBodyInput.value = recipient
});

function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 6000);