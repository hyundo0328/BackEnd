-- TCL (Tranaction Control Language)

insert into emp_dept values('222', '이태임', '경영지원부');
insert into emp_dept values('223', '하명도', '백엔드학부');
commit;

select * from emp_dept;
rollback;