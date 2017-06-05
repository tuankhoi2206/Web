package stock.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock.bo.impl.IStockBO;
import stock.dao.StockDAOImpl;
import stock.entity.Stock;

@Service("stockBO")
public class StockBOImpl implements IStockBO {

	@Autowired
	private StockDAOImpl daoImpl;

	@Override
	public void setStockDAO(StockDAOImpl daoImpl) {

	}

	@Override
	// @Transactional(readOnly = false)
	public void save(Stock stock) {
		daoImpl.saveStock(stock);
	}

	@Override
	public Stock getfindByID(Integer stockId) {
		return daoImpl.findByID(stockId);
	}

	@Override
	public void delete(Stock stock) {
		daoImpl.delete(stock);
	}

}
