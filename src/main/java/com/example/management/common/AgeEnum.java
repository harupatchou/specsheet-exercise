package com.example.management.common;

/**
 * 年齢を表す列挙型.
 * @author ueno
 *
 */
public enum AgeEnum {
	// 定数一覧、DayOfWeekのコンストラクタを使用
	EARLY_TWENTIES(1, "20代前半"),
	LATE_TWENTIES(2, "20代後半"),
	EARLY_THIRTIES(3, "30代前半"),
	LATE_THIRTIES(4, "30代後半"),
	EARLY_FORTIES(5,"40代前半"),
	LATE_FORTIES(6, "40代後半"),
	EARLY_FIFTIES(7, "50代前半"),
	LATE_FIFTIES(8,"50代後半")
	;
	
	// 定数に含めるフィールド、コンストラクタ、メソッドを定義
	/** key値 */
	private final int key;
	/** value値 */
	private final String value;
	
    /**
     * コンストラクタ。
     */
	private AgeEnum(final int key, final String value){
		this.key = key;
		this.value = value;
	}
	
    /**
     * 定数に含まれるvalue値を返します。
     * @return value値
     */
	public String getValue(){
		return value;
	}
	
    /**
     * 定数に含まれるkey値を返します。
     * @return key値
     */
	public int getKey(){
		return key;
	}
	
    /**
     * keyからenumを取得
     * @param key key
     * @return 渡されたkeyを含むenum
     */
	public static AgeEnum of(int key){
		for(AgeEnum dayOfWeek : AgeEnum.values()){
			if(dayOfWeek.key == key){
				return dayOfWeek;
			}
		}
		throw new IndexOutOfBoundsException("The value of enum doesn't exist.");
	}
}
