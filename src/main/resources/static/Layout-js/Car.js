async function loadDataCar() {
    let response = await axios.get(`/car-api/getAllCar`);
    listCar = response.data.data;
    createTableCar(listCar);
    console.log(response.data);
}

    function createTableCar(addToTable){
    let bodyTableListCarString = '';

    addToTable.forEach(function (e, index){
    bodyTableListCarString +=
    `<tr>` +
    `<td>${index +1}</td>` +
    `<td>${e.imageCar}</td>` +
    `<td>${e.typeCar}</td>` +
    `<td>${e.numberSeat}</td>` +
    `<td>${e.price}</td>` +
    `<td>${e.color}</td>` +
    `<td>${e.phone}</td>` +
    `<td>${e.description}</td>` +
    `<td><button type="button" onclick="getCarInformation(${e.carId})" class="btn btn-info">Edit</button></td>` +
    `</tr>`;
});
    $("#BodyListCar").html(bodyTableListCarString);
}

    $(document).ready(async function(){
    await loadDataCar();
});

    async function getCarInformation(carId){
    let response = await axios.get(`/car-api/getCarByCarId?carId=${carId}`);
    let result = response.data;
    if(result){
    fillDetailForm(result);
}
}

    function fillDetailForm(carDetail){
    $("#carId").val(carDetail.carId);
    $("#imageCar").val(carDetail.imageCar);
    $("#typeCar").val(carDetail.typeCar);
    $("#numberSeat").val(carDetail.numberSeat);
    $("#price").val(carDetail.price);
    $("#color").val(carDetail.color);
    $("#phone").val(carDetail.phone);
    $("#description").val(carDetail.description);
}

    async function saveCarInform(){
    const carData = {
    imageCar: $("#imageCar").val(),
    typeCar: $("#typeCar").val(),
    numberSeat: parseInt($("#numberSeat").val()),
    price: parseInt($("#price").val()),
    color: $("#color").val(),
    phone: $("#phone").val(),
    description: $("#description").val()
};
    let response = await axios.post(`/car-api/getSaveCar`, carData);
    await loadDataCar();
}

    async function updateCarInform(){
    const carData = {
    carId: $("#carId").val(),
    imageCar: $("#imageCar").val(),
    typeCar: $("#typeCar").val(),
    numberSeat: parseInt($("#numberSeat").val()),
    price: parseInt($("#price").val()),
    color: $("#color").val(),
    phone: $("#phone").val(),
    description: $("#description").val()
};
    let response = await axios.post(`/car-api/getSaveCar`, carData);
    await loadDataCar();
}

async function deleteCarInform() {
    const carId = $("#carId").val();
    if (!carId) {
        alert("Vui lòng chọn xe cần xóa");
        return;
    }

    try {
        let response = await axios.delete(`/car-api/DeleteCar?carId=${carId}`);
        if (response.data.status) {
            alert("Xóa xe thành công");
            await loadDataCar();
            createTableCar(listCar);
            clearForm();
        } else {
            alert("Xóa xe thất bại");
        }
    } catch (error) {
        console.error("There was an error deleting the car!", error);
    }
}

    function clearForm() {
    fillDetailForm({
        carId: '',
        imageCar: '',
        typeCar: '',
        numberSeat: '',
        price: '',
        color: '',
        phone: '',
        description: ''
    });
}

