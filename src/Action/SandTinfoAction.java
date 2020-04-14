package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Students;
import Entity.Teachers;
import Services.StudentService;
import Services.TeacherService;


public class SandTinfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentService();
	TeacherService teacherService  = new TeacherService();
	private String loginname;
	private String user;
	private HttpServletRequest request;
	public String getLoginname() {
		return loginname;
	}
	public String getUser() {
		return user;
	}
	private Students student;
	public Students getStudent() {
		return student;
	}
	private Teachers teacher;
	public Teachers getTeacher() {
		return teacher;
	}
@Override
public String execute() throws Exception {

	
	String result=null;
	request = ServletActionContext.getRequest();
	loginname = request.getParameter("loginname");//用户登录名
	user=request.getParameter("userclass");//用户登录类型student  or  teacher
	if (user.equals("student")) {
		//按用户登录名查询学生个人信息，并将查询的对象放入值栈中list_S
		student = studentService.SelectRestrictions(loginname);
		result = "student";
	}
	if(user.equals("teacher")){
		//按用户登录名查询教师个人信息，并将查询的对象放入值栈中list_T	
		teacher = teacherService.SelectRestrictions(loginname);
		result = "teacher";
	}
	return result;
}

}
