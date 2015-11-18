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

    $("nav a").each(function(){
        if($(this).attr("href") == url || $(this).attr("href") == '' )
            $(this).addClass("fis-nav-active");
    })

}

function validations(){
    var loginForm = $("#loginForm");

    loginForm.validate({
        rules:{
            userName: "required"
        },
        messages:{
            userName: "requireds"
        },
        errorClass: "fis-error"
    });
}