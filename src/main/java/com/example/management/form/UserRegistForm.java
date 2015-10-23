package com.example.management.form;

import lombok.Data;
/**
 * ユーザー登録フォーム
 * @author ueno
 */
@Data
public class UserRegistForm {
//	/**スタッフID*/
//	private String staffId;
	/**性別*/
	private String sex;
	/**姓*/
	private String firstName;
	/**名*/
	private String lastName;
	/**セイ*/
	private String firstPhonetic;
	/**メイ*/
	private String lastPhonetic;
	/**権限*/
	private Integer authorityId;
	/**スタッフIDパーツ１*/
	private String staffIdFirst;
	/**スタッフIDパーツ2*/
	private Integer staffIdSecond;
	/**スタッフIDパーツ3*/
	private Integer staffIdThird;
	/**スタッフID*/
	private String staffId = staffIdFirst + "-" + staffIdSecond + "-" + staffIdThird;
	
}
