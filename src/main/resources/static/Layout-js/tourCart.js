$(document).ready(async function() {
    const tourID = getProductIdFromUrl();
    if (tourID) {
        const tour = await loadDataTourById(tourID);
        createTableTourById(tourDetail);
    }
});

function getProductIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('tourID');
}

let tourDetail = []

async function loadDataTourById(tourID) {
    try {
        let response = await axios.get(`tour-api/getTourByTourID?tourID=${tourID}`);
        tourDetail = response.data.data;
    } catch (error) {
    }
}
function createTableTourById(tour) {

    let populateTypeTourDropdown =
        `
        <div class="row conttop">
            <div class="col-sm-4 mr-3">
                <div class="imgtour w-100">
                    <img src="/images/ImagesTour2/${tour.imageTour}" alt="" style=" width: 100%; height: 245px; /* Optional: Maintain aspect ratio */}">
                </div>
            </div>
            <div class="col-sm-7" style="border: 1px solid rgba(0, 0, 0, 0.2);">
                <div class="info-tour">
                    <h4>
                        <a href="#" style="text-decoration: none; color: #f30383; margin-top: 5px">${tour.nameTour}</a>
                    </h4>
                    <hr>
                    <style>
                        .tour-row {
                            margin-top: 5px;
                        }
                    </style>
                    <div class="tour-info-list" style="font-size: 15px">
                        <div class="row tour-row">
                            <span class="be col-3">Mã tour:</span>
                            <span style="font-weight:600" class="col-9">${tour.tourID}</span>
                        </div>
                        <div class="row tour-row">
                            <span class="be col-3">Thời gian:</span>
                            <span style="font-weight:600" class="col-9">${tour.tourDuration}</span>
                        </div>
                        <div class="row tour-row">
                            <span class="be col-3">Giá:</span>
                            <span style="font-weight: 600" class="col-9">${tour.priceAdult.toLocaleString('vi-VN', { style: 'decimal', minimumFractionDigits: 0 })} đ</span>
                        </div>
                        <div class="row tour-row">
                            <span class="be col-3">Ngày khởi hành:</span>
                            <span style="font-weight:600" class="col-9">${tour.timeStart}</span>
                        </div>
                        <div class="row tour-row">
                            <span class="be col-3">Nơi khởi hành:</span>
                            <span style="font-weight:600" class="col-9">${tour.startPlace}</span>
                        </div>
                        <div class="row tour-row">
                            <span class="be col-3">Số chỗ còn nhận:</span>
                            <span style="font-weight:600" class="col-9">${tour.available} chỗ</span>
                        </div>
                    </div>
                </div>
            </div>
            <ul class="mda-list-design mt-4">
                <li style="list-style: none">
                    <span style="color:#FF0000">Các khoản phí phát sinh (nếu có) như: phụ thu dành cho khách nước ngoài, việt kiều; phụ thu phòng đơn; phụ thu chênh lệch giá tour… Nhân viên Du Lịch Việt sẽ gọi điện thoại tư vấn cho quý khách ngay sau khi có phiếu xác nhận booking. (Trong giờ hành chính)</span>
                </li>
                <li style="text-align:justify; list-style: none">
                    <span style="color:#FF0000">Trường hợp quý khách không đồng ý các khoản phát sinh, phiếu xác nhận booking của quý khách sẽ không có hiệu lực.</span>
                </li>
            </ul>
            <hr style="padding-bottom: 10px; padding-top: 10px">
            <div class="mda-tilte-3"
                 style="padding-bottom: 25px ;text-transform: uppercase; font-size: 30px; justify-content: center; display: flex">
                <span class="mda-tilte-name"><i class="fa fa-tags" aria-hidden="true"></i> Bảng giá tour chi tiết</span>
            </div>
            <table class="mda-table chitiet_gia">
                <tbody>
                <tr>
                    <td><span>Loại giá\\Độ tuổi</span></td>
                    <td>Người lớn(Trên 11 tuổi)</td>
                    <td>Trẻ em(5 - 11 tuổi)</td>
                    <td>Trẻ nhỏ(2 - 5 tuổi)</td>
                    <td>Sơ sinh( &lt; 2 tuổi)</td>
                </tr>
                <tr>
                    <td><span>Giá</span></td>
                    <td><span class="mda-money">${tour.priceAdult.toLocaleString('vi-VN', { style: 'decimal', minimumFractionDigits: 0 }) + ' đ'}</span></td>
                    <td><span class="mda-money">${tour.priceChildren.toLocaleString('vi-VN', { style: 'decimal', minimumFractionDigits: 0 }) + ' đ'}</span></td>
                    <td><span class="mda-money">${tour.priceChildren.toLocaleString('vi-VN', { style: 'decimal', minimumFractionDigits: 0 }) + ' đ'}</span></td>
                    <td><span class="mda-money">0 </span></td>
                </tr>
                <tr>
                    <td><span>Phụ thu Nước Ngoài</span></td>
                    <td><span class="mda-money">690,000 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                </tr>
                <tr style="display:none">
                    <td><span>Phụ thu Việt Kiều</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                </tr>
                <tr style="display:none">
                    <td><span>Giảm giá</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                    <td><span class="mda-money">0 đ</span></td>
                </tr>
                </tbody>
            </table>
            <div class="mda-tilte-3"
                 style="padding-bottom: 25px ;text-transform: uppercase; font-size: 30px; justify-content: center; display: flex">
                <span class="mda-tilte-name"><i class="fa fa-info-circle"
                                                aria-hidden="true"></i> Thông Tin Liên Hệ</span>
            </div>
            <div class="info-calling">
                <div id="mda-guest-b">
                    <div class="row row-calling">
                        <div class="form-group col-md-4">
                            <label>HỌ TÊN *:<span id="bookNameError" class="error"></span></label>
                            <input data-error="#bookNameError" type="text" name="Name" id="lname"
                                   class="form-control input-tracking1" value="" placeholder="Họ tên">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Email *:<span id="bookEmailError" class="error"></span></label>
                            <input data-error="#bookEmailError" type="text" name="Mail" id="email" value=""
                                   class="user-email form-control input-tracking1" placeholder="Email">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Số điện thoại *:<span id="bookPhoneError" class="error"></span></label>
                            <input data-error="#bookPhoneError" type="text" name="Phone" value="" id="phone"
                                   class="form-control numeric input-tracking1" placeholder="Số điện thoại">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Địa chỉ *:<span id="bookAddressError" class="error"></span></label>
                            <textarea data-error="#bookAddressError" type="text" name="AddressShow"
                                      class="form-control input-tracking1" placeholder="Địa chỉ"></textarea>
                        </div>
                        <div class="form-group col-md-8">
                            <label>Ghi chú:</label>
                            <textarea name="Note" class="form-control" placeholder="Ghi chú"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-3">
                            <label>Người lớn:</label>
                            <input type="number" name="QAdult" class="quantity form-control mda-quantity  tour-quantity1 q-adult1" id="quantityAdult"
                                  data-price="${tour.priceAdult}" value="1" min="1" max="20" placeholder="Người lớn"
                                  oninput="updateTotalPrice()">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Trẻ em(5 - 11 tuổi):</label>
                            <input type="number" name="QChild" class="quantity form-control mda-quantity tour-quantity1 q-child1" id="quantityChildren"
                                   data-price="${tour.priceChildren}" min="0" value="0" placeholder="Trẻ em(5 - 11 tuổi)"
                                   oninput="updateTotalPrice()">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Trẻ nhỏ(2 - 5 tuổi):</label>
                            <input type="number" name="QBaby" class="quantity form-control mda-quantity tour-quantity1 q-baby1" id="treNho"
                                   data-price="${tour.priceChildren}" min="0" value="0" placeholder="Trẻ nhỏ(2 - 5 tuổi)"
                                   oninput="updateTotalPrice()">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Sơ sinh(nhỏ hơn 2 tuổi):</label>
                            <input type="number" name="QInfant"
                                   class="form-control mda-quantity tour-quantity1 q-infant1" min="0" value="0"
                                   placeholder="Sơ sinh(nhỏ hơn 2 tuổi)">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <input type="hidden" id="sumary-hidden" value="">
                        <input type="hidden" id="discount-hidden" value="0">
                        <div class="txtTotal" >Tổng giá trị : <span id="totalPrice">0 đ</span><br>
                            <div id="discount-price"></div>
                        </div>
                    </div>
                </div>
            </div>
            <hr style="padding-top: 35px; padding-bottom: 25px">
            <div class="mda-tilte-3"
                 style="padding-bottom: 25px ;text-transform: uppercase; font-size: 30px; justify-content: center; display: flex">
                <span class="mda-tilte-name"><i class="fa fa-money"
                                                aria-hidden="true"></i> Phương thức thanh toán</span>
            </div>
            <div class="payment_options">
                <div class="col-lg-6 payment_option">
                    <input type="radio" name="payment" id="payment_cod" value="COD" checked>
                    <label for="payment_cod">Thanh toán tại quầy Du Lịch Việt</label>
                </div>
                <div class="col-lg-6 payment_option">
                    <input type="radio" name="payment" id="payment_bank" value="BANK">
                    <label for="payment_bank">Thanh toán chuyển khoản qua ngân hàng</label>
                    <div class="payment_description">
                        <p>Quý khách chuyển khoản qua ngân hàng sau:<br>
                            Ngân hàng: <strong>MB BANK</strong>: Tài khoản <strong>22004 2202 9999</strong> – CHI NHÁNH Q12, TPHCM<br>
                            Tên tài khoản:<strong> "LE THANH TUNG"</strong></p>
                        <p>Quý khách vui lòng ghi rõ mã tour, họ tên, địa chỉ, số điện thoại và tên chuyến du lịch, ngày khởi hành cụ thể đã được quý khách chọn đăng ký.<br>
                    </div>
                </div>    

                </div>
            </div>
            <div class="text-center" style="margin-top:10px; margin-bottom: 20px">
                <p>Bằng việc tiếp tục, bạn chấp nhận đồng ý với chính sách/điều khoản như trên.</p>
                <button type="button" onclick="submit()" style="width: 150px; background-color: #66ffff; border: #66ffff; height: 30px"
                        class="btn btn-info" value="HOÀN THÀNH">HOÀN THÀNH
                </button>
            </div>
            <hr style="padding-bottom: 20px; padding-top: 20px">
        </div>
        `;
    $("#TourCard").html(populateTypeTourDropdown);
    updateTotalPrice()
}
function updateTotalPrice() {
    let total = 0;
    $('.quantity').each(function () {
        const price = $(this).data('price');
        const quantity = $(this).val();
        total += price * quantity;
    });
    $('#totalPrice').text(total.toLocaleString('vi-VN', { style: 'decimal', minimumFractionDigits: 0 }) + ' đ');
}

