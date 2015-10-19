package com.example.management.keyId;

import java.io.Serializable;

import lombok.Data;

/**
 * {@link UsersLicense}の主キークラス
 * @author takumi.sato
 *
 */
@Data
public class UsersLicenseKeyId implements Serializable{
	/** スタッフID */
	private String staffId;
	/** 取得資格No */
	private Integer usersLicenceNo;
}
