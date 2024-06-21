Logout = () => {
    Swal.fire({
        title: "Bạn Muốn Đăng Xuất Về Trang?",
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: "Đăng Nhập",
        denyButtonText: `Trang Chủ`
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            Swal.fire({
                position: "center",
                icon: "success",
                title: "Về Trang Đăng Nhập Thành Công",
                showConfirmButton: false,
                timer: 1500
            }).then(() => {
                localStorage.removeItem('account')
                window.location.href = '/logout'
            });
        } else if (result.isDenied) {
            Swal.fire({
                position: "center",
                icon: "success",
                title: "Về Trang Chủ Thành Công",
                showConfirmButton: false,
                timer: 1500
            }).then(() => {
                window.location.href='/home'
            });
        }
    });
}