package com.example.management.page;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecRegistConfirmPage {
	/**	プロジェクト開始日 */
	private ArrayList<String> startDay;
	/**	プロジェクト終了日 */
	private ArrayList<String> finishDay;
	/**	プロジェクトナンバー */
	private ArrayList<String> projectNo;
	/**	プロジェクト概要 */
	private ArrayList<String> overview;
	/**	プロジェクトOS */
	private ArrayList<String> os;
	/**	プロジェクト言語 */
	private ArrayList<String> lang;
	/**	プロジェクト開発関連技術 */
	private ArrayList<String> other;
	/**	プロジェクト役割 */
	private ArrayList<String> role;
	/**	プロジェクト担当工程 */
	private ArrayList<String> process;
	/**	作業内容 */
	private ArrayList<String> content;
	/**	チーム人数 */
	private ArrayList<String> teamNum;
	/**	プロジェクト全体人数 */
	private ArrayList<String> allNum;

}
