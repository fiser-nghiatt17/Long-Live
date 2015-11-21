package fis.longlive.database.process;

import fis.longlive.database.table.Album;
import fis.longlive.database.table.Category;
import fis.longlive.database.table.User;

public final class ProcessAlbum extends Process {
	private static final int ALBUM_NAME = 0;
	private static final int LIKE_AMOUNT = 1;
	private static final int VIEW_AMOUNT = 2;
	private static final int AUTHOR = 3;
	private static final int CATEGORY = 4;
	
	public static void insertAlbum(Album album) {
		beginProcess();
		getEntityManager().persist(album);
		endProcess();
	}
	
	public static void deleteAlbum(int albumID) {
		beginProcess();
		getEntityManager().remove(selectAlbum(albumID));
		endProcess();
	}
	
	public static Album selectAlbum(int albumID) {
		beginProcess();
		return getEntityManager().find(Album.class, albumID);
	}
	
	private static void updateAlbum(int albumID, Object newValue, int type) {
		beginProcess();
		
		Album album = selectAlbum(albumID);
		
		switch (type) {
			case ALBUM_NAME: 
				album.setAlbumName((String) newValue);
				break;
			case LIKE_AMOUNT:
				album.setLikeAmount((Integer) newValue);
				break;
			case VIEW_AMOUNT:
				album.setViewAmount((Integer) newValue);
				break;
			case AUTHOR:
				album.setUser((User) newValue);
				break;
			case CATEGORY:
				album.setCategoryBean((Category) newValue);
		}
		
		endProcess();
	}
	
	public static void updateAlbumName(int albumID, String newAlbumName) {
		updateAlbum(albumID, newAlbumName, ALBUM_NAME);
	}
	
	public static void updateLikeAmount(int albumID, int newLikeAmount) {
		updateAlbum(albumID, newLikeAmount, LIKE_AMOUNT);
	}
	
	public static void updateViewAmount(int albumID, int newViewAmount) {
		updateAlbum(albumID, newViewAmount, VIEW_AMOUNT);
	}
	
	public static void updateAuthor(int albumID, User newAuthor) {
		updateAlbum(albumID, newAuthor, AUTHOR);
	}
	
	public static void updateCategory(int albumID, Category newCategory) {
		updateAlbum(albumID, newCategory, CATEGORY);
	}
}
