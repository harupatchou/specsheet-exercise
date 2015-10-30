package com.example.management.common;

/**
 * 性別を表す列挙型.
 * @author okamoto
 *
 */
public enum SexEnum {
	// 定数一覧、DayOfWeekのコンストラクタを使用
	MAN("男", "男"),
    WOMAN("女","女"),
    ;

	// 定数に含めるフィールド、コンストラクタ、メソッドを定義
	/** key値 */
	private final String key;
	/** value値 */
    private final String value;
    
    /**
     * コンストラクタ。
     */
    private SexEnum(final String key, final String value) {
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
    public String getKey() {
        return key;
    }
    
    /**
     * keyからenumを取得
     * @param key key
     * @return 渡されたkeyを含むenum
     */
    public static SexEnum of(String key){
		for (SexEnum dayOfWeek : SexEnum.values()) {
			if (dayOfWeek.key == key) {
				return dayOfWeek;
			}
		}
		throw new IndexOutOfBoundsException("The value of enum doesn't exist.");
    }

}
