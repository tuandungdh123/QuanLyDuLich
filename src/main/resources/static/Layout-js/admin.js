
class ThongKe {
    dataBarChart = {}
    BarChart = null;
    dataPolarArea = {}
    PolarArea = null;
    loadInit = () => {

    }
    getDataPolarArea = async () => {

        let {data: response} = await axios.get('/thongke-api/getCountTour')
        if (!response.success) {
            Swal.fire({
                title: response.message,
                icon: 'error',
                showConfirmButton: false,
                timer: 1500
            })
            return
        }
        if (!response.data) {
            Swal.fire({
                title: 'Không tìm thấy dữ liệu',
                icon: 'error',
                showConfirmButton: false,
                timer: 1500
            })
            return
        }
        this.dataPolarArea = {
            "Du Lịch Miền Bắc": response.data.tour1,
            "Du Lịch Miền Trung": response.data.tour2,
            "Du Lịch Miền Nam": response.data.tour3,
            "Du Lịch cả nước": response.data.tour4,
            "Du Lịch Miền Tây": response.data.tour5,

        }
        this.createPolarAreaChart()
    }

    createPolarAreaChart = () => {
        let polarChart = $('#polarAreaChart');
        if (this.PolarArea) {
            this.PolarArea.destroy();
        }
        const data = {
            labels: Object.keys(this.dataPolarArea),
            datasets: [{
                label: 'Quản Lý Tour',
                data: Object.values(this.dataPolarArea),
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(75, 192, 192)',
                    'rgb(255, 205, 86)',
                    'rgb(201, 203, 207)',
                    'rgb(54, 162, 235)'
                ]
            }]
        };
        const config = {
            type: 'polarArea',
            data: data,
            options: {
                scales: {
                    r: {
                        ticks: {
                            stepSize: 0.5,
                        }
                    }
                }
            }
        };
        this.PolarArea = new Chart(polarChart, config);
    }

    getDataChart = async () => {

        let {data: response} = await axios.get('/thongke-api/getCountRole')
        if (!response.success) {
            Swal.fire({
                title: response.message,
                icon: 'error',
                showConfirmButton: false,
                timer: 1500
            })
            return
        }
        if (!response.data) {
            Swal.fire({
                title: 'Không tìm thấy dữ liệu',
                icon: 'error',
                showConfirmButton: false,
                timer: 1500
            })
            return
        }
        this.dataBarChart = {
            Admin: response.data.soLuongRole1,
            User: response.data.soLuongRole2

        }
        this.createBarChart()
    }
    createBarChart = () => {
        let barChart = $('#barChart')
        if (this.BarChart) {
            this.BarChart.destroy()
        }
        this.BarChart = new Chart(barChart, {
            type: 'bar',
            data: {
                labels: Object.keys(this.dataBarChart),
                datasets: [{
                    label: 'Quản Lý Tài Khoản',
                    data: Object.values(this.dataBarChart),
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 205, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(201, 203, 207, 0.2)'
                    ],
                    borderColor: [
                        'rgb(255, 99, 132)',
                        'rgb(255, 159, 64)',
                        'rgb(255, 205, 86)',
                        'rgb(75, 192, 192)',
                        'rgb(54, 162, 235)',
                        'rgb(153, 102, 255)',
                        'rgb(201, 203, 207)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            stepSize: 1,

                        }
                    }
                }
            }
        });
    }
}