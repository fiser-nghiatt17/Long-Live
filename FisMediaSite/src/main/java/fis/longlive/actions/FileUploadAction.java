package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.process.ProcessPicture;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.Album;
import fis.longlive.database.table.Picture;
import fis.longlive.database.table.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.UUID;

public class FileUploadAction extends ActionSupport implements ServletRequestAware {

    private File[] userImage;
    private String[] userImageContentType;
    private String[] userImageFileName;
    private HttpServletRequest servletContext;
    private String albumName;
    private String username;

    public String createAlbum() {
        Album album = new Album();
        username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
        User user = ProcessUser.selectUser(username);
        album.setAlbumName(albumName);
        album.setUser(user);
        album.setLikeAmount(0);
        album.setViewAmount(0);
        ProcessAlbum.insertAlbum(album);
        try {
            int userImageCount = userImage.length;
            for (int i = 0; i < userImageCount; i++) {
                Picture picture = new Picture();
                String filePath = servletContext.getServletContext().getRealPath("/").concat("images");
                String[] filenameSplits = userImageFileName[i].split("\\.");
                String newFilename = UUID.randomUUID() + "." + filenameSplits[filenameSplits.length - 1];
                File fileToCreate = new File(filePath, newFilename);
                FileUtils.copyFile(this.userImage[i], fileToCreate);
                picture.setUploadDate(new Date());
                picture.setPictureName(userImageFileName[i]);
                picture.setPictureURL("images/" + newFilename);
                picture.setAlbum(album);
                ProcessPicture.insertPicture(picture);
            }
            ProcessAlbum.selectAlbum(album.getAlbumID());
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            return INPUT;
        }
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public File[] getUserImage() {
        return userImage;
    }

    public void setUserImage(File[] userImage) {
        this.userImage = userImage;
    }

    public String[] getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String[] userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    public String[] getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String[] userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        servletContext = request;
    }
}
