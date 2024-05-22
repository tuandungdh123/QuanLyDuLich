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
    return new Promise(function (resolve) {
        setTimeout(function () {
            resolve(25); // Giả sử nhiệt độ là 25°C
        }, 1000);
    });

        document.getElementById('searchInput').addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
        event.preventDefault();
        performSearch();
    }
    });

        document.getElementById('searchButton').addEventListener('click', function() {
        performSearch();
    });

        function performSearch() {
        const query = document.getElementById('searchInput').value;
        if (query) {
        // Giả sử đây là kết quả tìm kiếm từ một cơ sở dữ liệu hoặc API
        const results = [
        `Kết quả cho "${query}":`,
        `Kết quả 1 cho ${query}`,
        `Kết quả 2 cho ${query}`,
        `Kết quả 3 cho ${query}`
        ];

        displayResults(results);
    }
    }

        function displayResults(results) {
        const resultsDiv = document.getElementById('searchResults');
        resultsDiv.innerHTML = ''; // Xóa kết quả trước đó
        results.forEach(result => {
        const resultItem = document.createElement('div');
        resultItem.textContent = result;
        resultsDiv.appendChild(resultItem);
    });
    }

}