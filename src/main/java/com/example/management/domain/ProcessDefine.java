package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 担当工程定義.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessDefine {
	/**担当工程ID */
	private Integer id;
	/**担当工程名 */
	private String name;
}
