package com.example.management.logicImpl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.OsDefine;
import com.example.management.domain.ProcessDefine;
import com.example.management.domain.Project;
import com.example.management.form.SpecForm;
import com.example.management.logic.ProjectLogic;
import com.example.management.page.ProjectLanguagePage;
import com.example.management.page.ProjectOsPage;
import com.example.management.page.ProjectProcessPage;
import com.example.management.service.DeleteService;
import com.example.management.service.LanguageDefineService;
import com.example.management.service.OsDefineService;
import com.example.management.service.ProcessDefineService;
import com.example.management.service.ProjectService;

@Component
public class ProjectLogicImpl implements ProjectLogic{
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private OsDefineService osDefineServise;
	@Autowired
	private LanguageDefineService languageDefineService;
	@Autowired
	private ProcessDefineService processDefineService;
	@Autowired
	private DeleteService deleteService;

	@Override
	public Boolean insertProject(String staffId, SpecForm specForm) throws Exception {
		Project project = new Project();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//プロジェクト番号でスプリット区切りの配列型に変換
		String[] projectNo = specForm.getProjectNo().split(",");
		String[] start = specForm.getStartDay().split(",");
		String[] finish = specForm.getFinishDay().split(",");
		String[] over = specForm.getOverview().split(",");
		String[] team = specForm.getTeamNum().split(",");
		String[] all = specForm.getAllNum().split(",");
		String[] role = specForm.getRole().split(",");
		String[] content = specForm.getContent().split(",");
		String[] other = specForm.getOther().split(",");
		
		for (String proNo : projectNo){
			project.setStaffId(staffId);
			project.setNo(Integer.parseInt(proNo));
			//String型の開始日時をDate型に変換する処理
			project.setStartDate(sdf.parse(start[Integer.parseInt(proNo)-1]));
			//String型の終了日時をDate型に変換する処理
			project.setFinishDate(sdf.parse(finish[Integer.parseInt(proNo)-1]));
			project.setOverview(over[Integer.parseInt(proNo)-1]);
			project.setTeamNum(team[Integer.parseInt(proNo)-1]);
			project.setAllNum(all[Integer.parseInt(proNo)-1]);
			project.setRole(role[Integer.parseInt(proNo)-1]);
			project.setContent(content[Integer.parseInt(proNo)-1]);
			project.setOther(other[Integer.parseInt(proNo)-1]);
			
			projectService.insertProject(project);
		}
		
		return true;
	}

	@Override
	public List<OsDefine> getOS() {
		List<OsDefine> osList = osDefineServise.findAll();
		return osList;
	}

	@Override
	public List<LanguageDefine> getLang() {
		List<LanguageDefine> langList = languageDefineService.findAll();
		return langList;
	}

	@Override
	public List<ProcessDefine> getProcess() {
		List<ProcessDefine> processList = processDefineService.findAll();
		return processList;
	}

	@Override
	public List<Project> selectByStaffId(String staffId) {
		List<Project> projectList = projectService.selectByStaffId(staffId);
		return projectList;
	}

	@Override
	public List<String> selectOs(String staffId) {
		//情報取得
		List<ProjectOsPage> osList = projectService.findProjectOs(staffId);
		//編集画面開発欄os初期表示用StringList
		List<String> strList = new ArrayList<String>();
		//取得データ内のos名を保持するカラム
		String str = new String();
		//プロジェクト番号を保持しておくカラム
		Integer tempProNum = 1;
		//osListの最後の値と一致したカラムが来たときの判別処理用
		Integer lastNum = 0;
		//
		for (ProjectOsPage os : osList){
			if(os.getNo()==1){
				str += os.getOsName();
				str +="/";
				lastNum+=1;
				continue;
			}
			if(os.getNo()!=tempProNum){
				str = str.substring(0, str.length()-1);
				strList.add(str);
				str="";
			}
			tempProNum = os.getNo();
			lastNum+=1;
			if(os.getNo()==tempProNum){
				str += os.getOsName();
				str +="/";
			}
			if(lastNum==osList.size()){
				str = str.substring(0, str.length()-1);
				strList.add(str);
				str="";
			}
		}
			
		return strList;
	}

	@Override
	public List<String> selectLang(String staffId) {
		//情報取得
		List<ProjectLanguagePage> langList = projectService.findProjectLang(staffId);
		//編集画面開発欄lang初期表示用StringList
		List<String> strList = new ArrayList<String>();
		//取得データ内のlang名を保持するカラム
		String str = new String();
		//プロジェクト番号を保持しておくカラム
		Integer tempProNum = 1;
		//langListの最後の値と一致したカラムが来たときの判別処理用
		Integer lastNum = 0;
		//
		for (ProjectLanguagePage lang : langList){
			if(lang.getNo()==1){
				str += lang.getName();
				str +="/";
				lastNum+=1;
				continue;
			}
			if(lang.getNo()!=tempProNum){
				str = str.substring(0, str.length()-1);
				strList.add(str);
				str="";
			}
			tempProNum = lang.getNo();
			lastNum+=1;
			if(lang.getNo()==tempProNum){
				str += lang.getName();
				str +="/";
			}
			if(lastNum==langList.size()){
				str = str.substring(0, str.length()-1);
				strList.add(str);
				str="";
			}
		}
			
		return strList;
	}

	@Override
	public List<String> selectProcess(String staffId) {
		//情報取得
		List<ProjectProcessPage> processList = projectService.findProjectProcess(staffId);
		//編集画面開発欄process初期表示用StringList
		List<String> strList = new ArrayList<String>();
		//取得データ内のprocess名を保持するカラム
		String str = new String();
		//プロジェクト番号を保持しておくカラム
		Integer tempProNum = 1;
		//langListの最後の値と一致したカラムが来たときの判別処理用
		Integer lastNum = 0;
		//
		for (ProjectProcessPage process : processList){
			if(process.getNo()==1){
				str += process.getName();
				str +="/";
				lastNum+=1;
				continue;
			}
			if(process.getNo()!=tempProNum){
				str = str.substring(0, str.length()-1);
				strList.add(str);
				str="";
			}
			tempProNum = process.getNo();
			lastNum+=1;
			if(process.getNo()==tempProNum){
				str += process.getName();
				str +="/";
			}
			if(lastNum==processList.size()){
				str = str.substring(0, str.length()-1);
				strList.add(str);
				str="";
			}
		}
			
		return strList;
	}

	@Override
	public void deleteAll(String staffId) {
		deleteService.delete(staffId);
	}
	
/*	private List<String> changeStartDateStr(List<Project> proList) {
		//開発経験のDate型の開始日時をString型リストにつめる
		List<String> startDateStrList = new ArrayList<String>();
		//Date型のデータを変換したデータを一時保存するStringカラム
		String startDateStr = "";
		for (Project proDate : projectList){
			startDateStr = new SimpleDateFormat("yyyy/MM/dd").format(proDate.getStartDate());
			startDateStrList.add(startDateStr);
			startDateStr = "";
		}
		
		return startDateStrList;
	}
	
	private List<String> changeFinishDateStr(List<Project> proList) {
		//開発経験のDate型の終了日時をString型リストにつめる
		List<String> finishDateStrList = new ArrayList<String>();
		//Date型のデータを変換したデータを一時保存するStringカラム
		String finishDateStr = "";
		
		for (Project proDate : projectList){
			finishDateStr = new SimpleDateFormat("yyyy/MM/dd").format(proDate.getFinishDate());
			finishDateStrList.add(finishDateStr);
			finishDateStr = "";
		}
		
		return finishDateStrList;
	}*/

	
	

}
