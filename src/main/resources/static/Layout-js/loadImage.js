// Lấy các phần tử từ DOM
const imageInput = document.getElementById('imageInput');
const imagePreview = document.getElementById('image-preview');

// Hàm xử lý khi có lỗi xảy ra với thẻ img
function onError(event) {
    event.target.src = '/images/.png'; // Đặt đường dẫn tới ảnh mặc định
}

// Lắng nghe sự kiện thay đổi của input
imageInput.addEventListener('change', function(event) {
    const file = event.target.files[0]; // Lấy tệp được chọn
    if (file) {
        const reader = new FileReader();
        // Lắng nghe sự kiện load của FileReader
        reader.onload = function(e) {
            imagePreview.src = e.target.result; // Đặt src của img là kết quả đọc được
        };

        // Đọc tệp dưới dạng URL
        reader.readAsDataURL(file);
    }

    // onError = (e) => {
    //     e.target.src = '/images/img.png'
    // }
});