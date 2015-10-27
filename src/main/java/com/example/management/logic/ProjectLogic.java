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
    
    //os選択用値取得
    public List<OsDefine> getOS();

    //lang選択用値取得
	public List<LanguageDefine> getLang();
	
	//process選択用値取得
	public List<ProcessDefine> getProcess();

}
