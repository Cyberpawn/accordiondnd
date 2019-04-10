package net.txeis.unity.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.txeis.unity.dao.CategoryDao;
import net.txeis.unity.exception.CustomException;
import net.txeis.unity.model.Category;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category get(String id) throws CustomException  {
		try {
			return categoryDao.get(id);
		} catch (PersistenceException e) {
			CustomException cE = new CustomException();
			cE.setErrorCause(e.getCause());
			cE.setStacktrace(e);

			throw cE;
		}
	}

	@Override
	public List<Category> list() throws CustomException  {
		try {
			return categoryDao.list();
		} catch (PersistenceException e) {

			CustomException cE = new CustomException();
			cE.setErrorCause(e.getCause());
			cE.setStacktrace(e);

			throw cE;
		}

	}

}
