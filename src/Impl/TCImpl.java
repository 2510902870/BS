package Impl;

import java.util.List;

import Entity.TC;

public interface TCImpl {
	public TC save(String str1, String str2, String str3, String str4, String str5, String str6);

	public List<TC> selectByStudentId(String studentId);

	public TC selectByCourseId(String courseId);

	public void deleteByCourseId(String courseId);
}
