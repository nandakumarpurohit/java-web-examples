var initialize = function() {
	var xmlHttp;

	if (window.XMLHttpRequest) {
		// code for modern browsers
		xmlHttp = new XMLHttpRequest();
	} else {
		// code for old IE browsers
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	return xmlHttp;
}

var process = function() {

	var AJAX = initialize();
	
	var name = document.getElementById("myname").value;
	
	AJAX.open("GET", "hello.jsp?username=" + name, true);
	AJAX.send();
	AJAX.onreadystatechange = manipulate;
	
	function manipulate() {
		if(AJAX.status == 200 && AJAX.readyState == 4) {
			var output = AJAX.responseText;
			console.log(output);
			var content = document.getElementById("content");
			content.innerHTML = "<b>" + output + "</b>";
			content.style.background = "yellow";
		}
	}

}