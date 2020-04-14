package Action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;

import com.opensymphony.xwork2.ActionSupport;
import Entity.Courses;
import Entity.Stu_Teacher;
import Entity.Students;
import Entity.Teachers;
import Services.CourseService;
import Services.STService;
import Services.StudentService;
import Services.TeacherService;

public class CommentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	StudentService studentService=new StudentService();
	private Students student;
	CourseService courseService=	new CourseService();
	private Courses course;
	TeacherService teacherService = new TeacherService();
	private Teachers teacher;
	STService stService  =new STService();
	private String studentId;				//学号
	private String studentName;		//姓名
	private String teacherId;//教师编号
	private String teacherName;//教师姓名
	private String studentContext;
	private String teacherContext;
	private Date time;//留言时间
	private String	courseAddress;
	private String loginname;
	private String user;
	
	public String getCourseAddress() {
		return courseAddress;
	}
	public String getLoginname() {
		return loginname;
	}

	public String getUser() {
		return user;
	}
private List<Stu_Teacher> comments;
	public List<Stu_Teacher> getComments() {
	return comments;
}
	
	@Override
	public String execute() throws Exception {
		//根据提供的loginname和user类型查到学生对象
		HttpServletRequest request = ServletActionContext.getRequest();
		 loginname = request.getParameter("loginname");
		 user = request.getParameter("userclass");
		 courseAddress = request.getParameter("courseAddress");
		 studentContext = request.getParameter("studentContext");
		
		student  = studentService.SelectRestrictions(loginname);
		studentId = student.getStudentId();
		studentName =student.getStudentName();
		course = courseService.selectByAddress(courseAddress);
		teacherName = course.getCourseAuthor();
		teacher =teacherService.SelectByteacherName(teacherName);
		teacherId = teacher.getTeacherId();
		time  = new Date();
		Stu_Teacher stu_Teacher = new Stu_Teacher();
		stu_Teacher.setStudentId(studentId);
		stu_Teacher.setStudentName(studentName);
		stu_Teacher.setTeacherId(teacherId);
		stu_Teacher.setTeacherName(teacherName);
		stu_Teacher.setStudentContext(studentContext);
		stu_Teacher.setTeacherContext(teacherContext);
		stu_Teacher.setTime(time);
		stu_Teacher.setCourseAddress(courseAddress);
		stu_Teacher.setPraise(0);
		stService.sava(stu_Teacher);
		ShowVideoAction showVideoAction=new ShowVideoAction();
		showVideoAction.execute();
		comments = showVideoAction.getComments();
		return "success";
	}

}
