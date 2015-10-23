package com.example.management.logic;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.management.page.SpecDetailDevelopmentExperiencePage;
import com.example.management.page.SpecSearchResultPage;

@Component
public interface ArrayListLogic {
	/** スペックシート検索結果のArrayListから重複する要素を削除して返す */
	public ArrayList<SpecSearchResultPage> hSearchResultUnique(ArrayList<SpecSearchResultPage> arg0);
	
	/** スペックシート検索結果のArrayListからnullの要素を削除して返す */
	public ArrayList<SpecSearchResultPage> hSearchResultCompact(ArrayList<SpecSearchResultPage> arg0);
	
	/** 整数のArrayListから重複する要素を削除して返す */
	public ArrayList<Integer> hIntUnique(ArrayList<Integer> arg0);
	
	/** 整数のArrayListからnullの要素を削除して返す */
	public ArrayList<Integer> hIntCompact(ArrayList<Integer> arg0);
	
	/** 文字列のArrayListから重複する要素を削除して返す */
	public ArrayList<String> hStrUnique(ArrayList<String> arg0);
	
	/** 文字列のArrayListからnullの要素を削除して返す */
	public ArrayList<String> hStrCompact(ArrayList<String> arg0);
	
	/** 開発経験検索結果のArrayListから重複する要素を削除して返す */
	public ArrayList<SpecDetailDevelopmentExperiencePage> hSpecDetailDevelopmentExperiencePageUnique(ArrayList<SpecDetailDevelopmentExperiencePage> arg0);
	
}
