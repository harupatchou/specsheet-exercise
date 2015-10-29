	/**
	 * 行追加
	 */
	function insertRow(id) {
	    // テーブル取得
	    var table = document.getElementById(id);
	    // 行を行末に追加
	    var row = table.insertRow(-1);
	    // セルの挿入
	    var cell1 = row.insertCell(-1);
	    var cell2 = row.insertCell(-1);
	    var cell3 = row.insertCell(-1);
	    var cell4 = row.insertCell(-1);
	    var cell5 = row.insertCell(-1);
	    var cell6 = row.insertCell(-1);
	    // ボタン用 HTML
	    var button = '<tr><input type="button" value="行削除" onclick="deleteRow(this)" />';
		var lisenceName = '<td><form:input path="lisenceName" name="lisenceName" /></td>';
		var strAcquireDate = '<td><form:input path="strAcquireDate" name="strAcquireDate"  placeholder="yyyy-MM-dd" /></td></tr>';
	    // 行数取得
	    var row_len = table.rows.length;
	 
	    // セルの内容入力
	    cell1.innerHTML =　lisenceName;
	    cell2.innerHTML = strAcquireDate;
	    
	    cell3.innerHTML =　lisenceName;
	    cell4.innerHTML = strAcquireDate;
	    
	    cell5.innerHTML =　lisenceName;
	    cell6.innerHTML = strAcquireDate;
	}
	


	 
	/**
	 * 行削除
	 */
	function deleteRow2(){    // 行削除 
		 var table = document.getElementById("userLicenseTable");
		  var rowCnt = table.rows.length; // 行数
		   if(rowCnt==3){alert("これ以上削除できません。");return;}
		   table.deleteRow(-1);// 末尾行を削除
		　　　　}
	 
