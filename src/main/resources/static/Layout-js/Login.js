document.getElementById('Loginform').addEventListener('submit', function (event){
   event.preventDefault();
   var username = document.getElementById('username').value;
   var password = document.getElementById('password').value;
   var isValid = true;
   document.getElementById('usernameError').textContent='';
   document.getElementById('passwordError').textContent='';
   if(username ===''){
       document.getElementById('usernameError').textContent='Vui lòng nhập tài khoản';
       isValid = false;
   }
    if(password ===''){
        document.getElementById('passwordError').textContent='Vui lòng nhập mật khẩu';
        isValid = false;
    }
    if(isValid){
        Swal.fire("Đăng nhập thành công!");
    }
});