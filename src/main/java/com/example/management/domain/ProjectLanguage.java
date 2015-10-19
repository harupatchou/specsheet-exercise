package com.example.management.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.management.keyId.ProjectLanguageKeyId;

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
@Entity
@Table(name="project_language")
@IdClass(value=ProjectLanguageKeyId.class)
public class ProjectLanguage {
	/** スタッフID */
	@Id
	private String staffId;
	/** プロジェクトNo */
	@Id
	private Integer projectNo;
	/** 言語経験No */
	@Id
	private Integer languageExpNo;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="staffId",referencedColumnName="staffId",insertable=false,updatable=false),
		@JoinColumn(name="projectNo",referencedColumnName="no",insertable=false,updatable=false)
	})
	private Project project;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="staffId",referencedColumnName="staffId",insertable=false,updatable=false),
		@JoinColumn(name="languageExpNo",referencedColumnName="no",insertable=false,updatable=false)
	})
	private LanguageExp languageExp;
	
}
