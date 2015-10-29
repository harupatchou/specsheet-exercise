package com.example.management.page;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecRegistConfirmPage {
	private ArrayList<String> startDay;
	private ArrayList<String> finishDay;
	private ArrayList<String> projectNo;
	private ArrayList<String> overview;
	private ArrayList<String> os;
	private ArrayList<String> lang;
	private ArrayList<String> other;
	private ArrayList<String> role;
	private ArrayList<String> process;
	private ArrayList<String> content;
	private ArrayList<String> teamNum;
	private ArrayList<String> allNum;

}
