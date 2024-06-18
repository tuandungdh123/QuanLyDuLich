
$(document).ready(async function (){
    await DataProductTour();
    createTableProductsTour(productsTour);
})

async function DataProductTour(){
    try {
        let response = await axios.get(`/home/tour-api/getAllTour`);
        productsTour = response.data.data;
        console.log(productsTour);
    } catch (error) {
        console.error("Error loading tours:", error);
    }
}
    function createTableProductsTour(productsTour){
        let bodyProductTourString = '';

        productsTour.forEach(function (product) {
            bodyProductTourString +=
                `<div class="col-md-4 col-sm-6 col-xs-12 tour-item mt-3">
                    <div class="wap-items-ss brbox">
                        <div class="item">
                            <div class="mda-box-item">
                                <div class="mda-box-img">
                                    <a href="/tour?tourID=${product.tourID}">
                                        <img class="lazyload" alt="" src="/images/ImagesTour2/${product.imageTour}"
                                             style="display: block;">
                                    </a>
                                    <div class="mda-box-lb">${product.startPlace}</div>
                                </div>
                                <div class="mda-caption">
                                    <div class="mda-info mda-grid">
                                        <h3 class="mda-name" ><a href="#" >${product.nameTour}</a></h3>
                                        <div class="mda-img-box-wrap">
                                            <p class="mda-time-grid">Lịch trình: ${product.tourDuration}</p>
                                            <p class="mda-schedule">Khởi hành: ${product.timeStart}</p>
                                            <p class="mda-place">Số chỗ còn nhận: ${product.available} <span
                                                class="contact">Liên hệ</span></p>
                                            <p class="mda-price mda-distcoun">
                                                <span class="mda-dis">${product.priceAdult.toLocaleString('vi-VN', { style: 'decimal', minimumFractionDigits: 0 })}đ</span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>`
        })
        $("#productsTour").html(bodyProductTourString);
    }

// Tour Mien Bac