// validate và pdf
async function submit(tour){
    var tenKH = document.getElementById('lname').value;
    var sdt = document.getElementById('phone').value;
    var email = document.getElementById('email').value;
    if (!tenKH) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Tên Khách Hàng là bắt buộc!',
        });
        return;
    }
    if (!sdt) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Số Điện Thoại là bắt buộc!',
        });
        return;
    }
    if (!email) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Email là bắt buộc!',
        });
        return;
    }
    try {

        Swal.fire({
            position: "center",
            icon: "success",
            title: "Đặt tour thành công, đơn hàng của bạn chúng tôi đã gửi về Email của bạn, hãy kiểm tra email nhé",
        });
        await generatePDF();
    } catch (error) {
        console.error('Error generating or sending PDF:', error);
    }

    async function generatePDF() {
        let element = document.getElementById('TourCard');

        let opt = {
            margin: 1,
            filename: 'BillDatTour.pdf',
            image: { type: 'jpeg', quality: 0.98 },
            html2canvas: { scale: 2 },
            jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
        };
        try {
            const pdfBlob = await html2pdf().from(element).set(opt).toPdf().output('blob');
            const pdfUrl = URL.createObjectURL(pdfBlob);
            window.open(pdfUrl);

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
            // let pdfResponse = await sendPdf.promise();

            // if (pdfResponse.ok) {
            //     console.log('File PDF đã được gửi thành công!');
            //
            //     let sendPayment = $.Deferred();
            //     $.post({
            //         url: "/upload-pdf-api/uploadPDF",
            //         data: { email: email },
            //         success: function (data) {
            //             sendPayment.resolve(data);
            //         },
            //         error: function (jqXHR, textStatus, errorThrown) {
            //             sendPayment.reject(errorThrown);
            //         }
            //     });
            //     let paymentResponse = await sendPayment.promise();
            //     console.log(paymentResponse);
            // } else {
            //     console.error('Có lỗi xảy ra khi gửi file PDF.');
            // }
        } catch (error) {
            console.error('Error generating PDF:', error);
            throw error;
        }
    }
}

