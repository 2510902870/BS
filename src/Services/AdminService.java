package Services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Entity.Courses;
import Entity.Teachers;
import Impl.AdminImpl;
import Utils.GetSession;

public class AdminService implements AdminImpl {

	private Session session;
	private Criteria criteria;

	@Override
	public List<Courses> selectUnchecked() {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("coursecheck", false));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Courses selectBycourseId(String courseId) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseId", courseId));//获取用户名为string的对象
		Courses course = (Courses) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public void sava(Courses course) {
		session = GetSession.Init();
		session.update(course);
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Courses course) {
		session = GetSession.Init();
		session.delete(course);
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getTeachersName() {
		session = GetSession.Init();
		criteria =session.createCriteria(Teachers.class);//创建Criteria对象
		criteria.setProjection(Projections.distinct(Projections.property("teacherName")));		// 设置
		List<String>  list =  criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;//返回的是所有老师
	}

	@Override
	public int getRecord(String teacherName) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAuthor",teacherName));
		criteria.setProjection(Projections.rowCount());		// 设置
		Long lobj = (Long) criteria.uniqueResult();		// 强制类型转化
		int a = lobj.intValue();		//long类型转化为int类型
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

}
