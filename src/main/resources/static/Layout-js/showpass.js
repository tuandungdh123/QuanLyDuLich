function btnShowPassword(){
    let element = $(`#password`)
    let toggle = $(`#toggleShowPassword`)
    if (element.prop('type') === 'password') {
        element.prop('type', 'text')
        toggle.removeClass('fa-solid fa-eye-slash').addClass('fa-solid fa-eye')
    } else {
        element.prop('type', 'password')
        toggle.removeClass('fa-solid fa-eye').addClass('fa-solid fa-eye-slash')
    }
}
function btnShowRepeatPassword(){
    let element = $(`#repeatPassword`)
    let toggle = $(`#toggleShowPassword2`)
    if (element.prop('type') === 'password') {
        element.prop('type', 'text')
        toggle.removeClass('fa-solid fa-eye-slash').addClass('fa-solid fa-eye')
    } else {
        element.prop('type', 'password')
        toggle.removeClass('fa-solid fa-eye').addClass('fa-solid fa-eye-slash')
    }
}