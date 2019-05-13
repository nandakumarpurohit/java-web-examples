$(document).ready(function() {
	console.log("Hello!");
	var availableStates = ["Abc", "Bca", "Cda", "Bcd", "Def", "Efg", "Hij", "Fgh"];
    var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Scheme"
      ];
    console.log(availableTags);
	
	$.ajax({
		url: "hello.jsp"
	}).then(function(data) {
		//console.log(data);
		availableStates = JSON.parse(data);
		console.log(availableStates);
		//var data2 = ["CA", "TX"];
		
		/*$.each(availableStates, function(idx) {
			console.log(availableStates[idx]);
		})*/
		$('#tags').focus();
	    $( "#tags" ).autocomplete({
	      source: availableStates
	    });
	});
	
	
	
	
	
})