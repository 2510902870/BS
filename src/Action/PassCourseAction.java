package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Services.AdminService;

public class PassCourseAction extends ActionSupport {
	AdminService adminService = new AdminService();
	private static final long serialVersionUID = 1L;
	private Courses list;
	private String Pinformation;
	public Courses getList() {
		return list;
	}
	public String getPinformation() {
		return Pinformation;
	}
@Override
public String execute() throws Exception {
	HttpServletRequest request = ServletActionContext.getRequest();
	String courseId = request.getParameter("courseId");
	list = adminService.selectBycourseId(courseId);
	list.setCoursecheck(true);
	adminService.sava(list);
	Pinformation = "审核通过！";
	return "success";
}

}
