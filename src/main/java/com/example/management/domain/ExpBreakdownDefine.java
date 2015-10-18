package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 経験内訳定義.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpBreakdownDefine {
	/**経験内訳ID */
	private Integer id;
	/**経験内訳名 */
	private String name;
}
