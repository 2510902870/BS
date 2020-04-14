package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Services.TCService;

public class DeleteSubscribeAction extends ActionSupport {
	private HttpServletRequest request ;
	private static final long serialVersionUID = 1L;
	TCService tcService=new TCService();
	private String Dinformation;
	
	public String getDinformation() {
		return Dinformation;
	}

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		String courseId =request.getParameter("courseId");//获取课程编号
		tcService.deleteByCourseId(courseId);
		Dinformation = "取消订阅成功！";
		return SUCCESS;
	}

}
