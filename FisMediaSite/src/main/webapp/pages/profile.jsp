<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
    <div class="page-content"><!-- Your content goes here -->
        <div class="mdl-grid">
            <s:set name="isOwner" value="isOwner"/>
            <s:if test="%{#isOwner == 'true'}">
                <div class="mdl-cell mdl-cell--3-col">
                    <div class="fis-edit-album-section mdl-shadow--3dp">
                        <button class="fis-add-album mdl-button mdl-js-button mdl-button--raised mdl-button--colored"
                                data-toggle="modal" data-target="#fis-new-album-container">
                            New Album
                        </button>
                        <span>Total: 15</span>
                    </div>
                </div>
            </s:if>
            <s:if test="%{#isOwner == 'false'}">
                <div class="mdl-cell mdl-cell--3-col">
                    <div  class="fis-edit-album-section mdl-shadow--3dp">
                        <p style="font-size: large; margin-top: 15px; font-weight: bold"><s:property value="user.fullname"/></p>
                        <p style="margin-top: 0px"><s:property value="user.username"/></p>
                    </div>
                </div>
            </s:if>

            <s:iterator value="user.albums" status="albumIndex" var="album">
                <div class="mdl-cell mdl-cell--3-col">
                    <div class="fis-slider">
                        <s:url action="editAAlbum" var="editAlbum">
                            <s:param name="albumId">
                                <s:property value="albumID"/>
                            </s:param>
                        </s:url>
                        <s:if test="%{#isOwner == 'true'}">
                            <button id="fis-edit-album-right-<s:property value="%{#albumIndex.index}" />"
                                    class="fis-edit-album-right mdl-button mdl-js-button mdl-button--icon">
                                <i class="material-icons">more_vert</i>
                            </button>
                        </s:if>
                        <div class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                             for="fis-edit-album-right-<s:property value="%{#albumIndex.index}" />">
                            <a href="<s:property value="editAlbum" />" style="color: #616161">
                                <li class="mdl-menu__item">Edit</li>
                            </a>
                            <a href="#" style="color: #616161" data-toggle="modal" class="fis-click-delete-album"
                               data-target="#fis-delete-popup" data-album-id=<s:property value="albumID" /> >
                                <li class="mdl-menu__item">Delete</li>
                            </a>
                        </div>
                        <s:iterator value="pictures" status="pictureIndex" var="picture">
                            <div class="fis-card-container">
                                <div class="fis-card  mdl-card mdl-shadow--6dp" style="background: url('<s:property
                                        value="#picture.pictureURL"/>') center / cover">
                                    <div class="mdl-card__title">
                                    </div>
                                    <div class="mdl-card--expand"></div>
                                    <s:url action="viewAAlbum" var="viewAlbum">
                                        <s:param name="albumId">
                                            <s:property value="albumID"/>
                                        </s:param>
                                    </s:url>
                                    <a style="cursor: pointer" href="<s:property value="viewAlbum" />">
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
                                    </a> <!-- End link to See album -->
                                </div>
                            </div>
                        </s:iterator>
                    </div>
                </div>
            </s:iterator>
        </div>

    </div><!-- End Your content goes here -->
</main>

<!-- New album Popup -->
<div class="modal fade" id="fis-new-album-container">
    <form class="fis-new-album-container" action="createAlbum" method="post" enctype="multipart/form-data">
        <input type="file" class="fis-choose-file" name="userImage"/>

        <div class="mdl-textfield mdl-js-textfield">
            <textarea class="mdl-textfield__input" type="text" rows="3" id="fis-title-file" name="albumName"></textarea>
            <label class="mdl-textfield__label" for="fis-title-file">Enter Album Name here ...</label>
        </div>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored fis-add-album-btn">
            Create
        </button>
    </form>
</div>
<!-- End New album Popup -->

<!--Delete Album Popup-->
<div class="modal fade" id="fis-delete-popup">
    <div class="fis-ask">
        <p>Are you sure to delete this album ?</p>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent fis-confirm-delete-album" data-dismiss="modal">Yes</button>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" data-dismiss="modal">No</button>
    </div>
</div>
<!--End Delete Album Popup -->