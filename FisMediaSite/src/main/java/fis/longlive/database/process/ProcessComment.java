package fis.longlive.database.process;

import fis.longlive.database.table.Album;
import fis.longlive.database.table.Comment;
import fis.longlive.database.table.User;

import java.util.Date; 

public final class ProcessComment extends Process {
	private static final int COMMENT_USER = 0;
	private static final int ON_ALBUM = 1;
	private static final int COMMENT_TIME = 2;
	private static final int CONTENT = 3;
	
	public static void insertComment(Comment comment) {
		beginProcess();
		getEntityManager().persist(comment);
		endProcess();
	}
	
	public static void deleteComment(int commentID) {
		getEntityManager().remove(selectComment(commentID));
	}
	
	public static Comment selectComment(int commentID) {
		beginProcess();
		Comment comment = getEntityManager().find(Comment.class, commentID);
		endProcess();
		return comment;
	}
	
	private static void updateComment(int commentID, Object newValue, int type) {
		beginProcess();
		
		Comment comment = selectComment(commentID);
		
		switch (type) {
			case COMMENT_USER:
				comment.setUser((User) newValue);
				break;
			case ON_ALBUM:
				comment.setAlbum((Album) newValue);
				break;
			case COMMENT_TIME:
				comment.setCommentTime((Date) newValue);
				break;
			case CONTENT:
				comment.setContent((String) newValue);
				break;
		}
		
		endProcess();
	}
	
	public static void updateCommentUser(int commentID, User newCommentUser) {
		updateComment(commentID, newCommentUser, COMMENT_USER);
	}
	
	public static void updateOnAlbum(int commentID, Album newOnAlbum) {
		updateComment(commentID, newOnAlbum, ON_ALBUM);
	}
	
	public static void updateCommentTime(int commentID, Date newCommentTime) {
		updateComment(commentID, newCommentTime, COMMENT_TIME);
	}
	
	public static void updateContent(int commentID, String newContent) {
		updateComment(commentID, newContent, CONTENT);
	}
}
