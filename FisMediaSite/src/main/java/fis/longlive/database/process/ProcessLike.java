package fis.longlive.database.process;

import fis.longlive.database.table.Album;
import fis.longlive.database.table.Like;
import fis.longlive.database.table.User;

public final class ProcessLike extends Process {
	private static final int LIKE_USER = 0;
	private static final int ON_ALBUM = 1;
	private static final int STATE = 2;
	
	public static void insertUser(Like like) {
		beginProcess();
		getEntityManager().persist(like);
		endProcess();
	}
	
	public static void deleteLike(int likeID) {
		beginProcess();
		
		Like like = getEntityManager().find(Like.class, likeID);
		getEntityManager().remove(like);
		
		endProcess();
	}
	
	public static Like selectLike(int likeID) {
		beginProcess();
		Like like = getEntityManager().find(Like.class, likeID);
		endProcess();
		return like;
	}
	
	private static void updateLike(int likeID, Object newValue, int type) {
		beginProcess();
		
		Like like = getEntityManager().find(Like.class, likeID);
		
		switch (type) {
			case LIKE_USER:
				like.setUser((User) newValue);
				break;
			case ON_ALBUM:
				like.setAlbum((Album) newValue);
				break;
			case STATE:
				like.setState((Boolean) newValue);
				break;
		}
		getEntityManager().persist(like);
		
		endProcess();
	}
	
	public static void updateLikeUser(int likeID, User newLikeUser) {
		updateLike(likeID, newLikeUser, LIKE_USER);
	}
	
	public static void updateOnAlbum(int likeID, Album newOnAlbum) {
		updateLike(likeID, newOnAlbum, ON_ALBUM);
	}
	
	public static void updateState(int likeID, boolean newState) {
		updateLike(likeID, newState, STATE);
	}
}
