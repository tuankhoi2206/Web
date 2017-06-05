package stock.impl;

import stock.entity.Stock;

public interface IStockDAO {

	Stock findByID(Integer stockId);

	void saveStock(Stock stock);

	void deleteStock(Stock stock);
}
