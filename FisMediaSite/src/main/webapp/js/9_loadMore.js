function loadMore(){
    var numberOfLoading = 1;
    var url = window.location.href.split("/").pop();

    var $mainTag = $(".fis-home-main");
    var $pageContent = $(".page-content");

    //var $loadingTemplate = $("#fis-image-loader").html();
    //var renderLoadingImage = Mustache.render($loadingTemplate, {});

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
