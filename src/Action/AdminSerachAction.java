package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.Students;
import Entity.Teachers;
import Services.StudentService;
import Services.TeacherService;

public class AdminSerachAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Students student;
	private Teachers teacher;
	public Students getStudent() {
		return student;
	}
	public Teachers getTeacher() {
		return teacher;
	}
	StudentService studentService= new StudentService();
	TeacherService teacherService=new TeacherService();
	ActionContext aContext = ServletActionContext.getContext();
	@Override
	public String execute() throws Exception {
		//获取学校名和编号
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String loginname = request.getParameter("loginname");
		String username = request.getParameter("username");
		aContext.put("loginname", loginname);
		aContext.put("userusername", username);
		String id = request.getParameter("Id");
		String schoolName = request.getParameter("schoolName");
		String user = request.getParameter("user");
		if (user.equals("student")) {
				student = studentService.selectById_schoolName(id, schoolName);
		}
		else{
			teacher = teacherService.selectById_schoolName(id, schoolName);
		}
		return "success";
	}
}
