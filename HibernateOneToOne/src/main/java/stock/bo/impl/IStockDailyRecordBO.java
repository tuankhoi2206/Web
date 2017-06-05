package stock.bo.impl;

import stock.dao.StockDailyRecordDAOImpl;
import stock.entitybk.StockDailyRecord;

public interface IStockDailyRecordBO {

	void setStockDailyRecord(StockDailyRecordDAOImpl dailyRecordDAOImpl);

	void save(StockDailyRecord stockDailyRecord);

}
