package Entity;

public class Teachers {
	private String teacherId;//教师编号
	private String teacherName;//教师姓名
	private String Tusername;//登录用户名
	private String Tpassword;//登录密码
	private String teacherClass;//教师类别
	private String teacherSex;//教师性别
	private String schoolName;//教师任职学校名
	private String teacherAge;//教师年龄
	public Teachers() {
		// TODO Auto-generated constructor stub
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTusername() {
		return Tusername;
	}
	public void setTusername(String tusername) {
		Tusername = tusername;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	public String getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(String teacherClass) {
		this.teacherClass = teacherClass;
	}
	public String getTeacherSex() {
		return teacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(String teacherAge) {
		this.teacherAge = teacherAge;
	}
	public Teachers(String teacherId, String teacherName, String tusername, String tpassword, String teacherClass,
			String teacherSex, String schoolName, String teacherAge) {
		//super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		Tusername = tusername;
		Tpassword = tpassword;
		this.teacherClass = teacherClass;
		this.teacherSex = teacherSex;
		this.schoolName = schoolName;
		this.teacherAge = teacherAge;
	}
	@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + ", Tusername=" + Tusername
				+ ", Tpassword=" + Tpassword + ", teacherClass=" + teacherClass + ", teacherSex=" + teacherSex
				+ ", schoolName=" + schoolName + ", teacherAge=" + teacherAge + "]";
	}

}
