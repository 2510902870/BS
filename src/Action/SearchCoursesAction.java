package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Services.CourseService;

public class SearchCoursesAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private HttpServletRequest request;
CourseService courseService=new CourseService();
private List<Courses> list;
public List<Courses> getList() {
	return list;
}
private String loginname;
private String user;
public String getLoginname() {
	return loginname;
}
public String getUser() {
	return user;
}
private String Linformation;
public String getLinformation() {
	return Linformation;
}
@Override
public String execute() throws Exception {
	 request = ServletActionContext.getRequest();
	 loginname = request.getParameter("loginname");
	 user = request.getParameter("user");
	 if (user.equals("student")) {
		Linformation = "订阅课程";
	}
	 String grade = request.getParameter("grade");
	 String courseClass = request.getParameter("class");
	 String difficulty = request.getParameter("difficulty"); 
	 list = courseService.searchCourse(grade, courseClass, difficulty);
	return "success";
}

}
