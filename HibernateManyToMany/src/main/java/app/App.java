package app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Category;
import entity.Stock;
import entity.StockCategory;
import entity.StockCategoryId;
import utils.HibernateUtils;

public class App {
	public static void main(String[] args) {

		/*
		 * Trường hợp đặc ra.
		 */
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();

			// Stock stock = (Stock) session.load(Stock.class, 1);
			// System.out.println(stock.getStockName());

			Stock stock = new Stock("5", "5");

			// session.saveOrUpdate(stock);

			Category category1 = new Category(1, "CONSUMER", "CONSUMER COMPANY");

			Stock stock2 = (Stock) session.get(Stock.class, 1);

			Category category = (Category) session.get(Category.class, 1);

			StockCategoryId id = new StockCategoryId(stock2.getStockId(),
					category.getCategoryId(), new Date(), "TK");

			StockCategory stockCategory = new StockCategory(id, stock2,
					category1);

			session.save(stockCategory);

			// session.save(category1);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}
}
