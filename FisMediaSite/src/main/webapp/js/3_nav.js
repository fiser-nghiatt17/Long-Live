function checkUrlToActiveNav(){
    var pgurl = window.location.href.split("/").pop();
    var indexOfDot = pgurl.search("\\.");
    var url;
    url = (indexOfDot == -1) ? pgurl : pgurl.substr(0, indexOfDot);

    $(".fis-main-nav a").each(function(){
        if($(this).attr("href") == url || $(this).attr("href") == '' )
            $(this).addClass("fis-nav-active");
    });

}