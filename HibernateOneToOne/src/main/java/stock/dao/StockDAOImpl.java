package stock.dao;

import org.springframework.stereotype.Repository;

import stock.entity.Stock;
import stock.impl.IStockDAO;
import stock.utils.AbstractHibernateDaoSupport;

/*
 * Ä�á»‹nh nghÄ©a ???
 * Ä‘Ã¡nh dáº¥u Ä‘á»ƒ chiu sá»± quáº£n lÃ½ gÃ¬?
 */
@Repository("stockDao")
public class StockDAOImpl extends AbstractHibernateDaoSupport implements
		IStockDAO {

	@Override
	public Stock findByID(Integer stockId) {
		return (Stock) getHibernateTemplate().get(Stock.class, stockId);
	}

	@Override
	public void saveStock(Stock stock) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(stock);
	}

	@Override
	public void delete(Stock stock) {
		getHibernateTemplate().setCheckWriteOperations(false);
		Stock get = getHibernateTemplate().get(Stock.class, stock.getStockId());
		System.out.println(get.getStockName());
		getHibernateTemplate().delete(get);
	}

}
