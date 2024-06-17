$(document).ready(async function (){
    await DataProductsHotel();
    createTableProductsHotel(productsHotel);
})

let productsHotel = []

async function DataProductsHotel(){
    try{
        let response = await axios.get("/hotel-api/getAllHotel");
        productsHotel = response.data.data;
    }
    catch (error){
        console.error("Error loading Hotel:",error);
    }
}
function createTableProductsHotel(productsHotel) {
    let bodyProductsHotelString='';
    productsHotel.forEach(function (product) {
        bodyProductsHotelString +=
            `<!-- Hotel 1 -->
                <div class="col-sm-12 hotel w-100">
                    <div class="img">
                        <a href="">
                            <img src="/images/ImagesHotel/${product.imageHotel}"
                                 alt="" class="mCS_img_loaded">
                        </a>
                    </div>
                    <div class="caption">
                        <div class="tend">
                            <h3 style="height: 50px">${product.hotelName}</h3>
                        </div>
                        <div class="price">
                            Giá : <span>Liên hệ</span>
                        </div>
                    </div>
                </div>
`
    })
    $("#productsHotel").html(bodyProductsHotelString);$("#productsHotel2").html(bodyProductsHotelString);

    this.SlickSlide();
}
SlickSlide = () => {
    $('.filtering').slick({
        slidesToShow:3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 800,
        arrows: true,
        speed: 3000
    });

    var filtered = false;
    $('.js-filter').on('click', function () {
        if (filtered === false) {
            $('#productsHotel').slick('slickFilter', ':even');
            $(this).text('Unfilter Slides');
            filtered = true;
        } else {
            $('#productsHotel').slick('slickUnfilter');
            $(this).text('Filter Slides');
            filtered = false;
        }
    });
}



