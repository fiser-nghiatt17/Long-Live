package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.User;

public class SettingAction extends ActionSupport{
    private String username;
    private String fullName;
    private String oldPassword;
    private String newPassword;
    private String message = "";

    public String chageInfo(){
        User user = ProcessUser.selectUser(username);
        if(user != null){
            if(!user.getPassword().equals(oldPassword)){
                message = "Wrong old password !";
            }else{
                ProcessUser.updatePassword(username, newPassword);
                ProcessUser.updateFullname(username, fullName);
                message = "Saved successfully !";
            }
        }else{
            message = "Something went wrong!";
        }

        return SUCCESS;
    }

    public String execute(){
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
