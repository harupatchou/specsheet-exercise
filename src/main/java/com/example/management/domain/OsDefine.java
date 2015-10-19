package com.example.management.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OS定義.
 * @author okamoto
 *
 */
@Data
@Entity
@Table(name="os_define")
@NoArgsConstructor
@AllArgsConstructor
public class OsDefine {
	/** OSID */
	@Id
	private Integer osId;
	/** OS名 */
	private String osName;
}
