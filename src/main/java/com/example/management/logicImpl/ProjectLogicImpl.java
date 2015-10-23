package com.example.management.logicImpl;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.management.domain.OsDefine;
import com.example.management.domain.Project;
import com.example.management.form.SpecForm;
import com.example.management.logic.ProjectLogic;
import com.example.management.service.OsDefineService;
import com.example.management.service.ProjectService;

@Component
public class ProjectLogicImpl implements ProjectLogic{
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private OsDefineService osDefineServise;

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
	
	

	
	

}
