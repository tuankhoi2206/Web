package stock.bo.impl;

import stock.dao.StockDAOImpl;
import stock.entity.Stock;

public interface IStockBO {

	void setStockDAO(StockDAOImpl daoImpl);

	void save(Stock stock);

	Stock getfindByID(Integer stockID);
	
	void delete(Stock stock);
}
