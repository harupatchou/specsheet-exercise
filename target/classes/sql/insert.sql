-- ?権限定義テーブル
INSERT INTO authority VALUES('1','ユーザー');
INSERT INTO authority VALUES('2','管理者');

-- 年代定義テーブル
INSERT INTO age VALUES('1','20代前半');
INSERT INTO age VALUES('2','20代後半');
INSERT INTO age VALUES('3','30代前半');
INSERT INTO age VALUES('4','30代後半');
INSERT INTO age VALUES('5','40代前半');
INSERT INTO age VALUES('6','40代後半');
INSERT INTO age VALUES('7','50代前半');
INSERT INTO age VALUES('8','50代後半');

-- OS定義テーブル

INSERT INTO os_define VALUES('1','Windows');
INSERT INTO os_define VALUES('2','Linux');
INSERT INTO os_define VALUES('3','Mac');
INSERT INTO os_define VALUES('4','Android');
INSERT INTO os_define VALUES('5','iOS');
INSERT INTO os_define VALUES('100','その他');


-- 言語定義テーブル
INSERT INTO language_define VALUES('1','Java');
INSERT INTO language_define VALUES('2','PHP');
INSERT INTO language_define VALUES('3','Ruby');
INSERT INTO language_define VALUES('4','Scala');
INSERT INTO language_define VALUES('5','JavaScript');
INSERT INTO language_define VALUES('6','C#');
INSERT INTO language_define VALUES('7','C++');
INSERT INTO language_define VALUES('8','C');
INSERT INTO language_define VALUES('100','その他');


-- 担当工程定義テーブル
INSERT INTO process_define VALUES('1','要件定義');
INSERT INTO process_define VALUES('2','基本設計');
INSERT INTO process_define VALUES('3','詳細設計');
INSERT INTO process_define VALUES('4','実装');
INSERT INTO process_define VALUES('5','テスト');
INSERT INTO process_define VALUES('6','運用');

-- 経験内訳定義テーブル
INSERT INTO exp_breakdown_define VALUES('1','サーバ・NW経験');
INSERT INTO exp_breakdown_define VALUES('2','システム開発経験');
INSERT INTO exp_breakdown_define VALUES('3','SE経験');
INSERT INTO exp_breakdown_define VALUES('4','PG・作業員経験');


/*ここまで定義テーブル*/

--ユーザーテーブル
INSERT INTO users VALUES('AP-202-0715','男','工藤','康平','クドウ','コウヘイ',1,'boost2000');
INSERT INTO users VALUES('AP-202-0716','男','黒澤','祐','クロサワ','ユウ',1,'boost2000');
INSERT INTO users VALUES('AP-202-0717','男','佐藤','拓海','サトウ','タクミ',1,'boost2000');
INSERT INTO users VALUES('AP-202-0736','女','鈴木','綾夏','スズキ','アヤカ',1,'boost2000');
INSERT INTO users VALUES('AP-000-0000','男','大矢','修嗣','オオヤ','ナオツギ',2,'boost2000');

-- プロジェクトテーブル
INSERT INTO project VALUES('AP-202-0715',1,'2015/05/01','2015/06/01','【社内研修】Ec-Site','4','4','テスター/PG','開発/テスト','eclipse/junit');
INSERT INTO project VALUES('AP-202-0715',2,'2015/04/01','2015/05/01','【新人研修】書籍管理システム','3','3','PG','開発','eclipse');
INSERT INTO project VALUES('AP-202-0717',1,'2015/10/01','2015/11/01','【現場】テスト','20','20','テスター','テスト','eclipse/junit');
INSERT INTO project VALUES('AP-202-0717',2,'2015/04/01','2015/09/30','【社内研修】Ec-Site','4','4','PG','開発','eclipse');
INSERT INTO project VALUES('AP-202-0736',1,'2015/02/03','2015/08/03','【現場】環境構築','10','10','PG/テスター','実装/テスト','teraterm');
INSERT INTO project VALUES('AP-202-0736',2,'2014/09/04','2015/01/04','【社内研修】食べログサイト','3','3','PM/SE','UT','remoteconect');
INSERT INTO project VALUES('AP-202-0736',3,'2013/02/05','2014/08/05','【新人研修】サーブレットにおける書籍管理システム','1','1','PG','IT','padedosa');


-- プロジェクト担当工程テーブル（工藤のデータ）
INSERT INTO project_process VALUES('AP-202-0715','1','4');
INSERT INTO project_process VALUES('AP-202-0715','1','5');
INSERT INTO project_process VALUES('AP-202-0715','2','3');
INSERT INTO project_process VALUES('AP-202-0715','2','4');
INSERT INTO project_process VALUES('AP-202-0715','2','5');
INSERT INTO project_process VALUES('AP-202-0717','1','5');
INSERT INTO project_process VALUES('AP-202-0717','2','3');
INSERT INTO project_process VALUES('AP-202-0717','2','4');
INSERT INTO project_process VALUES('AP-202-0717','2','5');
INSERT INTO project_process VALUES('AP-202-0736','1','4');
INSERT INTO project_process VALUES('AP-202-0736','1','5');
INSERT INTO project_process VALUES('AP-202-0736','2','3');
INSERT INTO project_process VALUES('AP-202-0736','2','4');
INSERT INTO project_process VALUES('AP-202-0736','2','5');
INSERT INTO project_process VALUES('AP-202-0736','3','1');
INSERT INTO project_process VALUES('AP-202-0736','3','2');


