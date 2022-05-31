var term= "";

$(function() {
	$("#errorBouteille").hide();
	getBouteilles();
	$("#unite").hide();
	$("#effacer").on("click", effaceEtReload);
	$("#search").on("click", search);
});

function getBouteilles() {
	console.log("je suis ici 1");
	$.get("http://localhost:8080/bouteilles/all", afficherBouteilles);
}

function afficherBouteilles(bouteilles){
	console.log("je suis ici 2");
	html = "";
	bouteilles.forEach(function(b) {
		let pet = b.petillant ? "oui" : "non";

		html += "<tr>";
		html += "<td><button onclick='detailBouteille(" + b.id + ")' type='text' class=' btn btn-link'> " + b.nom + "</button></td>";
		html += "<td>" + b.millesime + "</td>";
		html += "<td>" + pet + "</td>";
		html += "<td>" + b.quantite + "</td>";
		html += "<td>" + b.couleur.nom + "</td>";
		html += "<td>" + b.region.nom + "</td>";
		html += "<td class='centre'><button onclick='modifBouteille(" + b.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppBouteille(" + b.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
	console.log("je suis ici 3");
}


function detailBouteille(id){
	$.get("http://localhost:8080/bouteilles/getOne/" + id, function(b){

		let pet = b.petillant ? "oui" : "non";

		$("#tableList").hide();

		$("#idUnit").html(b.id);
		$("#nom").html(b.nom);
		$("#millesime").html(b.millesime);
		$("#petillant").html(pet);
		$("#quantite").html(b.quantite);
		$("#couleur").html(b.couleur.nom);
		$("#region").html(b.region.nom);
		
		$("#unite").show();
		});
}

function modifBouteille(id){
	window.location = "modifBouteille.html" + "?id=" + id ;
}

function suppBouteille(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/bouteilles/delete/' + id,
		success: function () {
			getBouteilles()
		}
	})
		.fail(function (xhr) {
			$("#errorBouteille").show();
			$("#errorBouteille").html(xhr.getResponseHeader('message'));
		})
}


function search(){
	term = $("#filtre").val();
	console.log(term);
	$.get('http://localhost:8080/bouteilles/search/' + term, afficherBouteilles)

}

function effaceEtReload(){
	if (term == $("#filtre").val() ){
		$("#filtre").val("")
		getBouteilles();
	} else {
		$("#filtre").val("");
	}

}

function triNomUp(){
	$.get("http://localhost:8080/bouteilles/triNomAntiAlpha", afficherBouteilles);
}
function triNomDown(){
	$.get("http://localhost:8080/bouteilles/triNomAlpha", afficherBouteilles);
}

function triMillesimeUp(){
	$.get("http://localhost:8080/bouteilles/triMillesimeAntiAlpha", afficherBouteilles);
}
function triMillesimeDown(){
	$.get("http://localhost:8080/bouteilles/triMillesimeAlpha", afficherBouteilles);
}

function triPetillantUp(){
	$.get("http://localhost:8080/bouteilles/triPetillantDesc", afficherBouteilles);
}
function triPetillantDown(){
	$.get("http://localhost:8080/bouteilles/triPetillantAsc", afficherBouteilles);
}

function triQuantiteUp(){
	$.get("http://localhost:8080/bouteilles/triQuantiteDesc", afficherBouteilles);
}
function triQuantiteDown(){
	$.get("http://localhost:8080/bouteilles/triQuantiteAsc", afficherBouteilles);
}

function triCouleurUp(){
	$.get("http://localhost:8080/bouteilles/triNomCouleurAntiAlpha", afficherBouteilles);
}
function triCouleurDown(){
	$.get("http://localhost:8080/bouteilles/triNomCouleurAlpha", afficherBouteilles);
}

function triRegionUp(){
	$.get("http://localhost:8080/bouteilles/triNomRegionAntiAlpha", afficherBouteilles);
}
function triRegionDown(){
	$.get("http://localhost:8080/bouteilles/triNomRegionAlpha", afficherBouteilles);
}

function retourList(){
	$("#unite").hide();
	$("#tableList").show();
}


