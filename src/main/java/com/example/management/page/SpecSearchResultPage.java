package com.example.management.page;

import java.util.Date;
import java.util.List;

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
	private String stateFlag;
	/**経験言語リスト */
	private List<String> langList;
	/**開発関連技術 */
	private String relatedTech;
	/**IT全体経験 */
	private Integer allExp;
	/**年代ID */
	private String ageRange;
	/**更新日時 */
	private Date updateDate;
	
}
