package com.example.management.keyId;

import java.io.Serializable;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OsExpKeyId implements Serializable{
	/** スタッフID */
	private String staffId;
	/** OS経験No */
	private Integer no;
}
