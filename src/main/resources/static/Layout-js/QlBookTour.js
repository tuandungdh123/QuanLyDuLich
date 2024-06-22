var listAllBookTour = [];
async function loadDataBookTour() {
    try {
        let response = await axios.get('/BookTour/getBookTourByStatusID?status_Id=3');
        listAllBookTour = response.data.data;
    } catch (error) {
    }
}
$(document).ready(async function () {
    await loadDataBookTour();
    createTableBookTour(listAllBookTour); // Gọi hàm createTableTour2 sau khi loadDataTour đã hoàn tất
    $("#helloAccount").text("Xin Chào," + localStorage.getItem("account")+ "!")
});

let addToTable =[];
function createTableBookTour(data) {
    addToTable = data;
    console.log(addToTable)

    let populateTypeTourDropdown = '';

    addToTable.forEach(function (e, index) {

            populateTypeTourDropdown +=
                `<tr ondblclick="selectRowIndex(${index})">` +
                `<td>${index + 1}</td>` +
                `<td>${e.bookTourId}</td>` +
                `<td>${e.tourE.tourID}</td>` +
                `<td>${e.nameUser}</td>` +
                `<td>${e.phone}</td>` +
                `<td>${e.email}</td>` +
                `<td>${e.date_Booked}</td>` +
                `<td>${e.price}</td>` +
                `<td>${e.statusTourEntity.type_Status}</td>` +
                `</tr>`;
    });
    $("#BodyListAllBookTour").html(populateTypeTourDropdown);
    let table = new DataTable('#paginationTour',{
        searching :  false,
        info: false,
        paging: true,
        ordering: false,
        lengthMenu:[4]
    });
    $('.dt-length').hide();
}
function selectRowIndex(index){
    // Truy cập vào hàng được double click bằng chỉ số
    const selectedRow = addToTable[index];
    console.log(selectedRow)

    document.getElementById('modalBookTourId').value = selectedRow.bookTourId;
    document.getElementById('modalTourId').value = selectedRow.tourE.tourID;
    document.getElementById('modalNameUser').value = selectedRow.nameUser;
    document.getElementById('modalPhone').value = selectedRow.phone;
    document.getElementById('modalEmail').value = selectedRow.email;
    document.getElementById('modalDateBooked').value = selectedRow.date_Booked;
    document.getElementById('modalPrice').value = selectedRow.price;
    document.getElementById('address').value = selectedRow.address;
    document.getElementById('numberAdults').value = selectedRow.numberAdults;
    document.getElementById('numberChildrens').value = selectedRow.numberChildren;
    document.getElementById('numberTreNho').value = selectedRow.numberTreNho;
    document.getElementById('description').value = selectedRow.description;
    document.getElementById('modalStatus').value = selectedRow.statusTourEntity.status_Id;
    // Hiển thị modal bằng Bootstrap
    var myModal = new bootstrap.Modal(document.getElementById('exampleModal'));
    myModal.show();

    // Hiển thị modal
    var myModal = new bootstrap.Modal(document.getElementById('exampleModal'));
    myModal.show();
    // Xử lý sự kiện khi modal đóng
    $('#exampleModal').on('hidden.bs.modal', function () {
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
    });
}

async function submit(){
    await generatePDF();
    await updateTourInForm();

}

