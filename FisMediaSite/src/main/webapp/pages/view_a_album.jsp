<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
    <div class="page-content"><!-- Your content goes here -->
        <div class="galleria">
            <s:iterator value="pictures">
                <img src="<s:property value="pictureURL"/>"/>
            </s:iterator>
        </div>
        <div class="fis-album-info mdl-shadow--3dp">
            <p><span style="font-size: xx-large"><s:property value="album.albumName"/></span>
            </p>
            <s:url action="profile" var="viewProfile">
                <s:param name="username">
                    <s:property value="author.username"/>
                </s:param>
            </s:url>
            <a href="<s:property value="viewProfile"/>" >
                <p style="font-weight: 600; color: #424242">
                    <s:property value="author.username"/>
                </p>
            </a>

            <div class="fis-album-info-icon">
                    <span style="cursor: pointer">
                        <i class="icon material-icons">visibility
                        </i><span class="fis-card-hover-icon-plus"><s:property value="album.viewAmount"/></span>
                    </span>
                    <span style="margin-left: 5px; cursor: pointer" class="fis-plus" data-album-id=<s:property value="albumId"/>>
                        <i class="icon material-icons">favorite
                        </i><span class="fis-card-hover-icon-plus"><s:property value="album.likeAmount"/></span>
                    </span>
            </div>
        </div>

        <div class="fis-comment mdl-shadow--3dp">
            <!-- <div class="fb-comments" data-href="http://localhost:8080/FisMediaSite/viewAAlbum" data-width="600" data-numposts="5"></div> -->
            <!-- <div id="fb-root"></div> -->
            <div class="fis-comment-input-container">
                <div class="fis-avatar-comment">
                    <img src="images/avatar2.png"/>
                </div>
                <form class="fis-comment-input" action="addComment" type="post">
                    <textarea class=" fis-comment-input-text" type="text" rows="3" name="newComment"></textarea>
                    <div class="fis-comment-submit fis-hide">
                        <button type="submit" class="fis-comment-cancel mdl-button mdl-js-button mdl-button--raised mdl-button--colored"
                                style="background: #fff; color: #898989">Cancel</button>
                        <button type="submit" class="fis-comment-submit mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                            Post</button>
                    </div>
                </form>
            </div>
            <div class="fis-comment-list">
                <s:iterator value="comments" var="comment">
                <div class="fis-comment-item">
                    <div class="fis-avatar-comment-list">
                       <a href="sf"> <img src="images/avatar2.png"/></a>
                    </div>
                    <div class="fis-comment-content">
                        <s:url action="profile" var="viewProfile">
                            <s:param name="username">
                                <s:property value="user.username"/>
                            </s:param>
                        </s:url>
                        <a style="text-decoration: none;" href="<s:property value="viewProfile"/>">
                            <div class="fis-comment-header"><s:property value="user.username"/>
                                <span><s:property value="commentTime"/></span>
                            </div>
                        </a>
                        <div class="fis-comment-body">
                            <s:property value="content"/>
                        </div>
                    </div>
                </div>
                </s:iterator>
            </div>
        </div>

    </div><!-- End Your content goes here -->
</main>
<script>
    /*(function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));*/
</script>
<%@ include file="login_signup_pop_up.jsp" %>