let param;
$(function() {
	$("#add").click(addRegion);
});

function addRegion(){
    let data = {
    	nom : $('#nom').val(),
    }

    $.ajax({
    	type: 'post',
    	url: 'http://localhost:8080/regions/add',
    	data: JSON.stringify(data),
    	contentType: "application/json;charset=utf-8",
    	success: function() {
			window.location = "index.html";
    	}
    })
    	.fail(function() {
			//TODO a gerer
    		$("#errorBouquet").css("display", "block");
    		$("#errorBouquet").html("Une erreur est survenue lors de la modification");
    	})
}