package fis.longlive.database.table;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the album database table.
 * 
 */
@Entity
@Table(name="album")
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int albumID;

	private int author;

	private int category;

	private String name;

	public Album() {
	}

	public int getAlbumID() {
		return this.albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}