package com.example.management.keyId;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectクラスの主キークラス
 * @author rksuser
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectKeyId implements Serializable{
	private String staffId;
	private Integer no;
}
