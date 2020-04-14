package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetSession {
	private static Session session;
	private static Transaction transaction;
	private static SessionFactory sessionFactory;
	public static Session Init() {
		if (sessionFactory == null) {
			sessionFactory = GetSessionFactory.getSessionFactory();// 获取session对象
		}
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();// 开启事务
		return session;
	}

	public static void close() {
		transaction.commit();// 提交事务
		//session.close(); // 关闭session
		//sessionFactory.close();// 关闭会话工厂
	}
}
