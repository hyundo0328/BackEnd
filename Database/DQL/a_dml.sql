-- DML (Data Manipulation Language): 데이터 조작어
-- 추가, 수정, 삭제

-- Insert
-- insert into 테이블명(컬럼명 [, 컬럼명…]) values(value [, value…])
insert into job(job_code, job_name) values('J8', '인턴');
select * from job;

insert into job(job_code, job_name) values('J9', '알바'), ('JA', '입사지원자');
select * from job;

create table emp_dept(
    emp_id varchar(3),
    emp_name varchar(50),
    dept_title varchar(50)
);

insert into emp_dept(
    select emp_id, emp_name, dept_title
        from EMPLOYEE e
        join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID)
        where ENT_YN = 'Y'
);

-- Update
update emp_dept set dept_title = concat('아주 멋진 ', dept_title) where emp_id = '222';
select * from emp_dept;

-- Delete
delete from emp_dept where emp_id = '222';
select  * from emp_dept;

