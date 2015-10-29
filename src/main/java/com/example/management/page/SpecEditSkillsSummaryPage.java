package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * スキル要約欄初期表示用ページ.
 * @author ueno
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecEditSkillsSummaryPage {
	/**経験言語・開発関連技術*/
	private String language;
	/**経験OS*/
	private String os;
	/**言語実務経験フラグ*/
	private Integer expFlag;
	/**言語経験月数*/
	private Integer monthOfLangExp;
	/**OS経験月数*/
	private Integer monthOfOsExp;
	/**開発関連技術*/
	private String relatedTech;
	
	
}
