package Entity;



public class Courses {
	private String courseId;//课程ID
	private String courseGrade;//课程年级
	private String courseClass;//课程分类
	private String courseDifficulty;//课程难度系数
	private String  courseCoverAddress;//课程封面地址
	private String courseTitle;//课程标题
	private String courseAddress;//课程上传地址
	private String courseAuthor;//课程上传作者
	private boolean coursecheck;//是否通过审核
	public Courses() {
		// TODO Auto-generated constructor stub
	}
	public Courses(String courseId, String courseGrade, String courseClass, String courseDifficulty,
			String courseCoverAddress, String courseTitle, String courseAddress, String courseAuthor,
			boolean coursecheck) {
		super();
		this.courseId = courseId;
		this.courseGrade = courseGrade;
		this.courseClass = courseClass;
		this.courseDifficulty = courseDifficulty;
		this.courseCoverAddress = courseCoverAddress;
		this.courseTitle = courseTitle;
		this.courseAddress = courseAddress;
		this.courseAuthor = courseAuthor;
		this.coursecheck = coursecheck;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	public String getCourseClass() {
		return courseClass;
	}
	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}
	public String getCourseDifficulty() {
		return courseDifficulty;
	}
	public void setCourseDifficulty(String courseDifficulty) {
		this.courseDifficulty = courseDifficulty;
	}
	public String getCourseCoverAddress() {
		return courseCoverAddress;
	}
	public void setCourseCoverAddress(String courseCoverAddress) {
		this.courseCoverAddress = courseCoverAddress;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseAddress() {
		return courseAddress;
	}
	public void setCourseAddress(String courseAddress) {
		this.courseAddress = courseAddress;
	}
	public String getCourseAuthor() {
		return courseAuthor;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}
	public boolean isCoursecheck() {
		return coursecheck;
	}
	public void setCoursecheck(boolean coursecheck) {
		this.coursecheck = coursecheck;
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseGrade=" + courseGrade + ", courseClass=" + courseClass
				+ ", courseDifficulty=" + courseDifficulty + ", courseCoverAddress=" + courseCoverAddress
				+ ", courseTitle=" + courseTitle + ", courseAddress=" + courseAddress + ", courseAuthor=" + courseAuthor
				+ ", coursecheck=" + coursecheck + "]";
	}
	
}
