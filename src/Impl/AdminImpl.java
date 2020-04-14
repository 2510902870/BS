package Impl;

import java.util.List;

import Entity.Courses;

public interface AdminImpl {
public List<Courses> selectUnchecked();//查询所有未被审核的课程
public Courses selectBycourseId(String courseId);//根据courseId返回一个课程对象
public void sava(Courses course);//保存一个课程对象
public void delete(Courses course);
public List<String> getTeachersName();
public int getRecord(String teacherName);//根据姓名获取记录条数
}
