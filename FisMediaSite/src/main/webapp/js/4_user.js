function loginHandle(){
    var loginForm = $("#loginForm");
    var fisLoader = $(".fis-loader");
    fisLoader.hide();
    loginForm.validate({
        rules:{
            username: errorMessages.rules.username,
            password: errorMessages.rules.password
        },
        messages:{
            username: errorMessages.messages.username,
            password: errorMessages.messages.password
        },
        errorClass: "fis-error",
        submitHandler: function(form){
            fisLoader.show();

            $.ajax({
                url: form.action,
                type: form.method,
                dataType: 'json',
                data: $(form).serialize(),
                success: function(res, status){
                    console.log(res);
                    fisLoader.hide();
                    if(res.result == "login"){
                        loginForm.find(".fis-login-title")
                            .append("<label class='fis-error'>Wrong User Name or Password</label>");
                    }else{
                        window.location.replace("http://localhost:8080/FisMediaSite/profile?username=" + res.username);
                    }
                }
            });
        }
    });
}

function signupHandle(){
    var signUpForm = $("#loginSignUp");
    var fisLoader = $(".fis-loader");
    fisLoader.hide();
    signUpForm.validate({
        rules:{
            username: errorMessages.rules.username,
            password: errorMessages.rules.password,
            confirmPassword: errorMessages.rules.confirmPassword,
            fullName: errorMessages.rules.fullName
        },
        messages:{
            username: errorMessages.messages.username,
            password: errorMessages.messages.password,
            confirmPassword: errorMessages.messages.confirmPassword,
            fullName: errorMessages.messages.fullName
        },
        errorClass: "fis-error",
        submitHandler: function(form){
            fisLoader.show();

            $.ajax({
                url: form.action,
                type: form.method,
                dataType: 'json',
                data: $(form).serialize(),
                success: function(res, status){
                    fisLoader.hide();
                    if(res.result == "login"){
                        signUpForm.find(".fis-login-title")
                            .append("<label class='fis-error'>User name already exits</label>");
                    }else{
                        window.location.replace("http://localhost:8080/FisMediaSite/profile?username=" + res.username);
                    }
                }
            });
        }
    });
}