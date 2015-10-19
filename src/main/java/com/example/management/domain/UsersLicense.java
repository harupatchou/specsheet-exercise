package com.example.management.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.management.keyId.UsersLicenseKeyId;

import lombok.Data;

/**
 * 取得資格
 * @author takumi.sato
 *
 */
@Data
@IdClass(value=UsersLicenseKeyId.class)
@Entity
@Table(name="usersLicense")
public class UsersLicense {
	/** スタッフID */
	@Id
	private String staffId;
	/** 取得資格No */
	@Id
	private Integer usersLicenceNo;
	/** 資格名 */
	private String name;
	/** 所得年月日*/
	private Date acquireDate;
}
