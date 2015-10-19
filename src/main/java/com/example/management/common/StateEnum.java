package com.example.management.common;

/**
 * 状態を表す列挙型.
 * @author ueno
 *
 */
public enum StateEnum {
		// 定数一覧、DayOfWeekのコンストラクタを使用
		WAITING(0, "待機"),
	    SITE(1,"現場"),
	    RETIREMENT(2,"退職")
	    ;

		// 定数に含めるフィールド、コンストラクタ、メソッドを定義
		/** key値 */
		private final int key;
		/** value値 */
	    private final String value;
	    
	    /**
	     * コンストラクタ。
	     */
	    private StateEnum(final int key, final String value) {
	        this.key = key;
	        this.value = value;
	    }

	    /**
	     * 定数に含まれるvalue値を返します。
	     * @return value値
	     */
	    public String getValue() {
	        return value;
	    }

	    /**
	     * 定数に含まれるkey値を返します。
	     * @return key値
	     */
	    public int getKey() {
	        return key;
	    }
	    
	    /**
	     * keyからenumを取得
	     * @param key key
	     * @return 渡されたkeyを含むenum
	     */
	    public static StateEnum of(int key){
			for (StateEnum dayOfWeek : StateEnum.values()) {
				if (dayOfWeek.key == key) {
					return dayOfWeek;
				}
			}
			throw new IndexOutOfBoundsException("The value of enum doesn't exist.");
	    }

	
}
