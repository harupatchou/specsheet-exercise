package com.example.management.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * プロジェクト言語.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLanguage {
	/** スタッフID */
	private String staffId;
	/** プロジェクトNo */
	private Integer projectNo;
	/** 言語経験No */
	private Integer languageExpNo;
	
	
}
