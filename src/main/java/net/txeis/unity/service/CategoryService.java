package net.txeis.unity.service;

import java.util.List;

import net.txeis.unity.exception.CustomException;
import net.txeis.unity.model.Category;

public interface CategoryService {

	Category get(String id) throws CustomException;

	List<Category> list() throws CustomException;

}