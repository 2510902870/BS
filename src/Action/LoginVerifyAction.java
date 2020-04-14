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

public class LoginVerifyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String Susername;// 表单用户名
	private String Spassword;// 表单密码
	private String name;// 登录名
	private String SelectPassword;// 数据库查询的密码（根据用户名查询）
	StudentService studentService = new StudentService();
	TeacherService teacherService = new TeacherService();
	CourseService courseService = new CourseService();
	private Teachers teacher;
	private Students student;
	private String hint;// 学生订阅
	public String getHint() {
		return hint;
	}
	String loginname;// 显示登录用户名123123，放入值栈中
	public String getLoginname() {
		return loginname;
	}
	public String getuser;
	public String getGetuser() {
		return getuser;
	}
	
	public String information;// 登录出错的显示信息
	public String getInformation() {
		return information;
	}
	private String XXX;
	public String getXXX() {
		return XXX;
	}
	private int scores;// 积分
	public int getScores() {
		return scores;
	}
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
	public void showVideo() {// 将推荐课程展示
		// 查看部分课程，即为推荐课程
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
	@Override
	public String execute() throws Exception {
		String result = null;
		request = ServletActionContext.getRequest();
		Susername = request.getParameter("Susername");// 获取用户姓名
		Spassword = request.getParameter("Spassword");// 获取用户密码
		getuser = request.getParameter("user");// 获取单选框的值，学生or教师or管理员
		// switch可以替代选择
		if (getuser.equals("student")) {
			student = studentService.SelectRestrictions(Susername);
			if (student == null) {// 用户名输入错误
				information = "输入的用户名出错";
				result = "login_default";
				return result;
			} else {
				hint = "订阅课程";
				information = "我的积分:";
				XXX = student.getStudentName();
				name = student.getSusername();// 登录用户名
				scores = student.getScores();
				SelectPassword = student.getSpassword();
			}
		}
		if (getuser.equals("teacher")) {
			teacher = teacherService.SelectRestrictions(Susername);
			if (teacher == null) {// 用户名输入错误
				information = "输入的用户名出错";
				result = "login_default";
				return result;
			} else {
				XXX = teacher.getTeacherName();
				name = teacher.getTusername();
				information = "我的积分:";
				scores = 0;
				SelectPassword = teacher.getTpassword();
			}
		}
		if (getuser.equals("admin")) {
			// 管理员
			SelectPassword = "123456";// 管理员密码
			XXX = "admin";
			name = "admin";
		}
		// 判断登录密码是否与查询密码相同
		if (SelectPassword.equals(Spassword)) {// 提示：千万要注意==和equals()
			// 登录成功
			loginname = name;// 将姓名放入值栈中
			this.showVideo();
			result = "login_success";
		} else {
			information = "输入的密码出错";
			result = "login_default";
		}
		return result;
	}
}
