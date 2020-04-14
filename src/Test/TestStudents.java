package Test;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Entity.Students;
import Utils.GetSession;
import Utils.GetSessionFactory;
import antlr.collections.List;

public class TestStudents {
	private Session session;
	private HttpServletRequest request;
	public Criteria criteria;
	@Test
	public void Excuta() {
		// 生成对象
	}
	@Test
	public void select(){
		//获取session对象
	
		session = GetSession.Init();
		criteria =session.createCriteria(Students.class);//创建Criteria对象
		criteria.add(Restrictions.eq("studentName", "彭浩登"));
		java.util.List<Students> list = criteria.list();
		for (Students student : list) {
			System.out.println(student.getSpassword());
		}
		try {
			GetSession.close();
		} catch (Exception e) {
			System.out.println("关闭资源！");
		}
	}
	
}
