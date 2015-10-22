package com.example.management.page;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * スペック.
 * @author takayuki.honma
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecSearchResultPage {
	/**スタッフID */
	private String staffId;
	/**名字 */
	private String firstName;
	/**名前 */
	private String lastName;
	/**フルネーム */
	private String fullName;
	/**状態フラグ */
	private Integer stateFlag;
	/**状態 */
	private String state;
	/**IT全体経験 */
	private Integer allExp;
	/**IT全体経験 */
	private Integer[] allExpArray;
	/**経験言語 */
	private String langName;
	/**経験言語リスト */
	private ArrayList<String> langList;
	/**年代ID */
	private Integer ageId;
	/**年代 */
	private String ageRange;
	/**開発関連技術 */
	private String relatedTech;
	/**更新日時 */
	private Date updateDate;
	
}
