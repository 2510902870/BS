package Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Entity.Teachers;
import Services.TeacherService;

public class TeacherRegisterAction  extends ActionSupport implements ModelDriven<Teachers>{

	private static final long serialVersionUID = 1L;
	private Teachers teacher = new Teachers();
	TeacherService ts =new TeacherService();
	public Teachers getModel() {
		return teacher;
	}
	// 采用模型驱动更加简单
	public String execute() throws Exception {
		//教师注册，调用TeacherService类中方法，该方法实现TeacherImpl接口
		ts.register(teacher);
		return SUCCESS;
	}

}
