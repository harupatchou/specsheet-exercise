package com.example.management.keyId;

import java.io.Serializable;


import lombok.Data;
/**
 * {@link ProjectOs}クラスの主キークラス
 * @author rksuser
 *
 */
@Data
public class ProjectOsKeyId implements Serializable{
	/** スタッフID */
	private String staffId;
	/** プロジェクトNo */
	private Integer projectNo;
	/** OS経験No */
	private Integer osExpNo;
}
