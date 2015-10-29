package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectProcessPage {
	/**プロジェクトNO */
	private Integer no;
	/**開発工程名 */
	private String name;
}
