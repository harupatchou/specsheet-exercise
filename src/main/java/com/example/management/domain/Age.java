package com.example.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 年代.
 * @author okamoto
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Age {
	/** 年代ID*/
	private String id;
	/** 年代*/
	private String age;
	
}
