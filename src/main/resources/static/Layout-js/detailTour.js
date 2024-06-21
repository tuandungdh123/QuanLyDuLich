$(document).ready(async function(){
    const tourID = getProductIdFromUrl();
    if (tourID) {
        const tour = await loadDataTourById(tourID);
        createTableTourById(tourDetail);
    }
})

function getProductIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('tourID');
}

let tourDetail = []

async function loadDataTourById(tourID) {
    try {
        let response = await axios.get(`/home/tour-api/getTourByTourID?tourID=${tourID}`);
        tourDetail = response.data.data;
    } catch (error) {
    }
}
function createTableTourById(tour) {

    let populateTypeTourDropdown =
            `
                <div class="wrapper">
            <div class="TourTiTle">
            <h1 style="font-size: 28px">${tour.nameTour}</h1>
            </div>
            <div class="row mod-content ">
                <div id="ntv-main" class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                    <div id="vnt-slide-thumbnail" class="slick-init slick-initialized slick-slider">
                        <div class="slick-list draggable">
                            <div class="slick-track" style="opacity: 1; width: 820px;">
                                <div class="slick-slide slick-current slick-active" data-slick-index="0"
                                     aria-hidden="false"
                                     style="width: 820px; position: relative; left: 0px; top: 0px; z-index: 999; opacity: 1;">
                                    <div>
                                        <div class="item" style="width: 100%; display: inline-block;">
                                            <div class="img" style="width: 800px; height: 400px">
                                                <img class="w-100 h-100" src="/images/imagesTour2/${tour.imageTour}" alt="dungdaubui">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-tour">
                        <div class="title" bis_skin_checked="1" style="margin-top: 20px">
                            <div class="title-diemnhan">
                                <i class="fa-solid fa-info"></i>
                                <span class="diemnhan-title"> <strong> Điểm nhấn hành trình </strong></span>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <table>

                        <tbody>
                        <tr>
                            <td style="width: 15%;">
                                <span style="color:#555555;">
                                    <strong>Hành trình</strong>
                                </span>
                            </td>
                            <td>
                                <span style="color:#555555;">
                                    <strong>${tour.nameTour}</strong>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span style="color:#555555;">
                                    <strong>Lịch trình</strong>
                                </span>
                            </td>
                            <td>
                                <span style="color:#555555;">
                                    <strong>${tour.tourDuration}</strong>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span style="color:#555555;">
                                    <strong>Khởi hành</strong>
                                </span>
                            </td>
                            <td>
                                <strong>
                                    <span style="color:#555555;">${tour.timeStart}</span>
                                </strong>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span style="color:#555555;">
                                    <strong>Vận chuyển</strong>
                                </span>
                            </td>
                            <td>
                                <span style="color:#555555;">
                                    <strong>${tour.transport}</strong>
                                </span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <p style="text-align: justify; margin-top: 15px ">
                        <em>
                            <a href="#"><strong>${tour.nameTour}</strong>
                            </a>${tour.decription}
                        </em>
                    </p>
                </div>
                <div id="vnt-sidebar" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 hidden-sm hidden-xs">
                    <div class="boxDesign1">
                        <div class="name">${tour.nameTour}
                        </div>
                        <hr>
                        <div class="attr">
                            <ul>
                                <li>
                                    <div class="at">Mã tour:</div>
                                    <div class="as">${tour.tourID}</div>
                                </li>
                                <hr>
                                <li>
                                    <div class="at">Thời gian:</div>
                                    <div class="as">${tour.tourDuration}</div>
                                </li>
                                <hr>
                                <li>
                                    <div class="at">Khởi hành:</div>
                                    <div class="as">${tour.timeStart}
                                    </div>
                                </li>
                                <hr>
                                <li>
                                    <div class="at">Vận Chuyển:</div>
                                    <div class="as">${tour.transport}</div>
                                </li>
                                <hr>
                                <li>
                                    <div class="at">Xuất phát:</div>
                                    <div class="as">${tour.startPlace}</div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="detail mnfixed_wrap" >
                        <div class="mnfixed_self">
                            <div class="boxFix">
                                <div class="boxPrice">
                                    <div class="price">
                                        <div class="txt">Giá từ:</div>
                                        <div class="red" id="giactt">${tour.priceAdult.toLocaleString('vi-VN')} đ</div>
                                    </div>
                                    <div class="attr">
                                        <p><strong>Điểm Nổi Bật:</strong></p>
                                        <ul>
                                            <li>${tour.experience}</li>
                                       
                                        </ul>
                                     
                                    </div>
                                    <div class="bot">
                                        <div class="form-group">
                                            <input type="text" name="dDate" id="dDate"
                                                   class="form-control bg-white dDate date-readonly dropdown-toggle"
                                                   value="24-05-2024" readonly="">
                                        </div>
                                        <div class="btn-booking dt">
                                            <button type="button" class="btn-order-tour" onclick="window.location.href='/home/tourCart?tourID=${tour.tourID}'">ĐẶT TOUR</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            `;
    $("#TourDetail").html(populateTypeTourDropdown);
}