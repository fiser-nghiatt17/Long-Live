package fis.longlive.database.process;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fis.longlive.database.table.Picture;

public final class ProcessPicture {
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
	
	public static void insert(Picture picture) {
		beginTransaction();
		eManager.persist(picture);
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static void delete(int id) {
		beginTransaction();
		eManager.remove(select(id));
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static Picture select(int id) {
		beginTransaction();
		Picture picture = eManager.find(Picture.class, id);
		endTransaction();
		return picture;
	}
	
	private static void update(int id, String field, Object value) {
		beginTransaction();
		
		Picture picture = select(id);
		
		switch (field) {
			case "pictureID": 
				picture.setPictureID((Integer) value);
				break;
			case "name":
				picture.setName((String) value);
				break;
			case "url": 
				picture.setUrl((String) value);
				break;
			case "description":
				picture.setDescription((String) value);
				break;
			case "dateUpdate": 
				picture.setDateUpdate((Date) value);
				break;
			case "view":
				picture.setView((Integer) value);
				break;
			case "album":
				picture.setAlbum((Integer) value); 
			default:
				break;
		}
		eManager.getTransaction().commit();
		
		endTransaction();
	}
	
	public static void updatePictureID(int id, int newID) {
		update(id, "pictureID", newID);
	}
	
	public static void updateName(int id, String newName) {
		update(id, "name", newName);
	}
	
	public static void updateAlbum(int id, int newAlbum) {
		update(id, "album", newAlbum);
	}
	
	public static void updateUrl(int id, String newUrl) {
		update(id, "url", newUrl);
	}
	
	public static void updateView(int id, int newView) {
		update(id, "view", newView);
	}
	
	public static void updateDescription(int id, String newDescription) {
		update(id, "description", newDescription);
	}
	
	public static void updateBirthday(int id, Date newBirthday) {
		update(id, "birthday", newBirthday);
	}
}
