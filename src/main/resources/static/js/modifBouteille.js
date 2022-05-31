let param;
$(function() {
	$("#errorBouteille").hide();
	getCouleur();
	getRegion();
	$("#modif").click(modifBouteilles);
	let searchParams = new URLSearchParams(window.location.search)
	if (searchParams.has('id')){
		param = searchParams.get('id')
	} else {
		window.location = "index.html";
	}
});

function modifBouteilles(){
	console.log($('#petillant').val());
    var data = {
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
    	type: 'put',
    	url: 'http://localhost:8080/bouteilles/modify/' + $('#id').val(),
    	data: JSON.stringify(data),
    	contentType: "application/json;charset=utf-8",
    	success: function() {
			window.location = "bouteilles.html";
    	}
    })
    	.fail(function(xhr) {
			//TODO a gerer
    		$("#errorBouteille").show();
    		$("#errorBouteille").html(xhr.getResponseHeader('message'));
    	})
}

function remplissageForm(b){


	$("#id").val(b.id);

	$("#nom").val(b.nom);
	$("#nom").attr('placeholder', b.nom);

	$("#millesime").val(b.millesime);
	$("#millesime").attr('placeholder', b.millesime);

	$("#petillant").val("" + b.petillant);

	$("#quantite").val(b.quantite);
	$("#quantite").attr('placeholder', b.quantite);

	$("#couleur").val(b.couleur.id);

	$("#region").val(b.region.id);

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
		$.get("http://localhost:8080/bouteilles/getOne/" + param, remplissageForm);
	});
}