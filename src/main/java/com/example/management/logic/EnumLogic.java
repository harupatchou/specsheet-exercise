package com.example.management.logic;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.management.common.AgeEnum;
import com.example.management.common.StateEnum;

public class EnumLogic {
	/**
	 * 状態フラグを取得.
	 * 
	 * @param stateKey
	 * @return
	 */
	public static Map<Integer, String> getState() {
		Map<Integer, String> stateMap = new LinkedHashMap<Integer, String>();
		stateMap.put(StateEnum.WAITING.getKey(), StateEnum.WAITING.getValue());
		stateMap.put(StateEnum.SITE.getKey(), StateEnum.SITE.getValue());
		stateMap.put(StateEnum.RETIREMENT.getKey(), StateEnum.RETIREMENT.getValue());
		return stateMap;
	}

	/**
	 * 年代を取得.
	 * 
	 * @param ageKey
	 * @return
	 */
	public static Map<Integer, String> getAge() {
		Map<Integer, String> ageMap = new LinkedHashMap<Integer, String>();
		ageMap.put(AgeEnum.EARLY_TWENTIES.getKey(), AgeEnum.EARLY_TWENTIES.getValue());
		ageMap.put(AgeEnum.LATE_TWENTIES.getKey(), AgeEnum.LATE_TWENTIES.getValue());
		ageMap.put(AgeEnum.EARLY_THIRTIES.getKey(), AgeEnum.EARLY_THIRTIES.getValue());
		ageMap.put(AgeEnum.LATE_THIRTIES.getKey(), AgeEnum.LATE_THIRTIES.getValue());
		ageMap.put(AgeEnum.EARLY_FORTIES.getKey(), AgeEnum.EARLY_FORTIES.getValue());
		ageMap.put(AgeEnum.LATE_FORTIES.getKey(), AgeEnum.LATE_FORTIES.getValue());
		ageMap.put(AgeEnum.EARLY_FIFTIES.getKey(), AgeEnum.EARLY_FIFTIES.getValue());
		ageMap.put(AgeEnum.LATE_FIFTIES.getKey(), AgeEnum.LATE_FIFTIES.getValue());
		return ageMap;
	}

}
