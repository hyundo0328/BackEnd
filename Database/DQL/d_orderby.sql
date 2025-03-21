# 사원들의 이름, 급여, 보너스, 연봉레벨, 부서코드를 조회
select EMPLOYEE.EMP_NAME, EMPLOYEE.SALARY, EMPLOYEE.BONUS, EMPLOYEE.SAL_LEVEL, EMPLOYEE.DEPT_CODE from EMPLOYEE
# 부서코드로 오름차순 정렬
# order by DEPT_CODE

# 부서코드로 내림차순 정렬
# order by DEPT_CODE asc

# 연봉레벨로 오름차순 정렬, 연봉레벨이 같다면 연봉으로 내림차순 정렬
# order by SAL_LEVEL asc, SALARY desc

# 보너스로 오름차순 정렬, null은 뒤쪽에 정렬
order by BONUS is null asc, BONUS asc;

# employee 테이블에서 급여를 가장 많이 받는 5명
select EMPLOYEE.EMP_NAME, EMPLOYEE.SALARY from EMPLOYEE
order by SALARY desc
limit 5;

# 가장 최근에 입사한 사원 5명 조회
select EMPLOYEE.EMP_NAME, EMPLOYEE.HIRE_DATE from EMPLOYEE
order by HIRE_DATE desc
limit 5;