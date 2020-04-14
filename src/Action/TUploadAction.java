package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Entity.Courses;
import Services.CourseService;


public class TUploadAction extends ActionSupport implements ModelDriven<Courses> {

	private static final long serialVersionUID = 1L;
	private Courses course = new Courses();
	CourseService cs = new CourseService();
	private String information;
	@Override
	public Courses getModel() {
		return course;
	}
	public String getInformation() {
		return information;
	}

	private HttpServletRequest request;
	
	private String loginname;
	public String getLoginname() {
		return loginname;
	}
	private String user;
	public String getUser() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		user= request.getParameter("userclass");//用户类别
		loginname = request.getParameter("loginname");//123123
		 cs.upload(course);
		 information = "上传成功";
		return "success";
	}

}
