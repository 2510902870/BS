package Impl;

import java.util.List;

import Entity.Students;

public interface StudentImpl {
	public void Register(Students student);// 注册接口，存入一个学生对象

	public Students SelectRestrictions(String string);// 根据登录名loginname查询，返回一个学生对象

	public void Alter(Students student);// 修改学生对象

	public List<Students> SelectScores(String schoolName, String grade);// 根据学校名，班级返回一个学生对象集合

	public Students selectByStudentId(String studentId);// 根据学生id查询，返回一个学生对象

	Students selectById_schoolName(String id, String schoolname);

}
