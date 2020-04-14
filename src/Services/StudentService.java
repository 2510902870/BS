package Services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Entity.Students;
import Impl.StudentImpl;
import Utils.GetSession;

public class StudentService implements StudentImpl {

	private Session session;
	private Criteria criteria;
	private Students student;

	// 学生注册
	public void Register(Students student) {
		session = GetSession.Init();
		session.save(student);// 注册成功
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 登录信息核对
	@SuppressWarnings("unchecked")
	public Students SelectRestrictions(String loginname) {
		session = GetSession.Init();
		criteria = session.createCriteria(Students.class);// 创建Criteria对象
		criteria.add(Restrictions.eq("Susername", loginname));// 获取用户名为string的对象
		java.util.List<Students> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			student = null;
		} else {
			student = list.get(0);// 若查到结果，则list第一个对象即为学生对象
		}
		return student;
	}

	@Override
	public void Alter(Students student) {
		// TODO Auto-generated method stub
		session = GetSession.Init();
		session.update(student);
		GetSession.close();
	}

	@Override
	public List<Students> SelectScores(String schoolName, String grade) {
		session = GetSession.Init();
		criteria = session.createCriteria(Students.class);// 创建Criteria对象
		criteria.add(Restrictions.eq("schoolName", schoolName));// 获取用户名为string的对象
		criteria.add(Restrictions.eq("grade", grade));// 获取用户名为string的对象
		criteria.addOrder(Order.desc("scores"));// 年龄排序
		java.util.List<Students> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Students selectByStudentId(String studentId) {
		session = GetSession.Init();
		criteria = session.createCriteria(Students.class);// 创建Criteria对象
		criteria.add(Restrictions.eq("studentId", studentId));// 获取用户名为string的对象
		student = (Students) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	@Override
public Students selectById_schoolName(String id,String schoolname){
		session = GetSession.Init();
		criteria = session.createCriteria(Students.class);// 创建Criteria对象
		criteria.add(Restrictions.eq("studentId", id));// 获取用户名为string的对象
		criteria.add(Restrictions.eq("schoolName", schoolname));
		student = (Students) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
}
}
