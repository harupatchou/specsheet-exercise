package com.example.management.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name="users")

public class Users {

	/**スタッフID */
	@Id
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
	private Integer authorityId;
	/**パスワード */
	private String password;	
}
