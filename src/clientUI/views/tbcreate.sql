select * from tab;

select * from bookmark
-- business_info
CREATE TABLE business_info (
	business_id   NUMBER(10)   NOT NULL, -- business_id
	business_name VARCHAR2(30) NULL,     -- business_name
	owner_name    VARCHAR2(20) NOT NULL, -- owner_name
	owner_phone   NUMBER(11)   NOT NULL, -- owner_phone
	pw            VARCHAR2(30) NOT NULL, -- pw
	owner_acc     NUMBER(15)   NOT NULL, -- owner_acc
	create_date   DATE         NULL,     -- create_date
	business_code NUMBER(5)    NULL      -- business_code
);

-- business_info 기본키
CREATE UNIQUE INDEX PK_business_info
	ON business_info ( -- business_info
		business_id ASC -- business_id
	);

-- business_info
ALTER TABLE business_info
	ADD
		CONSTRAINT PK_business_info -- business_info 기본키
		PRIMARY KEY (
			business_id -- business_id
		);
