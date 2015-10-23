package com.example.management.logic;


import java.util.List;

import org.springframework.stereotype.Component;

import com.example.management.domain.OsDefine;
import com.example.management.form.SpecForm;

@Component
public interface ProjectLogic {
	
	//登録処理
    public Boolean insertProject(String staffId,SpecForm specForm) throws Exception;
    
    //os選択用値取得
    public List<OsDefine> getOS();

}
