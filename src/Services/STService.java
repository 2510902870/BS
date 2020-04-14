package Services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import Entity.Stu_Teacher;
import Entity.Students;
import Utils.GetSession;

public class STService {
	private Session session;
	private Criteria criteria;
	public void sava(Stu_Teacher stu_Teacher){
		session = GetSession.Init();
		session.save(stu_Teacher);//上传成功
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Stu_Teacher stu_Teacher){
		session = GetSession.Init();
		session.update(stu_Teacher);//上传成功
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	////根据提供的视频地址获取留言
	private List<Stu_Teacher> comments;
	@SuppressWarnings("unchecked")
	public List<Stu_Teacher> getComment(String courseAddress){
		session = GetSession.Init();
		criteria =session.createCriteria(Stu_Teacher.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAddress", courseAddress));//获取用户名为string的对象
		comments = criteria.list();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	private Stu_Teacher comment;
	public  Stu_Teacher selectByCommentId(int commentId){
		session = GetSession.Init();
		criteria =session.createCriteria(Stu_Teacher.class);//创建Criteria对象
		criteria.add(Restrictions.eq("commentId", commentId));//获取用户名为string的对象
		comment = (Stu_Teacher) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;	
	}
	private Stu_Teacher stu_Teacher;
	public Stu_Teacher selectBycourseAddress(String courseAddress){
		session = GetSession.Init();
		criteria =session.createCriteria(Stu_Teacher.class);//创建Criteria对象
		criteria.add(Restrictions.eq("courseAddress", courseAddress));//获取用户名为string的对象
		stu_Teacher  = (Stu_Teacher) criteria.uniqueResult();
		try {
			GetSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stu_Teacher;
	}
}
