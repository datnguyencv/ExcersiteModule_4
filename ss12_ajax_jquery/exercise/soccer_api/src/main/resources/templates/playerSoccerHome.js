showList();

function showList() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/api/soccer",
        success: function (data) {
            console.log(data);
            let element = '';
            for (let i = 0; i < data.content.length; i++) {
                element += `<tr>
               <th scope="row">${i + 1}</th>
                <td>${data.content[i].name}</td>
                <td>${data.content[i].birthday}</td>
                <td>${data.content[i].location}</td>
                <td>${data.content[i].experience}</td>
                <td>${data.content[i].team?.name}</td>
                </tr>`;
            }
            $('#playerList').html(element);
        }
    });
}


function add() {
    let name = $('#name').val();
    let birthday = $('#birthday').val();
    let experience = $('#experience').val();
    let location = $('#location').val();
    let team = $('#team').val();
    let player = {
        name: name,
        birthday: birthday,
        experience: experience,
        location: location,
        team: team.id
    }
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        type: 'POST',
        url: 'http://localhost:8080/api/soccer',
        data: JSON.stringify(player),
        success: function (data) {

        },
        complete: function (data) {
            console.log(data);
            showList();
        }
    });
}
