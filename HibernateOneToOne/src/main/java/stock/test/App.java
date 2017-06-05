package stock.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import stock.entity.Stock;
import stock.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.openSession();

		Transaction ts = null;

		try {

			ts = session.beginTransaction();

			Stock stock2 = new Stock("test3", "test3");

			// StockDetail detail = new StockDetail(stock2, "test3", "test3",
			// "test3", new Date());

			// stock2.setStockDetail(detail);
			// session.save(detail);
			// session.save(detail);

			// Stock stock = (Stock) session.get(Stock.class, 24);

			// session.delete(stock);

			Stock stock = new Stock("test9", "test9");
			session.save(stock);

			// Category category = new Category(1, "ktest", "ktest");

			// session.save(category);
			 ts.commit();

		} catch (Exception e) {
			if (ts != null) {
				System.out.println("Fdfdfd");
			}
			ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
