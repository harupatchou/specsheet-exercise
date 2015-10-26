package com.example.management.form;

import lombok.Data;

/**
 * ユーザー編集フォーム.
 * @author ueno
 */
@Data
public class UserEditForm {
	/**スタッフID*/
	private String staffId;
	/** 権限 */
	private Integer authorityId;
	/**姓*/
	private String firstName;
	/**名*/
	private String lastName;
	/**セイ*/
	private String firstPhonetic;
	/**メイ*/
	private String lastPhonetic;
	/**性別*/
	private String sex;
	/** パスワード */
	private String password;
	/** 新しいパスワード */
	private String newPassword;
	/** 確認パスワード */
	private String confirmPassword;
	/**一時保存用スタッフID*/
	private String tempStaffId;
	/**スタッフIDパーツ１*/
	private String staffIdFirst;
	/**スタッフIDパーツ2*/
	private String staffIdSecond;
	/**スタッフIDパーツ3*/
	private String staffIdThird;
}
