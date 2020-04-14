package Action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Entity.Stu_Teacher;
import Entity.Students;
import Services.STService;
import Services.StudentService;
public class ShowVideoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String loginname;
	private String user;
	STService stService = new STService();

	public String getLoginname() {
		return loginname;
	}

	public String getUser() {
		return user;
	}

	private String courseAddress;

	public String getCourseAddress() {
		return courseAddress;
	}

	private List<Stu_Teacher> comments;
	public List<Stu_Teacher> getComments() {
		return comments;
	}
	private Students student;
	private int scores;
	
	public int getScores() {
		return scores;
	}

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		loginname = request.getParameter("loginname");
		user = request.getParameter("userclass");
		courseAddress = request.getParameter("courseAddress");
		comments = stService.getComment(courseAddress);
		//获取点赞数量
		
		return SUCCESS;
	}
}
