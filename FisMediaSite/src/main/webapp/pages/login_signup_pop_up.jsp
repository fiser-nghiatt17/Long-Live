<!-- Login Popup -->
    <div class="modal fade" id="fis-login-container">
            <div class="fis-login-container">
                <div class="mdl-progress mdl-js-progress mdl-progress__indeterminate fis-loader"></div>
                <form action="login" method="post" id="loginForm">
                    <div class="fis-login-title">
                        <h3>Log In</h3>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield user-name">
                        <input class="mdl-textfield__input" type="text" id="userName" name="username">
                        <label class="mdl-textfield__label" for="userName">User name</label>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="password" id="password" name="password">
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
            <div class="mdl-progress mdl-js-progress mdl-progress__indeterminate fis-loader"></div>
            <form action="signup" method="post" id="loginSignUp">
                <div class="fis-login-title">
                    <h3>Sign Up</h3>
                </div>
                <div class="mdl-textfield mdl-js-textfield user-name">
                    <input class="mdl-textfield__input" type="text" id="signUpUserName" name="username">
                    <label class="mdl-textfield__label" for="signUpUserName">User name</label>
                </div>

                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="signUpPassword" name="password">
                    <label class="mdl-textfield__label" for="signUpPassword">Password</label>
                </div>

                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="retypePassword" name="confirmPassword">
                    <label class="mdl-textfield__label" for="retypePassword">Retype Password</label>
                </div>

                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="signUpFullName" name="fullName">
                    <label class="mdl-textfield__label" for="signUpFullName">Full Name</label>
                </div>

                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored fis-signup-btn">
                    Submit
                </button>
            </form>
        </div>
    </div><!-- End Sign Up Popup -->