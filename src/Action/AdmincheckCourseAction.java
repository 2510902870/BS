package Action;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Entity.Courses;
import Entity.Stu_Admin;
import Services.AdminService;
import Services.Stu_AdminService;

public class AdmincheckCourseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String Sinformation;
	AdminService adminService = new AdminService();
	Stu_AdminService stu_AdminService = new Stu_AdminService();
	ActionContext aContext = ServletActionContext.getContext();
	private List<Courses> adminlist;
	public List<Courses> getAdminlist() {
		return adminlist;
	}

	// 查看管理员收到的举报信息
	private List<Stu_Admin> mypost;
	public List<Stu_Admin> getMypost() {
		return mypost;
	}
	private List<String> list5 = new ArrayList<>();
	public List<String> getList5() {
		return list5;
	}
	// 查询待审核的课程
	public String execute() throws Exception {
		// 查询未审核的课程
		adminlist = adminService.selectUnchecked();
		if (adminlist.isEmpty()) {
			Sinformation = "没有查到未审核的课程";
		}
		return "success";
	}
	
	// 获取举报信息
	public String mypost() {
		list5.add("举报编号");
		list5.add("学生学号");
		list5.add("学生姓名");
		list5.add("举报课程名");
		list5.add("举报理由");
		list5.add("附加信息");
		aContext.put("list5", list5);
		mypost = stu_AdminService.selectAllpost();// 封装到值栈中
		return "allpost";
	}
}
