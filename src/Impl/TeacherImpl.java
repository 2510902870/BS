package Impl;

import java.util.List;

import Entity.Students;
import Entity.Teachers;

public interface TeacherImpl {
public void register(Teachers teacher);//注册接口，存一个对象
public Teachers SelectRestrictions(String string);//根据登录用户名查询，返回一个教师对象
public void Alter(Teachers teacher);
public List<Students> SelectScores(String schoolName,String grade);
public Teachers SelectByteacherName(String string);
Teachers selectByLoginname(String loginname);
public int GetTnums(String teacherClass);
}
