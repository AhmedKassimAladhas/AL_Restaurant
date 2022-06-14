/**
 *
 */
 $(document).ready(function() {
	
      const ctx = document.getElementById("chart").getContext('2d');
       var xmlhttp = new XMLHttpRequest();
		var url = "http://localhost:8081/ALRestaurant/getChartTake";

		var myArr = "";
		xmlhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
		    myArr2 = JSON.parse(this.responseText);
		    myFunction(myArr2);   
		  }
		};
		
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
		
		function myFunction(arr) {	
		    
			  const myChart = new Chart(ctx, {
			        type: 'bar',
			        data: {
			          labels: Object.keys(arr),
			          datasets: [{
			            label: 'TakeAway',
			            backgroundColor: 'rgba(161, 198, 247, 1)',
			            borderColor: 'rgb(47, 128, 237)',
			            data: Object.values(arr),
			          }]
			        },
			        options: {
			          scales: {
			            yAxes: [{
			              ticks: {
			                beginAtZero: true,
			              }
			            }]
			          }
			        },
			      });
		}     
})

 $(document).ready(function() {
	
      const ctx = document.getElementById("chartD").getContext('2d');
       var xmlhttp = new XMLHttpRequest();
		var url = "http://localhost:8081/ALRestaurant/getChartDelevery";

		var myArr = "";
		xmlhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
		    myArr2 = JSON.parse(this.responseText);
		    myFunction(myArr2);   
		  }
		};
		
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
		
		function myFunction(arr) {	
		    
			  const myChart = new Chart(ctx, {
			        type: 'bar',
			        data: {
			          labels: Object.keys(arr),
			          datasets: [{
			            label: 'Delevery',
			            backgroundColor: 'rgba(161, 198, 247, 1)',
			            borderColor: 'rgb(47, 128, 237)',
			            data: Object.values(arr),
			          }]
			        },
			        options: {
			          scales: {
			            yAxes: [{
			              ticks: {
			                beginAtZero: true,
			              }
			            }]
			          }
			        },
			      });
		}     
})

$(document).ready(function() {
	
      const ctx = document.getElementById("chartR").getContext('2d');
       var xmlhttp = new XMLHttpRequest();
		var url = "http://localhost:8081/ALRestaurant/getChartReception";

		var myArr = "";
		xmlhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
		    myArr2 = JSON.parse(this.responseText);
		    myFunction(myArr2);   
		  }
		};
		
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
		
		function myFunction(arr) {	
		    
			  const myChart = new Chart(ctx, {
			        type: 'bar',
			        data: {
			          labels: Object.keys(arr),
			          datasets: [{
			            label: 'Reception',
			            backgroundColor: 'rgba(161, 198, 247, 1)',
			            borderColor: 'rgb(47, 128, 237)',
			            data: Object.values(arr),
			          }]
			        },
			        options: {
			          scales: {
			            yAxes: [{
			              ticks: {
			                beginAtZero: true,
			              }
			            }]
			          }
			        },
			      });
		}     
})