package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OS定義.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OsDefine {
	/**OSID */
	private Integer osId;
	/**OS名 */
	private String osName;
}
