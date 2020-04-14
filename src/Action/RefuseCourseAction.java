package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Services.AdminService;

public class RefuseCourseAction extends ActionSupport {

	
	AdminService adminService = new AdminService();
	private static final long serialVersionUID = 1L;
	private Courses list;
	private String Rinformation;
	public Courses getList() {
		return list;
	}
	public String getRinformation() {
		return Rinformation;
	}
@Override
public String execute() throws Exception {
	HttpServletRequest request = ServletActionContext.getRequest();
	String courseId = request.getParameter("courseId");
	list = adminService.selectBycourseId(courseId);
	adminService.delete(list);
	Rinformation = "拒绝通过审核！";//向教师发送消息
	return "success";
}
}
