package com.example.management.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 担当工程定義.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="process_define")
public class ProcessDefine {
	/**担当工程ID */
	@Id
	private Integer id;
	/**担当工程名 */
	private String name;
	
}
