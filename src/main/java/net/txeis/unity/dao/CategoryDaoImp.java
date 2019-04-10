package net.txeis.unity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.txeis.unity.model.Category;

@Repository
public class CategoryDaoImp implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category get(String id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public List<Category> list() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Category").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}
}