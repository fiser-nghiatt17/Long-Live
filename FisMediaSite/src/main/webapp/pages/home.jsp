<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content fis-home-main">
    <div class="page-content"><!-- Your content goes here -->
        <div class="mdl-grid">
            <s:iterator value="album" status="albumIndex" var="album">
                <div class="mdl-cell mdl-cell--3-col">
                    <div class="fis-slider">
                        <s:iterator value="pictures" status="pictureIndex" var="picture">
                            <div class="fis-card-container">
                                <s:url action="viewAAlbum" var="viewAlbum">
                                    <s:param name="albumId">
                                        <s:property value="album.albumID"/>
                                    </s:param>
                                </s:url>
                                <a style="cursor: pointer; text-decoration: none" href="<s:property value="viewAlbum" />">
                                    <div class="fis-card  mdl-card mdl-shadow--6dp" style="background: url('<s:property
                                            value="#picture.pictureURL"/>') center / cover">
                                        <div class="mdl-card__title">
                                        </div>
                                        <div class="mdl-card--expand"></div>

                                        <!-- Link to See album -->
                                        <div class="fis-card-hover mdl-card__actions">
                                            <p class="fis-card-title"><s:property value="albumName"/></p>

                                            <p class="fis-card-user"><s:property value="user.username"/></p>

                                            <div class="fis-card-hover-icon">
                                                    <span>
                                                        <i class="icon material-icons">visibility
                                                        </i><span class="fis-card-hover-icon-plus"><s:property
                                                            value="album.viewAmount"/></span>
                                                    </span>
                                                    <span style="position: relative; left: 7px">
                                                        <i class="icon material-icons">favorite
                                                        </i><span class="fis-card-hover-icon-plus"><s:property
                                                            value="album.likeAmount"/></span>
                                                    </span>
                                            </div>
                                        </div>
                                        <!-- End link to See album -->
                                    </div>
                                </a>
                            </div>
                        </s:iterator>
                    </div>
                </div>
            </s:iterator>
        </div>
    </div><!-- End Your content goes here -->
</main>

<%@ include file="login_signup_pop_up.jsp" %>
<%@ include file="home_template.jsp" %>
