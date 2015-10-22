package com.example.management.domain;


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
public class ProjectProcess {
	/**スタッフID */
	private String staffId;
	/**プロジェクトNo */
	private Integer projectNo;
	/**担当工程ID */
	private Integer processId;
	
}
