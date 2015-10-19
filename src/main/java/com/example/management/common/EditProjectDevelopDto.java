package com.example.management.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;
/**
 * スペックシート編集時の情報を格納するDto
 * @author takumi.sato
 *
 */
@Data
public class EditProjectDevelopDto {
	Integer no;
	Date startDate;
	Date finishDate;
	String overView;
	Map<Integer,String> osMap;
	Map<Integer,String> languageMap;
	List<String> otherList;
	Map<Integer,String> processMap;
	List<String> roleList;
	String teamNum;
	String allNum;
	String content;
}
