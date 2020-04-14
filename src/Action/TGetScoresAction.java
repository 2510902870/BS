package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Students;
import Services.TeacherService;

public class TGetScoresAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String loginname;
	private String user;
	private List<Students> list;
	public String getLoginname() {
		return loginname;
	}
	public String getUser() {
		return user;
	}
	public List<Students> getList() {
		return list;
	}
	TeacherService teacherService  =new TeacherService();
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		loginname =request.getParameter("loginname");
		user  = request.getParameter("userclass");
		String schoolName= request.getParameter("schoolName");
		String grade  = request.getParameter("classGrade");
		list = teacherService.SelectScores(schoolName, grade);
		return "success";
	}

}
