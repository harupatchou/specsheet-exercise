package com.example.management.form;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * スペックシート検索フォーム
 * @author takayuki.honma
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecSearchForm {
	/**氏名*/
	private String name;
	/**現場・待機フラグ*/
	private Integer stateFlag;
	/**経験言語*/
	private Integer langList;
	/**開発関連技術*/
	private Integer langList2;
	/**開発関連技術*/
	private Integer langList3;
	/**開発関連技術*/
	private String techList;
	/**開発関連技術のリスト*/
	private List<String> techSearchList;
	/**IT全体経験*/
	private Integer allExp;
	/**年代ID*/
	private Integer id;
	/**開発技術1*/
	private String techFirst;
	/**開発技術2*/
	private String techSecond;
	/**開発技術3*/
	private String techThird;
}
