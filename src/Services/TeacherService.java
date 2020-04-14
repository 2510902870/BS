package Services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.Courses;
import Entity.Students;
import Entity.Teachers;
import Impl.TeacherImpl;
import Utils.GetSession;

public class TeacherService implements TeacherImpl{

	
	private Session session;
	private Teachers teacher;
	private Criteria criteria;

	@Override
	public void register(Teachers teacher) {
		// TODO Auto-generated method stub
		session = GetSession.Init();
		session.save(teacher);//注册成功
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Teachers SelectRestrictions(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Teachers.class);//创建Criteria对象
		criteria.add(Restrictions.eq("teacherId", string));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		java.util.List<Teachers> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			teacher = null;
		}
		else{
			teacher=list.get(0);//若查到结果，则list第一个对象即为teacher对象
		}
		return teacher;	
	}
	@Override
	public Teachers selectByLoginname(String loginname){
		session = GetSession.Init();
		criteria =session.createCriteria(Teachers.class);//创建Criteria对象
		criteria.add(Restrictions.eq("Tusername", loginname));//获取用户名为string的对象
		teacher = (Teachers) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
	@Override
	public Teachers SelectByteacherName(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Teachers.class);//创建Criteria对象
		criteria.add(Restrictions.eq("teacherName", string));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		Teachers teacher = (Teachers) criteria.uniqueResult();//同名
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;	
	}
	@Override
	public void Alter(Teachers teacher) {
		// TODO Auto-generated method stub
		session = GetSession.Init();
		session.update(teacher);
		GetSession.close();
	}

	@Override
	public List<Students> SelectScores(String schoolName, String grade) {
		session = GetSession.Init();
		criteria =session.createCriteria(Students.class);//创建Criteria对象
		criteria.add(Restrictions.eq("schoolName", schoolName));
		criteria.add(Restrictions.eq("grade", grade));
		criteria.addOrder(Order.desc("scores"));// 年龄排序
		java.util.List<Students> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;//返回学生对象集合
	}

	@Override
	public int GetTnums(String teacherClass) {
		int count = 0;
		session = GetSession.Init();
		criteria =session.createCriteria(Teachers.class);//创建Criteria对象
		criteria.add(Restrictions.eq("teacherClass", teacherClass));//获取用户名为string的对象
		List<Teachers> list = criteria.list();
		for (Teachers courses : list) {
			count++;
		}
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Teachers selectById_schoolName(String id ,String schoolName){
		session = GetSession.Init();
		criteria =session.createCriteria(Teachers.class);//创建Criteria对象
		criteria.add(Restrictions.eq("teacherId", id));// 获取用户名为string的对象
		criteria.add(Restrictions.eq("schoolName", schoolName));
		teacher = (Teachers) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}
}
