package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Entity.Teachers;
import Services.CourseService;
import Services.TeacherService;


public class TeachersCourse extends ActionSupport {

	private static final long serialVersionUID = 1L;
	TeacherService teacherService  = new TeacherService();
	CourseService courseService = new CourseService();
	private HttpServletRequest request;
	
/*	private Courses course;
	public Courses getCourse() {
		return course;
	}*/
	private List<Courses> listcourses;//个人所有课程的集合
	public List<Courses> getListcourses() {
		return listcourses;
	}

	private String loginname;//用户登录号
	public String getLoginname() {
		return loginname;
	}
	
	private String user;//用户类别
	public String getUser() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		user= request.getParameter("userclass");//用户类别
		loginname = request.getParameter("loginname");//123123
		Teachers teacher = teacherService.SelectRestrictions(loginname);
		String teacherName=teacher.getTeacherName();
		//course = courseService.selectRestrictions(teacherName);
		listcourses =courseService.personCourses(teacherName);
		return "success";
	}
}
