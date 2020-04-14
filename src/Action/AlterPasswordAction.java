package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Entity.Students;
import Entity.Teachers;
import Services.StudentService;
import Services.TeacherService;

public class AlterPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentService();
	TeacherService teacherService  = new TeacherService();
	private String loginname;// 用户名
	private String user;// 用户类别
	private String password;
	private String repassword;
	private String oldpassword;
	private HttpServletRequest request;
	Students student;
	Teachers teacher;
	private String information;

	public String getInformation() {
		return information;
	}

	public String getLoginname() {
		return loginname;
	}

	public String getUser() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		String result=null;
		request = ServletActionContext.getRequest();
		loginname = request.getParameter("username");
		user = request.getParameter("user");// 放入值栈
		password = request.getParameter("password");
		repassword = request.getParameter("repassword");
		oldpassword = request.getParameter("oldpassword");
		
		if (user.equals("student")) {
			// 根据loginname获取学生对象（默认用户名正确）
			student = studentService.SelectRestrictions(loginname);
			String GetPassword = student.getSpassword();
			if (GetPassword.equals(oldpassword) && repassword.equals(password)) {
				// 允许修改
				student.setSpassword(repassword);
				studentService.Alter(student);
			//	studentService.Register(student);//主键冲突
				information= "修改成功";
				result = "student_success";
			} else {
				// 不允许修改
				information = "输入的旧密码不正确或者新密码与确认密码不相同";
				result = "student_default";
			}
		}
		if (user.equals("teacher")) {
			teacher = teacherService.SelectRestrictions(loginname);
			String GetPassword = teacher.getTpassword();
			if (GetPassword.equals(oldpassword) && repassword.equals(password)) {
				// 允许修改
				teacher.setTpassword(repassword);
				teacherService.Alter(teacher);
				//teacherService.register(teacher);//主键冲突
				information= "修改成功";
				result = "teacher_success";
			} else {
				// 不允许修改
				information = "输入的旧密码不正确或者新密码与确认密码不相同";
				result = "teacher_default";
			}
		}
		return result;
	}
}
