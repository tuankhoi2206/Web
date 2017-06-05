package stock.common;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stock.bo.StockBOImpl;
import stock.bo.StockDailyRecordBOImpl;
import stock.entity.Stock;
import stock.entity.StockDailyRecord;

public class App {
	// @Test
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/config/BeanLocations.xml");
		
		

		StockBOImpl daoImpl = (StockBOImpl) applicationContext
				.getBean("stockBO");

		// Stock stock = daoImpl.getfindByID(1);
		// System.out.println(stock.getStockName());

		// trường hợp save giá trị id key tự generate khi truyền vào đối tượng
		// tham chiếu save xuống
		// giá trị khóa

		/*
		 * Làm sao hibernate biết được khi nào là lấy giá trị không save và khi
		 * nào biết để save
		 */
		StockDailyRecordBOImpl boImpl = (StockDailyRecordBOImpl) applicationContext
				.getBean("stockDailyBO");

		// Stock stock = daoImpl.getfindByID(1);
		//
		// System.out.println(stock.getStockName());
		// System.out.println(stock.getStockDailyRecords().size());

		Stock stock2 = new Stock("test1", "test2");

		Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>();

		StockDailyRecord stockDailyRecord = new StockDailyRecord(stock2, 10f,
				10f, 10f, 19l, new Date());
		stockDailyRecords.add(stockDailyRecord);
		stock2.setStockDailyRecords(stockDailyRecords);
		// Not-null property references a transient value - transient instance
		// must be saved before current operation
		// stockDailyRecords.add();

		stock2.setStockId(17);
		daoImpl.delete(stock2);
		System.out.println("Finish");
		// stock2.setStockDailyRecords(stockDailyRecords);
		// daoImpl.save(stock2);
		// boImpl.save(stockDailyRecord);
		//
		// // Assert.assertNotNull(stock.getStockName());
		// System.out.println(stock.getStockName());

		// daoImpl.save(stock);

		//
		// Iterator<StockDailyRecord> iterable = stock.getStockDailyRecords()
		// .iterator();
		//
		// while (iterable.hasNext()) {
		// StockDailyRecord stockDailyRecord = iterable.next();
		// System.out.println(stockDailyRecord.getPriceChange());
		//
		// }

		// daoImpl.save(stock);

		// Stock stock2 = new Stock("3", "3");
		// daoImpl.save(stock2);

		// Stock stock = daoImpl.getfindByID(1);
		// System.out.println(stock.getStockName())
		// boImpl.save(new StockDailyRecord(stock2, new Date()));

	}
}
