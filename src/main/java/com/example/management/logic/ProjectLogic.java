package com.example.management.logic;


import java.util.List;

import org.springframework.stereotype.Component;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.OsDefine;
import com.example.management.domain.ProcessDefine;
import com.example.management.domain.Project;
import com.example.management.form.SpecForm;

@Component
public interface ProjectLogic {
	
	//個人情報の取得
    public List<Project> selectByStaffId(String staffId);
	
	//登録処理
    public Boolean insertProject(String staffId,SpecForm specForm) throws Exception;
    
    //編集時初期表示os取得
    public List<String> selectOs(String staffId);
    
    //編集時初期表示lang取得
    public List<String> selectLang(String staffId);
    
    //編集時初期表示process取得
    public List<String> selectProcess(String staffId);
    
    //os選択用値取得
    public List<OsDefine> getOS();

    //lang選択用値取得
	public List<LanguageDefine> getLang();
	
	//process選択用値取得
	public List<ProcessDefine> getProcess();
	
	//edit時、削除処理
	public void deleteAll(String staffId);
	
	/*//startDate変換
	public List<String> changeStartDateStr(List<Project> projectList);
	
	//finishDate変換
	public List<String> changeFinishDateStr(AtList<Project> projectList);*/
	
}
