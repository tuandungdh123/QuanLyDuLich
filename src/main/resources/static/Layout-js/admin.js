document.addEventListener('DOMContentLoaded', function() {
    var widget = document.getElementById('weather-widget');

    if (widget) {
        var widgetType = widget.getAttribute('data-widget');
        var location = widget.getAttribute('data-location');

        console.log('Widget Type:', widgetType);
        console.log('Location:', location);

        // Giả sử có một hàm fetchWeather để lấy thông tin thời tiết
        fetchWeather(location).then(function(temp) {
            document.getElementById('temperature').textContent = temp + '°C';
        });
    }
});

function fetchWeather(location) {
    // Hàm giả lập việc lấy thông tin thời tiết
    return new Promise(function(resolve) {
        setTimeout(function() {
            resolve(25); // Giả sử nhiệt độ là 25°C
        }, 1000);
    });
}