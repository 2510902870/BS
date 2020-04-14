package Services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Entity.Courses;
import Entity.TC;
import Entity.Teachers;
import Impl.TCImpl;
import Utils.GetSession;

public class TCService implements TCImpl {

	private Session session;
	private Criteria criteria;

	@Override
	public TC save(String str1, String str2, String str3, String str4, String str5, String str6) {
		// TODO Auto-generated method stub
		TC tc = new TC(str1, str2, str3, str4, str5, str6);
		session = GetSession.Init();
		try {
			session.save(tc);//注册成功
		} catch (Exception e) {
			System.out.println("重复收藏！");
		}
		
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tc;
	}

	@Override
	public List<TC> selectByStudentId(String studentId) {
		
		session = GetSession.Init();
		criteria =session.createCriteria(TC.class);//创建Criteria对象
		criteria.add(Restrictions.eq("studentId", studentId));//获取用户名为string的对象
		@SuppressWarnings("unchecked")
		java.util.List<TC> list = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TC selectByCourseId(String courseId) {
		session = GetSession.Init();
		criteria =session.createCriteria(TC.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseId",courseId));
		 TC tc	= (TC) criteria.uniqueResult();
		 try {
				GetSession.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return tc;
	}

	@Override
	public void deleteByCourseId(String courseId) {
		// TODO Auto-generated method stub
		session = GetSession.Init();
		criteria =session.createCriteria(TC.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseId",courseId));
		TC tc = (TC) criteria.uniqueResult();
		session.delete(tc);
		 try {
				GetSession.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
