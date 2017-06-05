package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import dao.iml.IBatchDAO;
import entity.Batch;

public class BatchDAO extends HibernateDaoSupport implements IBatchDAO {

	public void save(Batch batch) {
		getHibernateTemplate().save(batch);
	}

	@SuppressWarnings("unchecked")
	public List<Batch> getBatchs() {
		return (List<Batch>) getHibernateTemplate().find("from Batch");
	}
}
