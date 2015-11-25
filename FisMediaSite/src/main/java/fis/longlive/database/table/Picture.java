package fis.longlive.database.table;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pictures database table.
 * 
 */
@Entity
@Table(name="pictures")
@NamedQuery(name="Picture.findAll", query="SELECT p FROM Picture p")
public class Picture {
	@Id
	private int pictureID;

	@Lob
	private String description;

	private String pictureName;

	@Lob
	private String pictureURL;

	@Temporal(TemporalType.DATE)
	private Date uploadDate;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="inAlbum")
	private Album album;

	public Picture() {
	}

	public int getPictureID() {
		return this.pictureID;
	}

	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureName() {
		return this.pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureURL() {
		return this.pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}