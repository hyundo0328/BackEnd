select * from EMPLOYEE where SALARY >= 3500000 and SALARY <= 6000000;

select SALARY from EMPLOYEE where SALARY between 3500000 and 6000000;

select * from EMPLOYEE where hire_date between '90-01-01' and '01-01-01';

select emp_name from EMPLOYEE where EMP_NAME like '이%';

# employee 테이블에서 이름에 '이'가 포함되고 입사일이 01-01-01 이후인 사원의 이름, 사번, 입사일
select EMPLOYEE.EMP_NAME, EMPLOYEE.EMP_NO, EMPLOYEE.HIRE_DATE from EMPLOYEE where EMP_NAME like '%이%' and HIRE_DATE >= '01-01-01';

# employee 테이블에서 이름이 '연'으로 끝나고 재직중인 사원
select EMP_NAME, ENT_YN from EMPLOYEE where EMP_NAME like '%연' and ENT_YN = 'N';

# employee 테이블에서 전화번호 뒤에 4번째 자리가 7인 사원의 이름과 전화번호 조회
select EMP_NAME, PHONE from EMPLOYEE where PHONE like '%7___';

# 이메일이 "_" 앞에 3글자가 존재하는 패턴으로 시작하는 이메일을 가진 사원의 정보
select * from EMPLOYEE where EMAIL like '___$_%' escape '$';

# 직급코드가 'J7' 또는 'J2'인 사원 중 급여가 200만원 이상인 사원의 이름, 급여, 직급코드를 조회
select * from EMPLOYEE where JOB_CODE in ('J7', 'J2') and SALARY >= 2000000;

# bonus가 null인 사원 조회
select bonus from EMPLOYEE where BONUS is not null;

# 총 연봉이 5500 미만인 사원을 조회
select EMPLOYEE.EMP_NAME, salary*12*(1+ifnull(bonus, 0)) as '총연봉' from EMPLOYEE where SALARY*12*(1+ifnull(bonus, 0)) < 55000000;