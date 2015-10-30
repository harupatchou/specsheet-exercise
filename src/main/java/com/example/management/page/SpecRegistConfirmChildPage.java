package com.example.management.page;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * スペックシート登録確認画面用.
 * @author ueno
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecRegistConfirmChildPage {
	/**経験言語*/
	private List<String> langList;
	/**経験OS*/
	private List<String> osList;
	/**開発関連技術*/
	private List<String> relatedTech;
	/**工程*/
	private List<String> processList;
}
