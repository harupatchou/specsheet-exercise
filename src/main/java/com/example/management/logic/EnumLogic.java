package com.example.management.logic;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface EnumLogic {
	/** 状態フラグマップを取得. */
	public Map<Integer, String> getStateMap();

	/** 年代マップを取得.*/
	public Map<Integer, String> getAgeMap();

}
