let param;
$(function() {
	$("#errorBouteille").hide();
	getCouleur();
	getRegion();
	$("#add").click(addBouteilles);
});

function addBouteilles(){
	console.log($('#petillant').val());
    let data = {
    	nom : $('#nom').val(),
		millesime:  $('#millesime').val(),
    	quantite:  $('#quantite').val(),
    	petillant: $('#petillant').val(),
    	couleur: {
			id: $("#couleur").val()
		},
    	region: {
    		id: $("#region").val()
    	}
    }
	console.log(data);

    $.ajax({
    	type: 'post',
    	url: 'http://localhost:8080/bouteilles/add',
    	data: JSON.stringify(data),
    	contentType: "application/json;charset=utf-8",
    	success: function() {
			window.location = "bouteilles.html";
    	}
    })
    	.fail(function(xhr) {
    		$("#errorBouteille").show();
    		$("#errorBouteille").html(xhr.getResponseHeader('message'));
    	})
}

function getCouleur() {
	$.get("http://localhost:8080/couleurs/all", function(couleurs){
		let data = "";
		couleurs.forEach(function(c){
			data += "<option value="+c.id +">" + c.nom + "</option>";
		});
		$("#couleur").html(data);
		getRegion();
	});
}

function getRegion() {
	$.get("http://localhost:8080/regions/all", function(regions){
		let data = "";
		regions.forEach(function(r){
			data += "<option value="+r.id +">" + r.nom + "</option>";
		});
		$("#region").html(data);
	});
}