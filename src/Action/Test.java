package Action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Entity.Students;
import Utils.GetSession;

public class Test {
	private Session session;
	private List<Students> list;
	public List<Students> getList() {
		return list;
	}


	@SuppressWarnings("unchecked")
public String	execute(){
	session = GetSession.Init();
	//查询所有学生放入list值栈中
	Query query = session.createQuery("from Students");
	
	 list= query.list(); 
	try {
		GetSession.close();
	} catch (Exception e) {
	}
		return "success";
	}
}
