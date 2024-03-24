package models;

import java.util.List;

public interface categorieDao {
	public List<String> getAllCategory();
	public int findCategorieIdByName(String categoryName);
}
