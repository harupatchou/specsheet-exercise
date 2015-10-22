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
	/**氏*/
	private String firstName;
	/**名*/
	private String lastName;
	/**現場・待機フラグ*/
	private Integer stateFlag;
	/**経験言語*/
	private Integer lang1;
	/**開発関連技術*/
	private Integer lang2;
	/**開発関連技術*/
	private Integer lang3;
	/**開発関連技術*/
	private String techList;
	/**開発関連技術のリスト*/
	private List<String> techSearchList;
	/**IT全体経験*/
	private Integer allExp;
	/**年代ID*/
	private Integer id;
	/**開発技術1*/
	private String tech1;
	/**開発技術2*/
	private String tech2;
	/**開発技術3*/
	private String tech3;
}
