package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 経験内訳
 * @author takayuki.honma
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpBreakdownPage {
	/**スタッフID */
	private String staffId;
	/**経験内訳ID */
	private Integer expBreakdownId;
	/**経験内訳月数 */
	private Integer monthOfExp;
	/**経験内訳名 */
	private String name;
	/** */
	private Integer serverNetworkExpYear;
	/** */
	private Integer serverNetworkExpMonth;
	/** */
	private Integer seExpYear;
	/** */
	private Integer seExpMonth;
	/** */
	private Integer developmentExpYear;
	/** */
	private Integer developmentExpMonth;
	/** */
	private Integer pgOperatorExpYear;
	/** */
	private Integer pgOperatorExpMonth;
	
}
