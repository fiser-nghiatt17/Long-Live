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
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment  {
	@Id
	private int commentID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date commentTime;

	@Lob
	private String content;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="commentUser")
	private User user;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="onAlbum")
	private Album album;

	public Comment() {
	}

	public int getCommentID() {
		return this.commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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