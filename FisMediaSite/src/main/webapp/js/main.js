$(document).ready(function(){
    checkUrlToActiveNav();
    validations();

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

function validations(){
    var loginForm = $("#loginForm");

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
            form.submit();
        }
    });
}