package com.example.management.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 言語定義.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="language_define")
public class LanguageDefine {
	/**言語ID */
	@Id
	private Integer id;
	/**言語名 */
	private String name;
}
