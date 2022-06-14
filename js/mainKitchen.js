/**
 *
 */
var linModal = document.getElementById('AllLineModel')
linModal.addEventListener('show.bs.modal', function(event) {
	
	var button = event.relatedTarget
	
	var Lid = button.getAttribute('data-bs-Lid')
	
	var value = Lid;
	$("#TableL1 tr").filter(
			function() {
				$(this).toggle(
						$(this).text().toLowerCase()
								.indexOf(value) > -1)
			});
});