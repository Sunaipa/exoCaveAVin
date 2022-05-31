let param;
$(function() {
	$("#errorCouleur").hide();
	$("#add").click(addCouleur);
	getCouleurs();



});

function getCouleurs() {
	$.get("http://localhost:8080/couleurs/all", afficherCouleurs);
}

function afficherCouleurs(couleurs){
	html = "";
	couleurs.forEach(function(c) {

		html += "<tr>";
		html += "<td value='" + c.id + "'>" + c.id + "</td>";
		html += "<td>" + "<input id='" + c.id + "' value='" + c.nom + "'/>" + "</td>";
		html += "<td class='centre'><button onclick='modifCouleur(" + c.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppCouleur(" + c.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
}

function addCouleur(){
    let data = {
    	nom : $('#nom').val(),
    }

    $.ajax({
    	type: 'post',
    	url: 'http://localhost:8080/couleurs/add',
    	data: JSON.stringify(data),
    	contentType: "application/json;charset=utf-8",
    	success: function() {
			getCouleurs();
    	}
    })
    	.fail(function(xhr) {
			//TODO a gerer
			console.log("sdgljkhoifghoighj");
    		$("#errorCouleur").show();
    		$("#errorCouleur").html(xhr.getResponseHeader('message'));
    	})
}

function modifCouleur(id){
	var data = {
		id: id,
		nom: $('#' + id +'').val()
	}

	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/couleurs/modify/' + id,
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			getCouleurs();
		}
	})
		.fail(function(xhr) {
			//TODO a gerer
			$("#errorCouleur").show();
			$("#errorCouleur").html(xhr.getResponseHeader('message'));
		})
}

function suppCouleur(id){
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/couleurs/delete/' + id,
		success: function () {
			getCouleurs()
		}
	})
		.fail(function (xhr) {
			$("#errorCouleur").show();
			$("#errorCouleur").html(xhr.getResponseHeader('message'));
		})
}



function triIdUp(){
	$.get("http://localhost:8080/couleurs/triIdDesc", afficherCouleurs);
}
function triIdDown(){
	$.get("http://localhost:8080/couleurs/triIdAsc", afficherCouleurs);
}

function triNomUp(){
	$.get("http://localhost:8080/couleurs/triNomAntiAlpha", afficherCouleurs);
}
function triNomDown(){
	$.get("http://localhost:8080/couleurs/triNomAlpha", afficherCouleurs);
}