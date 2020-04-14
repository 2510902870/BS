package Test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.Init;

import Entity.Students;
import Utils.GetSession;

public class TestQBCselect {

	private Session session;
	private Criteria criteria;
	private List list111;

	@Before
	public void Init() {
		session = GetSession.Init();
		criteria = session.createCriteria(Students.class);// 创建Criteria对象
	}

	@Test
	public void listAll() {
		@SuppressWarnings("unchecked")
		java.util.List<Students> list = criteria.list();
		for (Students student : list) {// student代表每一个学生对象
			System.out.println(student.toString());
		}
	}

	@Test
	public void restrictionSelect() {// 条件查询
		criteria.add(Restrictions.eq("studentName", "彭浩登"));
		java.util.List<Students> list = criteria.list();
		for (Students student : list) {
			System.out.println(student.toString());
		}
	}

	@Test
	public void orderSelect() {// 排序查询
		criteria.addOrder(Order.desc("studentAge"));// 年龄排序
		java.util.List<Students> list = criteria.list();
		for (Students student : list) {
			System.out.println(student.toString());
		}
	}

	@Test
	public void dimSelectd() {// 模糊查询
		criteria.add(Restrictions.like("studentName", "%周%"));
		java.util.List<Students> list = criteria.list();
		for (Students student : list) {
			System.out.println(student.toString());
		}
	}
@Test
public void pageSelect(){//获取页面的一部分数据
	criteria.setFirstResult(0);
	criteria.setMaxResults(3);
	java.util.List<Students> list = criteria.list();
	for (Students student : list) {
		System.out.println(student.toString());
	}
}

	@Test
	public void methodSelect() {// 聚集函数的使用
		criteria.setProjection(Projections.rowCount());		// 设置
		Long lobj = (Long) criteria.uniqueResult();		// 强制类型转化
		int a = lobj.intValue();		//long类型转化为int类型
		System.out.println("总共有" + a + "记录");
	}
	@After
	public void close() {
		try {
			GetSession.close();
		} catch (Exception e) {
			System.out.println("关闭资源！");
		}
	}
	@Test
	public void getXXX(){
		criteria.setProjection(Projections.distinct(Projections.property("studentName")));		// 设置
		 list111 = criteria.list();
		for (Object object : list111) {
			System.out.println(object.toString());
		}
	}
}
