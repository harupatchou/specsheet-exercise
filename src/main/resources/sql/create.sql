-- Project Name : ER図_2
-- Date/Time    : 2015/10/19 11:02:59
-- Author       : rksuser
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- スペックテーブル
drop table if exists spec cascade;

create table spec (
  staff_id character varying(16) not null
  , age_id integer not null
  , state_flag integer
  , all_exp integer
  , related_tech character varying(1024)
  , appeal character varying(1024)
  , nearest_station character varying(16)
  , comment character varying(1024)
  , update_date timestamp
  , update_name character varying(16)
) ;

create unique index spec_PKI
  on spec(staff_id);

alter table spec
  add constraint spec_PKC primary key (staff_id);

-- 言語経験テーブル
drop table if exists language_exp cascade;

create table language_exp (
  staff_id character varying(16) not null
  , no serial
  , language_id integer not null
  , other character varying(16)
  , exp_flag integer
  , month_of_exp integer
) ;

create unique index language_exp_PKI
  on language_exp(staff_id,no);

alter table language_exp
  add constraint language_exp_PKC primary key (staff_id,no);

-- 年代定義テーブル
drop table if exists age cascade;

create table age (
  id integer
  , age_range character varying(8)
) ;

create unique index age_PKI
  on age(id);

alter table age
  add constraint age_PKC primary key (id);

-- 経験内訳定義テーブル
drop table if exists exp_breakdown_define cascade;

create table exp_breakdown_define (
  id serial
  , name character varying(16)
) ;

alter table exp_breakdown_define add constraint exp_breakdown_define_IX1
  unique (name) ;

create unique index exp_breakdown_define_PKI
  on exp_breakdown_define(id);

alter table exp_breakdown_define
  add constraint exp_breakdown_define_PKC primary key (id);

-- プロジェクトテーブル
drop table if exists project cascade;

create table project (
  staff_id character varying(16) not null
  , no integer not null
  , start_date date
  , finish_date date
  , overview character varying(64)
  , team_num character varying(16)
  , all_num character varying(16)
  , role character varying(128)
  , content character varying(1024)
  , other character varying(256)
) ;

create unique index project_PKI
  on project(staff_id,no);

alter table project
  add constraint project_PKC primary key (staff_id,no);

-- 経験内訳テーブル
drop table if exists exp_breakdown cascade;

create table exp_breakdown (
  staff_id character varying(16) not null
  , exp_breakdown_id integer not null
  , month_of_exp integer
) ;

create unique index exp_breakdown_PKI
  on exp_breakdown(staff_id,exp_breakdown_id);

alter table exp_breakdown
  add constraint exp_breakdown_PKC primary key (staff_id,exp_breakdown_id);

-- OS経験テーブル
drop table if exists os_exp cascade;

create table os_exp (
  staff_id character varying not null
  , no serial
  , os_id integer not null
  , other character varying(32)
  , month_of_exp integer
) ;

create unique index os_exp_PKI
  on os_exp(staff_id,no);

alter table os_exp
  add constraint os_exp_PKC primary key (staff_id,no);

-- OS定義テーブル
drop table if exists os_define cascade;

create table os_define (
  os_id serial
  , os_name character varying(32)
) ;

alter table os_define add constraint os_define_IX1
  unique (os_name) ;

create unique index os_define_PKI
  on os_define(os_id);

alter table os_define
  add constraint os_define_PKC primary key (os_id);

-- プロジェクトOSテーブル
drop table if exists project_os cascade;

create table project_os (
  staff_id character varying(16) not null
  , project_no integer not null
  , os_exp_no integer not null
) ;

create unique index project_os_PKI
  on project_os(staff_id,project_no,os_exp_no);

alter table project_os
  add constraint project_os_PKC primary key (staff_id,project_no,os_exp_no);

-- プロジェクト言語テーブル
drop table if exists project_language cascade;

create table project_language (
  staff_id character varying(16) not null
  , project_no integer not null
  , language_exp_no integer not null
) ;

create unique index project_language_PKI
  on project_language(staff_id,project_no,language_exp_no);

alter table project_language
  add constraint project_language_PKC primary key (staff_id,project_no,language_exp_no);

-- ユーザーテーブル
drop table if exists users cascade;

create table users (
  staff_id character varying(16) not null
  , sex character varying(8)
  , first_name character varying(16)
  , last_name character varying(16)
  , first_phonetic character varying(16)
  , last_phonetic character varying(16)
  , authority_id integer not null
  , password character varying(16)
) ;

create unique index users_PKI
  on users(staff_id);

alter table users
  add constraint users_PKC primary key (staff_id);

-- 権限定義テーブル
drop table if exists authority cascade;

create table authority (
  id integer
  , name character varying(8)
) ;

create unique index authority_PKI
  on authority(id);

alter table authority
  add constraint authority_PKC primary key (id);

-- 言語定義テーブル
drop table if exists language_define cascade;

create table language_define (
  id serial
  , name character varying(16)
) ;

alter table language_define add constraint language_define_IX1
  unique (name) ;

create unique index language_define_PKI
  on language_define(id);

alter table language_define
  add constraint language_define_PKC primary key (id);

-- プロジェクト担当工程テーブル
drop table if exists project_process cascade;

create table project_process (
  staff_id character varying(16) not null
  , project_no integer not null
  , process_id integer not null
) ;

create unique index project_process_PKI
  on project_process(staff_id,project_no,process_id);

alter table project_process
  add constraint project_process_PKC primary key (staff_id,project_no,process_id);

-- 担当工程定義テーブル
drop table if exists process_define cascade;

create table process_define (
  id integer
  , name character varying(16)
) ;

