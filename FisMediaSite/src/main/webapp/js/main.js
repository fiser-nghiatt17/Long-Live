$(document).ready(function(){
    checkUrlToActiveNav();
    handlerSubmit();

});

function checkUrlToActiveNav(){
    var pgurl = window.location.href.split("/").pop();
    var indexOfQm = pgurl.search("\\?");
    var url;

    if (indexOfQm == -1){
        url = pgurl;
    }else{
        url = pgurl.substr(0, indexOfQm);
    }

    $(".fis-main-nav a").each(function(){
        if($(this).attr("href") == url || $(this).attr("href") == '' )
            $(this).addClass("fis-nav-active");
    })

}

function handlerSubmit(){
    loginHandle();
    signupHandle();
    settingHandle();
    uploadImageHandle();
}

function loginHandle(){
    var loginForm = $("#loginForm");
    var fisLoader = $(".fis-loader");
    fisLoader.hide();
    loginForm.validate({
        rules:{
            username: {
                required: true,
                minlength: 5,
                maxlength: 15
            },
            password: {
                required: true,
                minlength: 5,
                maxlength: 15
            }
        },
        messages:{
            username: {
                required: "This field is required",
                minlength: "Too short",
                maxlength: "Too long"
            },
            password: {
                required: "This field is required",
                minlength: "Too short",
                maxlength: "Too long"
            }
        },
        errorClass: "fis-error",
        submitHandler: function(form){
            fisLoader.show();

            $.ajax({
                url: form.action,
                type: form.method,
                dataType: 'json',
                data: $(form).serialize(),
                success: function(res){
                    fisLoader.hide();
                   if(res.result == "login"){
                       loginForm.find(".fis-login-title")
                           .append("<label class='fis-error'>Wrong User Name or Password</label>");
                   }else{
                       window.location.replace("http://localhost:8080/FisMediaSite/profile");
                   }
                }
            });
        }
    });
}

function signupHandle(){

}

function settingHandle(){

}

function uploadImageHandle(){

}
