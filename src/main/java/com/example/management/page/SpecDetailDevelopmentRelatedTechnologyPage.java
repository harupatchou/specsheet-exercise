package com.example.management.page;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecDetailDevelopmentRelatedTechnologyPage {
//スキル要約に表示するため、４つJOINして使う？
	/**スタッフID */
	private String staffId;
//	/**プロジェクトNo */
//	private Integer no;
//	/**開始期間 */
//	private Date startDate;
//	/**終了期間 */
//	private Date finishDate;
//	/**プロジェクト概要 */
//	private String overview;
//	/**チーム人数 */
//	private String teamNum;
//	/**全体人数 */
//	private String allNum;
//	/**担当役割 */
//	private String role;
//	/**作業内容 */
//	private String content;
	/**その他技術 */
	private String other;
	
	//以下、JOINしてもってくる部分
//	/**スキル要約の言語 */
//	private String languageName;
//	/**スキル要約の環境OS等 */
//	private String osName;
//	/**スキル要約の業務範囲 */
//	private String processName;
}
