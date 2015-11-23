<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
    <div class="page-content"><!-- Your content goes here -->
        <div class="mdl-grid">
            <%--<s:iterator value="homeDisplays" var="a">

                <div class="mdl-cell mdl-cell--3-col">
                    <div class="fis-slider">
                        <div class="fis-card-container">
                            <s:url action="viewAAlbum" var="viewAlbum">
                                <s:param name="albumId">
                                    <s:property value="albumId"/>
                                </s:param>
                            </s:url>
                            <a style="cursor: pointer; text-decoration: none" href="<s:property value="viewAlbum" />">
                                <!-- Link to view a album  -->
                                <s:iterator value="pictures" status="pictureIndex" var="picture">
                                    <div class="fis-card-container">
                                        <div class="fis-card  mdl-card mdl-shadow--6dp"
                                             style="background: url('<s:property
                                                     value="#picture.pictureURL"/>') center / cover">
                                            <div class="mdl-card__title mdl-card--expand">
                                            </div>
                                            <div class="fis-card-hover mdl-card__actions"><!-- Hover -->
                                                <p class="fis-card-title"><s:property value="#a.albumname"/></p>

                                                <p class="fis-card-user"><s:property value="#a.fullname"/></p>

                                                <div class="fis-card-hover-icon">
                                            <span>
                                                <i class="icon material-icons">visibility
                                                </i><span class="fis-card-hover-icon-plus"><s:property
                                                    value="#a.view"/></span>
                                            </span>
                                            <span style="position: relative; left: 7px">
                                                <i class="icon material-icons">favorite
                                                </i><span class="fis-card-hover-icon-plus"><s:property
                                                    value="#a.like"/></span>
                                            </span>
                                                </div>
                                            </div><!-- End Hover -->
                                        </div>
                                    </div>
                                </s:iterator>
                            </a>
                        </div>
                    </div>
                </div>
            </s:iterator>--%>
                <s:iterator value="album" status="albumIndex" var="album">
                    <div class="mdl-cell mdl-cell--3-col">
                        <div class="fis-slider">
                            <button id="fis-edit-album-right-<s:property value="%{#albumIndex.index}" />"
                                    class="fis-edit-album-right mdl-button mdl-js-button mdl-button--icon">
                                <i class="material-icons">more_vert</i>
                            </button>
                            <s:iterator value="pictures" status="pictureIndex" var="picture">
                                <div class="fis-card-container">
                                    <s:url action="viewAAlbum" var="viewAlbum">
                                        <s:param name="albumId">
                                            <s:property value="albumID"/>
                                        </s:param>
                                    </s:url>
                                    <a style="cursor: pointer" href="<s:property value="viewAlbum" />">
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
                                                        </i><span class="fis-card-hover-icon-plus"><s:property value="album.viewAmount"/></span>
                                                    </span>
                                                    <span style="position: relative; left: 7px">
                                                        <i class="icon material-icons">favorite
                                                        </i><span class="fis-card-hover-icon-plus"><s:property value="album.likeAmount"/></span>
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