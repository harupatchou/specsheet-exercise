package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecDetailProcessPage {
	/**スタッフID */
	private String staffId;
//	/**プロジェクトNo */
//	private Integer projectNo;
//	/**担当工程ID */
//	private Integer processId;
	/**担当工程名 */
	private String name;
}
