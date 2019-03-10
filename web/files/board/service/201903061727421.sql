﻿CREATE TABLE "TB_BD_INFO" (
	"INFO_NO"	NUMBER		NOT NULL,
	"INFO_TITLE"	VARCHAR2(100)		NULL,
	"INFO_CONTENTS"	VARCHAR2(3000)		NULL,
	"INFO_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"INFO_UP"	NUMBER	DEFAULT 0	NULL,
	"INFO_HITS"	NUMBER	DEFAULT 0	NULL,
	"INFO_FILE1"	VARCHAR2(1000)		NULL,
	"INFO_FILE2"	VARCHAR2(1000)		NULL,
	"INFO_FILE3"	VARCHAR2(1000)		NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"Field"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "TB_BD_INFO"."INFO_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_TITLE" IS '제목';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_UP" IS '추천수';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_HITS" IS '조회수';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_FILE1" IS '파일경로1';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_FILE2" IS '파일경로2';

COMMENT ON COLUMN "TB_BD_INFO"."INFO_FILE3" IS '파일경로3';

COMMENT ON COLUMN "TB_BD_INFO"."USER_ID" IS '작성자';

CREATE TABLE "TB_USER" (
	"USER_ID"	VARCHAR2(20)		NOT NULL,
	"USER_NM"	VARCHAR2(20)		NOT NULL,
	"USER_PWD"	VARCHAR2(20)		NOT NULL,
	"NICKNAME"	VARCHAR2(30)		NULL,
	"BIRTH"	DATE		NULL,
	"GENDER"	CHAR(1)		NULL,
	"ADDRESS"	VARCHAR2(300)		NULL,
	"EMAIL"	VARCHAR2(30)		NULL,
	"PURPOSE"	VARCHAR2(50)		NULL,
	"AGREE_YN"	CHAR(1)	DEFAULT Y	NULL,
	"PROFILE"	VARCHAR2(1000)		NULL,
	"WEIGHT"	NUMBER	DEFAULT 0	NULL,
	"CAUTION_COUNT"	NUMBER		NULL,
	"DROP_YN"	CHAR(1)	DEFAULT N	NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"PARTNER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_USER"."USER_ID" IS '아이디';

COMMENT ON COLUMN "TB_USER"."USER_NM" IS '이름';

COMMENT ON COLUMN "TB_USER"."USER_PWD" IS '비밀번호';

COMMENT ON COLUMN "TB_USER"."NICKNAME" IS '닉네임';

COMMENT ON COLUMN "TB_USER"."BIRTH" IS '생년월일';

COMMENT ON COLUMN "TB_USER"."GENDER" IS '성별';

COMMENT ON COLUMN "TB_USER"."ADDRESS" IS '주소';

COMMENT ON COLUMN "TB_USER"."EMAIL" IS '이메일';

COMMENT ON COLUMN "TB_USER"."PURPOSE" IS '운동목적';

COMMENT ON COLUMN "TB_USER"."AGREE_YN" IS '파트너 매칭 동의여부';

COMMENT ON COLUMN "TB_USER"."PROFILE" IS '자기소개';

COMMENT ON COLUMN "TB_USER"."WEIGHT" IS '몸무게';

COMMENT ON COLUMN "TB_USER"."CAUTION_COUNT" IS '경고횟수';

COMMENT ON COLUMN "TB_USER"."DROP_YN" IS '탈퇴유무';

COMMENT ON COLUMN "TB_USER"."ENROLL_DATE" IS '가입날짜';

COMMENT ON COLUMN "TB_USER"."PARTNER_ID" IS '파트너아이디';

CREATE TABLE "TB_EXERCISE" (
	"EXER_NO"	NUMBER		NOT NULL,
	"EXER_NM"	VARCHAR2(30)		NULL,
	"MET"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_EXERCISE"."EXER_NO" IS '운동번호';

COMMENT ON COLUMN "TB_EXERCISE"."EXER_NM" IS '운동이름';

COMMENT ON COLUMN "TB_EXERCISE"."MET" IS 'MET';

CREATE TABLE "TB_FOOD" (
	"FOOD_NO"	NUMBER		NOT NULL,
	"FOOD_NAME"	VARCHAR2(30)		NULL,
	"ONCE_IN"	NUMBER		NULL,
	"CALORIE"	NUMBER		NULL,
	"CARB"	NUMBER		NULL,
	"PROTEIN"	NUMBER		NULL,
	"FAT"	NUMBER		NULL,
	"SUGAR"	NUMBER		NULL,
	"NA"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_FOOD"."FOOD_NO" IS '음식번호';

COMMENT ON COLUMN "TB_FOOD"."FOOD_NAME" IS '음식명';

COMMENT ON COLUMN "TB_FOOD"."ONCE_IN" IS '1회제공량(g)';

COMMENT ON COLUMN "TB_FOOD"."CALORIE" IS '열량(kcal)';

COMMENT ON COLUMN "TB_FOOD"."CARB" IS '탄수화물(g)';

COMMENT ON COLUMN "TB_FOOD"."PROTEIN" IS '단백질(g)';

COMMENT ON COLUMN "TB_FOOD"."FAT" IS '지방(g)';

COMMENT ON COLUMN "TB_FOOD"."SUGAR" IS '당류(g)';

COMMENT ON COLUMN "TB_FOOD"."NA" IS '나트륨(mg)';

CREATE TABLE "TB_SCHEDULER" (
	"SCHE_DATE"	DATE		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NOT NULL,
	"EXER_GOAL"	NUMBER		NULL,
	"FOOD_GOAL"	NUMBER		NULL,
	"ATTEND_YN"	CHAR(1)	DEFAULT N	NULL
);

COMMENT ON COLUMN "TB_SCHEDULER"."SCHE_DATE" IS '날짜';

COMMENT ON COLUMN "TB_SCHEDULER"."USER_ID" IS '아이디';

COMMENT ON COLUMN "TB_SCHEDULER"."EXER_GOAL" IS '운동칼로리목표(kcal)';

COMMENT ON COLUMN "TB_SCHEDULER"."FOOD_GOAL" IS '음식칼로리목표(kcal)';

COMMENT ON COLUMN "TB_SCHEDULER"."ATTEND_YN" IS '출석여부';

CREATE TABLE "TB_FAQ" (
	"FAQ_NO"	NUMBER		NOT NULL,
	"FAQ_TITLE"	VARCHAR2(100)		NULL,
	"FAQ_CONENTS"	VARCHAR2(3000)		NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"Field"	VARCHAR(255)		NULL
);

COMMENT ON COLUMN "TB_FAQ"."FAQ_NO" IS '질문번호';

COMMENT ON COLUMN "TB_FAQ"."FAQ_TITLE" IS '제목';

COMMENT ON COLUMN "TB_FAQ"."FAQ_CONENTS" IS '내용';

COMMENT ON COLUMN "TB_FAQ"."USER_ID" IS '작성자';

CREATE TABLE "TB_PLACE" (
	"PLACE_NO"	NUMBER		NOT NULL,
	"PLACE_CATEGORY"	VARCHAR2(30)		NULL,
	"PLACE_NM"	VARCHAR2(100)		NULL,
	"PLACE_ADDRESS"	VARCHAR2(300)		NULL,
	"PLACE_TEL"	NUMBER		NULL,
	"PLACE_TIME"	VARCHAR2(30)		NULL,
	"PLACE_LONGTITUDE"	NUMBER		NULL,
	"PLACE_LATITUDE"	NUMBER		NULL,
	"PLACE_FEE"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_PLACE"."PLACE_NO" IS '시설번호';

COMMENT ON COLUMN "TB_PLACE"."PLACE_CATEGORY" IS '종류';

COMMENT ON COLUMN "TB_PLACE"."PLACE_NM" IS '시설명';

COMMENT ON COLUMN "TB_PLACE"."PLACE_ADDRESS" IS '주소';

COMMENT ON COLUMN "TB_PLACE"."PLACE_TEL" IS '연락처';

COMMENT ON COLUMN "TB_PLACE"."PLACE_TIME" IS '운영시간';

COMMENT ON COLUMN "TB_PLACE"."PLACE_LONGTITUDE" IS '경도';

COMMENT ON COLUMN "TB_PLACE"."PLACE_LATITUDE" IS '위도';

COMMENT ON COLUMN "TB_PLACE"."PLACE_FEE" IS '사용료';

CREATE TABLE "TB_LEVEL" (
	"LEVEL_NO"	NUMBER		NOT NULL,
	"LEVEL_NM"	VARCHAR2(5)		NULL,
	"LOW_SCORE"	NUMBER		NULL,
	"HIGH_SCORE"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_LEVEL"."LEVEL_NO" IS '등급번호';

COMMENT ON COLUMN "TB_LEVEL"."LEVEL_NM" IS '등급명';

COMMENT ON COLUMN "TB_LEVEL"."LOW_SCORE" IS '최소점수';

COMMENT ON COLUMN "TB_LEVEL"."HIGH_SCORE" IS '최대점수';

CREATE TABLE "TB_SANCTION" (
	"SAN_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NOT NULL,
	"SAN_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"SAN_TIME"	DATE		NULL,
	"SAN_CONTENTS"	VARCHAR2(1000)		NULL
);

COMMENT ON COLUMN "TB_SANCTION"."SAN_NO" IS '제재번호';

COMMENT ON COLUMN "TB_SANCTION"."USER_ID" IS '아이디';

COMMENT ON COLUMN "TB_SANCTION"."SAN_DATE" IS '제재날짜';

COMMENT ON COLUMN "TB_SANCTION"."SAN_TIME" IS '제제기간';

COMMENT ON COLUMN "TB_SANCTION"."SAN_CONTENTS" IS '제제사유';

CREATE TABLE "TB_QNA" (
	"QNA_NO"	NUMBER		NOT NULL,
	"QNA_CATEGORY"	VARCHAR2(10)		NULL,
	"QNA_TITLE"	VARCHAR2(100)		NULL,
	"QNA_CONTENTS"	VARCHAR2(3000)		NULL,
	"QNA_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"QNA_HITS"	NUMBER	DEFAULT 0	NULL,
	"QNA_PWD"	VARCHAR2(20)		NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"QNA_FILE"	VARCHAR2(1000)		NULL,
	"QNA_FILE2"	VARCHAR2(1000)		NULL,
	"QNA_FILE3"	VARCHAR2(1000)		NULL
);

COMMENT ON COLUMN "TB_QNA"."QNA_NO" IS '문의번호';

COMMENT ON COLUMN "TB_QNA"."QNA_CATEGORY" IS '카테고리';

COMMENT ON COLUMN "TB_QNA"."QNA_TITLE" IS '제목';

COMMENT ON COLUMN "TB_QNA"."QNA_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_QNA"."QNA_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_QNA"."QNA_HITS" IS '조회수';

COMMENT ON COLUMN "TB_QNA"."QNA_PWD" IS '비밀번호';

COMMENT ON COLUMN "TB_QNA"."USER_ID" IS '작성자';

COMMENT ON COLUMN "TB_QNA"."QNA_FILE" IS '파일경로1';

COMMENT ON COLUMN "TB_QNA"."QNA_FILE2" IS '파일경로2';

COMMENT ON COLUMN "TB_QNA"."QNA_FILE3" IS '파일경로3';

CREATE TABLE "TB_QNA_REPLY" (
	"QNA_RP_NO"	NUMBER		NOT NULL,
	"QNA_RP_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"QNA_RP_CONTENT"	VARCHAR2(300)		NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"QNA_NO"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_QNA_REPLY"."QNA_RP_NO" IS '댓글번호';

COMMENT ON COLUMN "TB_QNA_REPLY"."QNA_RP_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_QNA_REPLY"."QNA_RP_CONTENT" IS '내용';

COMMENT ON COLUMN "TB_QNA_REPLY"."USER_ID" IS '작성자';

COMMENT ON COLUMN "TB_QNA_REPLY"."QNA_NO" IS '문의번호';

CREATE TABLE "TB_DROPUSER" (
	"USER_ID"	VARCHAR2(20)		NOT NULL,
	"DROP_DATE"	DATE	DEFAULT SYSDATE	NULL
);

COMMENT ON COLUMN "TB_DROPUSER"."USER_ID" IS '아이디';

COMMENT ON COLUMN "TB_DROPUSER"."DROP_DATE" IS '탈퇴날짜';

CREATE TABLE "TB_HEALTH" (
	"USER_ID"	VARCHAR2(20)		NOT NULL,
	"TOTAL_SCORE"	NUMBER		NULL,
	"SCORE1"	NUMBER		NULL,
	"SCORE2"	NUMBER		NULL,
	"SCORE3"	NUMBER		NULL,
	"SCORE4"	NUMBER		NULL,
	"SCORE5"	NUMBER		NULL,
	"SCORE6"	NUMBER		NULL,
	"SCORE7"	NUMBER		NULL,
	"SCORE8"	NUMBER		NULL,
	"SCORE9"	NUMBER		NULL,
	"SCORE10"	NUMBER		NULL,
	"SCORE11"	NUMBER		NULL,
	"SCORE12"	NUMBER		NULL,
	"SCORE13"	NUMBER		NULL,
	"SCORE14"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_HEALTH"."USER_ID" IS '아이디';

COMMENT ON COLUMN "TB_HEALTH"."TOTAL_SCORE" IS '건강점수';

COMMENT ON COLUMN "TB_HEALTH"."SCORE1" IS '항목1';

COMMENT ON COLUMN "TB_HEALTH"."SCORE2" IS '항목2';

COMMENT ON COLUMN "TB_HEALTH"."SCORE3" IS '항목3';

COMMENT ON COLUMN "TB_HEALTH"."SCORE4" IS '항목4';

COMMENT ON COLUMN "TB_HEALTH"."SCORE5" IS '항목5';

COMMENT ON COLUMN "TB_HEALTH"."SCORE6" IS '항목6';

COMMENT ON COLUMN "TB_HEALTH"."SCORE7" IS '항목7';

COMMENT ON COLUMN "TB_HEALTH"."SCORE8" IS '항목8';

COMMENT ON COLUMN "TB_HEALTH"."SCORE9" IS '항목9';

COMMENT ON COLUMN "TB_HEALTH"."SCORE10" IS '항목10';

COMMENT ON COLUMN "TB_HEALTH"."SCORE11" IS '항목11';

COMMENT ON COLUMN "TB_HEALTH"."SCORE12" IS '항목12';

COMMENT ON COLUMN "TB_HEALTH"."SCORE13" IS '항목13';

COMMENT ON COLUMN "TB_HEALTH"."SCORE14" IS '항목14';

CREATE TABLE "TB_BD_GALLARY" (
	"GA_NO"	NUMBER		NOT NULL,
	"GA_TITLE"	VARCHAR2(100)		NULL,
	"GA_CONTENTS"	VARCHAR2(3000)		NULL,
	"GA_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"GA_UP"	NUMBER	DEFAULT 0	NULL,
	"GA_HITS"	NUMBER	DEFAULT 0	NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"GA_FILE1"	VARCHAR2(1000)		NULL,
	"GA_FILE2"	VARCHAR2(1000)		NULL,
	"GA_FILE3"	VARCHAR2(1000)		NULL
);

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_TITLE" IS '제목';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_UP" IS '추천수';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_HITS" IS '조회수';

COMMENT ON COLUMN "TB_BD_GALLARY"."USER_ID" IS '작성자';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_FILE1" IS '파일경로1';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_FILE2" IS '파일경로2';

COMMENT ON COLUMN "TB_BD_GALLARY"."GA_FILE3" IS '파일경로3';

CREATE TABLE "TB_BD_USERQNA" (
	"UQ_NO"	NUMBER		NOT NULL,
	"UQ_TITLE"	VARCHAR2(100)		NULL,
	"UQ_CONTENTS"	VARCHAR2(3000)		NULL,
	"UQ_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"UQ_UP"	NUMBER	DEFAULT 0	NULL,
	"UQ_HITS"	NUMBER	DEFAULT 0	NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"UQ_FILE1"	VARCHAR2(1000)		NULL,
	"UQ_FILE2"	VARCHAR2(1000)		NULL,
	"UQ_FILE3"	VARCHAR2(1000)		NULL
);

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_TITLE" IS '제목';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_UP" IS '추천수';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_HITS" IS '조회수';

COMMENT ON COLUMN "TB_BD_USERQNA"."USER_ID" IS '작성자';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_FILE1" IS '파일경로1';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_FILE2" IS '파일경로2';

COMMENT ON COLUMN "TB_BD_USERQNA"."UQ_FILE3" IS '파일경로3';

CREATE TABLE "TB_BD_NOTICE" (
	"NT_NO"	NUMBER		NOT NULL,
	"NT_TITLE"	VARCHAR2(100)		NULL,
	"NT_CONTENTS"	VARCHAR2(3000)		NULL,
	"NT_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"NT_UP"	NUMBER	DEFAULT 0	NULL,
	"NT_HITS"	NUMBER	DEFAULT 0	NULL,
	"NT_ID"	VARCHAR2(20)		NULL,
	"NT_FILE1"	VARCHAR2(1000)		NULL,
	"NT_FILE2"	VARCHAR2(1000)		NULL,
	"NT_FILE3"	VARCHAR2(1000)		NULL
);

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_TITLE" IS '제목';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_UP" IS '추천수';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_HITS" IS '조회수';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_ID" IS '작성자';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_FILE1" IS '파일경로1';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_FILE2" IS '파일경로2';

COMMENT ON COLUMN "TB_BD_NOTICE"."NT_FILE3" IS '파일경로3';

CREATE TABLE "TB_BD_FREE" (
	"FR_NO"	NUMBER		NOT NULL,
	"FR_TITLE"	VARCHAR2(100)		NULL,
	"FR_CONTENTS"	VARCHAR2(3000)		NULL,
	"FR_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"FR_UP"	NUMBER	DEFAULT 0	NULL,
	"FR_HITS"	NUMBER	DEFAULT 0	NULL,
	"USER_ID"	VARCHAR2(20)		NULL,
	"FR_FILE1"	VARCHAR2(1000)		NULL,
	"FR_FILE2"	VARCHAR2(1000)		NULL,
	"FR_FILE3"	VARCHAR2(1000)		NULL
);

COMMENT ON COLUMN "TB_BD_FREE"."FR_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_BD_FREE"."FR_TITLE" IS '제목';

COMMENT ON COLUMN "TB_BD_FREE"."FR_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_BD_FREE"."FR_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_BD_FREE"."FR_UP" IS '추천수';

COMMENT ON COLUMN "TB_BD_FREE"."FR_HITS" IS '조회수';

COMMENT ON COLUMN "TB_BD_FREE"."USER_ID" IS '작성자';

COMMENT ON COLUMN "TB_BD_FREE"."FR_FILE1" IS '파일경로1';

COMMENT ON COLUMN "TB_BD_FREE"."FR_FILE2" IS '파일경로2';

COMMENT ON COLUMN "TB_BD_FREE"."FR_FILE3" IS '파일경로3';

CREATE TABLE "TB_UQ_REPLY" (
	"UQ_RP_NO"	NUMBER		NOT NULL,
	"UQ_RP_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"UQ_RP_CONTENTS"	VARCHAR2(300)		NULL,
	"UQ_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_UQ_REPLY"."UQ_RP_NO" IS '댓글번호';

COMMENT ON COLUMN "TB_UQ_REPLY"."UQ_RP_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_UQ_REPLY"."UQ_RP_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_UQ_REPLY"."UQ_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_UQ_REPLY"."USER_ID" IS '작성자';

CREATE TABLE "TB_INFO_REPLY" (
	"INFO_RP_NO"	NUMBER		NOT NULL,
	"INFO_RP_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"INFO_RP_CONTENTS"	VARCHAR2(300)		NULL,
	"INFO_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_INFO_REPLY"."INFO_RP_NO" IS '댓글번호';

COMMENT ON COLUMN "TB_INFO_REPLY"."INFO_RP_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_INFO_REPLY"."INFO_RP_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_INFO_REPLY"."INFO_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_INFO_REPLY"."USER_ID" IS '작성자';

CREATE TABLE "TB_BD_GALLARY_REPLY" (
	"RP_NO"	NUMBER		NOT NULL,
	"RP_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"RP_CONTENT"	VARCHAR2(300)		NULL,
	"GA_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_BD_GALLARY_REPLY"."RP_NO" IS '댓글번호';

COMMENT ON COLUMN "TB_BD_GALLARY_REPLY"."RP_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_BD_GALLARY_REPLY"."RP_CONTENT" IS '내용';

COMMENT ON COLUMN "TB_BD_GALLARY_REPLY"."GA_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_BD_GALLARY_REPLY"."USER_ID" IS '작성자';

CREATE TABLE "TB_FR_REPLY" (
	"FR_RP_NO"	NUMBER		NOT NULL,
	"FR_RP_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"FR_RP_CONTENTS"	VARCHAR2(300)		NULL,
	"FR_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_FR_REPLY"."FR_RP_NO" IS '댓글번호';

COMMENT ON COLUMN "TB_FR_REPLY"."FR_RP_DATE" IS '작성일자';

COMMENT ON COLUMN "TB_FR_REPLY"."FR_RP_CONTENTS" IS '내용';

COMMENT ON COLUMN "TB_FR_REPLY"."FR_NO" IS '게시글번호';

COMMENT ON COLUMN "TB_FR_REPLY"."USER_ID" IS '작성자';

CREATE TABLE "TB_EXERCISE_LIST" (
	"ADD_EXER_NO"	NUMBER		NOT NULL,
	"EXER_NM"	VARCHAR2(30)		NULL,
	"HOUR"	NUMBER		NULL,
	"CALORIE"	NUMBER		NULL,
	"SCHE_DATE"	DATE		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_EXERCISE_LIST"."ADD_EXER_NO" IS '운동추가번호';

COMMENT ON COLUMN "TB_EXERCISE_LIST"."EXER_NM" IS '운동명';

COMMENT ON COLUMN "TB_EXERCISE_LIST"."HOUR" IS '운동시간';

COMMENT ON COLUMN "TB_EXERCISE_LIST"."CALORIE" IS '운동칼로리';

COMMENT ON COLUMN "TB_EXERCISE_LIST"."SCHE_DATE" IS '날짜';

COMMENT ON COLUMN "TB_EXERCISE_LIST"."USER_ID" IS '아이디';

CREATE TABLE "TB_FOOD_LIST" (
	"ADD_FOOD_NO"	NUMBER		NOT NULL,
	"ADD_FOOD_NM"	VARCHAR2(30)		NULL,
	"ADD_FOOD_COUNT"	NUMBER		NULL,
	"ADD_FOOD_CAL"	NUMBER		NULL,
	"SCHE_DATE"	DATE		NOT NULL,
	"USER_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "TB_FOOD_LIST"."ADD_FOOD_NO" IS '음식추가번호';

COMMENT ON COLUMN "TB_FOOD_LIST"."ADD_FOOD_NM" IS '음식명';

COMMENT ON COLUMN "TB_FOOD_LIST"."ADD_FOOD_COUNT" IS '분량';

COMMENT ON COLUMN "TB_FOOD_LIST"."ADD_FOOD_CAL" IS '음식칼로리';

COMMENT ON COLUMN "TB_FOOD_LIST"."SCHE_DATE" IS '날짜';

COMMENT ON COLUMN "TB_FOOD_LIST"."USER_ID" IS '아이디';

ALTER TABLE "TB_BD_INFO" ADD CONSTRAINT "PK_TB_BD_INFO" PRIMARY KEY (
	"INFO_NO"
);

ALTER TABLE "TB_USER" ADD CONSTRAINT "PK_TB_USER" PRIMARY KEY (
	"USER_ID"
);

ALTER TABLE "TB_EXERCISE" ADD CONSTRAINT "PK_TB_EXERCISE" PRIMARY KEY (
	"EXER_NO"
);

ALTER TABLE "TB_FOOD" ADD CONSTRAINT "PK_TB_FOOD" PRIMARY KEY (
	"FOOD_NO"
);

ALTER TABLE "TB_SCHEDULER" ADD CONSTRAINT "PK_TB_SCHEDULER" PRIMARY KEY (
	"SCHE_DATE",
	"USER_ID"
);

ALTER TABLE "TB_FAQ" ADD CONSTRAINT "PK_TB_FAQ" PRIMARY KEY (
	"FAQ_NO"
);

ALTER TABLE "TB_PLACE" ADD CONSTRAINT "PK_TB_PLACE" PRIMARY KEY (
	"PLACE_NO"
);

ALTER TABLE "TB_LEVEL" ADD CONSTRAINT "PK_TB_LEVEL" PRIMARY KEY (
	"LEVEL_NO"
);

ALTER TABLE "TB_SANCTION" ADD CONSTRAINT "PK_TB_SANCTION" PRIMARY KEY (
	"SAN_NO",
	"USER_ID"
);

ALTER TABLE "TB_QNA" ADD CONSTRAINT "PK_TB_QNA" PRIMARY KEY (
	"QNA_NO"
);

ALTER TABLE "TB_QNA_REPLY" ADD CONSTRAINT "PK_TB_QNA_REPLY" PRIMARY KEY (
	"QNA_RP_NO"
);

ALTER TABLE "TB_DROPUSER" ADD CONSTRAINT "PK_TB_DROPUSER" PRIMARY KEY (
	"USER_ID"
);

ALTER TABLE "TB_HEALTH" ADD CONSTRAINT "PK_TB_HEALTH" PRIMARY KEY (
	"USER_ID"
);

ALTER TABLE "TB_BD_GALLARY" ADD CONSTRAINT "PK_TB_BD_GALLARY" PRIMARY KEY (
	"GA_NO"
);

ALTER TABLE "TB_BD_USERQNA" ADD CONSTRAINT "PK_TB_BD_USERQNA" PRIMARY KEY (
	"UQ_NO"
);

ALTER TABLE "TB_BD_NOTICE" ADD CONSTRAINT "PK_TB_BD_NOTICE" PRIMARY KEY (
	"NT_NO"
);

ALTER TABLE "TB_BD_FREE" ADD CONSTRAINT "PK_TB_BD_FREE" PRIMARY KEY (
	"FR_NO"
);

ALTER TABLE "TB_UQ_REPLY" ADD CONSTRAINT "PK_TB_UQ_REPLY" PRIMARY KEY (
	"UQ_RP_NO"
);

ALTER TABLE "TB_INFO_REPLY" ADD CONSTRAINT "PK_TB_INFO_REPLY" PRIMARY KEY (
	"INFO_RP_NO"
);

ALTER TABLE "TB_BD_GALLARY_REPLY" ADD CONSTRAINT "PK_TB_BD_GALLARY_REPLY" PRIMARY KEY (
	"RP_NO"
);

ALTER TABLE "TB_FR_REPLY" ADD CONSTRAINT "PK_TB_FR_REPLY" PRIMARY KEY (
	"FR_RP_NO"
);

ALTER TABLE "TB_EXERCISE_LIST" ADD CONSTRAINT "PK_TB_EXERCISE_LIST" PRIMARY KEY (
	"ADD_EXER_NO"
);

ALTER TABLE "TB_FOOD_LIST" ADD CONSTRAINT "PK_TB_FOOD_LIST" PRIMARY KEY (
	"ADD_FOOD_NO"
);

ALTER TABLE "TB_SCHEDULER" ADD CONSTRAINT "FK_TB_USER_TO_TB_SCHEDULER_1" FOREIGN KEY (
	"USER_ID"
)
REFERENCES "TB_USER" (
	"USER_ID"
);

ALTER TABLE "TB_SANCTION" ADD CONSTRAINT "FK_TB_USER_TO_TB_SANCTION_1" FOREIGN KEY (
	"USER_ID"
)
REFERENCES "TB_USER" (
	"USER_ID"
);

ALTER TABLE "TB_DROPUSER" ADD CONSTRAINT "FK_TB_USER_TO_TB_DROPUSER_1" FOREIGN KEY (
	"USER_ID"
)
REFERENCES "TB_USER" (
	"USER_ID"
);

ALTER TABLE "TB_HEALTH" ADD CONSTRAINT "FK_TB_USER_TO_TB_HEALTH_1" FOREIGN KEY (
	"USER_ID"
)
REFERENCES "TB_USER" (
	"USER_ID"
);

