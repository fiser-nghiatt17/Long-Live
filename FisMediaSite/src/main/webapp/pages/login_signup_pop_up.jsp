<!-- Login Popup -->
    <div class="modal fade" id="fis-login-container">
            <div class="fis-login-container">
                <form action="home" id="loginForm">
                    <div class="fis-login-title">
                        <h3>Log In</h3>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield user-name">
                        <input class="mdl-textfield__input" type="text" id="userName">
                        <label class="mdl-textfield__label" for="userName">User name</label>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="password" id="password">
                        <label class="mdl-textfield__label" for="password">Password</label>
                    </div>
                    <div>
                        <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-1">
                            <input type="checkbox" id="checkbox-1" class="mdl-checkbox__input">
                            <span class="mdl-checkbox__label">Remember Me</span>
                        </label>
                    </div>
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored fis-login-btn">
                        Log In
                    </button>
                </form>
            </div>
    </div>
    <!-- End Login Popup -->

    <!-- Sign Up Popup -->
    <div class="modal fade" id="fis-signup-container">
        <div class="fis-login-container">
            <form action="profile">
                <div class="fis-login-title">
                    <h3>Sign Up</h3>
                </div>
                <div class="mdl-textfield mdl-js-textfield user-name">
                    <input class="mdl-textfield__input" type="text" id="signUpUserName" pattern="[A-Z,a-z, ]*">
                    <label class="mdl-textfield__label" for="signUpUserName">User name</label>
                    <span class="mdl-textfield__error">Letters and spaces only</span>
                </div>

                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="signUpPassword" pattern="[A-Z,a-z, ]*">
                    <label class="mdl-textfield__label" for="signUpPassword">Password</label>
                    <span class="mdl-textfield__error">Letters and spaces only</span>
                </div>

                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="retypePassword" pattern="[A-Z,a-z, ]*">
                    <label class="mdl-textfield__label" for="retypePassword">Retype Password</label>
                    <span class="mdl-textfield__error">Letters and spaces only</span>
                </div>

                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="email" id="signUpFullName" >
                    <label class="mdl-textfield__label" for="signUpFullName">Full Name</label>
                    <span class="mdl-textfield__error">Letters and spaces only</span>
                </div>

                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored fis-signup-btn">
                    Submit
                </button>
            </form>
        </div>
    </div><!-- End Sign Up Popup -->