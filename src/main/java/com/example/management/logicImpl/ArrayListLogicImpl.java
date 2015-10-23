package com.example.management.logicImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.management.logic.ArrayListLogic;
import com.example.management.page.SpecDetailDevelopmentExperiencePage;
import com.example.management.page.SpecSearchResultPage;

@Component
public class ArrayListLogicImpl implements ArrayListLogic {
	
	@Override
	public ArrayList<SpecSearchResultPage> hSearchResultUnique(ArrayList<SpecSearchResultPage> arg0) {
		ArrayList<SpecSearchResultPage> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			SpecSearchResultPage x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
		}
	
	@Override
	public ArrayList<SpecSearchResultPage> hSearchResultCompact(ArrayList<SpecSearchResultPage> arg0) {
		ArrayList<SpecSearchResultPage> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				SpecSearchResultPage x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}
	
	@Override
	public ArrayList<Integer> hIntUnique(ArrayList<Integer> arg0) {
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			Integer x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
	}
	
	@Override
	public ArrayList<Integer> hIntCompact(ArrayList<Integer> arg0) {
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				Integer x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}
	
	@Override
	public ArrayList<String> hStrUnique(ArrayList<String> arg0) {
		ArrayList<String> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			String x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
	}
	
	@Override
	public ArrayList<String> hStrCompact(ArrayList<String> arg0) {
		ArrayList<String> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				String x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}

	@Override
	public ArrayList<SpecDetailDevelopmentExperiencePage> hSpecDetailDevelopmentExperiencePageUnique(ArrayList<SpecDetailDevelopmentExperiencePage> arg0) {
		ArrayList<SpecDetailDevelopmentExperiencePage> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			SpecDetailDevelopmentExperiencePage x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
		}

}
