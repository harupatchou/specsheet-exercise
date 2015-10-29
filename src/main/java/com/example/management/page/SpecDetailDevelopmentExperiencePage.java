package com.example.management.page;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecDetailDevelopmentExperiencePage {
	/**プロジェクトNo */
	private Integer no;
	/**開始期間 */
	private Date startDate;
	/**終了期間 */
	private Date finishDate;
	/**プロジェクト概要 */
	private String overview;
	
	/**OS名 */
	private String osName;//
	private List<String> osNameList;//
	/**言語名 */
	private String languageName;//
	private List<String> languageNameList;//
	/**その他 */
	private String other;
	private List<String> otherList;

	/**担当工程名 */
	private String processName;//
	private List<String> processNameList;//

	/**担当役割名 */
	private String role;
	private List<String> roleList;

	/**チーム人数 */
	private String teamNum;
	/**全体人数 */
	private String allNum;
	/**作業内容 */
	private String content;
	
	/**期間*/
	private Integer period;
}
