$(document).ready(()=> {
    showList();
});

function showList() {
    listTeam();
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/api/soccer",
        success: function (data) {
            console.log(data);
            let element = '';
            for (let i = 0; i < data.length; i++) {
                element += `<tr>`
                element += `<th scope="row">${i + 1}</th>`
                element += `<td>${data[i].name}</td>`
                element += `<td>${data[i].birthday}</td>`
                element += `<td>${data[i].location}</td>`
                element += `<td>${data[i].experience}</td>`
                element += `<td>${data[i].team.name}</td>`
                element += `</tr>`;
            }
            console.log(element);
            $('#playerList').html(element);
        }
    });
}


function listTeam() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/api/soccer/teams",
        success: function (data) {
            console.log(data);
            showListTeams(data);
        },
        error: function (err) {
            console.log(err);
        },
    });
}
function showListTeams(listTeams) {
    let element = `<label class="form-label">Team</label>
    <select class='form-control' id='teams'>`;
    for (let team of listTeams) {
        element += `<option value=${team.id}>${team.name}</option>`;
    }
    element += `</select>`;
    $('#teamList').html(element);}

function add() {
    let name = $('#name').val();
    let birthday = $('#birthday').val();
    let experience = $('#experience').val();
    let location = $('#location').val();
    let team = $('#teams').val();
    console.log(team)
    let playerSoccer = {
        name: name,
        birthday: birthday,
        experience: experience,
        location: location,
        team: {id: team}
    }
    console.log(playerSoccer)
    console.log(JSON.stringify(playerSoccer));
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        type: 'POST',
        url: 'http://localhost:8080/api/soccer',
        data: JSON.stringify(playerSoccer),
        success: function (data) {
        },
        complete: function (data) {
            console.log(data);
            $('#successModal').modal('show');
            clearInputs();
            showList();
        }
    });

    function clearInputs() {
        document.getElementById("name").value = "";
        document.getElementById("birthday").value = "";
        document.getElementById("location").value = "";
        document.getElementById("experience").value = "";
        document.getElementById("teamList").innerHTML = "";
    }
}

function closeModal() {
    $('#successModal').modal('hide');
}
