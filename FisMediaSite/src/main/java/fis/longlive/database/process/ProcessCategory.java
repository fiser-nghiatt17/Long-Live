package fis.longlive.database.process;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fis.longlive.database.table.Category;

public final class ProcessCategory {
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
	
	public static void insert(Category category) {
		beginTransaction();
		eManager.persist(category);
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static void delete(int id) {
		beginTransaction();
		eManager.remove(eManager.find(Category.class, id));
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static Category select(int id) {
		beginTransaction();
		Category category = eManager.find(Category.class, id);
		endTransaction();
		return category;
	}
	
	private static void update(int id, String type, Object value) {
		beginTransaction();
		
		Category category = eManager.find(Category.class, id);
		
		switch (type) {
			case "categoryID":
				category.setCategoryID((Integer) value);
				break;
			case "name":
				category.setName((String) value);
				break;
			case "description":
				category.setDescription((String) value);
				break;
			default:
				break;
		}
		
		endTransaction();
	}
	
	public static void updateCategoryID(int id, int newID) {
		update(id, "categoryID", newID);
	}
	
	public static void updateName(int id, String newName) {
		update(id, "name", newName);
	}
	
	public static void updateDescription(int id, String newDescription) {
		update(id, "description", newDescription);
	}
}
