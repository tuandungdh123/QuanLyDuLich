var listAllTour = []
async function saveTourInForm() {
    // Lấy dữ liệu từ các trường nhập liệu
    const nameTour = $("#nameTour").val();
    const imageTour = $("#imageInput").val().split('\\')[2];
    const type_Id = parseInt($("#type_Id").val());
    const tourDuration = $("#TimeTravel").val();
    const timeStart = $("#Start").val();
    const transport = $("#Transport").val();
    const startPlace = $("#StartPlace").val();
    const priceAdult = parseInt($("#Price").val());
    const priceChildren = parseInt($("#PriceEm_Children").val());
    const description = $("#Note").val();
    const available = parseInt($("#Slot").val());
    const experience = $("#Experience").val();
    // Kiểm tra xem có trường nào rỗng không
    if (!nameTour || !imageTour || !type_Id || !tourDuration || !timeStart || !transport || !startPlace || !priceAdult || !priceChildren || !description || !available) {
        // Hiển thị cảnh báo nếu có trường trống
        Swal.fire({
            icon: 'error',
            title: 'Thêm không thành công...',
            text: 'Vui Lòng điền đầy đủ thông tin!',
        });
        return; // Dừng lại nếu có trường trống
    }
    // Nếu không có trường nào rỗng, tiếp tục thực hiện lưu dữ liệu
    const TourData = {
        nameTour: nameTour,
        imageTour: imageTour,
        typeTourE: {
            type_Id: type_Id
        },
        tourDuration: tourDuration,
        timeStart: timeStart,
        transport: transport,
        startPlace: startPlace,
        priceAdult: priceAdult,
        priceChildren: priceChildren,
        description: description,
        available: available,
        experience: experience
    };
    console.log(TourData)

    Swal.fire({
        title: 'Lưu Tour Này Chứ?',
        text: 'Bạn có chắn chắn là lưu Tour này?',
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Chắc, lưu Tour này!',
        cancelButtonText: 'Cancel'
    }).then(async (result) => {
        if (result.isConfirmed) {
            try {
                let response = await axios.post('/home/tour-api/getSaveTour', TourData);
                await upLoadFile();
                await loadDataTour();
                createTableTourByTypeTour(listAllTour);
                clearForm(); // Xóa form sau khi lưu thành công
                Swal.fire(
                    'Lưu Thành Công!',
                    'Đã lưu tour thành công.',
                    'success'
                );
            } catch (error) {
                console.error("Error saving tour:", error);
                Swal.fire(
                    'Error!',
                    'An error occurred while saving the tour.',
                    'error'
                );
            }
        }
    });
}

//Update
async function updateTourInForm() {
    const updateTourData = {
        tourID: $("#TourID").val(),
        nameTour: $("#nameTour").val(),
        imageTour : $("#imageInput").val().split('\\')[2],
        typeTourE: {
            type_Id: parseInt($("#type_Id").val())
        },
        tourDuration: $("#TimeTravel").val(),
        timeStart: $("#Start").val(),
        transport: $("#Transport").val(),
        startPlace: $("#StartPlace").val(),
        priceAdult: parseInt($("#Price").val()),
        priceChildren: parseInt($("#PriceEm_Children").val()),
        decription: $("#Note").val(),
        available: parseInt($("#Slot").val()),
        experience: $("#Experience").val()
    }
    let response = await axios.post('/home/tour-api/getSaveTour', updateTourData);
    await upLoadFile();
    await loadDataTour();
    createTableTourByTypeTour(listAllTour);
    Swal.fire(
        'Cập nhật thành công!',
        'Bạn cập nhật thành công.',
        'success'
    );
}

//Edit
async function getTourToForm(tourID) {
    let response = await axios.get(`/home/tour-api/getTourByTourID?tourID=${tourID}`);
    let result = response.data;
    if (result.status) {
        fillTourForm(result.data)
    }
}

function fillTourForm(tourDetail) {
    $("#TourID").val(tourDetail.tourID);
    $("#nameTour").val(tourDetail.nameTour);
    $('#image-preview').attr('src', '/images/imagesTour2/' + tourDetail.imageTour);

    fetch('/images/imagesTour2/' + tourDetail.imageTour)
        .then(res => res.blob())
        .then(blob => {
            const dataTransfer = new DataTransfer();
            const file = new File([blob], tourDetail.imageTour, { type: blob.type });
            dataTransfer.items.add(file);
            $("#imageInput")[0].files = dataTransfer.files;
        })
        .catch(error => {
            console.error('Error:', error);
        });

    $("#type_Id").val(tourDetail.typeTourE.type_Id);
    $("#TimeTravel").val(tourDetail.tourDuration);
    $("#Start").val(tourDetail.timeStart);
    $("#Transport").val(tourDetail.transport);
    $("#StartPlace").val(tourDetail.startPlace);
    $("#Price").val(tourDetail.priceAdult);
    $("#PriceEm_Children").val(tourDetail.priceChildren);
    $("#Note").val(tourDetail.decription);
    $("#Slot").val(tourDetail.available);
    $("#Experience").val(tourDetail.experience);


}

//Delete
async function deleteTourByID(TourData) {
    try {
        let response = await axios.delete(`/home/tour-api/getDeleteTour?tourID=${TourData.tourID}`);
        let result = response.data;
        if (result.status) {
            //
            await loadDataTour();
            createTableTourByTypeTour(listAllTour);
            //
        } else {
        }
    } catch (error) {
    }
}

document.getElementById("deleteBtn").addEventListener("click", function () {
    const TourData = {
        tourID: $("#TourID").val(),
    }
    deleteTourByID(TourData);
});

