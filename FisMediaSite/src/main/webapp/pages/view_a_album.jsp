<main class="mdl-layout__content">
   <div class="page-content"><!-- Your content goes here -->
   		<div class="galleria">
                <img src="images/image.jpg">
                <img src="images/image.jpg">
                <img src="images/image.jpg">
            </div>
            <div class="fis-album-info mdl-shadow--3dp">
                <p><span style="font-size: 30px">Nature</span>
                </p>
                <p>
                    Author: Jenifer Nghia
                </p>
                <div class="fis-album-info-icon">
                    <span style="cursor: pointer" class="fis-plus">
                        <i class="icon material-icons">visibility
                        </i><span class="fis-card-hover-icon-plus">666</span>
                    </span>
                    <span style="margin-left: 5px; cursor: pointer" class="fis-plus">
                        <i class="icon material-icons">favorite
                        </i><span class="fis-card-hover-icon-plus">888</span>
                    </span>
                </div>
            </div>

            <div class="fis-comment mdl-shadow--3dp">
                <div class="fb-comments" data-href="http://localhost:8080/FisMediaSite/viewAAlbum" data-width="600" data-numposts="5"></div>
                <!-- <div id="fb-root"></div> -->
            </div>

   </div><!-- End Your content goes here -->
</main>
<script>
    (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
    fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>
<%@ include file="login_signup_pop_up.jsp" %>
