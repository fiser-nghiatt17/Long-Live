<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
   <div class="page-content"><!-- Your content goes here -->
	  <div class="mdl-grid">
	  		<div class="mdl-cell mdl-cell--3-col">
		  		<div class="fis-edit-album-section mdl-shadow--3dp">
		              <button class="fis-add-album mdl-button mdl-js-button mdl-button--raised mdl-button--colored"
		                      data-toggle="modal" data-target="#fis-new-album-container">
		                  New Album
		              </button>
		              <span>Total: 15</span>
		         </div>
	  	    </div>
   			<div class="mdl-cell mdl-cell--3-col">
   				<div class="fis-card-container">
                            <div class="fis-card  mdl-card mdl-shadow--6dp" style="background: url('images/image.jpg') center / cover">
                                <div class="mdl-card__title">
            <!-- Edit album -->    <button id="fis-edit-album-right-1"
                                            class="fis-edit-album-right mdl-button mdl-js-button mdl-button--icon">
                                        <i class="material-icons">more_vert</i>
                                     </button>
                                    <div class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                                        for="fis-edit-album-right-1">
                                        <a href="editAAlbum" style="color: #616161">
                                            <li class="mdl-menu__item">Edit</li>
                                        </a>
                                        <a href="#" style="color: #616161" data-toggle="modal" data-target="#fis-delete-popup">
                                           <li class="mdl-menu__item">Delete</li>
                                        </a>
                                    </div>
    <!-- End Edit album -->    </div>
                                <div class="mdl-card--expand"></div>
                                <a style="cursor: pointer" href="viewAAlbum"> <!-- Link to See album -->
                                    <div class="fis-card-hover mdl-card__actions">
                                            <p class="fis-card-title">Nature</p>
                                            <p class="fis-card-user">Jenefer lawrence</p>
                                        <div class="fis-card-hover-icon">
                                            <span>
                                                <i class="icon material-icons">visibility
                                                </i><span class="fis-card-hover-icon-plus">269</span>
                                            </span>
                                            <span style="position: relative; left: 7px">
                                                <i class="icon material-icons">favorite
                                                </i><span class="fis-card-hover-icon-plus">60</span>
                                            </span>
                                        </div>
                                    </div>
                                </a> <!-- End link to See album -->
                            </div>
                    </div>
		   	</div>
		   	<div class="mdl-cell mdl-cell--3-col">
		   	</div>
		   	<div class="mdl-cell mdl-cell--3-col">
		   	</div>
  	   </div>
   	
   </div><!-- End Your content goes here -->
</main>

<!-- New album Popup -->
<div class="modal fade" id="fis-new-album-container">
    <form class="fis-new-album-container" action="createAlbum" method="post" enctype="multipart/form-data">
        <input type="file" class="fis-choose-file" name="userImage" />
        <div class="mdl-textfield mdl-js-textfield">
            <textarea class="mdl-textfield__input" type="text" rows= "3" id="fis-title-file" name="albumName"></textarea>
            <label class="mdl-textfield__label" for="fis-title-file">Enter Album Name here ...</label>
        </div>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored fis-add-album-btn">
            Create
        </button>
    </form>
</div><!-- End New album Popup -->

<!--Delete Album Popup-->
<div class="modal fade" id="fis-delete-popup">
    <div class="fis-ask">
        <p>Are you sure to delete this album ?</p>
        <button class="mdl-button mdl-js-button mdl-button--raised  mdl-button--accent" data-dismiss="modal">Yes</button>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" data-dismiss="modal">No</button>
    </div>
</div><!--End Delete Album Popup -->