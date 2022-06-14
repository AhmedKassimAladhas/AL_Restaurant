/**
 * 
 */
var exampleModal = document.getElementById('deleteSectionModel')
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
var editEmp = document.getElementById('addSectionModal')
editEmp.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var title = button.getAttribute('data-bs-title')
	var id = button.getAttribute('data-bs-id')
	var name = button.getAttribute('data-bs-name')

	var modalTitle = editEmp.querySelector('.modal-header #title')
	var sec_id = editEmp.querySelector('.modal-body #sec_id')
	var sec_name = editEmp.querySelector('.modal-body #sec_name')
	modalTitle.textContent = title
	sec_id.value = id
	sec_name.value = name

});
var catModal = document.getElementById('deleteCategoriesModel')
catModal.addEventListener('show.bs.modal', function(event) {
	// Button that triggered the modal
	var button = event.relatedTarget
	// Extract info from data-bs-* attributes
	var recipient = button.getAttribute('data-bs-dcid')
	// If necessary, you could initiate an AJAX request here
	// and then do the updating in a callback.
	//
	// Update the modal's content.
	var modalTitle = catModal.querySelector('.modal-body #dUid')

	var modalBodyInput = catModal.querySelector('.modal-body input')

	modalTitle.textContent = recipient
	modalBodyInput.value = recipient
});
var editModel = document.getElementById('addCategoriesModal')
editModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var title = button.getAttribute('data-bs-title')
	var catId = button.getAttribute('data-bs-cid')
	var secName = button.getAttribute('data-bs-secname')
	var secId = button.getAttribute('data-bs-secid')
	var catName = button.getAttribute('data-bs-catname')
	var catMeasu = button.getAttribute('data-bs-catmeasu')
	var catNum = button.getAttribute('data-bs-catnum')

	var modalTitle = editModel.querySelector('.modal-header #title')
	var cat_id = editModel.querySelector('.modal-body #cat_id')
	var sec_name = editModel.querySelector('.modal-body #sec_name')
	var sec_id = editModel.querySelector('.modal-body #sec_id')
	var cat_name = editModel.querySelector('.modal-body #cat_name')
	var cat_measu = editModel.querySelector('.modal-body #catMeasuring')
	var cat_num = editModel.querySelector('.modal-body #cat_count')

	modalTitle.textContent = title
	cat_id.value = catId
	sec_name.value = secName
	sec_id.value = secId
	cat_name.value = catName
	cat_measu.value = catMeasu
	cat_num.value = catNum

});
var addMenu = document.getElementById('addDetailsModel')
addMenu.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var id = button.getAttribute('data-bs-mcid')
	var name = button.getAttribute('data-bs-mcnam')

	var cat_id = addMenu.querySelector('.modal-body #catId')
	var cat_name = addMenu.querySelector('.modal-body #catName')
	cat_id.value = id
	cat_name.value = name

});
var menModal = document.getElementById('deleteMenuModel')
menModal.addEventListener('show.bs.modal', function(event) {
	// Button that triggered the modal
	var button = event.relatedTarget
	// Extract info from data-bs-* attributes
	var recipient = button.getAttribute('data-bs-menid')
	// If necessary, you could initiate an AJAX request here
	// and then do the updating in a callback.
	//
	// Update the modal's content.
	var modalTitle = menModal.querySelector('.modal-body #mUid')

	var modalBodyInput = menModal.querySelector('.modal-body input')

	modalTitle.textContent = recipient
	modalBodyInput.value = recipient
});
var detModal = document.getElementById('deleteMenuDetailModel')
detModal.addEventListener('show.bs.modal', function(event) {
	// Button that triggered the modal
	var button = event.relatedTarget
	// Extract info from data-bs-* attributes
	var recipient = button.getAttribute('data-bs-detid')
	// If necessary, you could initiate an AJAX request here
	// and then do the updating in a callback.
	//
	// Update the modal's content.
	var modalTitle = detModal.querySelector('.modal-body #deUid')

	var modalBodyInput = detModal.querySelector('.modal-body input')

	modalTitle.textContent = recipient
	modalBodyInput.value = recipient
});
var menuEditModel = document.getElementById('addMenuModal')
menuEditModel.addEventListener('show.bs.modal', function(event) {
	var button = event.relatedTarget
	var title = button.getAttribute('data-bs-title')
	var menId = button.getAttribute('data-bs-mid')
	var secName = button.getAttribute('data-bs-secname')
	var name = button.getAttribute('data-bs-mname')
	var sale = button.getAttribute('data-bs-msale')
	var sale2 = button.getAttribute('data-bs-msale2')
	var buy = button.getAttribute('data-bs-mbuy')
	var ingr = button.getAttribute('data-bs-mingr')
	var count = button.getAttribute('data-bs-mcount')
	var note = button.getAttribute('data-bs-mnote')

	var modalTitle = menuEditModel.querySelector('.modal-header #title')
	var men_id = menuEditModel.querySelector('.modal-body #men_id')
	var sec_name = menuEditModel.querySelector('.modal-body #sec_name')
	var m_name = menuEditModel.querySelector('.modal-body #menuNam')
	var men_sale = menuEditModel.querySelector('.modal-body #price_sale')
	var men_sale2 = menuEditModel.querySelector('.modal-body #price_sale2')
	var men_buy = menuEditModel.querySelector('.modal-body #price_buy')
	var men_ingr = menuEditModel.querySelector('.modal-body #ingredients')
	var men_count = menuEditModel.querySelector('.modal-body #count')
	var men_note = menuEditModel.querySelector('.modal-body #men_notes')

	modalTitle.textContent = title
	men_id.value = menId
	sec_name.value = secName
	m_name.value = name
	men_sale.value = sale
	men_sale2.value = sale2
	men_buy.value = buy
	men_ingr.value = ingr
	men_count.value = count
	men_note.value = note

});
$("#menuNam").change(function() {
	var menuName = $("#menuNam").val();
	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8081/ALRestaurant/getIngredients?name="+menuName;

	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	    var myArr = JSON.parse(this.responseText);
	    myFunction(myArr);
	  }
	};
	xmlhttp.open("GET", url, true);
	xmlhttp.send();

	function myFunction(arr) {
	  var out = "";
	  var i;
	  for(i = 0; i < arr.length; i++) {
		  if(i < 1){
			  out += arr[i] ;
		  }else{
			  out += " , " + arr[i] ;
		  }
		  
	  }
//	  document.getElementById("ingredients").innerHTML = out;
	  $("#ingredients").val(out);
	}
});
function allert() {
	document.getElementById("alertSuccess").style.visibility = "hidden";
}
setTimeout("allert()", 6000);