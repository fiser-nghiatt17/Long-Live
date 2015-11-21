package fis.longlive.database.process;

import java.util.Date;

import fis.longlive.database.table.Album;
import fis.longlive.database.table.Picture;

public final class ProcessPicture extends Process {
	private static final int PICTURE_NAME = 0;
	private static final int IN_ALBUM = 1;
	private static final int PICTURE_URL = 2;
	private static final int UPLOAD_DATE = 3;
	private static final int DESCRIPTION = 4;
	
	public static void insertPicture(Picture picture) {
		beginProcess();
		getEntityManager().persist(picture);
		endProcess();
	}
	
	public static void deletePicture(int pictureID) {
		getEntityManager().remove(selectPicture(pictureID));
	}
	
	public static Picture selectPicture(int pictureID) {
		beginProcess();
		Picture picture = getEntityManager().find(Picture.class, pictureID);
		endProcess();
		return picture;
	}
	
	private static void updatePicture(int pictureID, Object newValue, int type) {
		beginProcess();
		
		Picture picture = selectPicture(pictureID);
		
		switch (type) {
			case PICTURE_NAME:
				picture.setPictureName((String) newValue);
				break;
			case IN_ALBUM:
				picture.setAlbum((Album) newValue);
				break;
			case PICTURE_URL:
				picture.setPictureURL((String) newValue);
				break;
			case UPLOAD_DATE:
				picture.setUploadDate((Date) newValue);
				break;
			case DESCRIPTION:
				picture.setDescription((String) newValue);
				break;
		}
		
		endProcess();
	}
	
	public static void updatePictureName(int pictureID, String newPictureName) {
		updatePicture(pictureID, newPictureName, PICTURE_NAME);
	}
	
	public static void updateInAlbum(int pictureID, Album newInAlbum) {
		updatePicture(pictureID, newInAlbum, IN_ALBUM);
	}
	
	public static void updatePictureURL(int pictureID, String newPictureURL) {
		updatePicture(pictureID, newPictureURL, PICTURE_URL);
	}
	
	public static void updateUploadDate(int pictureID, Date newUploadDate) {
		updatePicture(pictureID, newUploadDate, UPLOAD_DATE);
	}
	
	public static void updateDescription(int pictureID, String newDescription) {
		updatePicture(pictureID, newDescription, DESCRIPTION);
	}
}
