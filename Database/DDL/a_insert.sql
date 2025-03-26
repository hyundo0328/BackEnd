-- DDL
-- Data definition language : 데이터 정의 언어

-- 테이블 생성
-- create table 테이블명 (컬럼명 type [제약조건])

create table ddl_dept(
                         dept_code char(3) primary key,
                         dept_title varchar(50)
);

insert into ddl_dept(dept_code, dept_title) values('D01', '개발팀');
insert into ddl_dept(dept_code, dept_title) values('D02', '인사팀');
insert into ddl_dept(dept_code, dept_title) values('D03', '기획팀');
commit;

select * from ddl_dept;

CREATE TABLE ddl_emp (
                         emp_id INT AUTO_INCREMENT PRIMARY KEY,
                         emp_name VARCHAR(50) NOT NULL,
                         age INT CHECK (age >= 0),
                         emp_no VARCHAR(15) UNIQUE,
                         hire_date TIMESTAMP DEFAULT NOW(),
                         dept_code CHAR(3),
                         FOREIGN KEY (dept_code) REFERENCES ddl_dept(dept_code)
);

create table ddl_emp(
    -- auto_increment : 1부터 1씩 순차적으로 증가하는 값을 emp_id에 저장
                        emp_id int auto_increment primary key,

    -- not null : 컬럼에 null을 허용하지 않음
                        emp_name varchar(50) not null,

    -- check : 도메인 무결성을 보장. 도메인 정의에 부합하는 값만 컬럼에 추가할 수 있다.
                        age int check(age >= 0),

    -- unique : 중복값 허용하지 않음
                        emp_no varchar(15) unique,

	-- default : 컬럼에 null이 들어오면 default 값으로 대체
	hire_date timestamp default now(),

	-- 참조무결성, 외래키 : 참조하고 있는 테이블의 행을 식별하기 위해 사용
	-- 외래키 : 유일성과 최소성이 만족되는 컬럼을 지정
	dept_code char(3),
	foreign key(dept_code) references ddl_dept(dept_code)
);



-- 기본키에 null 넣기
-- insert into ddl_dept (dept_code, dept_title) values(null, '테스트부서');
-- 기본키에 중복된 값 넣기
-- insert into ddl_dept (dept_code, dept_title) values('D01', '테스트부서');
-- not null, unique
-- insert into ddl_dept (dept_code, dept_title) values('D04', '테스트부서');
select * from ddl_dept;

-- null 제약조건
insert into ddl_emp(emp_name, age, emp_no, dept_code)
values('하명도', 20, '000000-1111111', 'D01');
select * from ddl_emp;

-- check 제약조건
insert into ddl_emp(emp_name, age, emp_no, dept_code)
values('어선정', 20, '000000-2111111', 'D01');
select * from ddl_emp;

-- unique 제약조건
insert into ddl_emp(emp_name, age, emp_no, dept_code)
values('헤더', 20, '000000-2111112', 'D01');
select * from ddl_emp;

-- 외래키 제약조건
-- 부모테이블 : 참조되고 있는 테이블
-- 자식테이블 : 외래키 제약조건을 선언한 테이블
-- 1. 참조하는 테이블의 컬럼에 존재하지 않는 값을 자식테이블의 외래키 컬럼에 추가할 수 없다.
insert into ddl_emp(emp_name, age, emp_no, dept_code)
values('전정원', 20, '000000-1111112', 'D01');

-- 2. 자식테이블이 참조하고 있는 행은 삭제할 수 없다.
delete from ddl_dept where dept_code = 'D04';