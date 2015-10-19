package com.example.management.keyId;

import java.io.Serializable;

import com.example.management.domain.ProjectLanguage;

import lombok.Data;
/**
 * {@link ProjectLanguage}クラスのキークラス
 * @author rksuser
 *
 */
@Data
public class ProjectLanguageKeyId implements Serializable{
	/** スタッフID */
	private String staffId;
	/** プロジェクトNo */
	private Integer projectNo;
	/** 言語経験No */
	private Integer languageExpNo;
}
