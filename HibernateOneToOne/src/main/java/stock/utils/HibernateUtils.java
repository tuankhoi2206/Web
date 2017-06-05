package stock.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		/*
		 * mặc định đọc file cấu hình ở đâu
		 */
		Configuration configuration = new Configuration();
		configuration.configure();

		// ServiceRegistry
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		return sessionFactory;

	}

	public static Session getSession() {
		Session session = (Session) HibernateUtils.session.get();
		if (session == null) {
			session = SESSION_FACTORY.openSession();
			HibernateUtils.session.set(session);
		}
		return session;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	public static void shutdown() {
		SESSION_FACTORY.close();
	}

	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private static final ThreadLocal transaction = new ThreadLocal();
}
