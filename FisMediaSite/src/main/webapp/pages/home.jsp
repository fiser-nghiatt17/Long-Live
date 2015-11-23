<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
    <div class="page-content"><!-- Your content goes here -->
        <div class="mdl-grid">
            <s:iterator value="homeDisplays" status = "index" var="a">
                <div class="mdl-cell mdl-cell--3-col">
                    <div class="fis-slider">
                        <div class="fis-card-container">
                            <a style="cursor: pointer" href="viewAAlbum"><!-- Link to view a album  -->
                                <div class="fis-card  mdl-card mdl-shadow--6dp"
                                     style="background: url('<s:property value="#a.picURL"/> ') center / cover">
                                    <div class="mdl-card__title mdl-card--expand">
                                    </div>
                                    <div class="fis-card-hover mdl-card__actions"><!-- Hover -->
                                        <p class="fis-card-title"><s:property value="#a.albumname"/></p>

                                        <p class="fis-card-user"><s:property value="#a.fullname"/></p>

                                        <div class="fis-card-hover-icon">
                                            <span>
                                                <i class="icon material-icons">visibility
                                                </i><span class="fis-card-hover-icon-plus"><s:property value="#a.view"/></span>
                                            </span>
                                            <span style="position: relative; left: 7px">
                                                <i class="icon material-icons">favorite
                                                </i><span class="fis-card-hover-icon-plus"><s:property value="#a.like"/></span>
                                            </span>
                                        </div>
                                    </div><!-- End Hover -->
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </div>
    </div><!-- End Your content goes here -->
</main>

<%@ include file="login_signup_pop_up.jsp" %>