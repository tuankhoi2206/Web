package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import entity.Products;
import utils.AbstractHibernateDAOSupport;

public class ProductDAOImpl extends AbstractHibernateDAOSupport implements
		ProductDAO {

	@SuppressWarnings("unchecked")
	public List<Products> listProduct() {

		return getHibernateTemplate().execute(
				new HibernateCallback<List<Products>>() {
					public List<Products> doInHibernate(Session session) {
						Query query = session.createQuery("from Products");
						query.setCacheable(true);
						return query.list();
					}
				});
	}

	public List<Products> findByName(String name) {
		return null;
	}

	public void editProduct(Products products) {
		getHibernateTemplate().update(products);
	}

	@SuppressWarnings("unchecked")
	public Products findById(String id) {
		List<Products> lstProducts = (List<Products>) getHibernateTemplate()
				.find("from Products where code=?", id);
		System.out.println("K test " + lstProducts.size());
		return lstProducts != null ? lstProducts.get(0) : null;
	}
}
