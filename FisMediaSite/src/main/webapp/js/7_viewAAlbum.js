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
