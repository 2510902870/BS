package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Services.CourseService;

public class TDeleteCourse extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	CourseService courseService =new CourseService();
	private String information;
	public String getInformation() {
		return information;
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
		String courseId = request.getParameter("courseId");
		//根据courseId删除课程
		courseService.delete(courseId);
		information = courseId+"删除成功！";
		return "success";
	}
}
