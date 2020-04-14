package Entity;

public class Stu_Admin {
	private int reportId;//举报编号
	private String studentId;//举报学生学号
	private String studentName;//姓名
	private String courseTitle;//举报课程名
	private String reason;//举报理由
	private String addInformation;//附加信息
	public Stu_Admin() {
		// TODO Auto-generated constructor stub
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
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
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAddInformation() {
		return addInformation;
	}
	public void setAddInformation(String addInformation) {
		this.addInformation = addInformation;
	}
	public Stu_Admin(int reportId, String studentId, String studentName, String courseTitle, String reason,
			String addInformation) {
		//	super();
		this.reportId = reportId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseTitle = courseTitle;
		this.reason = reason;
		this.addInformation = addInformation;
	}
	@Override
	public String toString() {
		return "Stu_Admin [reportId=" + reportId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", courseTitle=" + courseTitle + ", reason=" + reason + ", addInformation=" + addInformation + "]";
	}
	
}
