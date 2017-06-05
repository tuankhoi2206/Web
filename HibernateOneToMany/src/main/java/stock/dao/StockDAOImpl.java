package stock.dao;

import org.hibernate.LockMode;
import org.springframework.stereotype.Repository;

import stock.entity.Stock;
import stock.impl.IStockDAO;
import stock.utils.AbstractHibernateDaoSupport;

/*
 * Định nghĩa ???
 * đánh dấu để chiu sự quản lý gì?
 */
@Repository("stockDao")
public class StockDAOImpl extends AbstractHibernateDaoSupport implements
		IStockDAO {

	@Override
	public Stock findByID(Integer stockId) {
		getHibernateTemplate().setCheckWriteOperations(false);
		return (Stock) getHibernateTemplate().get(Stock.class, stockId);
	}

	@Override
	public void saveStock(Stock stock) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(stock);
	}

	@Override
	public void deleteStock(Stock stock) {
		getHibernateTemplate().setCheckWriteOperations(false);

		getHibernateTemplate().delete(
				getHibernateTemplate().get(Stock.class, stock.getStockId()));

	}

}
