package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OS経験.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OsExp {
	/**スタッフID */
	private String staffId;
	/**OS経験No */
	private Integer no;
	/**OSID */
	private Integer osId;
	/**その他記入カラム */
	private String other;
	/**経験月数 */
	private Integer monthOfExp;
}
