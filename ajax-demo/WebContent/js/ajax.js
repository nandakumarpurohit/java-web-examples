$(document).ready(function() {

	$("#btn").click(function() {
		var zipCode = $("#myname").val();
		$.ajax({
			url: "https://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us&appid=a30ebb5af6b78e566e1797db9855606e"	
		}).then(function(data) {
			console.log(data);
			$("#content").html(data.main.temp_min + "<br/>");
			$("#content").append(data.main.temp_max + "<br/>");
			$("#content").append(data.main.humidity + "<br/>");
			$("#content").append(data.name + "<br/>");
		})
	})
})
