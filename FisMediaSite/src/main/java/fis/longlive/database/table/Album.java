package fis.longlive.database.table;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the albums database table.
 * 
 */
@Entity
@Table(name="albums")
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album  {
	@Id
	private int albumID;

	private String albumName;

	private int likeAmount;

	private int viewAmount;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="author")
	private User user;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category")
	private Category categoryBean;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="album")
	private List<Comment> comments;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="album")
	private List<Like> likes;

	//bi-directional many-to-one association to Picture
	@OneToMany(mappedBy="album")
	private List<Picture> pictures;

	public Album() {
	}

	public int getAlbumID() {
		return this.albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getLikeAmount() {
		return this.likeAmount;
	}

	public void setLikeAmount(int likeAmount) {
		this.likeAmount = likeAmount;
	}

	public int getViewAmount() {
		return this.viewAmount;
	}

	public void setViewAmount(int viewAmount) {
		this.viewAmount = viewAmount;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategoryBean() {
		return this.categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAlbum(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAlbum(null);

		return comment;
	}

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setAlbum(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setAlbum(null);

		return like;
	}

	public List<Picture> getPictures() {
		return this.pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Picture addPicture(Picture picture) {
		getPictures().add(picture);
		picture.setAlbum(this);

		return picture;
	}

	public Picture removePicture(Picture picture) {
		getPictures().remove(picture);
		picture.setAlbum(null);

		return picture;
	}

}