<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
   <div class="page-content"><!-- Your content goes here -->
   	  <div class="mdl-grid">
   	  	<div class="mdl-cell mdl-cell--3-col">
   	  		<form action="editAAlbum" class="fis-album-detail mdl-shadow--3dp upload-a-image">
                 <p>Add image</p>
                 <input class="mdl-textfield__input" type="file" name="userImage">
                 <p style="position: relative; top: 20px">Name Album</p>
                 <div class="mdl-textfield mdl-js-textfield">
                     <input class="mdl-textfield__input" type="text" id="name-album" value="Nature" name="albumName">
                     <label class="mdl-textfield__label" for="name-album"></label>
                 </div>
                 <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">Save</button>
             </form>
   	  	</div>

   	  	<div class="mdl-cell mdl-cell--3-col">
   	  		<div class="fis-card  mdl-card mdl-shadow--6dp" style="background: url('images/image.jpg') center / cover">
                  <div class="mdl-card__title"><!-- Delete Image -->
                      <button class="fis-edit-album-right mdl-button mdl-js-button mdl-button--icon"
                              data-toggle="modal" data-target="#fis-delete-popup">
                          <i class="material-icons">delete</i>
                      </button>
                  </div><!-- End Delete Image -->
                  <div class="mdl-card--expand"></div>
             </div>
   	  	</div>
   	  	<div class="mdl-cell mdl-cell--3-col">
   	  	</div>
   	  	<div class="mdl-cell mdl-cell--3-col">
   	  	</div>
   	  </div>
   </div><!-- End Your content goes here -->
</main>

<div class="modal fade" id="fis-delete-popup">
    <div class="fis-ask">
        <p>Are you sure to delete this picture ?</p>
        <button class="mdl-button mdl-js-button mdl-button--raised  mdl-button--accent" data-dismiss="modal">Yes</button>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" data-dismiss="modal">No</button>
    </div>
</div>