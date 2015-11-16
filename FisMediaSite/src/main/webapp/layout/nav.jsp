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
        <span class="mdl-layout-title">Home</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="home">Home</a>
            <ul class="fis-sub-nav">
                <li><a href="home">Newest</a></li>
                <li><a href="home">Most view</a></li>
                <li><a href="home">Most favorite</a></li>
                <li><a href="viewAAlbum">View a album</a></li>
            </ul>
            <a class="mdl-navigation__link" href="profile">Profile</a>
            <ul class="fis-sub-nav">
                <li><a href="editAAlbum">Edit a album</a></li>
            </ul>
            <a class="mdl-navigation__link" href="setting">Setting</a>
            <a class="mdl-navigation__link" data-toggle="modal" data-target="#fis-signup-container">Sign Up</a>
            <a class="mdl-navigation__link" data-toggle="modal" data-target="#fis-login-container">Log In</a>
            <a class="mdl-navigation__link" href="home">Log out</a>
        </nav>
    </div>