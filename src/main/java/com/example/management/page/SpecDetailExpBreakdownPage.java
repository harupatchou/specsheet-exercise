package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecDetailExpBreakdownPage {
	/**スタッフID */
	private String staffId;
	/**経験内訳ID */
	private Integer expBreakdownId;
	/**経験月数 */
	private Integer monthOfExp;
	/**経験内訳名　*/
	private String breakdownName;
	
	/**経験月数を年数に直した数値 */
	private Integer[] year;
	/**経験月数を年数に直した数値の余り月数 */
	private Integer[] month;
	
}
