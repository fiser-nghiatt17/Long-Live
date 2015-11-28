package fis.longlive.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.process.ProcessComment;
import fis.longlive.database.process.ProcessPicture;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.Album;
import fis.longlive.database.table.Comment;
import fis.longlive.database.table.Picture;
import fis.longlive.database.table.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nghiatran on 11/22/15.
 */
public class AlbumAction extends ActionSupport implements ServletRequestAware {
    private int albumId;
    private Album album;
    private User author;
    private List<Picture> pictures;
    private List<Comment> comments;
    private String newComment;
    private int like;
    private String isOwner;
    private File[] userImage;
    private String[] userImageFileName;
    private String[] userImageContentType;

    private HttpServletRequest servletRequest;

    public String execute() {
        album = ProcessAlbum.selectAlbum(albumId);
        ProcessAlbum.updateViewAmount(albumId, album.getViewAmount() + 1);
        album = ProcessAlbum.selectAlbum(albumId);
        pictures = album.getPictures();
        comments = album.getComments();
        author = album.getUser();
        ActionContext.getContext().getSession().put("albumId", albumId);
        return SUCCESS;
    }

    public String editAlbum(){
        album = ProcessAlbum.selectAlbum(albumId);
        pictures = album.getPictures();

        author = album.getUser();
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(author.getUsername().equals(session.getAttribute("username")))
            isOwner = "true";
        else isOwner = "false";

        ActionContext.getContext().getSession().put("albumId", albumId);

        return "success";
    }

    public String addPictures() {
        albumId = (int) ActionContext.getContext().getSession().get("albumId");
        album = ProcessAlbum.selectAlbum(albumId);
        try {
            int userImageCount = userImage.length;
            for (int i = 0; i < userImageCount; i++) {
                Picture picture = new Picture();
                String filePath = servletRequest.getServletContext().getRealPath("/").concat("images");
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
        }
        return SUCCESS;
    }

    public String likeAlbum() {
        album = ProcessAlbum.selectAlbum(albumId);
        ProcessAlbum.updateLikeAmount(albumId, album.getLikeAmount() + like);
        return "success";
    }

    public String addComment() {
        String username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
        albumId = (int) ActionContext.getContext().getSession().get("albumId");
        User user = ProcessUser.selectUser(username);
        album = ProcessAlbum.selectAlbum(albumId);
        Comment comment = new Comment();
        comment.setAlbum(album);
        comment.setCommentTime(new Date());
        comment.setUser(user);
        comment.setContent(newComment);
        ProcessComment.insertComment(comment);
        return SUCCESS;
    }

    public File[] getUserImage() {
        return userImage;
    }

    public void setUserImage(File[] userImage) {
        this.userImage = userImage;
    }

    public String[] getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String[] userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    public String[] getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String[] userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        servletRequest = request;
    }
}
