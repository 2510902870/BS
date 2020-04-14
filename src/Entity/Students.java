package Entity;

public class Students {
	private String studentId;				//学号
	private String studentName;		//姓名
	private String Susername;				//用户名
	private String Spassword;				//登录密码
	private int studentAge;					//年龄
	private String  grade;					//年级
	private String schoolName;			//学校
	private int scores;   //积分
	public Students() {
		// TODO Auto-generated constructor stub
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSusername() {
		return Susername;
	}
	public void setSusername(String susername) {
		Susername = susername;
	}
	public String getSpassword() {
		return Spassword;
	}
	public void setSpassword(String spassword) {
		Spassword = spassword;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	public Students(String studentId, String studentName, String susername, String spassword, int studentAge,
			String grade, String schoolName, int scores) {
		//super();
		this.studentId = studentId;
		this.studentName = studentName;
		Susername = susername;
		Spassword = spassword;
		this.studentAge = studentAge;
		this.grade = grade;
		this.schoolName = schoolName;
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", Susername=" + Susername
				+ ", Spassword=" + Spassword + ", studentAge=" + studentAge + ", grade=" + grade + ", schoolName="
				+ schoolName + ", scores=" + scores + "]";
	}
}
