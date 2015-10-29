package com.example.management.logicImpl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.example.management.form.SpecForm;
import com.example.management.logic.DevelopLogic;
import com.example.management.page.SpecRegistConfirmPage;

@Component
public class DevelopLogicImpl implements DevelopLogic {
	
	@Override
	public SpecRegistConfirmPage hGenerateDevPage(SpecForm form) {
		ArrayList<String> startDay = new ArrayList<String>(Arrays.asList(form.getStartDay().split(",")));
		ArrayList<String> finishDay = new ArrayList<String>(Arrays.asList(form.getFinishDay().split(",")));
		ArrayList<String> projectNo = new ArrayList<String>(Arrays.asList(form.getProjectNo().split(",")));
		ArrayList<String> overview = new ArrayList<String>(Arrays.asList(form.getOverview().split(",")));
		ArrayList<String> os = new ArrayList<String>(Arrays.asList(form.getOs().split(",")));
		ArrayList<String> lang = new ArrayList<String>(Arrays.asList(form.getLang().split(",")));
		ArrayList<String> other = new ArrayList<String>(Arrays.asList(form.getOther().split(",")));
		ArrayList<String> role = new ArrayList<String>(Arrays.asList(form.getRole().split(",")));
		ArrayList<String> process = new ArrayList<String>(Arrays.asList(form.getProcess().split(",")));
		ArrayList<String> content = new ArrayList<String>(Arrays.asList(form.getContent().split(",")));
		ArrayList<String> teamNum = new ArrayList<String>(Arrays.asList(form.getTeamNum().split(",")));
		ArrayList<String> allNum = new ArrayList<String>(Arrays.asList(form.getAllNum().split(",")));
		
		SpecRegistConfirmPage page = new SpecRegistConfirmPage(startDay, finishDay, projectNo, overview, os,
				lang, other, role, process, content, teamNum, allNum);
		
		return page;
	}
		
}
