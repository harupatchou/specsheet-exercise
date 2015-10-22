package com.example.management.page;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecDetailLicensePage {
	/**スタッフID */
	private String staffId;
	/**取得資格No */
	private Integer usersLicenceNo;//←スペル正しくはLicense、テーブルが間違い
	/**資格名 */
	private String name;
	/**習得年月日 */
	private Date acquireDate;
}
