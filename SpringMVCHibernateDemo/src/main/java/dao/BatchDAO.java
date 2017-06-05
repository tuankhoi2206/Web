package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import entities.Batch;

public class BatchDAO extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Batch> getAllBatch() {
		String hql = "select b from Batch b";
		return (List<Batch>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<Batch> getBatchList() {
		String query = "select b from Batch b";
		return (List<Batch>) getHibernateTemplate().find(query);
	}

	public void addBatch(Batch batch) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(batch);
	}
}
