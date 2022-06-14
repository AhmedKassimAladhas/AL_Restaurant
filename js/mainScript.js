/**
 * 
 */
var exampleModal = document.getElementById('deleteUserModel')
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
var editEmp = document.getElementById('addEmpModal')
editEmp.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var title = button.getAttribute('data-bs-title')
	var id = button.getAttribute('data-bs-id')
	var name = button.getAttribute('data-bs-name')
	var phone = button.getAttribute('data-bs-phone')
	var job = button.getAttribute('data-bs-job')
	var gender = button.getAttribute('data-bs-gender')
	var insurance = button.getAttribute('data-bs-insurance')
	var salary = button.getAttribute('data-bs-salary')
	var user = button.getAttribute('data-bs-user')

	var modalTitle = editEmp.querySelector('.modal-header #title')
	var emp_id = editEmp.querySelector('.modal-body #emp_id')
	var emp_name = editEmp.querySelector('.modal-body #emp_name')
	var emp_phone = editEmp.querySelector('.modal-body #emp_phone')
	var emp_job = editEmp.querySelector('.modal-body #emp_job')
	var emp_gender = editEmp.querySelector('.modal-body #emp_gender')
	var emp_insurance = editEmp.querySelector('.modal-body #emp_insurance')
	var emp_salary = editEmp.querySelector('.modal-body #emp_salary')
	var emp_user = editEmp.querySelector('.modal-body #emp_user')
	modalTitle.textContent = title
	emp_id.value = id
	emp_name.value = name
	emp_phone.value = phone
	emp_job.value = job
	emp_gender.value = gender
	emp_insurance.value = insurance
	emp_salary.value = salary
	emp_user.value = user

});
var userModel = document.getElementById('addUserModal')
userModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var userId = button.getAttribute('data-bs-id')
	var user = button.getAttribute('data-bs-name')

	var emp_id = userModel.querySelector('.modal-body #empId')
	var emp_name = userModel.querySelector('.modal-body #empName')

	emp_id.value = userId
	emp_name.value = user

});
var shiftModel = document.getElementById('addShiftModal')
shiftModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var shiftId = button.getAttribute('data-bs-id')
	var shift = button.getAttribute('data-bs-name')

	var emp_id = shiftModel.querySelector('.modal-body #empId')
	var emp_name = shiftModel.querySelector('.modal-body #empName')

	emp_id.value = shiftId
	emp_name.value = shift

});
var sh = document.getElementById('datesModel')
sh.addEventListener('show.bs.modal', function(event) {
	var button5 = event.relatedTarget
	var shId = button5.getAttribute('data-bs-empName')

	var emp_Name = sh.querySelector('.modal-title #name')

	var empNme = sh.querySelector('.modal-title #bemp')

	empNme.textContent = shId
	emp_Name.value = shId

	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("name");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}

});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 6000);