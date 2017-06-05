package stock.common;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stock.bo.StockBOImpl;
import stock.bo.StockDailyRecordBOImpl;
import stock.entity.Stock;

public class App {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/config/BeanLocations.xml");

		StockBOImpl daoImpl = (StockBOImpl) applicationContext
				.getBean("stockBO");

		// Stock stock = daoImpl.getfindByID(29);
		// System.out.println(stock.getStockName());

		Stock stock = new Stock();
		System.out.println(stock.equals(null));
		// Stock stock = daoImpl.getfindByID(1);
		// System.out.println(stock.getStockName());

		// trường hợp save giá trị id key tự generate khi truyền vào đối tượng
		// tham chiếu save xuống
		// giá trị khóa

		/*
		 * Làm sao hibernate biết được khi nào là lấy giá trị không save và khi
		 * nào biết để save
		 */
		// StockDailyRecordBOImpl boImpl = (StockDailyRecordBOImpl)
		// applicationContext
		// .getBean("stockDailyBO");
		//
		// Stock stock = daoImpl.getfindByID(1);
		//
		// System.out.println(stock.getStockName());
		//
		// Iterator<StockDailyRecord> iterable = stock.getStockDailyRecords()
		// .iterator();
		//
		//
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
