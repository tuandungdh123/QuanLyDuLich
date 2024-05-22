var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7'],
        datasets: [{
            label: 'Lượng người truy cập vào trang web',
            data: [65, 59, 80, 81, 56, 55, 40],
            borderColor: 'rgba(255, 99, 132, 1)',
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            borderWidth: 1
        }]
    },
    options: {
        responsive: false, // Tắt tính năng phản ứng để biểu đồ không thay đổi kích thước
        maintainAspectRatio: false // Tắt việc duy trì tỷ lệ khung hình để canvas có thể thay đổi kích thước
    }
});