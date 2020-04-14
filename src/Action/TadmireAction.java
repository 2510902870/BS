package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Stu_Teacher;
import Entity.Students;
import Entity.Teachers;
import Services.STService;
import Services.StudentService;
import Services.TeacherService;

public class TadmireAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String	courseAddress;
	private String loginname;
	private String user;
	private int priase;
	
	public int getPriase() {
		return priase;
	}
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
	private Teachers teacher;
	TeacherService teacherService = new TeacherService();
	StudentService studentService  = new StudentService();
	STService stService  =new STService();

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int commentId =Integer.parseInt(request.getParameter("commentId"));//获取留言编号
		loginname = request.getParameter("loginname");
		user = request.getParameter("userclass");
		courseAddress = request.getParameter("courseAddress");
		String studentId = request.getParameter("studentId");
		String teacherId = request.getParameter("teacherId");		//上传视频的教师编号
		Students student = studentService.selectByStudentId(studentId);
		int scores = student.getScores();//学生积分
		
		// 根据loginname获取登录教师的ID和该视频教师ID相同时才能给学生加积分
		if (user.equals("teacher")) {
			teacher = teacherService.SelectRestrictions(loginname);
			String getTeacherId = teacher.getTeacherId();
			if (getTeacherId.equals(teacherId)) {//如果是视频上传作者（老师）给留言点赞，给留言者加3分
				scores = scores + 5;
				
			}else {
				scores = scores + 2;//非上传视频的老师给留言点赞，给留言者加2分
			}
		}else {
				scores = scores + 1;//同学点赞，给留言者加1分
		}
		student.setScores(scores);
		studentService.Alter(student);
		// 点赞数量的显示
		Stu_Teacher stu_Teacher = stService.selectByCommentId(commentId);
		priase = stu_Teacher.getPraise()+1;//原先点赞数量再加1
		stu_Teacher.setPraise(priase);
		stService.update(stu_Teacher);
		ShowVideoAction showVideoAction=new ShowVideoAction();
		showVideoAction.execute();
		comments = showVideoAction.getComments();
		return "success";
	}
}
