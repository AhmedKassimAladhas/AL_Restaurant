/**
 *
 */
var exampleModal = document.getElementById('PrintModel')
exampleModal.addEventListener('show.bs.modal', function(event) {
	
	var button = event.relatedTarget
	
	var billid = button.getAttribute('data-bs-billid')
	var type = button.getAttribute('data-bs-type')

	var bid = exampleModal.querySelector('.modal-body #bid')

	var idInput = exampleModal.querySelector('.modal-body #bill_id')
	var typeInput = exampleModal.querySelector('.modal-body #bitype')

	bid.textContent = billid
	idInput.value = billid
	typeInput.value = type
});
$(document).ready(function() {
	$("#Save").click(function() {

		var id = $("#bill_id").val();
		var type = $("#bitype").val();
		setTimeout(function() { // Delay for Chrome
			if (id != null ) {				
				window.open("/ALRestaurant/print?id=" + id +"&type="+ type, "_blank");
			}
		}, 220);
	})
})