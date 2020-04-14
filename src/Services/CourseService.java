package Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Entity.Courses;
import Impl.CourseImpl;
import Utils.GetSession;

public class CourseService implements CourseImpl {

	private Session session;
	private Criteria criteria;
	private Courses course;
	
	
	@Override
	public void upload(Courses course) {
		session = GetSession.Init();
		session.save(course);//上传成功
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//根据提供的条件查询,返回一个course对象
	@Override
	public Courses selectRestrictions(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAuthor", string));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			course = null;
		}
		else{
			course=list.get(0);//若查到结果，则list第一个对象即为学生对象
		}
		return course;	
	}
	

	@Override
	public void delete(String courseId) {
		// TODO Auto-generated method stub
		session = GetSession.Init();
		course = (Courses) session.get(Courses.class, courseId);
		session.delete(course);
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseId", courseId));//获取用户名为string的对象
		course = (Courses) criteria.uniqueResult();//获取相应的课程对象
		System.out.println("删除课程对象的"+course.hashCode());
		session.delete(course);//没有执行？
*/
		}

	//根据提供的条件查询,返回一个course对象
	@Override
	public List<Courses> personCourses(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAuthor", string));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return	list;
	}
	@Override
	public List<Courses> personCourses_true(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAuthor", string));//获取用户名为string的对象
		criteria.add(Restrictions.eq("coursecheck", true));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return	list;
	}
	@Override
	public List<Courses> classCourse(String string) {
		
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseClass", string));//根据视频类别查询
		criteria.add(Restrictions.eq("coursecheck", true));//必须是通过审核的课程
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		java.util.List<Courses> list_4 = new ArrayList<Courses>();//只要list前四个
		for (int i = 0; i < 4; i++) {
			list_4.add(list.get(i));
		}
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return	list_4;
	}

	
	//根据教师姓名查询其所有课程
	public List<Courses> teachersVideo(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAuthor", string));//根据视频类别查询
		criteria.add(Restrictions.eq("coursecheck", true));//必须是通过审核的课程
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//根据课程分类，难度系数，年级查询课程
	public List<Courses> searchCourse(String str1, String str2, String str3) {
		String grade;
		 String courseClass;
		 String difficulty;
		 session = GetSession.Init();
		 criteria =session.createCriteria(Courses.class);//创建Criteria对象
		 if (!str1.equals("all")) {//如果grade年级不是选择全部
			grade = str1;
			criteria.add(Restrictions.eq("courseGrade", grade));//添加年级条件
		}
		 if (!str2.equals("all")) {//如果courseClass课程分类不是选择全部
			 courseClass = str2;
				criteria.add(Restrictions.eq("courseClass", courseClass));//添加分类条件条件
			}
		 if (!str3.equals("all")) {//如果courseClass课程分类不是选择全部
			 difficulty = str3;
				criteria.add(Restrictions.eq("courseDifficulty", difficulty));//添加分类条件条件
			}
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
	public Courses selectById(String string) {
		
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseId", string));//获取用户名为string的对象
		Courses course = (Courses) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	@Override
public Courses selectByAddress(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAddress", string));//获取用户名为string的对象
		Courses course = (Courses) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	@Override
	public List<Courses> allClassCourse(String string) {
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseClass", string));//根据视频类别查询
		criteria.add(Restrictions.eq("coursecheck", true));//必须是通过审核的课程
		@SuppressWarnings("unchecked")
		java.util.List<Courses> list = criteria.list();
		/*java.util.List<Courses> list_4 = new ArrayList<Courses>();//只要list前四个
		for (int i = 0; i < 4; i++) {
			list_4.add(list.get(i));
		}*/
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return	list;
	}

	//获取科目数量
	@Override
	public int GetNums(String subject) {
		int count = 0;
		session = GetSession.Init();
		criteria =session.createCriteria(Courses.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseClass", subject));//根据视频类别查询
		criteria.add(Restrictions.eq("coursecheck", true));//必须是通过审核的课程
		List<Courses> list = criteria.list();
		for (Courses courses : list) {
			count++;
		}
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}	
	}


