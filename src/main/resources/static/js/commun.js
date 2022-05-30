$(function() {
	includeNavBar();
	includeFooter();
});


function includeNavBar(){
	var id = $(".include-Nav").attr("name");
	id = "#" + id;
	$(".include-Nav").load("./include/navBar.html", function(){
		setActive(id);
	});
}

function setActive(id){
	$(id).attr("class", "active");
}

function includeFooter(){
	$(".include-Footer").load("./include/footer.html")
}