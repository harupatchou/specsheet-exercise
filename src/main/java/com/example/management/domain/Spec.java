package com.example.management.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * スペック.
 * @author okamoto
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="spec")
public class Spec {
	/**スタッフID */
	@Id
	private String staffId;
	/**名前 */
	private String name;
	/**年代ID */
	private Integer ageId;
	/**性別 */
	private Integer sex;
	/**状態フラグ */
	private Integer stateFlag;
	/**IT全体経験 */
	private Integer allExp;
	/**開発関連技術 */
	private String relatedTech;
	/**アピールポイント */
	private String appeal;
	/**最寄駅 */
	private String nearestStation;
	/**サーバ・NW経験 */
	private Integer serverNetworkExp;
	/**システム開発経験 */
	private Integer developmentExp;
	/**SE経験 */
	private Integer seExp;
	/**PG・作業員経験 */
	private Integer pgOperatorExp;
	/**変更コメント */
	private String comment;
	/**更新日時 */
	private Date updateDate;
	/**更新者名 */
	private String updateName;
}
