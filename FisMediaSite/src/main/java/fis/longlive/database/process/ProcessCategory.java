package fis.longlive.database.process;

import fis.longlive.database.table.Category;

public final class ProcessCategory extends Process {
	private static final int CATEGORY_NAME = 0;
	private static final int DESCRIPTION = 1;
	
	public static void insertCategory(Category category) {
		beginProcess();
		getEntityManager().persist(category);
		endProcess();
	}
	
	public static void deleteCategory(int categoryID) {
		beginProcess();
		
		Category category = getEntityManager().find(Category.class, categoryID);
		getEntityManager().remove(category);
		getEntityManager().getTransaction().commit();
		
		endProcess();
	}
	
	public static Category selectCategory(int categoryID) {
		beginProcess();
		Category category = getEntityManager().find(Category.class, categoryID);
		endProcess();
		return category;
	}
	
	private static void updateCategory(int categoryID, Object newValue, int type) {
		beginProcess();
		
		Category category = getEntityManager().find(Category.class, categoryID);
		
		switch (type) {
			case CATEGORY_NAME: 
				category.setCategoryName((String) newValue);
				break;
			case DESCRIPTION:
				category.setDescription((String) newValue);
				break;
		}
		
		getEntityManager().persist(category);
		
		endProcess();
	}
	
	public static void updateCategoryName(int categoryID, String newCategoryName) {
		updateCategory(categoryID, newCategoryName, CATEGORY_NAME);
	}
	
	public static void updateDescription(int categoryID, String newDescription) {
		updateCategory(categoryID, newDescription, DESCRIPTION);
	}
}
