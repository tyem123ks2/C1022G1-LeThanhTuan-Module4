showList();

function showList() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/rest/player",
        success: function (data) {
            console.log(data)
            let content = '';
            for (let i = 0; i < data.length; i++) {
                content += `<tr>`
                content += `<td>${data[i].id}</td>`
                content += `<td>${data[i].name}</td>`
                content += `<td>${data[i].dateOfBirth}</td>`
                content += `<td>${data[i].age}</td>`
                content += `<td>${data[i].experience}</td>`
                content += `<tr>`
            }
            $('#tbody').html(content);
        }
    });
}

function add() {
    let name = $('#name').val();
    let dateOfBirth = $('#dateOfBirth').val();
    let age = $('#age').val();
    let experience = $('#experience').val();
    let player = {
        name: name,
        dateOfBirth: dateOfBirth,
        age: age,
        experience: experience
    }
    $.ajax({
        contentType: 'application/json;',
        dataType: 'json',
        type: 'POST',
        url: "http://localhost:8080/rest/player",
        data: JSON.stringify(player),
        success: function (data) {

        },
        complete: function (data) {
            console.log(data)
            showList();
        }
    });
}