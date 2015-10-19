package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 経験内訳
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpBreakdown {
	/**スタッフID */
	private String staffId;
	/**経験内訳ID */
	private Integer expBreakdownId;
	/**経験内訳月数 */
	private Integer monthOfExp;
}
