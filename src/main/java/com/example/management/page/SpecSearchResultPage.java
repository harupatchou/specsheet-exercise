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
	/**名前 */
	private String name;
	/**状態フラグ */
	private Integer stateFlag;
	/**経験言語リスト */
	private ArrayList<String> langList;
	/**開発関連技術 */
	private String relatedTech;
	/**IT全体経験 */
	private Integer allExp;
	/**年代ID */
	private Integer ageId;
	/**更新日時 */
	private Date updateDate;
	
}
