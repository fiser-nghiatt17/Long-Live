var errorMessages = {
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
        },
        userImage:{
            required: true,
            accept: "image/*",
            fileSize: 1048576
        },
        albumName:{
            required: true
        }
    },
    messages:{/*ss*/
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
        },
        userImage:"File must be JPG, GIF or PNG, less than 1MB"
    }
};

$(document).ready(function(){
    checkUrlToActiveNav();
    handlerSubmit();
    viewAAlbum();
    sliderHomePage();
    loadMore();
});

function handlerSubmit(){
    loginHandle();
    signupHandle();
    settingHandle();
    uploadImageHandle();
}

function checkUrlToActiveNav(){
    var pgurl = window.location.href.split("/").pop();
    var indexOfDot = pgurl.search("\\.");
    var url;
    url = (indexOfDot == -1) ? pgurl : pgurl.substr(0, indexOfDot);

    $(".fis-main-nav a").each(function(){
        if($(this).attr("href") == url || $(this).attr("href") == '' )
            $(this).addClass("fis-nav-active");
    });

}
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
function settingHandle(){
    var $settingForm = $(".fis-setting");
    var fisLoader = $(".fis-loader");
    fisLoader.hide();
    $settingForm.validate({
        rules:{
            fullName: errorMessages.rules.fullName,
            username: errorMessages.rules.username,
            oldPassword: errorMessages.rules.password,
            newPassword: errorMessages.rules.password,
            retypeNewPassword: {
                required: errorMessages.rules.confirmPassword.required,
                minlength: errorMessages.rules.confirmPassword.minlength,
                maxlength: errorMessages.rules.confirmPassword.maxlength,
                equalTo: "#setting-new-password"
            }
        },
        errorClass: 'fis-error',
        submitHandler: function(form){
            fisLoader.show();
            $.ajax({
                url: form.action,
                type: form.method,
                dataType: 'json',
                data: $(form).serialize(),
                success: function(res, status){
                    var message = res.message;
                    var styleMessage = "fis-error";
                    if (message === "Saved successfully !"){
                        styleMessage = "fis-success";
                    }
                    fisLoader.hide();
                    for (var i=2;i<=4;i++){
                        $settingForm.find("input:eq("+i+")").val("");
                    }
                    $settingForm.find("label").html("");
                    $settingForm
                        .prepend("<label class=\""+ styleMessage +"\" style='font-size: large'>" + message + "</label>");
                }
            });
        }
    });
}
function uploadImageHandle(){
    var $uploadForm = $(".fis-new-album-container");
    var $uploadAImage = $(".upload-a-image");

    $uploadForm.validate({
        rules:{
            userImage:errorMessages.rules.userImage,
            albumName:errorMessages.rules.albumName
        },
        messages:{
            userImage:errorMessages.messages.userImage
        },
        submitHandler: function(form){
            //ajax here
        },
        errorClass: 'fis-error'
    });

    $uploadAImage.validate({
        rules:{
            userImage:errorMessages.rules.userImage,
            albumName:errorMessages.rules.albumName
        },
        messages:{
            userImage:errorMessages.messages.userImage
        },
        submitHandler: function(form){
            //ajax here
        },
        errorClass: 'fis-error'
    });
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

    //ajax here
}

function sliderHomePage(){
    var $sliderHomePage = $(".fis-slider");
    $sliderHomePage.find(".fis-card-container:gt(0)").hide();

    var run = null;
    var $grid = $(".mdl-grid");

    $grid.delegate(".fis-slider", "mouseenter mouseleave", function(event){
        var self = $(this);
        var count = self.find(".fis-card-container").length;
        if (event.type === "mouseenter"){
            if(count > 1){
                run = setInterval(function(){
                   self.find(".fis-card-container:first")
                        .fadeOut(1000).next().fadeIn(1000).end().appendTo(self);
                }, 1500);
            }
        }else{
            clearInterval(run)
        }
    });
    /*$sliderHomePage.hover(function(){
        var self = $(this);
        var count = self.find(".fis-card-container").length;
        if(count > 1){
            run = setInterval(function(){
                self.find(".fis-card-container:first")
                    .fadeOut(1000).next().fadeIn(1000).end().appendTo(self);
            }, 1500);
        }
    },function(){ clearInterval(run)});*/
}
function loadMore(){
    var numberOfLoading = 1;
    var url = window.location.href.split("/").pop();

    var $mainTag = $(".fis-home-main");
    var $pageContent = $(".page-content");

    var $loadingTemplate = $("#fis-image-loader").html();
    var renderLoadingImage = Mustache.render($loadingTemplate, {});

    $mainTag.on('scroll', function(){
        var pageContentHeight = $pageContent.height();
        var mainTagHeight = $mainTag.height();
        var self = $(this);
        if(self.scrollTop() >= pageContentHeight - mainTagHeight){

           /* for(var i=1; i<=7; i++)
                self.find(".mdl-grid").append(renderLoadingImage);*/

            $.ajax({
                url: url,
                type: "POST",
                data:{numberOfLoading: numberOfLoading},
                dataType: 'html',
                success: function(res, status){
                    //self.find(".fis-image-loader").remove();

                    var toAppend = $(res).find(".mdl-cell--3-col");
                    toAppend.css("display", "none");
                    toAppend.appendTo( self.find(".mdl-grid")).fadeIn(1000);
                }
            });

            numberOfLoading++;
        }
    });

}
