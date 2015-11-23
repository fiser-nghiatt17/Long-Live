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