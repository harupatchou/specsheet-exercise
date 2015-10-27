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
	/**年齢フラグ*/
	private Integer ageFlag;
	/**最寄駅*/
	private String nearestStation;
	/**アピールポイント*/
	private String appeal;
	
	//経験年数要素
		/**IT全体経験(月数換算)*/
		private Integer allExp;
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
		
	//スキル要約
		/**経験言語*/
		private String skillLangList;
		/**実務経験フラグ*/
		private Integer expFlagInt;
		/**言語経験月数*/
		private Integer monthOfLangExp; 
		/**経験OS*/
		private String skillOsList;
		/**OS経験月数*/
		private Integer monthOfOsExp;
		/**開発関連技術*/
		private String relatedTech;
		/**更新日時 */
		private Date updateDate;
		/**更新者名 */
		private String updateName;
		
	/** 開発経験テーブル */
	//人数
		/**チーム人数*/
		private String teamNum;
		/**全体人数*/
		private String allNum;
		
	//開発期間
		/**開始日時*/
		private String startDay;
		/**終了日時*/
		private String finishDay;
		
	//プロジェクト詳細		
		/**ポロジェクト番号*/
		private String projectNo;
		/**プロジェクト概要*/
		private String overview;
		/**OS*/
		private String os;
		/**言語*/
		private String lang;
		/**開発関連技術*/
		private String other;
		/**担当役割*/
		private String role;
		/**担当工程*/
		private String process;
		/**作業内容*/
		private String content;
		/**最後のテーブル判別*/
		private String lastHidden;
		
}
