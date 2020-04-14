package Action;

import org.hibernate.Session;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import Entity.Students;
import Services.StudentService;

//返回封装表单的对象
public class StudentRegisterAction extends ActionSupport  implements ModelDriven<Students>{

	private static final long serialVersionUID = 1L;
	Session session;
	StudentService studentService = new StudentService();
//	HttpServletRequest request;
	private Students student = new Students();
	@Override
	public Students getModel() {
		return student;
	}
	public String sava() {// 采用模型驱动更加简单
		studentService.Register(student);
		return SUCCESS;
	}
}
/*
 * request = ServletActionContext.getRequest(); String studentId =
 * request.getParameter("studentId"); String Susername =
 * request.getParameter("Susername"); String Spassword =
 * request.getParameter("Spassword"); String studentName =
 * request.getParameter("studentName"); int studentAge =
 * Integer.parseInt(request.getParameter("studentAge")); String grade =
 * request.getParameter("grade"); Students student = new
 * Students(studentId, studentName,Susername,Spassword, studentAge,
 * grade);
 */
