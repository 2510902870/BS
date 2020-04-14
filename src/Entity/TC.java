package Entity;
//TC :学生的订阅的课程
public class TC {
	private String courseId;					//课程ID
	private String studentId;				//学号;
	private String studentName;		//姓名
	private String courseTitle;			//课程标题
	private String courseAuthor;		//课程上传作者
	private String courseGrade;			//课程年级
	public TC(String studentId, String studentName, String courseId, String courseTitle, String courseAuthor,
			String courseGrade) {
		//super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseAuthor = courseAuthor;
		this.courseGrade = courseGrade;
	}
	public TC() {
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseAuthor() {
		return courseAuthor;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	@Override
	public String toString() {
		return "TC [studentId=" + studentId + ", studentName=" + studentName + ", courseId=" + courseId
				+ ", courseTitle=" + courseTitle + ", courseAuthor=" + courseAuthor + ", courseGrade=" + courseGrade
				+ "]";
	}
	
	
}
