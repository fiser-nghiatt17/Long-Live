function sliderHomePage(){
    var $sliderHomePage = $(".fis-slider");
    $sliderHomePage.find(".fis-card-container:gt(0)").hide();

    var run = null;
    $sliderHomePage.hover(function(){
        var self = $(this);
        var count = self.find(".fis-card-container").length;
        if(count > 1){
            run = setInterval(function(){
                self.find(".fis-card-container:first")
                    .fadeOut(1000).next().fadeIn(1000).end().appendTo(self);
            }, 1500);
        }
    },function(){ clearInterval(run)});
}