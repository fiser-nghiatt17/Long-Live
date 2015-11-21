package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileUploadAction extends ActionSupport implements ServletRequestAware{

    private File[] userImage;
    private String[] userImageContentType;
    private String[] userImageFileName;
    private HttpServletRequest servletContext;
    private String albumName;

    public String createAlbum() {
        try {

            String filePath = servletContext.getServletContext().getRealPath("/").concat("images");
            System.out.println("Image location:" + filePath);
            File fileToCreate = new File(filePath, this.userImageFileName[0]);

            FileUtils.copyFile(this.userImage[0], fileToCreate);
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            return INPUT;
        }
        return SUCCESS;
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
