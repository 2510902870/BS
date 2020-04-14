package Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Entity.Students;
import Entity.TC;
import Services.CourseService;
import Services.StudentService;
import Services.TCService;

public class StudentCourseAction extends ActionSupport {
	private String loginname;
	private String user;
	public String getLoginname() {
		return loginname;
	}
	public String getUser() {
		return user;
	}
	private static final long serialVersionUID = 1L;
	StudentService studentService =	new StudentService();
	TCService tcService =  new TCService();
	CourseService courseService = new CourseService();
	private List<TC> list1;
	private Courses course;
	private List<Courses> list = new ArrayList<Courses>();
	public List<Courses> getList() {
		return list;
	}
	
	
@Override
public String execute() throws Exception {
	HttpServletRequest request = ServletActionContext.getRequest();
	loginname = request.getParameter("loginname");
	user = request.getParameter("userclass");
	
	Students student = studentService.SelectRestrictions(loginname);
	String studentId = student.getStudentId();
		 list1 =tcService.selectByStudentId(studentId);
	 for (TC tc : list1) {
		String courseId=tc.getCourseId();
		course =courseService.selectById(courseId);
		System.out.println("查询的course对象为："+course);
			list.add(course);
	 }
	return "success";
}
}
	


