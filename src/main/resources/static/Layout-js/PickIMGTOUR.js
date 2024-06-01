//Chọn ảnh trong QLTour
// Thêm sự kiện 'change' cho input
document.getElementById('image-input').addEventListener('change', function(event) {
    const file = event.target.files[0]; // Lấy tệp đầu tiên trong danh sách tệp
    if (file) {
        const reader = new FileReader(); // Tạo đối tượng FileReader
        reader.onload = function(e) {
            // Khi tệp đã được đọc xong, đặt URL của tệp vào src của thẻ img
            const imgElement = document.getElementById('image-preview');
            imgElement.src = e.target.result;
            imgElement.style.display = 'block'; // Hiển thị ảnh sau khi chọn
            document.getElementById('image-input').style.display = 'none'; // Ẩn nút chọn ảnh
        };
        reader.readAsDataURL(file); // Đọc tệp dưới dạng URL dữ liệu (Data URL)
    }
});