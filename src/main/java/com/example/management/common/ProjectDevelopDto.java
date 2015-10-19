package com.example.management.common;

import java.util.Date;
import java.util.List;

import lombok.Data;
/**
 * スペックシートの開発経験を保持するDto
 * @author rksuser
 *
 */
@Data
public class ProjectDevelopDto {
	Integer no;
	Date startDate;
	Date finishDate;
	/** 現在の日時*/
	Date currentDate;
	/** プロジェクト期間*/
	Integer projectPeriod;
	String overView;
	List<String> osList;
	List<String> languageList;
	List<String> otherList;
	List<String> processList;
	List<String> roleList;
	String teamNum;
	String allNum;
	String content;
	String fmtFirstDate;
	String fmtFinishDate;
}
