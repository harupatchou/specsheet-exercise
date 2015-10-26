package com.example.management.form;


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
		private String relatedTech;
		
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
		private String os1;
		private String os2;
		private String os3;
		private String os4;
		private String os5;
		/**言語*/
		private String lang1;
		private String lang2;
		private String lang3;
		private String lang4;
		private String lang5;
		/**開発関連技術*/
		private String other;
		/**担当役割*/
		private String role;
		/**担当工程*/
		private String process1;
		private String process2;
		private String process3;
		private String process4;
		private String process5;
		/**作業内容*/
		private String content;
		
		
}
