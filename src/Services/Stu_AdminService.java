package Services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import Entity.Stu_Admin;
import Impl.Stu_AdminImpl;
import Utils.GetSession;

public class Stu_AdminService implements Stu_AdminImpl {

	private Session session;
	private List<Stu_Admin> allpost;
	private Criteria criteria;
	@Override
	public void sava(Stu_Admin stu_Admin) {
		session = GetSession.Init();
		session.save(stu_Admin);// 注册成功
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
public List<Stu_Admin> selectAllpost(){
	session = GetSession.Init();
	criteria = session.createCriteria(Stu_Admin.class);
	criteria.addOrder(Order.desc("reportId"));
	allpost = criteria.list();
	try {
		GetSession.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return allpost;
}
}
