package fis.longlive.database.process;

import java.util.Date;

import fis.longlive.database.table.User;

public final class ProcessUser extends Process {
	private static final int PASSWORD = 0;
	private static final int FULLNAME = 1;
	private static final int USER_GENDER = 2;
	private static final int USER_EMAIL = 3;
	private static final int USER_BIRTHDAY = 4;
	
	public static void insertUser(User user) {
		beginProcess();
		getEntityManager().persist(user);
		endProcess();
	}
	
	public static void deleteUser(String username) {
		beginProcess();
		
		User user = getEntityManager().find(User.class, username);
		getEntityManager().remove(user);
		
		endProcess();
	}
	
	public static User selectUser(String username) {
		beginProcess();
		User user = getEntityManager().find(User.class, username);
		endProcess();
		return user;
	}
	
	private static void updateUser(String username, Object newValue, int type) {
		beginProcess();
		
		User user = getEntityManager().find(User.class, username);
		
		switch (type) {
			case PASSWORD:
				user.setPassword((String) newValue);
				break;
			case FULLNAME:
				user.setFullname((String) newValue);
				break;
			case USER_GENDER:
				user.setUserGender((Boolean) newValue);
				break;
			case USER_EMAIL:
				user.setUserEmail((String) newValue);
				break;
			case USER_BIRTHDAY:
				user.setUserBirthday((Date) newValue);
				break;
		}
		getEntityManager().persist(user);
		
		endProcess();
	}
	
	public static void updatePassword(String username, String newPassword) {
		updateUser(username, newPassword, PASSWORD);
	}
	
	public static void updateFullname(String username, String newFullname) {
		updateUser(username, newFullname, FULLNAME);
	}
	
	public static void updateUserGender(String username, boolean newUserGender) {
		updateUser(username, newUserGender, USER_GENDER);
	}
	
	public static void updateUserEmail(String username, String newUserEmail) {
		updateUser(username, newUserEmail, USER_EMAIL);
	}
	
	public static void updateUserBirthday(String username, Date newUserBirthday) {
		updateUser(username, newUserBirthday, USER_BIRTHDAY);
	}
}
