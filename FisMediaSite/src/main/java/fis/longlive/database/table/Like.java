package fis.longlive.database.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the likes database table.
 * 
 */
@Entity
@Table(name="likes")
@NamedQuery(name="Like.findAll", query="SELECT l FROM Like l")
public class Like {
	@Id
	private int likeID;

	private boolean state;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="likeUser")
	private User user;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="onAlbum")
	private Album album;

	public Like() {
	}

	public int getLikeID() {
		return this.likeID;
	}

	public void setLikeID(int likeID) {
		this.likeID = likeID;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}