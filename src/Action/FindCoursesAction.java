package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Services.CourseService;

public class FindCoursesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String findname;
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
	public String Linformation;

public String getLinformation() {
		return Linformation;
	}

@Override
public String execute() throws Exception {
	
	 request = ServletActionContext.getRequest();
	 loginname = request.getParameter("loginname");
	 user = request.getParameter("user");
	 if(user.equals("student")){
		 Linformation = "订阅课程";
	 }
	 findname = request.getParameter("context");//按姓名查找
	 list = courseService.teachersVideo(findname);
	return "success";
}


}
