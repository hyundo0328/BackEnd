#1. 급여가 200만원 이상인 대리 직급 직원을 조회하세요
select EMP_NAME from EMPLOYEE where SALARY >= 2000000;

#2. 부서명과 부서별 평균급여를 구하시오
# 평균 급여는 소수점에서 내림처리하여 정수로 표현하세요
# 부서에 사원이 존재하지 않아 평균급여가 null일경우는 0원으로 표시하세요
select e.EMP_NAME, d.DEPT_TITLE, e.DEPT_CODE from EMPLOYEE e join DEPARTMENT d on (e.DEPT_CODE = d.DEPT_ID);

#3. 각 부서별 급여의 합계들을 구하여, 
#부서 급여합이 1000만을 초과하는 부서명과 부서별 급여합계를 조회하는
select d.DEPT_TITLE, sum(e.SALARY) from EMPLOYEE e
    join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID)
    group by d.DEPT_TITLE
    having sum(e.SALARY) > 10000000;

#4. 직원 테이블에서 보너스 포함한 연봉이 높은 5명의
# 사번, 이름, 부서명, 직급명, 입사일을 조회하세요
select e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE, j.JOB_NAME, e.HIRE_DATE, e.SALARY*12*(1+ifnull(e.BONUS, 0)) as '연봉' from EMPLOYEE e
    join DEPARTMENT d on (e.DEPT_CODE = d.DEPT_ID)
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
    where e.SALARY*12*(1+ifnull(e.BONUS, 0))
    order by e.SALARY*12*(1+ifnull(e.BONUS, 0)) desc limit 5;

#5.70년대 생이면서 성별이 여성이고 성이 전씨인 사원의
#이름, 주민등록번호, 부서명, 직급명을 출력하세요.
select e.EMP_NAME, e.EMP_NO, d.DEPT_TITLE, j.JOB_NAME from EMPLOYEE e
    join DEPARTMENT d on (e.DEPT_CODE = d.DEPT_ID)
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
    where e.EMP_NO between '70%' and '79%'
        and e.EMP_NO like '______-2%'
        and e.EMP_NAME like '전%';

#6. 이름에 '형'이 들어가는 사원의 사원ID, 사원이름, 직업명을 출력하세요 
select e.EMP_ID, e.EMP_NAME, j.JOB_NAME from EMPLOYEE e
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
    where e.EMP_NAME like '%형%';

#7. 부서코드가 D5, D6 인 사원의 이름, 직급명, 부서코드, 부서명을 출력하세요
select e.EMP_NAME, e.DEPT_CODE, j.JOB_NAME, d.DEPT_TITLE from EMPLOYEE e
    join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID)
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
    where e.DEPT_CODE like 'D5' or e.DEPT_CODE like 'D6';

#8. 사번, 사원명, 급여
#급여가 500만원 이상이면 '고급'
#급여가 300~500만원이면 '중급'
#그 이하는 '초급'으로 출력처리 하고 별칭은 '구분' 으로 한다.
select e.EMP_NO, e.EMP_NAME, e.SALARY,
    case
        when e.SALARY >= 5000000 then '고급'
        when e.SALARY >= 3000000 then '중급'
        else '초급'
    end as '구분'
       from EMPLOYEE e;

#9. 보너스를 받은 사원의 사원명, 보너스, 부서명, 지역명을 출력하세요
select e.EMP_NAME, e.BONUS, d.DEPT_TITLE, l.LOCAL_NAME from EMPLOYEE e
    join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID)
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
    join LOCATION l on(d.LOCATION_ID = l.LOCAL_CODE)
    where e.BONUS is not null;

#10. 부서가 위치한 국가가 한국이나 일본인 사원의
#이름, 부서명, 지역명, 국가명을 출력하시오
select e.EMP_NAME, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME from EMPLOYEE e
    join DEPARTMENT d on(e.DEPT_CODE = d.DEPT_ID)
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
    join LOCATION l on(d.LOCATION_ID = l.LOCAL_CODE)
    join NATIONAL n on(l.NATIONAL_CODE = n.NATIONAL_CODE)
    where n.NATIONAL_NAME in('한국', '일본');

#11. job_code가 'J4', 'J7'이면서 보너스를 받지 못한 사원의 
#이름, 직급명, 급여, 보너스금액(0원으로) 출력하세요
select e.EMP_NAME, j.JOB_NAME, e.SALARY, 0 as '보너스금액' from EMPLOYEE e
    join JOB j on(e.JOB_CODE = j.JOB_CODE)
where e.JOB_CODE in('J4', 'J7') and e.BONUS is null;