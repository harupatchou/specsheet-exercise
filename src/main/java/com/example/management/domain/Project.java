package com.example.management.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * プロジェクト.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project")
public class Project {
	/**スタッフID */
	private String staffId;
	/**プロジェクトNo */
	@Id
	private Integer no;
	/**開始期間 */
	private Date startDate;
	/**終了期間 */
	private Date finishDate;
	/**プロジェクト概要 */
	private String overview;
	/**チーム人数 */
	private String teamNum;
	/**全体人数 */
	private String allNum;
	/**担当役割 */
	private String role;
	/**作業内容 */
	private String content;
	/**その他技術 */
	private String other;
}
