package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Courses;
import Entity.Students;
import Entity.Teachers;
import Services.CourseService;
import Services.StudentService;
import Services.TeacherService;

public class ReturnHomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	CourseService courseService = new CourseService();
	StudentService studentService = new StudentService();
	TeacherService teacherService  = new TeacherService();
	private List<Courses> math;
	private List<Courses> chinese;
	private List<Courses> english;
	private List<Courses> political;
	private List<Courses> history;
	private List<Courses> geography;
	private List<Courses> biology;
	private List<Courses> physical;
	private List<Courses> chemistry;
	
public List<Courses> getMath() {
		return math;
	}
	public List<Courses> getChinese() {
		return chinese;
	}
	public List<Courses> getEnglish() {
		return english;
	}
	public List<Courses> getPolitical() {
		return political;
	}
	public List<Courses> getHistory() {
		return history;
	}
	public List<Courses> getGeography() {
		return geography;
	}
	public List<Courses> getBiology() {
		return biology;
	}
	public List<Courses> getPhysical() {
		return physical;
	}
	public List<Courses> getChemistry() {
		return chemistry;
	}
	private String loginname;//登录名loginname
	private String getuser;//登录用户类型
	private String XXX;//登录姓名
	private String hint;//订阅课程
	private String information;//我的积分
	private int scores;//积分
	
public String getLoginname() {
		return loginname;
	}
	public String getGetuser() {
		return getuser;
	}
	public String getXXX() {
		return XXX;
	}
	public String getHint() {
		return hint;
	}
	public String getInformation() {
		return information;
	}
	public int getScores() {
		return scores;
	}
public void showVideo(){//将推荐课程展示
	//查看部分课程，即为推荐课程
	math = courseService.classCourse("数学");
	chinese = courseService.classCourse("语文");
	english = courseService.classCourse("英语");
	political = courseService.classCourse("政治");
	history = courseService.classCourse("历史");
	geography = courseService.classCourse("地理");
	biology = courseService.classCourse("生物");
	physical = courseService.classCourse("物理");
	chemistry = courseService.classCourse("化学");
}
private Students student;
private Teachers teacher;
	public String execute() throws Exception {
		this.showVideo();//查询推荐视频
		HttpServletRequest request = ServletActionContext.getRequest();
		loginname = request.getParameter("loginname");
		getuser = request.getParameter("userclass");//careful
		if (getuser.equals("student")) {
			//根据loginname获取学生对象
			student = studentService.SelectRestrictions(loginname);			
			XXX = student.getStudentName();
			hint = "订阅课程";
			information = "我的积分：";
			scores = student.getScores();
		}
		if (getuser.equals("teacher")) {
			teacher = teacherService.SelectRestrictions(loginname);
			information = "我的积分：";
			scores = 0;
			XXX = teacher.getTeacherName();
		}
		if (getuser.equals("admin")) {
			XXX = "admin";
			information = "我的积分：";
			scores = 0;
		}
		return "success";
	}
}
