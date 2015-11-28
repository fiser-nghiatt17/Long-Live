<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
    <div class="page-content"><!-- Your content goes here -->
        <div class="mdl-grid">
            <s:set name="isOwner" value="isOwner"/>
            <s:if test="%{#isOwner == 'true'}">
                <div class="mdl-cell mdl-cell--3-col">
                    <form action="updateAlbum" class="fis-album-detail mdl-shadow--3dp upload-a-image" method="post"
                          enctype="multipart/form-data">
                        <p>Add images</p>
                        <input class="mdl-textfield__input" multiple type="file" name="userImage"/>

                        <p style="position: relative; top: 20px">Name Album</p>

                        <div class="mdl-textfield mdl-js-textfield">
                            <input class="mdl-textfield__input" type="text" id="name-album" value="Nature" name="albumName">
                            <label class="mdl-textfield__label" for="name-album"></label>
                        </div>
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">Save</button>
                    </form>
                </div>
            </s:if>
            <s:iterator value="pictures" status="pictureIndex" var="picture">
                <div class="mdl-cell mdl-cell--3-col">
                    <div class="fis-card  mdl-card mdl-shadow--6dp" style="background: url('<s:property
                            value="#picture.pictureURL"/>') center / cover">
                        <div class="mdl-card__title"><!-- Delete Image -->
                            <s:if test="%{#isOwner == 'true'}">
                                <button class="fis-edit-album-right mdl-button mdl-js-button mdl-button--icon fis-click-delete-picture"
                                        data-toggle="modal" data-target="#fis-delete-popup" data-picture-id=<s:property value="pictureID"/> >
                                    <i class="material-icons">delete</i>
                                </button>
                            </s:if>
                        </div><!-- End Delete Image -->
                        <div class="mdl-card--expand"></div>
                    </div>
                </div>
            </s:iterator>
        </div>
    </div><!-- End Your content goes here -->
</main>

<div class="modal fade" id="fis-delete-popup">
    <div class="fis-ask">
        <p>Are you sure to delete this picture ?</p>
        <button class="mdl-button mdl-js-button mdl-button--raised  mdl-button--accent fis-confirm-delete-picture" data-dismiss="modal">Yes
        </button>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" data-dismiss="modal">No</button>
    </div>
</div>