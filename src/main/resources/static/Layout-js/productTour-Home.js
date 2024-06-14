$(document).ready(async function (){
    await loadDataTourMienBac();
    createTableProductsTourMienBac(listAllTourMienBac);
})
let listAllTourMienBac = []
async function loadDataTourMienBac() {
    try {
        let response = await axios.get(`/tour-api/getTourByTypeID?type_ID=1`);
        listAllTourMienBac = response.data.data;
    } catch (error) {
        console.error("Error loading tours:", error);
    }
}

function createTableProductsTourMienBac(productsTourMienBac) {
    let bodyProductTourMienBacString = '';

    productsTourMienBac.forEach(function (product) {
        bodyProductTourMienBacString +=
            `<div class="col-md-12 col-sm-12 col-xs-12">
                <div class="row">
                    <div class="wap-items-ss brbox">
                        <div class="owl-item active" style="250pxwidth: auto; margin-right: 5px;">
                            <div class="item">
                                <div class="mda-box-item">
                                    <div class="mda-box-img">
                                        <a href="/tour?tourID=${product.tourID}">
                                            <img class="lazyload" alt="" src="/images/ImagesTour2/${product.imageTour}" style="display: block; height: ">
                                        </a>
                                        <div class="mda-box-lb">Từ Hồ Chí Minh</div>
                                    </div>
                                    <div class="mda-caption">
                                        <div class="mda-info mda-grid">
                                            <h3 class="mda-name"><a href="#">${product.nameTour}</a></h3>
                                            <div class="mda-img-box-wrap">
                                                <p class="mda-time-grid">Lịch trình: ${product.tourDuration}</p>
                                                <p class="mda-schedule">Khởi hành: ${product.timeStart}</p>
                                                <p class="mda-place">Số chỗ còn nhận: ${product.available}</p>
                                                <p class="mda-price mda-distcoun">
                                                    <span class="mda-dis">${product.priceAdult.toLocaleString('vi-VN')}đ</span></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>`
    });
    $("#TourMienBac").html(bodyProductTourMienBacString);
    this.addSlickToSlide()
}
addSlickToSlide = () => {
    $('.filtering').slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        arrows: true,
        speed: 3000
    });

    var filtered = false;

    $('.js-filter').on('click', function () {
        if (filtered === false) {
            $('#TourMienBac').slick('slickFilter', ':even');
            $(this).text('Unfilter Slides');
            filtered = true;
        } else {
            $('#TourMienBac').slick('slickUnfilter');
            $(this).text('Filter Slides');
            filtered = false;
        }
    });
}
