<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <div>
                <span class="mdl-layout-title" style="cursor: pointer; margin-right: 20px;">Home</span>
            </div>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation. We hide it in small screens. -->
            <nav class="mdl-navigation mdl-layout--large-screen-only">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
                    <label class="mdl-button mdl-js-button mdl-button--icon" style="position: relative; top: 3px"
                           for="fixed-header-drawer-exp">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" type="text" name="sample"
                               id="fixed-header-drawer-exp">
                    </div>
                </div>
                <a class="mdl-navigation__link" data-toggle="modal" data-target="#fis-signup-container">Sign Up</a>
                <a class="mdl-navigation__link" data-toggle="modal" data-target="#fis-login-container">Log In</a>
            </nav>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Long Live</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="home">Home</a>
            <div class="fis-sub-nav">
                <a class="mdl-navigation__link"  href="newest">Newest</a>
                <a class="mdl-navigation__link"  href="mostView">Most view</a>
                <a class="mdl-navigation__link"  href="mostFavorite">Most favorite</a>
                <a class="mdl-navigation__link"  href="viewAAlbum">View a album</a>
            </div>
            <a class="mdl-navigation__link" href="profile">Profile</a>
            <div class="fis-sub-nav">
                <a class="mdl-navigation__link"  href="editAAlbum">Edit A Album</a>
            </div>
            <a class="mdl-navigation__link" href="setting">Setting</a>
            <a class="mdl-navigation__link" data-toggle="modal" data-target="#fis-signup-container">Sign Up</a>
            <a class="mdl-navigation__link" data-toggle="modal" data-target="#fis-login-container">Log In</a>
            <a class="mdl-navigation__link" href="logOut">Log out</a>
        </nav>
    </div>