package com.example.management.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.management.keyId.LanguageExpKeyId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 言語経験.
 * @author okamoto
 *
 */
@Data
@Entity
@Table(name="language_exp")
@IdClass(value=LanguageExpKeyId.class)
@NoArgsConstructor
@AllArgsConstructor
public class LanguageExp {
	/**スタッフID */
	@Id
	private String staffId;
	/**言語経験No */
	@Id
	private Integer no;
	/**言語ID */
	private Integer languageId;
	/**その他記入カラム */
	private String other;
	/**実務経験フラグ */
	private Integer expFlag;
	/**経験月数 */
	private Integer monthOfExp;
	
	/** プロジェクト言語 */
	@OneToMany
	private List<ProjectLanguage> projectLanguageList;
	
	/** 言語定義*/
	@ManyToOne
	@JoinColumn(name="languageId",referencedColumnName="id",insertable=false,updatable=false)
	private LanguageDefine languageDefine;
}
