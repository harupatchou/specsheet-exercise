package com.example.management.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 言語経験.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageExp {
	/**スタッフID */
	private String staffId;
	/**言語経験No */
	private Integer no;
	/**言語ID */
	private Integer languageId;
	/**その他記入カラム */
	private String other;
	/**実務経験フラグ */
	private Integer expFlag;
	/**経験月数 */
	private Integer monthOfExp;
	
}
