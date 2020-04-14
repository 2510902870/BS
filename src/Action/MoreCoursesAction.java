package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Services.CourseService;

public class MoreCoursesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Courses course;
	private List<Courses> list;
	public List<Courses> getList() {
		return list;
	}
	private String loginname;
	private String user;
	private String Linformation;
	
	public String getLoginname() {
		return loginname;
	}
	public String getUser() {
		return user;
	}
	public String getLinformation() {
		return Linformation;
	}
	CourseService courseService=new CourseService();
	@Override
	public String execute() throws Exception {
		request =	ServletActionContext.getRequest();
		loginname = request.getParameter("loginname");
		user = request.getParameter("userclass");
		if (user.equals("student")) {
			Linformation = "订阅课程";
		}
		String courseId = request.getParameter("courseId");
		course = courseService.selectById(courseId);
		String courseClass  =  course.getCourseClass();
		//根据类别查询所有课程放入值栈中
		 list = courseService.allClassCourse(courseClass);
		 
		return "success";
	}

}
