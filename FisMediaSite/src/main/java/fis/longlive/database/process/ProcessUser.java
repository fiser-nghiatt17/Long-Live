package fis.longlive.database.process;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fis.longlive.database.table.User;

public final class ProcessUser {
	
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
	
	public static void insert(User user) {
		beginTransaction();
		eManager.persist(user);
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static void delete(int id) {
		beginTransaction();
		eManager.remove(select(id));
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static User select(int id) {
		beginTransaction();
		User user = eManager.find(User.class, id);
		endTransaction();
		return user;
	}
	
	private static void update(int id, String field, Object value) {
		beginTransaction();
		
		User user = select(id);
		
		switch (field) {
			case "userID": 
				user.setUserID((Integer) value);
				break;
			case "username":
				user.setUsername((String) value);
				break;
			case "password": 
				user.setPassword((String) value);
				break;
			case "email":
				user.setEmail((String) value);
				break;
			case "fullname": 
				user.setFullname((String) value);
				break;
			case "sex":
				user.setSex((Byte) value);
				break;
			case "birthday":
				user.setBirthday((Date) value); 
			default:
				break;
		}
		eManager.getTransaction().commit();
		
		endTransaction();
	}
	
	public static void updateUserID(int id, int newID) {
		update(id, "userID", newID);
	}
	
	public static void updateUsername(int id, String newUsername) {
		update(id, "username", newUsername);
	}
	
	public static void updatePassword(int id, String newPassword) {
		update(id, "password", newPassword);
	}
	
	public static void updateFullname(int id, String newFullname) {
		update(id, "fullname", newFullname);
	}
	
	public static void updateEmail(int id, String newEmail) {
		update(id, "email", newEmail);
	}
	
	public static void updateSex(int id, byte newSex) {
		update(id, "sex", newSex);
	}
	
	public static void updateBirthday(int id, Date newBirthday) {
		update(id, "birthday", newBirthday);
	}
}
