package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	/**スタッフID */
	private String staffId;
	/**名前 */
	private String name;
	/**姓 */
	private String firstName;
	/**名 */
	private String lastName;
	/**姓(ﾌﾘｶﾞﾅ) */
	private String firstPhonetic;
	/**名(ﾌﾘｶﾞﾅ) */
	private String lastPhonetic;
	/**権限ID */
	private Integer authority;
	/**パスワード */
	private String password;	
}
