package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 言語定義.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDefine {
	/**言語ID */
	private Integer id;
	/**言語名 */
	private String name;
}
