package Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Services.AdminService;
import Services.CourseService;
import Services.TeacherService;

public class GetTeacherInfoAction extends ActionSupport {
	AdminService adminService =new AdminService();
	CourseService courseService = new CourseService();
	TeacherService teacherService =new TeacherService();
	private static final long serialVersionUID = 1L;
	private	Map<String, Integer> map =new HashMap<String,Integer>();
	public Map<String, Integer> getMap() {
		return map;
	}
	private int count=0;
	private String Ginformation;
	public String getGinformation() {
		return Ginformation;
	}
	
	private List<String> list2 = new ArrayList<>();
	public List<String> getList2() {
		return list2;
	}

	private List<String> list3 = new ArrayList<>();
	public List<String> getList3() {
		return list3;
	}
	private List<String> list4 = new ArrayList<>();
	public List<String> getList4() {
		return list4;
	}


	@Override
	public String execute() throws Exception {
		//获取所有老师
	List<String> list =	adminService.getTeachersName();
	for (String teacherName : list) {
		count++;
		int a =	adminService.getRecord(teacherName);
		map.put(teacherName, a);
	}
	Ginformation = "一共有"+count+"教师";
	
	
	list2.add("语文");//2
	list2.add("数学");//3
	list2.add("英语");//4
	list2.add("政治");//5
	list2.add("历史");//6
	list2.add("地理");//7
	list2.add("生物");//8
	list2.add("物理");//9
	list2.add("化学");//10
	ActionContext  aContext = ServletActionContext.getContext();
	aContext.put("list2", list2);//科目放入值栈中
	aContext.put("th1", "科目");
	aContext.put("th2", "课程数量");
	aContext.put("th3", "教师数量");
	String chinesenum = courseService.GetNums("语文")+"";//将int类型转为string类型保存
	list3.add(chinesenum);//0
	String mathnum = courseService.GetNums("数学")+"";
	list3.add(mathnum);//1
	String Englishnum = courseService.GetNums("英语")+"";
	list3.add(Englishnum);//2
	String politicalnum = courseService.GetNums("政治")+"";
	list3.add(politicalnum);//3
	String historynum = courseService.GetNums("历史")+"";
	list3.add(historynum);//4
	String geographynum = courseService.GetNums("地理")+"";
	list3.add(geographynum);//5
	String biographynum = courseService.GetNums("生物")+"";
	list3.add(biographynum);//6
	String physicalnum = courseService.GetNums("物理")+"";
	list3.add(physicalnum);//7
	String chemicalnum = courseService.GetNums("化学")+"";
	list3.add(chemicalnum);//8
	aContext.put("list3", list3);
	
	
		String  chineseTnum = teacherService.GetTnums("语文")+"";
		list4.add(chineseTnum);
		String  mathTnum = teacherService.GetTnums("数学")+"";
		list4.add(mathTnum);
		String EnglishTnum = teacherService.GetTnums("英语")+"";
		list4.add(EnglishTnum);
		String politicalTnum = teacherService.GetTnums("政治")+"";
		list4.add(politicalTnum);
		String historyTnum = teacherService.GetTnums("历史")+"";
		list4.add(historyTnum);
		String geographyTnum = teacherService.GetTnums("地理")+"";
		list4.add(geographyTnum);
		String biographyTnum = teacherService.GetTnums("生物")+"";
		list4.add(biographyTnum);
		String physicalTnum = teacherService.GetTnums("物理")+"";
		list4.add(physicalTnum);
		String chemicalTnum = teacherService.GetTnums("化学")+"";
		list4.add(chemicalTnum);
		
	/*
	
	aContext.put("chinesenum", chinesenum);
	
	aContext.put("chineseTnum", chineseTnum);

	aContext.put("mathnum", mathnum);
	int mathTnum = teacherService.GetTnums("数学");
	aContext.put("mathTnum", mathTnum);*/
	
/*	aContext.put("th4", "英语");

	aContext.put("Englishnum", Englishnum);
	int EnglishTnum = teacherService.GetTnums("英语");
	aContext.put("EnglishTnum", EnglishTnum);
	
	aContext.put("th5", "政治");

	aContext.put("politicalnum", politicalnum);
	int politicalTnum = teacherService.GetTnums("政治");
	aContext.put("politicalTnum", politicalTnum);
	
	aContext.put("th6", "历史");

	aContext.put("historynum", historynum);
	int historyTnum = teacherService.GetTnums("历史");
	aContext.put("historyTnum", historyTnum);

	aContext.put("th7", "地理");

	aContext.put("geographynum", geographynum);
	int geographyTnum = teacherService.GetTnums("地理");
	aContext.put("geographyTnum", geographyTnum);
	
	aContext.put("th8", "生物");

	aContext.put("biographynum", biographynum);
	int biographyTnum = teacherService.GetTnums("生物");
	aContext.put("biographyTnum", biographyTnum);
	
	aContext.put("th9", "物理");

	aContext.put("physicalnum", physicalnum);
	int physicalTnum = teacherService.GetTnums("物理");
	aContext.put("physicalTnum", physicalTnum);
	
	
	aContext.put("th10", "化学");

	aContext.put("chemicalnum", chemicalnum);
	int chemicalTnum = teacherService.GetTnums("化学");
	aContext.put("chemicalTnum", chemicalTnum);
	
	aContext.put("th11", "课程数量");
	aContext.put("th12", "教师数量");
*/

		return SUCCESS;
	}
}
