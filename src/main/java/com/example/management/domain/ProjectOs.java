package com.example.management.domain;

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
public class ProjectOs {
	/**スタッフID */
	private String staffId;
	/**プロジェクトNo */
	private Integer	projectNo;
	/**OS経験No */
	private Integer osExpNo;
}