//Clear Form
function clearForm() {
    $("#TourID").val("");
    $("#nameTour").val("");
    $("#imageInput").val("");
    $("#type_Id").val("");
    $("#TimeTravel").val("");
    $("#Start").val("");
    $("#Transport").val("");
    $("#StartPlace").val("");
    $("#Price").val("");
    $("#Note").val("");
    $("#Slot").val("");
    $("#Experience").val("");

}

//Loc tour theo typeTour va fill data len table
$(document).ready(async function () {
    await loadDataTour();
    createTableTourByTypeTour(listAllTour); // Gọi hàm createTableTour sau khi loadDataTour đã hoàn tất
    createTableTourByTypeTour2(listAllTour); // Gọi hàm createTableTour2 sau khi loadDataTour đã hoàn tất

    // Thêm sự kiện cho dropdown để lọc danh sách tour khi thay đổi lựa chọn
    $("#TypeTour").on("change", function () {
        let selectedType = $(this).val();
        let filteredTours = filterToursByType(listAllTour, selectedType);
        createTableTourByTypeTour(filteredTours);
    });
    $("#helloAccount").text("Xin Chào," + localStorage.getItem("account")+ "!")
});

function createTableTourByTypeTour(addToTable) {
    let populateTypeTourDropdown = '';

    addToTable.forEach(function (e, index) {
        const today = new Date();
        today.setHours(0, 0, 0, 0); // Đặt thời gian hiện tại về 0 giờ để so sánh chính xác
        if ($.fn.dataTable.isDataTable('#paginationTour')) {
            $('#paginationTour').DataTable().destroy();
        }

        const tourStartDate = new Date(e.timeStart);
        tourStartDate.setHours(0, 0, 0, 0); // Đặt thời gian của ngày bắt đầu tour về 0 giờ để so sánh chính xác
        if (tourStartDate >= today) {
            populateTypeTourDropdown +=
                `<tr>` +
                `<td>${index + 1}</td>` +
                `<td>${e.nameTour}</td>` +
                `<td>${e.imageTour}</td>` +
                `<td>${e.typeTourE.type_Name}</td>` +
                `<td>${e.tourDuration}</td>` +
                `<td>${e.timeStart}</td>` +
                `<td>${e.transport}</td>` +
                `<td>${e.startPlace}</td>` +
                `<td>${e.priceAdult}</td>` +
                `<td>${e.available}</td>` +
                `<td>` +
                `<button type="button" class="btn btn-outline-success" onclick="getTourToForm(${e.tourID})">Edit</button>` +
                `</td>` +
                `</tr>`;
        }
    });
    $("#BodyListAllTour").html(populateTypeTourDropdown);
    // Phá hủy bảng DataTable nếu đã tồn tại và khởi tạo lại
    // if ($.fn.DataTable.isDataTable('#paginationTour')) {
    //     $('#paginationTour').DataTable().destroy();
    // }
    let table = new DataTable('#paginationTour',{
        searching :  false,
        info: false,
        paging: true,
        ordering: false,
        lengthMenu:[4]
    });
    $('.dt-length').hide();
}

    /*Tour Qúa hạn*/
     function createTableTourByTypeTour2(addToTable) {
         let populateTypeTourDropdown2 = '';

         addToTable.forEach(function (e, index) {
             const today = new Date();
        today.setHours(0, 0, 0, 0); // Đặt thời gian hiện tại về 0 giờ để so sánh chính xác
        // if ($.fn.dataTable.isDataTable('#paginationTour2')) {
        //         $('#paginationTour').DataTable().destroy();
        //      }
             const tourStartDate = new Date(e.timeStart);
             tourStartDate.setHours(0, 0, 0, 0); // Đặt thời gian của ngày bắt đầu tour về 0 giờ để so sánh chính xác
             if (tourStartDate < today) {
                 populateTypeTourDropdown2 +=
                     `<tr>` +
                    `<td>${index + 1}</td>` +
                     `<td>${e.nameTour}</td>` +
                     `<td>${e.imageTour}</td>` +
                     `<td>${e.typeTourE.type_Name}</td>` +
                     `<td>${e.tourDuration}</td>` +
                     `<td>${e.timeStart}</td>` +
                     `<td>${e.transport}</td>` +
                     `<td>${e.startPlace}</td>` +
                     `<td>${e.priceAdult}</td>` +
                     `<td>${e.available}</td>` +
                     `<td>` +
                     `<button type="button" class="btn btn-outline-success" onclick="getTourToForm(${e.tourID})">Edit</button>` +
                     `</td>` +
                     `</tr>`;
             }
         });
         $("#BodyListAllTour2").html(populateTypeTourDropdown2);
         // Phá hủy bảng DataTable nếu đã tồn tại và khởi tạo lại
         if ($.fn.DataTable.isDataTable('#paginationTour2')) {
             $('#paginationTour').DataTable().destroy();
         }
       let table = new DataTable('#paginationTour', {
          searching: false,
            info: false,
            paging: true,
            ordering: false,
           lengthMenu: [4]
        });
    $('.dt-length').hide();
    }

async function loadDataTour() {
    try {
        let response = await axios.get(`/home/tour-api/getAllTour`);
        listAllTour = response.data.data;
    } catch (error) {
    }
}

function filterToursByType(tours, type_Id) {
    if (!type_Id) return tours; // Nếu không chọn loại nào, trả về toàn bộ danh sách
    return tours.filter(tour => tour.typeTourE.type_Id === parseInt(type_Id));
}

async function upLoadFile() {
    var formData = new FormData();
    var fileInput = $('#imageInput')[0];

    // Kiểm tra xem đã chọn file chưa
    if (fileInput.files.length === 0) {
        return;
    }

    formData.append('file', fileInput.files[0]);

    let response = await axios.post('/upload-api/upload', formData, {})
        .then(function (response) {
        })
        .catch(function (error) {
        });
}