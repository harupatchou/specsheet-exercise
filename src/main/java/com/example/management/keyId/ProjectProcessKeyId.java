package com.example.management.keyId;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectProcessKeyId implements Serializable{
	/** スタッフID */
	private String staffId;
	/** プロジェクトNo */
	private Integer projectNo;
	/** 担当工程 */
	private Integer processId;
}
