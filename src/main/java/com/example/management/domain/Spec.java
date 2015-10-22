package com.example.management.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

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
	/**年代ID */
	private Integer ageId;
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
	/**変更コメント */
	private String comment;
	/**更新日時 */
	private Date updateDate;
	/**更新者名 */
	private String updateName;
	
	/**IT全体経験の年数 */
	private Integer year;
	/**IT全体経験の月数 */
	private Integer month;
}
