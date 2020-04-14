package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Stu_Admin;
import Services.Stu_AdminService;

//对数据的封装
public class Stu_ReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	Stu_Admin stu_Admin = new Stu_Admin();
	Stu_AdminService stu_adminService = new Stu_AdminService();
	private String loginname;
	private String user;
	
	public String getLoginname() {
		return loginname;
	}

	public String getUser() {
		return user;
	}
	private String Reinformation;
	public String getReinformation() {
		return Reinformation;
	}

	public String execute() throws Exception {
		HttpServletRequest request =ServletActionContext.getRequest();
		loginname =request.getParameter("loginname");
		user = request.getParameter("userclass");
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		String courseTitle  = request.getParameter("courseTitle");
		String reasons = request.getParameter("reasons");
		String addInformation =request.getParameter("addInformation");
		stu_Admin.setAddInformation(addInformation);
		stu_Admin.setCourseTitle(courseTitle);
		stu_Admin.setReason(reasons);
		stu_Admin.setStudentId(studentId);
		stu_Admin.setStudentName(studentName);
		//保存stu_admin 对象
		stu_adminService.sava(stu_Admin);
		Reinformation = "举报成功！";
		return "success";
	}
}