async function generatePDF(bookTourEntity) {

    const BookTourData = {
        bookTourID: $("#modalBookTourId").val(),
        tourE: {
            tourID: $("#modalTourId").val(),
        },
        nameUser: $("#modalNameUser").val(),
        phone: $("#modalPhone").val(),
        email: $("#modalEmail").val(),
        date_Booked: $("#modalDateBooked").val(),
        address: $("#address").val(),
        numberAdults: $("#numberAdults").val(),
        numberChildren: $("#numberChildrens").val(),
        numberTreNho: $("#numberTreNho").val(),
        description: $("#description").val(),
        price: $("#modalPrice").val(),
        statusTourEntity: {
            status_Id: String($("#modalStatus").val())
        }

    }

    var email = document.getElementById('modalEmail').value;
    // Base64 image strings

    let element =
    `<div class="card mt-4">
        <div class="card-front">
            <div class="logo-section">
                <img src="" style="width: 100px; height:auto;" alt="">
                    <h1>LỮ HÀNH VIỆT NAM</h1>
                    <p>Đơn vị tổ chức tour du lịch chuyên nghiệp từ AnhDev.</p>
            </div>
            <div class="image-section w-100">
                <img src="" style="width: 100%; height:250px;" alt="">
            </div>
        </div>
        <div class="card-back">
            <div class="booking-info">
                <p class="justify-content-center"><strong>THÔNG TIN ĐĂT LỊCH</strong></p>
                <div class="row">
                    <p class="col-6" id="modalBookTourId">Book Tour ID: ${BookTourData.bookTourID}</p>
                    <p class="col-6" id="modalTourId">Tour ID: ${BookTourData.tourE.tourID}</p>
                    <p class="col-6" id="modalNameUser">Name: ${BookTourData.nameUser}</p>
                    <p class="col-6" id="modalPhone">Phone: ${BookTourData.phone}</p>
                    <p class="col-6" id="modalEmail">Email: ${BookTourData.email}</p>
                    <p class="col-6" id="modalDateBooked">Date Booked: ${BookTourData.date_Booked}</p>
                    <p class="col-6" id="address">Address: ${BookTourData.address}</p>
                    <p class="col-6" id="numberAdults">Số người lớn: ${BookTourData.numberAdults}</p>
                    <p class="col-6" id="numberChildrens">Số trẻ em: ${BookTourData.numberChildren}</p>
                    <p class="col-6" id="numberTreNho">Số trẻ nhỏ: ${BookTourData.numberTreNho}</p>
                    <p class="col-6" id="description">Description: ${BookTourData.description}</p>
                    <p class="col-6" id="modalStatus">Trạng thái: ${BookTourData.statusTourEntity.status_Id}</p>
                    <p class="col-6" id="modalPrice" style="color: red; font-size: 20px">Tổng giá: ${BookTourData.price} đ</p>
                </div>
            </div>
            <div class="qr-section">
                <span>Truy Cập: <em style="color: #ff0000">anhdeveptrai@eptrai.traiep</em> </span>
                <p>Quét để xem các gói du lịch và ưu đãi mới nhất</p>
            </div>
            <div class="thank-you">
                <p>Cảm ơnn đã sử dụng dịch vụ bên chúng tôi <3!</p>
            </div>
        </div>
    </div>`

    let opt = {
        // margin: 1,
        filename: 'BillDatTour.pdf',
        image: { type: 'jpeg', quality: 0.98 },
        // html2canvas: { scale: 2 },
        jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
    };
    let cssLink = document.createElement("link");
    cssLink.href = "/layout-css/BillPdf.css";
    cssLink.rel = "stylesheet";
    document.head.appendChild(cssLink);
    try {
        const pdfBlob = await html2pdf().from(element).set(opt).toPdf().output('blob');

        let fileURL = URL.createObjectURL(pdfBlob);
        window.open(fileURL);

        let formData = new FormData();
        formData.append('file', pdfBlob);
        formData.append('email', email);  // Thêm email vào formData

        let sendPdf = $.Deferred();
        $.post({
            url: "/send-bill-api/SendBillPdf",
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                sendPdf.resolve(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                sendPdf.reject(errorThrown);
            }
        });

    } catch (error) {
        console.error('Error generating PDF:', error);
        throw error;
    }
}

async function updateTourInForm() {
    const updateBookTourData = {
        bookTourId: $("#modalBookTourId").val(),
        price: $("#modalPrice").val(),
        nameUser: $("#modalNameUser").val(),
        phone: $("#modalPhone").val(),
        email: $("#modalEmail").val(),
        description: $("#description").val(),
        date_Booked: $("#modalDateBooked").val(),
        address: $("#address").val(),
        statusTourEntity: {
            status_Id: parseInt($("#modalStatus").val()),
        },
        tourE: {
            tourID: parseInt($("#modalTourId").val()),
        },
    }
    let response = await axios.post('/BookTour/saveBookTour', updateBookTourData);
    await loadDataBookTour();
    createTableBookTour(listAllBookTour);
    console.log(response.data)
    Swal.fire(
        'Cập nhật thành công!',
        'Bạn cập nhật thành công.',
        'success'
    );
}
