package Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.xml.internal.ws.Closeable;

import Entity.Students;
import Utils.GetSession;
public class TestHql {
	private Session session;
	@Before
	public void Init(){
		session = GetSession.Init();
	}
	@After
	public void close(){
		try {
			GetSession.close();
		} catch (Exception e) {
			System.out.println("关闭资源！");
		}
	}
@Test
public void selectAll(){
	Query query = session.createQuery("from Students");
	List<Students> list= query.list(); 
	 for (Students student : list) {
		System.out.println(student.toString());
	}
}
@Test
public void selectRestriction(){//可用and添加并列条件
	Query query = session.createQuery("from Students where studentName = ? ");
	query.setParameter(0, "周晓泽");
	List<Students> list= query.list();
	 for (Students student : list) {
		System.out.println(student.toString());
	}
}
@Test
public void dimSelect(){
	Query query = session.createQuery("from Students where studentName like ? ");
	query.setParameter(0, "%王%");
	List<Students> list= query.list();
	 for (Students student : list) {
		System.out.println(student.toString());
	}
}
@Test
public void orderSelect(){
	Query query = session.createQuery("from Students order by  studentAge asc");
	List<Students> list= query.list();
	 for (Students student : list) {
		System.out.println(student.toString());
	}
}
@Test
public void pageSelect(){
	Query query = session.createQuery("from Students");
	query.setFirstResult(2);
	query.setMaxResults(3);
	List<Students> list= query.list();
	 for (Students student : list) {
		System.out.println(student.toString());
	}
}
@Test
public void projectionSelect(){
	Query query = session.createQuery("select studentName from Students");
	List<Object> list= query.list();
	for (Object object : list) {
		System.out.println(object.toString());
	}
}
@Test
public void methodSelect(){
	Query query = session.createQuery("select count(*) from Students");
	Object object =	query.uniqueResult();
	Long lobj = (Long)object;
	int a = lobj.intValue();
	System.out.println("总共有" + a + "记录");
}
}
