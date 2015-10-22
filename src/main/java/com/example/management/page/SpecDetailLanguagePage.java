package com.example.management.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecDetailLanguagePage {
	/**スタッフID */
	private String staffId;
//	/**言語経験No */
//	private Integer no;
//	/**言語ID */
//	private Integer languageId;
//	/**その他記入カラム */
//	private String other;
//	/**実務経験フラグ */
//	private Integer expFlag;
//	/**経験月数 */
//	private Integer monthOfExp;
	/**言語名 */
	private String name;
}
