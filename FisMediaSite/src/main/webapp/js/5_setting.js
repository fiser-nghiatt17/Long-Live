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