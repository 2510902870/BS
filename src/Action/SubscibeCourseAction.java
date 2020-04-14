package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Entity.Students;
import Entity.TC;
import Services.CourseService;
import Services.StudentService;
import Services.TCService;

public class SubscibeCourseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Students student;
	private Courses list;
	public Courses getList() {
		return list;
	}
	private String Sinformatica;
	public String getSinformatica() {
		return Sinformatica;
	}
	StudentService studentService =	new StudentService();
	CourseService courseService = new CourseService();
	TCService  tcService = new TCService();
	private TC tc;
	private String studentName;
	private String courseTitle;
	private String courseId1;
	private String courseAuthor;
	private String courseGrade;
	private String studentId;
	public TC getTc() {
		return tc;
	}
private String loginname;
private String user;

	public String getLoginname() {
	return loginname;
}

public String getUser() {
	return user;
}

	@Override
	public String execute() throws Exception {
		/* String studentId;*/
		
		request = ServletActionContext.getRequest();
		 loginname = request.getParameter("loginname");
		 user = request.getParameter("userclass");
		String courseId = request.getParameter("courseId");
		//根据courseId查看TC表，是否有对象，有则会重复订阅，无则可以收藏
		tc = tcService.selectByCourseId(courseId);
		if (tc == null) {
			//说明表中没有要订阅的课程，可以订阅
			//获取学生姓名
			student =studentService.SelectRestrictions(loginname);
			studentId = student.getStudentId();
			studentName = student.getStudentName();
			//获取课程标题
			list = courseService.selectById(courseId);//课程放入
			courseTitle = list.getCourseTitle();
			courseId1 = list.getCourseId();
			 courseAuthor = list.getCourseAuthor();
			 courseGrade = list.getCourseGrade();
			//根据courseId查看TC表，是否有对象，有则会重复订阅，无则可以收藏
			tc = tcService.save( studentId , studentName, courseId1, courseTitle, courseAuthor, courseGrade);
			Sinformatica = "收藏成功！";
		}else{
			try {
				tc = tcService.save( studentId , studentName, courseId1, courseTitle, courseAuthor, courseGrade);
			} catch (Exception e) {
				
			}finally {
				Sinformatica = "你已经收藏过该课程，不能重复收藏!";
			}
		}
 		return "success";
	}
}
