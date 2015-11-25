package fis.longlive.database.process;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Process {
	private static final String PERSISTENCE_UNIT = "FisMediaSite";
	
	private static EntityManagerFactory eFactory;
	private static EntityManager eManager;
	
	private static boolean flagCommit = false;
	
	protected static EntityManager getEntityManager() {
		return Process.eManager;
	}
	
	protected static void beginProcess() {
		eFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		eManager = eFactory.createEntityManager();
		eManager.getTransaction().begin();
	}
	
	protected static void endProcess() {
		if (isOpen()) {
			eManager.getTransaction().commit();
			eManager.close();
			eFactory.close();
		}
	}
	
	private static boolean isOpen() {
		return (eFactory.isOpen() && eManager.isOpen());
	}
	
	public static boolean checkFlag() {
		return flagCommit;
	}
}
