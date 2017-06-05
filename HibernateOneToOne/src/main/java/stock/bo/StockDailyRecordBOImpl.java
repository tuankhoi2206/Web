package stock.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock.bo.impl.IStockDailyRecordBO;
import stock.dao.StockDailyRecordDAOImpl;
import stock.entitybk.StockDailyRecord;

@Service("stockDailyBO")
public class StockDailyRecordBOImpl implements IStockDailyRecordBO {

	@Autowired
	private StockDailyRecordDAOImpl dailyRecordDAOImpl;

	@Override
	public void setStockDailyRecord(StockDailyRecordDAOImpl dailyRecordDAOImpl) {
		this.dailyRecordDAOImpl = dailyRecordDAOImpl;
	}

	@Override
	public void save(StockDailyRecord stockDailyRecord) {
		dailyRecordDAOImpl.save(stockDailyRecord);
	}

}
