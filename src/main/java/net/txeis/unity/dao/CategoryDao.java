package net.txeis.unity.dao;

import java.util.List;

import net.txeis.unity.model.Category;

public interface CategoryDao {

	Category get(String stu_id);

	List<Category> list();
}
