
    $(document).ready(async function(){
       await DataCar();
       createTableCar(listCar);
    })
    let listCar =[]
    async function DataCar(){
    try{
        let response = await axios.get(`/car-api/getAllCar`);
        listCar = response.data.data;
        console.log(listCar);
    }catch (error) {
        console.error("Error loading Car: ", error);
    }
}

    function createTableCar(listCar){
        let bodyCarRentalString = '';
        listCar.forEach(function (productCar){
            bodyCarRentalString +=
                `<div class="col-4 mt-3">
                    <div class="Car">
                        <div class="card" style="width: 20rem;">
                            <div class="card-image-container">
                            <a href="CarDetail"><img src=" /images/xe/${productCar.imageCar}" alt="Car 6" class="card-image"></a>
                                <a href="LienHeXe" class="contact-button">LIÊN HỆ</a>
                            </div>
                            <div class="card-body">
                            <div class="row">
                                <h3>DỊCH VỤ THUÊ XE ${productCar.carManufacturer} ${productCar.carModel} </h3>
                            
                            </div>
                                <p class="car-details">
                                    <i class="fa-solid fa-car"></i> ${productCar.carManufacturer} |
                                    <i class="fa-solid fa-people-line"></i> ${productCar.numberSeat} chỗ |
                                    <i class="fa-solid fa-circle-info"></i><a href="#" class="details-link"> Chi tiết</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>`
        })
        console.log(listCar)
        $("#productsCar").html(bodyCarRentalString);
    }
