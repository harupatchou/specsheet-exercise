package com.example.management.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.management.keyId.ProjectOsKeyId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * プロジェクトOS.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project_os")
@IdClass(value=ProjectOsKeyId.class)
public class ProjectOs {
	/**スタッフID */
	@Id
	private String staffId;
	/**プロジェクトNo */
	@Id
	private Integer	projectNo;
	/**OS経験No */
	@Id
	private Integer osExpNo;
	
	/**プロジェクト*/
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="staffId",referencedColumnName="staffId",insertable=false,updatable=false),
		@JoinColumn(name="projectNo",referencedColumnName="no",insertable=false,updatable=false)
	})
	private Project project;
	
	/** OS経験 */
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="staffId",referencedColumnName="staffId",insertable=false,updatable=false),
		@JoinColumn(name="osExpNo",referencedColumnName="no",insertable=false,updatable=false)
	})
	private OsExp osExp;
}
