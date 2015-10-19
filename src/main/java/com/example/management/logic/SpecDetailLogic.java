package com.example.management.logic;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.management.common.SkillPage;

@Service
public class SpecDetailLogic extends SkillPage{
	
	/**
	 * 言語経験、開発関連技術、OS経験、経験工程のうち一番数が多いものの数を返す。
	 * @param languageNameList　言語経験リスト
	 * @param relatedTechList　開発関連技術リスト
	 * @param osNameList　OS経験リスト
	 * @param processNameList　経験工程リスト
	 * @return　一番数が多い要素数
	 */
	public static int maxSize(ArrayList<String> languageNameList, ArrayList<String> relatedTechList, 
			ArrayList<String> osNameList, ArrayList<String> processNameList) {
		int maxSize = 0;
		if ((languageNameList.size() >= relatedTechList.size()) && (languageNameList.size() >= osNameList.size()) && (languageNameList.size() >= processNameList.size())) {
			if(languageNameList.size() % 2 != 0) {
				return languageNameList.size() + 1;
			} else {
				return languageNameList.size();
			}
		}
		if ((osNameList.size() >= languageNameList.size()) && (osNameList.size() >= relatedTechList.size()) && (osNameList.size() >= processNameList.size())) {
			if(osNameList.size() % 2 != 0) {
				return osNameList.size() + 1;
			} else {
				return osNameList.size();
			}
		}
		if ((relatedTechList.size() >= languageNameList.size()) && (relatedTechList.size() >= osNameList.size()) && (relatedTechList.size() >= processNameList.size())) {
			if(relatedTechList.size() % 2 != 0) {
				return relatedTechList.size() + 1;
			} else {
				return relatedTechList.size();
			}
		}
		if ((processNameList.size() >= languageNameList.size()) && (processNameList.size() >= osNameList.size()) && (processNameList.size() >= relatedTechList.size())) {
			if(processNameList.size() % 2 != 0) {
				return processNameList.size() + 1;
			} else {
				return processNameList.size();
			}
		}
		return maxSize;
	}
	
	public static int RawMaxSize(ArrayList<String> languageNameList, ArrayList<String> relatedTechList, 
			ArrayList<String> osNameList, ArrayList<String> processNameList) {
		int maxSize = 0;
		if ((languageNameList.size() >= relatedTechList.size()) && (languageNameList.size() >= osNameList.size()) && (languageNameList.size() >= processNameList.size())) {
			return languageNameList.size();
		}
		if ((osNameList.size() >= languageNameList.size()) && (osNameList.size() >= relatedTechList.size()) && (osNameList.size() >= processNameList.size())) {
			return osNameList.size();
		}
		if ((relatedTechList.size() >= languageNameList.size()) && (relatedTechList.size() >= osNameList.size()) && (relatedTechList.size() >= processNameList.size())) {
			return relatedTechList.size();
		}
		if ((processNameList.size() >= languageNameList.size()) && (processNameList.size() >= osNameList.size()) && (processNameList.size() >= relatedTechList.size())) {
			return processNameList.size();
		}
		return maxSize;
	}
	
	/**
	 * 言語経験、開発関連技術、OS経験、経験工程を各2つづつ繰り返しながら挿入した配列を返す
	 * @param languageNameList　言語経験リスト
	 * @param relatedTechList　開発関連技術リスト
	 * @param osNameList　OS経験リスト
	 * @param processNameList　経験工程リスト
	 * @return　全リストを入れた配列
	 */
	public ArrayList<String> allContents(ArrayList<String> languageNameList, ArrayList<String> relatedTechList, 
			ArrayList<String> osNameList, ArrayList<String> processNameList) {
		ArrayList<String> allContents = new ArrayList<>();
		
		if (languageNameList.size() % 2 != 0) {
			this.languageNameList.add("");
		}
		if (relatedTechList.size() % 2 != 0) {
			this.relatedTechList.add("");
		}
		if (osNameList.size() % 2 != 0) {
			this.osNameList.add("");
		}
		if (processNameList.size() % 2 != 0) {
			this.processNameList.add("");
		}
		
		for (int i = 0, lc = 0, rc = 0, oc = 0, pc = 0; i < maxSize(languageNameList, relatedTechList, osNameList, processNameList) * 4; ++i) {
			if(i % COL_SIZE == 0 || i % COL_SIZE == 1) {
				if (lc >= languageNameList.size()) {
					this.languageNameList.add("");
					allContents.add("");
				} else {
					allContents.add(languageNameList.get(lc));
				}
				++lc;
			} else if(i % COL_SIZE == 2 || i % COL_SIZE == 3) {
				if (rc >= relatedTechList.size()) {
					this.relatedTechList.add("");
					allContents.add("");
				} else {
					allContents.add(relatedTechList.get(rc));
				}
				++rc;
			} else if(i % COL_SIZE == 4 || i % COL_SIZE == 5) {
				if (oc >= osNameList.size()) {
					this.osNameList.add("");
					allContents.add("");
				} else {
					allContents.add(osNameList.get(oc));
				}
				++oc;
			} else {
				if (pc >= processNameList.size()) {
					this.processNameList.add("");
					allContents.add("");
				} else {
					allContents.add(processNameList.get(pc));
				}
				++pc;
			}
		}
		return allContents;
	}

}
