async function loadDataCar(){
    let response = await axios.get('/car-api/getAllCar');
    listAllCar = response.data.data;
    console.log(response.data.data);
}

$(document).ready(async function (){
    await loadDataCar();
    createTableCar(listAllCar);
})

function createTableCar(addToTable){
    let bodyTableListCar = '';

    addToTable.forEach(function (e){
        bodyTableListCar +=
            `<tr>` +
            `<td>${e.carId}</td>` +
            `<td>${e.imageCar}</td>` +
            `<td>${e.typeCar}</td>` +
            `<td>${e.numberSeat}</td>` +
            `<td>${e.price}</td>` +
            `<td>${e.color}</td>` +
            `<td>${e.phone}</td>` +
            `<td>${e.availability}</td>` +
            `<td>${e.description}</td>` +
            `<td>` +
            `<button type="button"
                        className="btn btn-outline-success">Edit</button>` +
            `</td>` +
            `</tr>`;
    })

    $("#BodyListAllCar").html(bodyTableListCar);
}