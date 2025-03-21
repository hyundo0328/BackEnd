# join

# 모든 직원의 이름, 부서명을 조회
select EMP_NAME, (select DEPT_TITLE from DEPARTMENT where e.DEPT_CODE = DEPT_ID) as '부서명' from EMPLOYEE e;
select EMP_NAME, DEPT_TITLE from EMPLOYEE e join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID);

# cross join
select * from EMPLOYEE cross join DEPARTMENT;

# inner join (equals join, 등가조인)
select EMP_ID, EMP_NAME, JOB_NAME from EMPLOYEE e join job j on(e.JOB_CODE = j.JOB_CODE);
# using
select EMP_ID, EMP_NAME, JOB_NAME from EMPLOYEE e join job j using(job_code);

# 여러 테이블 join 하기
# 모든 사원들의 사번, 이름, 부서명, 근무지를 출력
select EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME from EMPLOYEE e
    join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID)
    join LOCATION l on(d.LOCATION_ID = l.LOCAL_CODE);

# ASIA 지역에서 근무하는 사원 중 급여가 500만원 미만인 모든 사원을 조회
select EMP_ID, SALARY, LOCAL_NAME from EMPLOYEE e
    join DEPARTMENT d on (e.DEPT_CODE = d.DEPT_ID)
    join LOCATION l on (d.LOCATION_ID = l.LOCAL_CODE)
    where LOCAL_NAME like 'ASIA%' and SALARY < 5000000;

# outer join
# left join
select EMPLOYEE.EMP_ID, EMPLOYEE.EMP_NAME, DEPARTMENT.DEPT_TITLE from EMPLOYEE e
    left join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID);
# right join
select EMPLOYEE.EMP_ID, EMPLOYEE.EMP_NAME, DEPARTMENT.DEPT_TITLE from EMPLOYEE e
    right join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID);

# self join
# employee 테이블에서 매니저 이름을 조회하는 쿼리
select e.EMP_NAME, e.MANAGER_ID, e2.EMP_NAME from EMPLOYEE e
    right join EMPLOYEE e2 on (e2.MANAGER_ID = e.EMP_ID);