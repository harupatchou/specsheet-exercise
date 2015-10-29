package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLanguagePage {
	/**プロジェクトNO */
	private Integer no;
	/**言語名 */
	private String name;
}