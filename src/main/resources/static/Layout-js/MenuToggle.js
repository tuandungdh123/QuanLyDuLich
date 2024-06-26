 function menuToggle(){
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active')
}

 $(document).ready(function() {
     let accountData = localStorage.getItem('account');
     if (accountData) {
         accountData = JSON.parse(accountData);
         let phone = accountData.phone;
         $('#phoneUser').text(phone);
         let accountUser = accountData.accountName;
         $('#accountUser').text(accountUser);
         let email = accountData.email;
         $('#emailUser').text(email);
     } else {
         console.log('No account data found in localStorage.');
     }
 });