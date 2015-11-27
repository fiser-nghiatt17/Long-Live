function deleteHandler(){
    deleteAAlbum();
    deleteAPicture();
}

function deleteAAlbum(){
    var $clickDelete = $(".fis-click-delete-album");
    var $confirmDeleteAlbum = $(".fis-confirm-delete-album");
    var albumId = null;
    var self;

    $clickDelete.on("click", function(){
        albumId = $(this).attr("data-album-id");
        //console.log(albumId);
        self = $(this);
    });

    $confirmDeleteAlbum.on("click", function(){
        self.closest(".mdl-cell").remove();
        $.ajax({
            type: "POST",
            dataType: 'json',
            data: {albumId: albumId},
            url: "deleteAAlbum",
            success: function(res){
                //console.log(res);
            }
        });
    });
}

function deleteAPicture(){
    var $clickDelete = $(".fis-click-delete-picture");
    var $confirmDeletePicture = $(".fis-confirm-delete-picture");
    var pictureId = null;
    var self;

    $clickDelete.on("click", function(){
        pictureId = $(this).attr("data-picture-id");
       // console.log(pictureId);
        self = $(this);
    });

    $confirmDeletePicture.on("click", function(){
        self.closest(".mdl-cell").remove();
        $.ajax({
            type: "POST",
            dataType: 'json',
            data: {pictureId: pictureId},
            url: "deleteAPicture",
            success: function(res){
               // console.log(res);
            }
        });
    });
}