package com.example.management.logic;

import java.util.ArrayList;

import com.example.management.page.SpecSearchResultPage;

public class ArrayListLogic {
	public static ArrayList<SpecSearchResultPage> hUnique(ArrayList<SpecSearchResultPage> arg0) {
		ArrayList<SpecSearchResultPage> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			SpecSearchResultPage x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
	}
	
	public static ArrayList<SpecSearchResultPage> hCompact(ArrayList<SpecSearchResultPage> arg0) {
		ArrayList<SpecSearchResultPage> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				SpecSearchResultPage x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}
	
	public static ArrayList<Integer> hIntUnique(ArrayList<Integer> arg0) {
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			Integer x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
	}
	
	public static ArrayList<Integer> hIntCompact(ArrayList<Integer> arg0) {
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				Integer x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}
	
	public static ArrayList<String> hStrUnique(ArrayList<String> arg0) {
		ArrayList<String> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			String x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
	}
	
	public static ArrayList<String> hStrCompact(ArrayList<String> arg0) {
		ArrayList<String> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				String x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}

}
