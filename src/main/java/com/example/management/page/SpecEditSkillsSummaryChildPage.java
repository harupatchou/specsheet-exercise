package com.example.management.page;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecEditSkillsSummaryChildPage {
	/**経験言語・開発関連技術*/
	private List<String> langList;
	/**経験OS*/
	private List<String> osList;
	/**言語実務経験フラグ*/
	private List<Integer> expFlagList;
	/**言語経験月数*/
	private List<Integer> monthOfLangExpList;
	/**OS経験月数*/
	private List<Integer> monthOfOsExpList;
	/**開発関連技術*/
	private String relatedTech;

}
