package fis.longlive.database.process;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fis.longlive.database.table.Album;

public final class ProcessAlbum {
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
	
	public static void insert(Album album) {
		beginTransaction();
		eManager.persist(album);
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static void delete(int id) {
		beginTransaction();
		eManager.remove(eManager.find(Album.class, id));
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static Album select(int id) {
		beginTransaction();
		Album album = eManager.find(Album.class, id);
		endTransaction();
		return album;
	}
	
	private static void update(int id, String type, Object value) {
		beginTransaction();
		
		Album album = eManager.find(Album.class, id);
		switch (type) {
			case "albumID":
				album.setAlbumID((Integer) value);
				break;
			case "author":
				album.setAuthor((Integer) value);
				break;
			case "category":
				album.setCategory((Integer) value);
				break;
			case "name":
				album.setName((String) value);
				break;
			default:
				break;
		}
		
		eManager.getTransaction().commit();
		
		endTransaction();
	}
	
	public static void updateAlbumID(int id, int newID) {
		update(id, "albumID", newID);
	}
	
	public static void updateName(int id, String newName) {
		update(id, "name", newName);
	}
	
	public static void updateAuthor(int id, int newAuthor) {
		update(id, "author", newAuthor);
	}
	
	public static void updateCategory(int id, int newCategory) {
		update(id, "category", newCategory);
	}
}
