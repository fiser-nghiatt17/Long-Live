$(document).ready(function(){
    checkUrlToActiveNav();
    handlerSubmit();
    viewAAlbum();
});

function checkUrlToActiveNav(){
    var pgurl = window.location.href.split("/").pop();
    var indexOfQm = pgurl.search("\\?");
    var url;

    if (indexOfQm == -1){
        url = pgurl;
        var indexOfDot = url.search("\\.");
        url = (indexOfDot == -1) ? url : url.substr(0, indexOfDot);
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
                minlength: "Username must be 6-20 characters",
                maxlength: "Username must be 6-20 characters"
            },
            password: {
                required: "This field is required",
                minlength: "Username must be 6-20 characters",
                maxlength: "Username must be 6-20 characters"
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
                success: function(res, status){
                    console.log(status);
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
    var signUpForm = $("#loginSignUp");
    var fisLoader = $(".fis-loader");
    fisLoader.hide();
    signUpForm.validate({
        rules:{
            username: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
            confirmPassword: {
                required: true,
                minlength: 6,
                maxlength: 20,
                equalTo: "#signUpPassword"
            },
            fullName: {
                required: true,
                minlength: 6,
                maxlength: 20
            }
        },
        messages:{
            username: {
                required: "This field is required",
                minlength: "Username must be 6-20 characters",
                maxlength: "Username must be 6-20 characters"
            },
            password: {
                required: "This field is required",
                minlength: "Password must be 6-20 characters",
                maxlength: "Password must be 6-20 characters"
            },
            confirmPassword: {
                required: "This field is required",
                minlength: "Password must be 6-20 characters",
                maxlength: "Password must be 6-20 characters",
                equalTo: "Not match"
            },
            fullName: {
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
                success: function(res, status){
                    console.log(res);
                    fisLoader.hide();
                    if(res.result == "login"){
                        signUpForm.find(".fis-login-title")
                            .append("<label class='fis-error'>User name already exits</label>");
                    }else{
                        window.location.replace("http://localhost:8080/FisMediaSite/profile");
                    }
                }
            });
        }
    });
}

function settingHandle(){

}

function uploadImageHandle(){

}

function viewAAlbum(){
    var plus = $(".fis-plus");
    var isPlus = false;
    plus.click(function(){
        var plusIcon = $(this).find(".fis-card-hover-icon-plus");
        var oldVal = parseInt(plusIcon.html());
        var newVal;
        if(!isPlus){
            newVal = oldVal + 1;
            isPlus = true;
        }else{
            newVal = oldVal - 1;
            isPlus = false;
        }
        plusIcon.html(newVal);
    });

    //query here
}
