package com.example.management.form;

import lombok.Data;

/**ログイン用フォーム.
 * @author ueno
 */
@Data
public class UserLoginForm {
	/**スタッフID */
	private String staffId;
	/**パスワード */
	private String password;
}
