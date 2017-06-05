package stock.bo.impl;

import stock.dao.StockDailyRecordDAOImpl;
import stock.entity.StockDailyRecord;

public interface IStockDailyRecordBO {

	void setStockDailyRecord(StockDailyRecordDAOImpl dailyRecordDAOImpl);

	void save(StockDailyRecord stockDailyRecord);

}
