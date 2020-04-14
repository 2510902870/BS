package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Students;
import Services.StudentService;

public class SGetScoresAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentService();
	private String loginname;
	private String user;
	private HttpServletRequest request;
	private Students student;
	private List<Students> list;
	
	public List<Students> getList() {
		return list;
	}
	public String getLoginname() {
		return loginname;
	}
	public String getUser() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		loginname = request.getParameter("loginname");//用户登录名
		user=request.getParameter("userclass");//用户登录类型student  or  teacher
		student = studentService.SelectRestrictions(loginname);
		String schoolName=student.getSchoolName();
		String grade = student.getGrade();//获取学生学校和班级
		System.out.println(schoolName+grade);
		list = studentService.SelectScores(schoolName, grade);
		return "success";
	}
}
