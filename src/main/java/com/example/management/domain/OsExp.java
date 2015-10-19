package com.example.management.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.management.keyId.OsExpKeyId;

import lombok.Data;

/**
 * OS経験.
 * @author okamoto
 *
 */
@Data
@Entity
@Table(name="os_exp")
@IdClass(value=OsExpKeyId.class)
public class OsExp {
	/**スタッフID */
	@Id
	private String staffId;
	/**OS経験No */
	@Id
	private Integer no;
	/**OSID */
	private Integer osId;
	/**その他記入カラム */
	private String other;
	/**経験月数 */
	private Integer monthOfExp;
	
	/**プロジェクトOS*/
	@OneToMany(mappedBy="project")
	private List<ProjectOs> projectOsList;
	
	/** OS定義 */
	@ManyToOne
	@JoinColumn(name="osId",referencedColumnName="osId",insertable=false,updatable=false)
	private OsDefine osDefine;
}
