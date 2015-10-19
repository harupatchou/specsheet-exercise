package com.example.management.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecForm {
	//基本情報
	/**スタッフID*/
	private String staffId;
	/**氏名*/
	private String firstName;
	/**氏名*/
	private String lastName;
	/**現場/待機フラグ*/
	private Integer stateFlag;
	/**編集時コメント*/
	private String comment;
	/**最寄駅*/
	private String nearestStation;
	/**アピールポイント*/
	private String appeal;
	
	//経験年数要素
		/**IT全体経験年*/
		private Integer allExpYear;
		/**IT全体経験月*/
		private Integer allExpMonth;
		/**サーバ・NW経験年*/
		private Integer serverNetworkExpYear;
		/**サーバ・NW経験月*/
		private Integer serverNetworkExpMonth;
		/**システム開発経験年*/
		private Integer developmentExpYear;
		/**システム開発経験月*/
		private Integer developmentExpMonth;
		/**SE経験年*/
		private Integer seExpYear;
		/**SE経験月*/
		private Integer seExpMonth;
		/**PG経験年*/
		private Integer pgOperatorExpYear;
		/**PG経験月*/
		private Integer pgOperatorExpMonth;
		
	//人数
		/**チーム人数*/
		private Integer teamNum;
		
	//開発期間
		/**開始日時*/
		private String startDay;
		/**終了日時*/
		private String finishDay;
		
	//プロジェクト内容
		
		
		/**プロジェクト概要*/
		private String overView;

}
