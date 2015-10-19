package com.example.management.domain;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.management.keyId.ProjectProcessKeyId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * プロジェクト担当工程.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="project_process")
@IdClass(value=ProjectProcessKeyId.class)
public class ProjectProcess {
	/**スタッフID */
	@Id
	private String staffId;
	/**プロジェクトNo */
	@Id
	private Integer projectNo;
	/**担当工程ID */
	@Id
	private Integer processId;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="staffId",referencedColumnName="staffId",updatable=false,insertable=false),
		@JoinColumn(name="projectNo",referencedColumnName="no",updatable=false,insertable=false)
	})
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="processId",referencedColumnName="id",insertable=false,updatable=false)
	private ProcessDefine processDefine;
}