create unique index process_define_PKI
  on process_define(id);

alter table process_define
  add constraint process_define_PKC primary key (id);

-- 取得資格テーブル
drop table if exists users_license cascade;

create table users_license (
  staff_id character varying not null
  , users_licence_no serial
  , name character varying(32)
  , acquire_date date
) ;

create unique index users_license_PKI
  on users_license(staff_id,users_licence_no);

alter table users_license
  add constraint users_license_PKC primary key (staff_id,users_licence_no);

comment on table spec is 'スペックテーブル	 スペックシート上部部分の情報を保持するテーブル';
comment on column spec.staff_id is 'スタッフID';
comment on column spec.age_id is '年代ID';
comment on column spec.state_flag is '状態フラグ';
comment on column spec.all_exp is 'IT全体経験';
comment on column spec.related_tech is '開発関連技術';
comment on column spec.appeal is 'アピールポイント';
comment on column spec.nearest_station is '最寄駅';
comment on column spec.comment is '変更コメント';
comment on column spec.update_date is '更新日時';
comment on column spec.update_name is '更新者名';

comment on table language_exp is '言語経験テーブル	 ユーザが今まで経験した言語(Java等)を保持する';
comment on column language_exp.staff_id is 'スタッフID';
comment on column language_exp.no is '言語経験No';
comment on column language_exp.language_id is '言語ID';
comment on column language_exp.other is 'その他記入カラム';
comment on column language_exp.exp_flag is '実務経験フラグ';
comment on column language_exp.month_of_exp is '経験月数';

comment on table age is '年代定義テーブル	 年代(20代前半など)を定義するテーブル';
comment on column age.id is '年代ID';
comment on column age.age_range is '年代';

comment on table exp_breakdown_define is '経験内訳定義テーブル	 スペックシートの内訳(サーバ・NW経験等)を定義する';
comment on column exp_breakdown_define.id is '経験内訳ID';
comment on column exp_breakdown_define.name is '経験内訳名';

comment on table project is 'プロジェクトテーブル	 スペックシートの開発経験の情報を保持する';
comment on column project.staff_id is 'スタッフID';
comment on column project.no is 'プロジェクトNo';
comment on column project.start_date is '開始期間';
comment on column project.finish_date is '終了期間';
comment on column project.overview is 'プロジェクト概要';
comment on column project.team_num is 'チーム人数';
comment on column project.all_num is '全体人数';
comment on column project.role is '担当役割';
comment on column project.content is '作業内容';
comment on column project.other is 'その他技術';

comment on table exp_breakdown is '経験内訳テーブル	 ユーザの経験内訳情報(サーバ・NW経験等)を保持する';
comment on column exp_breakdown.staff_id is 'スタッフID';
comment on column exp_breakdown.exp_breakdown_id is '経験内訳ID';
comment on column exp_breakdown.month_of_exp is '経験月数';

comment on table os_exp is 'OS経験テーブル	 ユーザが今まで経験したOSを保持する。';
comment on column os_exp.staff_id is 'スタッフID';
comment on column os_exp.no is 'OS経験No';
comment on column os_exp.os_id is 'OSID';
comment on column os_exp.other is 'その他記入カラム';
comment on column os_exp.month_of_exp is '経験月数';

comment on table os_define is 'OS定義テーブル	 OSを定義する。';
comment on column os_define.os_id is 'OSID';
comment on column os_define.os_name is 'OS名';

comment on table project_os is 'プロジェクトOSテーブル	 プロジェクトで使用したOSを保持する';
comment on column project_os.staff_id is 'スタッフID';
comment on column project_os.project_no is 'プロジェクトNo';
comment on column project_os.os_exp_no is 'OS経験No';

comment on table project_language is 'プロジェクト言語テーブル	 対象プロジェクトにて使用した言語(Java等)を保持する';
comment on column project_language.staff_id is 'スタッフID';
comment on column project_language.project_no is 'プロジェクトNo';
comment on column project_language.language_exp_no is '言語経験No';

comment on table users is 'ユーザーテーブル	 ログインユーザの情報を保持する';
comment on column users.staff_id is 'スタッフID';
comment on column users.sex is '性別';
comment on column users.first_name is '姓';
comment on column users.last_name is '名';
comment on column users.first_phonetic is '姓(ﾌﾘｶﾞﾅ)';
comment on column users.last_phonetic is '名(ﾌﾘｶﾞﾅ)';
comment on column users.authority_id is '権限ID';
comment on column users.password is 'パスワード';

comment on table authority is '権限定義テーブル	 ログインユーザの権限を定義するテーブル';
comment on column authority.id is '権限ID';
comment on column authority.name is '権限名';

comment on table language_define is '言語定義テーブル	 言語(Java等)を定義する';
comment on column language_define.id is '言語ID';
comment on column language_define.name is '言語名';

comment on table project_process is 'プロジェクト担当工程テーブル	 対象プロジェクトにて担当した工程(要件定義)等を保持する';
comment on column project_process.staff_id is 'スタッフID';
comment on column project_process.project_no is 'プロジェクトNo';
comment on column project_process.process_id is '担当工程ID';

comment on table process_define is '担当工程定義テーブル	 工程(要件定義)等を定義する';
comment on column process_define.id is '担当工程ID';
comment on column process_define.name is '担当工程名';

comment on table users_license is '取得資格テーブル	 ユーザの取得資格を保持する';
comment on column users_license.staff_id is 'スタッフID';
comment on column users_license.users_licence_no is '取得資格No';
comment on column users_license.name is '資格名';
comment on column users_license.acquire_date is '習得年月日';
