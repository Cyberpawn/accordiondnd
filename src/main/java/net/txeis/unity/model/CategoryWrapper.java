package net.txeis.unity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Category> categories = new ArrayList<>();

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}