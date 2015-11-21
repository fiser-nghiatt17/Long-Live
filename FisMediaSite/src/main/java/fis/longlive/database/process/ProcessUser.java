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
	
	public static void delete(String username) {
		beginTransaction();
		eManager.remove(eManager.find(User.class, username));
		eManager.getTransaction().commit();
		endTransaction();
	}
	
	public static User select(String username) {
		beginTransaction();
		User user = eManager.find(User.class, username);
		endTransaction();
		return user;
	}
	
	private static void update(String username, String field, Object value) {
		beginTransaction();
		
		User user = eManager.find(User.class, username);
		
		switch (field) {
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
				user.setSex((Boolean) value);
				break;
			case "birthday":
				user.setBirthday((Date) value); 
			default:
				break;
		}
		eManager.getTransaction().commit();
		
		endTransaction();
	}
	
	public static void updateUsername(String username, String newUsername) {
		update(username, "username", newUsername);
	}
	
	public static void updatePassword(String username, String newPassword) {
		update(username, "password", newPassword);
	}
	
	public static void updateFullname(String username, String newFullname) {
		update(username, "fullname", newFullname);
	}
	
	public static void updateEmail(String username, String newEmail) {
		update(username, "email", newEmail);
	}
	
	public static void updateSex(String username, boolean newSex) {
		update(username, "sex", newSex);
	}
	
	public static void updateBirthday(String username, Date newBirthday) {
		update(username, "birthday", newBirthday);
	}
}