-- プロジェクト言語テーブル（工藤）
INSERT INTO project_language VALUES('AP-202-0715','1','1');
INSERT INTO project_language VALUES('AP-202-0715','1','2');
INSERT INTO project_language VALUES('AP-202-0715','2','3');
INSERT INTO project_language VALUES('AP-202-0715','2','4');
INSERT INTO project_language VALUES('AP-202-0717','1','1');
INSERT INTO project_language VALUES('AP-202-0717','1','2');
INSERT INTO project_language VALUES('AP-202-0717','2','3');
INSERT INTO project_language VALUES('AP-202-0717','2','4');
INSERT INTO project_language VALUES('AP-202-0717','2','5');
INSERT INTO project_language VALUES('AP-202-0717','2','6');
INSERT INTO project_language VALUES('AP-202-0736','1','2');
INSERT INTO project_language VALUES('AP-202-0736','1','4');
INSERT INTO project_language VALUES('AP-202-0736','2','3');
INSERT INTO project_language VALUES('AP-202-0736','2','4');
INSERT INTO project_language VALUES('AP-202-0736','2','6');
INSERT INTO project_language VALUES('AP-202-0736','3','1');

-- 取得資格テーブル（鈴木さんのデータ）
INSERT INTO users_license VALUES('AP-202-0736','1','HTML5プロフェッショナル認定資格レベル1','2014/07/06');
INSERT INTO users_license VALUES('AP-202-0736','2','基本情報試験','2013/07/06');

-- プロジェクトOSテーブル（工藤のデータ）
INSERT INTO project_os VALUES('AP-202-0715','1','1');
INSERT INTO project_os VALUES('AP-202-0715','1','2');
INSERT INTO project_os VALUES('AP-202-0715','2','2');
INSERT INTO project_os VALUES('AP-202-0715','2','3');
INSERT INTO project_os VALUES('AP-202-0715','2','4');
INSERT INTO project_os VALUES('AP-202-0717','1','1');
INSERT INTO project_os VALUES('AP-202-0717','2','1');
INSERT INTO project_os VALUES('AP-202-0717','2','3');
INSERT INTO project_os VALUES('AP-202-0717','2','4');
INSERT INTO project_os VALUES('AP-202-0736','1','1');
INSERT INTO project_os VALUES('AP-202-0736','1','2');
INSERT INTO project_os VALUES('AP-202-0736','2','2');
INSERT INTO project_os VALUES('AP-202-0736','2','3');
INSERT INTO project_os VALUES('AP-202-0736','3','4');

--OS経験テーブル
INSERT INTO os_exp VALUES('AP-202-0715',1,1,Null,4);
INSERT INTO os_exp VALUES('AP-202-0715',2,2,Null,4);
INSERT INTO os_exp VALUES('AP-202-0736',1,1,Null,29);
INSERT INTO os_exp VALUES('AP-202-0736',2,2,Null,1);
INSERT INTO os_exp VALUES('AP-202-0717',1,1,Null,9);
INSERT INTO os_exp VALUES('AP-202-0717',2,2,Null,4);

--言語経験テーブル
INSERT INTO language_exp VALUES('AP-202-0715',1,1,Null,1,4);
INSERT INTO language_exp VALUES('AP-202-0715',2,2,Null,1,4);
INSERT INTO language_exp VALUES('AP-202-0736',1,1,Null,1,29);
INSERT INTO language_exp VALUES('AP-202-0736',2,5,Null,1,15);
INSERT INTO language_exp VALUES('AP-202-0717',1,1,Null,0,9);
INSERT INTO language_exp VALUES('AP-202-0717',2,2,Null,1,10);
INSERT INTO language_exp VALUES('AP-202-0717',3,5,Null,0,25);

--経験内訳テーブル
INSERT INTO exp_breakdown VALUES('AP-202-0715',2,4);
INSERT INTO exp_breakdown VALUES('AP-202-0715',4,4);
INSERT INTO exp_breakdown VALUES('AP-202-0736',3,14);
INSERT INTO exp_breakdown VALUES('AP-202-0736',4,15);
INSERT INTO exp_breakdown VALUES('AP-202-0717',4,2);



-- スペックテーブル
INSERT INTO spec VALUES('AP-202-0715',1,0,2,'Spring','アピールポイント1','渋谷','誤字修正',1, 2,'2015/09/01','更新者名16文字');
INSERT INTO spec VALUES('AP-202-0736',1,0,2,'Ajax','アピールポイント2','新宿','経歴追加',0, 2,'2015/09/01','更新者名16文字');
INSERT INTO spec VALUES('AP-202-0717',1,0,2,'JavaScript','アピールポイント3','池袋','初版作成',0, 4,'2015/09/01','更新者名16文字');
INSERT INTO spec VALUES('AP-000-0000',1,0,44,'Spring','アピールポイントMaster','渋谷','誤字修正',3, 6,'2015/09/01','更新者名16文字');



