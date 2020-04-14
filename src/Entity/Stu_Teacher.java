package Entity;

import java.util.Date;

public class Stu_Teacher {
	private int commentId;
	private String studentId;				//学号
	private String studentName;		//姓名
	private String teacherId;//教师编号
	private String teacherName;//教师姓名
	private String studentContext;
	private String teacherContext;
	private Date time;//留言时间
	private String	courseAddress;
	private int praise;//点赞数量
	public Stu_Teacher() {
		// TODO Auto-generated constructor stub
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	public String getStudentContext() {
		return studentContext;
	}
	public void setStudentContext(String studentContext) {
		this.studentContext = studentContext;
	}
	public String getTeacherContext() {
		return teacherContext;
	}
	public void setTeacherContext(String teacherContext) {
		this.teacherContext = teacherContext;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getCourseAddress() {
		return courseAddress;
	}
	public void setCourseAddress(String courseAddress) {
		this.courseAddress = courseAddress;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public Stu_Teacher(int commentId, String studentId, String studentName, String teacherId, String teacherName,
			String studentContext, String teacherContext, Date time, String courseAddress, int praise) {
		//super();
		this.commentId = commentId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.studentContext = studentContext;
		this.teacherContext = teacherContext;
		this.time = time;
		this.courseAddress = courseAddress;
		this.praise = praise;
	}
	@Override
	public String toString() {
		return "Stu_Teacher [commentId=" + commentId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", studentContext=" + studentContext
				+ ", teacherContext=" + teacherContext + ", time=" + time + ", courseAddress=" + courseAddress
				+ ", praise=" + praise + "]";
	}
	
}
