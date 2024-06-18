logout = () => {
    Swal.fire({
        title: "Bạn Muốn Đăng Xuất?",
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: "Yes",
        denyButtonText: `No`
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                icon: "success",
                title: "Đăng Xuất Thành Công!",
                showConfirmButton: false,
                timer: 1500
            }).then(() => {
                window.location.href = '/login'
            });

        }
    });
}