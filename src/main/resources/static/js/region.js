let param;
$(function() {
	$("#errorRegion").hide();
	$("#add").click(addRegion);
	getRegions();
});

function getRegions() {
	$.get("http://localhost:8080/regions/all", afficherRegions);
}


function afficherRegions(regions){
	html = "";
	regions.forEach(function(r) {

		html += "<tr>";
		html += "<td value='" + r.id + "'>" + r.id + "</td>";
		html += "<td>" + "<input id='" + r.id + "' value='" + r.nom + "'/>" + "</td>";
		html += "<td class='centre'><button onclick='modifRegion(" + r.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		html += "<td class='centre'><button onclick='suppRegion(" + r.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";
		html += "</tr>";
	})
	$("#tbodyliste").html(html);
}

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
			getRegions();
    	}
    })
    	.fail(function(xhr) {
			//TODO a gerer
    		$("#errorRegion").show();
    		$("#errorRegion").html(xhr.getResponseHeader('message'));
    	})
}


function modifRegion(id){
	var data = {
		id: id,
		nom: $('#' + id +'').val()
	}

	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/regions/modify/' + id,
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			getRegions();
		}
	})
		.fail(function(xhr) {
			$("#errorRegion").show();
			$("#errorRegion").html(xhr.getResponseHeader('message'));
		})
}

function suppRegion(id){
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/regions/delete/' + id,
		success: function () {
			getRegions()
		}
	})
		.fail(function (xhr) {
			$("#errorRegion").show();
			$("#errorRegion").html(xhr.getResponseHeader('message'));
		})
}


function triIdUp(){
	$.get("http://localhost:8080/regions/triIdDesc", afficherRegions);
}
function triIdDown(){
	$.get("http://localhost:8080/regions/triIdAsc", afficherRegions);
}

function triNomUp(){
	$.get("http://localhost:8080/regions/triNomAntiAlpha", afficherRegions);
}
function triNomDown(){
	$.get("http://localhost:8080/regions/triNomAlpha", afficherRegions);
}