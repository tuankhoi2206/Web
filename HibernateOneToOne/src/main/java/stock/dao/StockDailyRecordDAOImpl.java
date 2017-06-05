package stock.dao;

import org.springframework.stereotype.Repository;

import stock.entitybk.StockDailyRecord;
import stock.impl.IStockDailyRecord;
import stock.utils.AbstractHibernateDaoSupport;

@Repository("stockDAO")
public class StockDailyRecordDAOImpl extends AbstractHibernateDaoSupport
		implements IStockDailyRecord {

	@Override
	public void save(StockDailyRecord stockDailyRecord) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(stockDailyRecord);
	}

}
