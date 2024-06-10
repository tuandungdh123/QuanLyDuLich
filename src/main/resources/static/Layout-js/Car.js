async function loadDataCar() {
    let response = await axios.get('/car-api/getAllCar');
    listAllCar = response.data.data;
    console.log(response.data.data);
}

$(document).ready(async function() {
    await loadDataCar();
    createTableCar(listAllCar);

    // Thêm sự kiện 'change' cho input
    document.getElementById('imageInput').addEventListener('change', function(event) {
        const file = event.target.files[0]; // Lấy tệp đầu tiên trong danh sách tệp
        if (file) {
            const reader = new FileReader(); // Tạo đối tượng FileReader
            reader.onload = function(e) {
                // Khi tệp đã được đọc xong, đặt URL của tệp vào src của thẻ img
                const imgElement = document.getElementById('image-preview');
                imgElement.src = e.target.result;
                imgElement.style.display = 'block'; // Hiển thị ảnh sau khi chọn
                document.getElementById('imageInput').style.display = 'none'; // Ẩn nút chọn ảnh
            };
            reader.readAsDataURL(file); // Đọc tệp dưới dạng URL dữ liệu (Data URL)
        }
    });
});

function createTableCar(addToTable) {
    let bodyTableListCar = '';

    addToTable.forEach(function(e, index) {
        bodyTableListCar +=
            `<tr>` +
            `<td>${index + 1}</td>` +
            `<td><img src="${e.imageCar}" alt="Car Image" width="100"></td>` +
            `<td>${e.typeCar}</td>` +
            `<td>${e.numberSeat}</td>` +
            `<td>${e.price}</td>` +
            `<td>${e.color}</td>` +
            `<td>${e.phone}</td>` +
            `<td>${e.availability}</td>` +
            `<td>${e.description}</td>` +
            `<td>` +
            `<button type="button" class="btn btn-outline-success" onclick="editCar(${e.carId})">Edit</button>` +
            `</td>` +
            `</tr>`;
    });

    $("#BodyListAllCar").html(bodyTableListCar);
}

function clearForm() {
    document.getElementById('carId').value = '';
    document.getElementById('typeCar').value = '';
    document.getElementById('numberSeat').value = '';
    document.getElementById('price').value = '';
    document.getElementById('color').value = '';
    document.getElementById('phone').value = '';
    document.getElementById('availability').value = '';
    document.getElementById('description').value = '';
    document.getElementById('image-preview').src = '';
    document.getElementById('image-preview').style.display = 'none';
    document.getElementById('imageInput').style.display = 'block';
}

async function saveTourInForm() {
    // Lấy dữ liệu từ form
    let car = {
        typeCar: document.getElementById('typeCar').value,
        numberSeat: document.getElementById('numberSeat').value,
        price: document.getElementById('price').value,
        color: document.getElementById('color').value,
        phone: document.getElementById('phone').value,
        availability: document.getElementById('availability').value,
        description: document.getElementById('description').value
    };

    try {
        let response = await axios.post('/car-api/create', car);
        if (response.data.success) {
            Swal.fire('Success', 'Car created successfully', 'success');
            await loadDataCar();
            createTableCar(listAllCar);
        } else {
            Swal.fire('Error', 'Failed to create car', 'error');
        }
    } catch (error) {
        Swal.fire('Error', 'Failed to create car', 'error');
    }
}

async function updateTourInForm() {
    let carId = document.getElementById('carId').value;
    let car = {
        carId: carId,
        typeCar: document.getElementById('typeCar').value,
        numberSeat: document.getElementById('numberSeat').value,
        price: document.getElementById('price').value,
        color: document.getElementById('color').value,
        phone: document.getElementById('phone').value,
        availability: document.getElementById('availability').value,
        description: document.getElementById('description').value
    };

    try {
        let response = await axios.put(`/car-api/update/${carId}`, car);
        if (response.data.success) {
            Swal.fire('Success', 'Car updated successfully', 'success');
            await loadDataCar();
            createTableCar(listAllCar);
        } else {
            Swal.fire('Error', 'Failed to update car', 'error');
        }
    } catch (error) {
        Swal.fire('Error', 'Failed to update car', 'error');
    }
}

async function deleteCar() {
    let carId = document.getElementById('carId').value;

    try {
        let response = await axios.delete(`/car-api/delete/${carId}`);
        if (response.data.success) {
            Swal.fire('Success', 'Car deleted successfully', 'success');
            await loadDataCar();
            createTableCar(listAllCar);
        } else {
            Swal.fire('Error', 'Failed to delete car', 'error');
        }
    } catch (error) {
        Swal.fire('Error', 'Failed to delete car', 'error');
    }
}
