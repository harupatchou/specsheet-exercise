package com.example.management.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.common.EditProjectDevelopDto;
import com.example.management.common.ProjectDevelopDto;
import com.example.management.domain.LanguageExp;
import com.example.management.domain.OsExp;
import com.example.management.domain.Project;
import com.example.management.domain.ProjectLanguage;
import com.example.management.domain.ProjectOs;
import com.example.management.domain.ProjectProcess;
import com.example.management.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public List<ProjectDevelopDto> getProjectDevelopDtoList(String staffId){
		List<ProjectDevelopDto> result = new ArrayList<ProjectDevelopDto>();
		//対象ユーザの全てのプロジェクト情報を取得
		List<Project> projectList = projectRepository.findByStaffIdOrderByNoAsc(staffId);
		if(projectList == null){
			return result;
		}
		
		//(プロジェクトの取得を最初で失敗した時用に-1でフラグを立てている)
		ProjectDevelopDto dto = new ProjectDevelopDto();;
		dto.setNo(-1);
		try{
			for(Project project:projectList){
				//各種情報を詰め込む
				dto = new ProjectDevelopDto();
				dto.setStartDate(project.getStartDate());
				dto.setFinishDate(project.getFinishDate());
				
				//期間フォーマット
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				
					Date StartDate = project.getStartDate();
					String formatStartDate = sdf.format(StartDate);
//					dto.setStartDate(sdf.parse(formatStartDate));
					String formatFinishDate = sdf.format(project.getFinishDate());
					
					dto.setFmtFirstDate(formatStartDate);
					dto.setFmtFinishDate(formatFinishDate);
					
				dto.setOverView(project.getOvertview());
				if(project.getRole() != null){
					dto.setRoleList(Arrays.asList(project.getRole().split(",")));
				}
				dto.setTeamNum(project.getTeamNum());
				if(project.getOther() != null){
					dto.setOtherList(Arrays.asList(project.getOther().split(",")));
				}
				dto.setAllNum(project.getAllNum());
				dto.setContent(project.getContent());
				
				//現在何か月目かを計算
				Calendar from= Calendar.getInstance();
				Calendar to = Calendar.getInstance();
				from.setTime(dto.getStartDate());
				if(dto.getFinishDate() == null){
					to.setTimeInMillis(System.currentTimeMillis());
				}else{
					to.setTime(project.getFinishDate());
				}
				//最低でも1か月目と表示させたいので1足す
				Integer deffMonth = to.get(Calendar.MONTH) - from.get(Calendar.MONTH) + 1;
				Integer deffYear = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
				if(deffMonth<0){
					deffYear--;
				}
				dto.setProjectPeriod(deffMonth + deffYear*12);
				
				//各リストを取得
				setOsListToDto(dto, project);
				setLanguageListToDto(dto, project);
				setProcessList(dto, project);

				//表示するリストへ追加
				result.add(dto);
			}
		}catch(EntityNotFoundException e){
			if(dto.getNo() != -1){
				result.add(dto);
			}
			return result;
		}
		return result;
	}
	
	
	/**
	 * 開発経験に表示するためのDtoの取得
	 * @param staffId
	 * @return
	 */
	public List<EditProjectDevelopDto> getEditProjectDevelopDtoList(String staffId){
		List<EditProjectDevelopDto> result = new ArrayList<EditProjectDevelopDto>();
		//対象ユーザの全てのプロジェクト情報を取得
		List<Project> projectList = projectRepository.findByStaffIdOrderByNoAsc(staffId);
		if(projectList == null){
			return result;
		}
		//各プロジェクトの情報を取得していく
		//(プロジェクトの取得を最初で失敗した時用に-1でフラグを立てている)
		EditProjectDevelopDto dto = new EditProjectDevelopDto();
		dto.setNo(-1);
		try{
			for(Project project:projectList){
				//各種情報を詰め込む
				dto = new EditProjectDevelopDto();
				dto.setStartDate(project.getStartDate());
				dto.setFinishDate(project.getFinishDate());
				dto.setOverView(project.getOvertview());
				if(project.getRole() != null){
					dto.setRoleList(Arrays.asList(project.getRole().split(",")));
				}
				dto.setTeamNum(project.getTeamNum());
				if(project.getOther() != null){
					dto.setOtherList(Arrays.asList(project.getOther().split(",")));
				}
				dto.setAllNum(project.getAllNum());
				dto.setContent(project.getContent());
				
				//各リストを取得
				setOsListToDto(dto, project);
				setLanguageListToDto(dto, project);
				setProcessList(dto, project);

				//表示するリストへ追加
				result.add(dto);
			}
		}catch(EntityNotFoundException e){
			if(dto.getNo() != -1){
				result.add(dto);
			}
			return result;
		}
		return result;
	}
	
	
	
	/**
	 * OS情報をDtoへ書き込む
	 * @author takumi.sato
	 * @param dto
	 * @param project
	 */
	public void setOsListToDto(ProjectDevelopDto dto,Project project){
		List<String> result = new ArrayList<String>();
		try{
			//osの取得
			List<ProjectOs> osList = project.getProjectOsList();
			
			for(ProjectOs projectOs:osList){
				OsExp osExp = projectOs.getOsExp();
				result.add(osExp.getOsDefine().getOsName());	
			}
		}catch(EntityNotFoundException e){
		}finally{
			dto.setOsList(result);
		}
	}
	/**
	 * OS情報を編集用のDtoへ書き込む
	 * @author takumi.sato
	 * @param dto
	 * @param project
	 */
	public void setOsListToDto(EditProjectDevelopDto dto,Project project){
		Map<Integer,String> result = new HashMap<Integer, String>();
		try{
			//osの取得
			List<ProjectOs> osList = project.getProjectOsList();
			for(ProjectOs projectOs:osList){
				OsExp osExp = projectOs.getOsExp();
				result.put(osExp.getOsDefine().getOsId(), osExp.getOsDefine().getOsName());
			}
		}catch(EntityNotFoundException e){
		}finally{
			dto.setOsMap(result);
		}
	}
	
	
	/**
	 * 言語情報をDtoへ書き込む
	 * @author takumi.sato
	 * @param dto
	 * @param project
	 */
	public void setLanguageListToDto(ProjectDevelopDto dto,Project project){
		List<String> result = new ArrayList<String>();
		try{
			//言語情報の取得
			List<ProjectLanguage> languageList = project.getProjectLanguageList();
			for(ProjectLanguage projectLanguage:languageList){
				LanguageExp languageExp = projectLanguage.getLanguageExp();
				result.add(languageExp.getLanguageDefine().getName());
			}
		}catch(EntityNotFoundException e){
		}finally{
			dto.setLanguageList(result);
		}
	}
	/**
	 * 言語情報を編集用へのDtoへ書き込む
	 * @param dto
	 * @param project
	 */
	public void setLanguageListToDto(EditProjectDevelopDto dto,Project project){
		Map<Integer,String> result = new HashMap<Integer, String>();
		try{
			//言語情報の取得
			List<ProjectLanguage> languageList = project.getProjectLanguageList();
			for(ProjectLanguage projectLanguage:languageList){
				LanguageExp languageExp = projectLanguage.getLanguageExp();
				result.put(languageExp.getLanguageDefine().getId(),languageExp.getLanguageDefine().getName());
			}
		}catch(EntityNotFoundException e){
		}finally{
			dto.setLanguageMap(result);
		}
	}
	
	
	/**
	 * 担当工程情報をDtoへ書き込む
	 * @author takumi.sato
	 * @param dto
	 * @param project
	 */
	public void setProcessList(ProjectDevelopDto dto,Project project){
		List<String> result = new ArrayList<String>();
		try{
			//言語情報の取得
			List<ProjectProcess> processList = project.getProjectProcessList();
			for(ProjectProcess projectProcess:processList){
				result.add(projectProcess.getProcessDefine().getName());
			}
		}catch(EntityNotFoundException e){
		}finally{
			dto.setProcessList(result);
		}
	}
	/**
	 * 担当工程情報を編集用のDtoへ書き込む
	 * @param dto
	 * @param project
	 */
	public void setProcessList(EditProjectDevelopDto dto,Project project){
		Map<Integer,String> result = new HashMap<Integer, String>();
		try{
			//言語情報の取得
			List<ProjectProcess> processList = project.getProjectProcessList();
			for(ProjectProcess projectProcess:processList){
				result.put(
					projectProcess.getProcessDefine().getId(),
					projectProcess.getProcessDefine().getName());
			}
		}catch(EntityNotFoundException e){
		}finally{
			dto.setProcessMap(result);
		}
	}
	/**
	 * プロジェクト情報を保存する
	 * @author takumi.sato
	 * @param project
	 */
	public Project saveProject(Project project){
		return projectRepository.save(project);
	}
	/**
	 * 対象ユーザのプロジェクト情報を全て削除する
	 * @param staffId
	 */
	public void deleteByStaffId(String staffId){
		projectRepository.deleteByStaffId(staffId);
	}
}
