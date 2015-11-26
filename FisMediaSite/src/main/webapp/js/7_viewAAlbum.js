function viewAAlbum(){
    var plus = $(".fis-plus");
    var isPlus = false;
    var like;
    var albumId = plus.attr("data-album-id");
    plus.click(function(){
        $(this).toggleClass("fis-like");
        var plusIcon = $(this).find(".fis-card-hover-icon-plus");
        var oldVal = parseInt(plusIcon.html());
        var newVal;
        if(!isPlus){
            like = 1;
            newVal = oldVal + 1;
            isPlus = true;
        }else{
            like = -1;
            newVal = oldVal - 1;
            isPlus = false;
        }
        plusIcon.html(newVal);

        $.ajax({
            type: "POST",
            url: "likeAlbum",
            dataType: "json",
            data: {like: like, albumId: albumId},
            success: function(res, status){
                if(status === "success"){

                }
            }
        });
    });

    commentSection();
}

function commentSection(){
    var $fisCommentInputText = $(".fis-comment-input-text");
    var $fisCommentSubmit = $(".fis-comment-submit");
    var $fisCommentCancel = $(".fis-comment-cancel");

    $fisCommentInputText.focus(function(){
        $fisCommentSubmit.removeClass("fis-hide");
        $(this).attr("rows", 5);
    });

    $fisCommentCancel.on("click", function(e){
        e.preventDefault();
        $fisCommentSubmit.addClass("fis-hide");
        $fisCommentInputText.attr("rows", 3);
    });
}
