package com.example.management.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * スペックシートの資格登録するためのクラス.
 * @author okamoto
 */
//いらないかも？？
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecRegistLicenseForm {
	/**スタッフID */
	private String staffId;
	/**資格名 */
	private String lisenceName;
	/**取得日 */
	private Date acquireDate;
}
