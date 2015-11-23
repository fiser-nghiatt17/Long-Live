function loadMore(){
    var documentHeight = $(document).height();
    var windowHeight = $(window).height();
    var loadingPoint = documentHeight - windowHeight;
    console.log(documentHeight);
    $(".fis-home-main").on('scroll', function(){
        if($(this).scrollTop() > loadingPoint){
            loadingPoint += documentHeight;
            console.log("Loding point: " + loadingPoint);
            console.log("Scroll Top: " + $(this).scrollTop());
            for(var i=0; i<4; i++)
                $(this).find(".mdl-grid").append("<div class='mdl-cell mdl-cell--3-col' ><div style='width: 100%; height: 1000px; background: red;'></div></div>");
        }
    });

}
