<%@ taglib prefix="s" uri="/struts-tags" %>
<main class="mdl-layout__content">
<div class="page-content"><!-- Your content goes here -->

     <form class="fis-setting" action="chageInfo" method="post">
             <div class="mdl-progress mdl-js-progress mdl-progress__indeterminate fis-loader" style="width: 100%"></div>
             <div class="fis-setting-item">
                     <p>Full Name</p>
                     <div class="mdl-textfield mdl-js-textfield">
                             <input  name="fullName" class="mdl-textfield__input" type="text" id="setting-fullname"
                                     value=<%= "\""+session.getAttribute("fullName")+"\""%>>
                             <label class="mdl-textfield__label" for="setting-fullname">Full Name</label>
                     </div>
             </div>
             <div class="fis-setting-item">
                     <p>User Name</p>
                     <div class="mdl-textfield mdl-js-textfield">
                             <input name="username" class="mdl-textfield__input" type="text" id="setting-username" readonly="readonly"
                                    style="color: #000" value=<%= "\""+session.getAttribute("username")+"\""%>>
                             <label class="mdl-textfield__label" for="setting-username"></label>
                     </div>
             </div>
             <div class="fis-setting-item">
                     <p>Old Password</p>
                     <div class="mdl-textfield mdl-js-textfield">
                             <input name="oldPassword" class="mdl-textfield__input" type="password" id="setting-old-password">
                             <label class="mdl-textfield__label" for="setting-old-password"></label>
                     </div>
             </div>
             <div class="fis-setting-item">
                     <p>New Password</p>
                     <div class="mdl-textfield mdl-js-textfield">
                             <input name="newPassword" class="mdl-textfield__input" type="password" id="setting-new-password">
                             <label class="mdl-textfield__label" for="setting-new-password"></label>
                     </div>
             </div>
             <div class="fis-setting-item">
                     <p>Retype Password</p>
                     <div class="mdl-textfield mdl-js-textfield">
                             <input name="retypeNewPassword"  class="mdl-textfield__input" type="password" id="setting-retype-password">
                             <label class="mdl-textfield__label" for="setting-retype-password"></label>
                     </div>
             </div>
             <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                     Save
             </button>
     </form>

</div><!-- End Your content goes here -->
</main>