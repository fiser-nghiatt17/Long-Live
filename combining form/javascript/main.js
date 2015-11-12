$(document).ready(function(){

    /*Navigation*/
    var $afterLogin = $(".after-login");
    var $beforeLogin = $(".before-login");
    var $logout = $(".logout");

    $afterLogin.hide();

    $beforeLogin.click(function(){
        $beforeLogin.hide();
        $afterLogin.show();
    });

    $logout.click(function(){
        $afterLogin.hide();
        $beforeLogin.show();
    });

    /*End Navigation*/
});
