package com.example.management.domain;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 取得資格
 * @author takumi.sato
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersLicense {
	/** スタッフID */
	private String staffId;
	/** 取得資格No */
	private Integer usersLicenceNo;
	/** 資格名 */
	private String name;
	/** 所得年月日*/
	private Date acquireDate;
}
