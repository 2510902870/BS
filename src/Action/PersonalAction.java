package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class PersonalAction extends ActionSupport {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
		String result;
		private String loginname;//将其放入栈中
		public String getLoginname() {
			return loginname;
		}
		
		private String user;//用户类别
		public String getUser() {
			return user;
		}

		public String execute() throws Exception {
			//获取用户类型
			request = ServletActionContext.getRequest();//request对象要获取才能用
			loginname =request.getParameter("loginname");
			user  = request.getParameter("username");//用户类别
			if (user.equals("student")) {
				result ="students";
			}
			if (user.equals("teacher")) {
				result = "teachers";
			}
			if(user.equals("admin")){
				result = "admins";
			}
			return	result;
		}
}
