package fis.longlive.database.process;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fis.longlive.database.table.Comment;

public final class ProcessComment {
	private static EntityManagerFactory eFactory;
	private static EntityManager eManager;
	
	private static void beginTransaction() {
		eFactory = Persistence.createEntityManagerFactory("FisMediaSite");
		eManager = eFactory.createEntityManager();
		eManager.getTransaction().begin();
	}
	
	private static void endTransaction() {
		eManager.close();
		eFactory.close();
	}
	
	public static void insert(Comment comment) {
		beginTransaction();
		eManager.persist(comment);
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static void delete(int id) {
		beginTransaction();
		eManager.remove(eManager.find(Comment.class, id));
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static Comment select(int id) {
		beginTransaction();
		Comment comment = eManager.find(Comment.class, id);
		endTransaction();
		return comment;
	}
	
	private static void update(int id, String type, Object value) {
		beginTransaction();
		
		Comment comment = eManager.find(Comment.class, id);
		
		switch (type) {
			case "categoryID":
				comment.setCommentID((Integer) value);
				break;
			case "user":
				comment.setUser((Integer) value);
			case "onAlbum":
				comment.setOnAlbum((Integer) value);
				break;
			case "content":
				comment.setContent((String) value);
				break;
			case "commentTime":
				comment.setCommentTime((Date) value);
			default:
				break;
		}
		
		endTransaction();
	}
	
	public static void updateCommentID(int id, int newID) {
		update(id, "commentID", newID);
	}
	
	public static void updateUser(int id, int newUser) {
		update(id, "user", newUser);
	}
	
	public static void updateContent(int id, String newContent) {
		update(id, "content", newContent);
	}
	
	public static void updateOnAlbum(int id, int newOnPicture) {
		update(id, "onPicture", newOnPicture);
	}
	
	public static void updateCommentTime(int id, int newCommentTime) {
		update(id, "commentTime", newCommentTime);
	}
}
