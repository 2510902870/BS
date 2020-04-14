package Impl;

import java.util.List;

import Entity.Courses;
import Entity.Teachers;

public interface CourseImpl {
	//接口不能用private修饰
	public void upload(Courses course);//教师上传视频
	public Courses selectRestrictions(String string);//根据用户名查询
	public Courses selectById(String string);//根据courseid查询
	public void delete(String courseId);//根据courseId删除课程
	public List<Courses> personCourses(String string);//根据courseAuthor查询
	public List<Courses> classCourse(String string);//根据视频类别查询前4
	public List<Courses> allClassCourse(String string);//根据视频类别查询所有
	public  List<Courses> teachersVideo(String string);//根据教师姓名查询其所有课程
	public List<Courses> searchCourse(String str1,String str2,String str3);//根据课程分类，难度系数，年级查询课程
	public Courses selectByAddress(String string);
	public List<Courses> personCourses_true(String string);//通过审核的课程
	public int GetNums(String subject);
	
}
