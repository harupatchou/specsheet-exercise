package com.example.management.form;

import lombok.Data;

/**
 * 駅間時間検索用
 * @author okamoto
 *
 */
@Data
public class StationTimeForm {
	/*スタッフID*/
	private String staffId;
	/**最寄駅*/
	private String nearStation;
	/**到着駅*/
	private String arrivalStation;
	/**参考サイトURL*/
	private String url;
}
