-- select절 과제 --
# 1
select BK_IDX, ISBN, TITLE, RENT_CNT from BOOK
    where RENT_CNT >= 20;

# 2
select BK_IDX, ISBN, TITLE, REG_DATE from BOOK
    where REG_DATE > '2020-06-20';

# 3
select BK_IDX, ISBN, TITLE, RENT_CNT from BOOK
    where RENT_CNT = 8 and CATEGORY like 'B001';

# 4
select BK_IDX, ISBN, TITLE, AUTHOR from BOOK
    where AUTHOR like '혜민%';

# 5
select TITLE from BOOK where TITLE like '%소설%';

# 6
select BK_IDX, ISBN, TITLE, AUTHOR, RENT_CNT from BOOK
    where REG_DATE < '2020-04-15' and RENT_CNT <= 10;

# 7
select BK_IDX, ISBN, TITLE, AUTHOR, RENT_CNT from BOOK where TITLE like '나는%';

# 8
select CATEGORY, avg(RENT_CNT) as '평균 대출건수', sum(RENT_CNT) as '총 대출건수' from BOOK
    group by CATEGORY order by sum(RENT_CNT);

# 9
select BK_IDX, ISBN, TITLE, AUTHOR, RENT_CNT from BOOK
    order by RENT_CNT desc limit 5;

# 10
select BK_IDX, ISBN, TITLE, AUTHOR, REG_DATE from BOOK
    where CATEGORY like 'B002' order by REG_DATE desc;

# 11
select USER_ID, PASSWORD, EMAIL, GRADE, TELL, IS_LEAVE from MEMBER
    where GRADE like 'ROLE_USER' order by USER_ID asc;

# 12
select USER_ID, PASSWORD, EMAIL, GRADE, TELL, IS_LEAVE from MEMBER
    where GRADE like 'ROLE_ADMIN' and IS_LEAVE = 0;

# 13
select GRADE, count(GRADE) from MEMBER group by GRADE;

# 14
select USER_ID, PASSWORD, EMAIL, GRADE, TELL, IS_LEAVE from MEMBER
    where GRADE like 'ROLE_USER' and TELL like '%9';

# 15
select EMAIL from MEMBER where IS_LEAVE = 0 and GRADE like 'ROLE_ADMIN' order by EMAIL;

# 16
select USER_ID, PASSWORD, EMAIL, GRADE, TELL, IS_LEAVE from MEMBER
    where GRADE like 'ROLE_USER' and IS_LEAVE = 0
    and TELL like '%4___' and USER_ID like 'E%';

# 17
select BD_IDX, USER_ID, REG_DATE, TITLE, CONTENT, VIEW_CNT, IS_DEL from BOARD
    where TITLE like '%철학%' or CONTENT like '%철학%';

# 18
select BD_IDX, USER_ID, REG_DATE, TITLE, CONTENT, VIEW_CNT, IS_DEL from BOARD
    order by VIEW_CNT desc limit 10;

# 19
select BD_IDX, USER_ID, REG_DATE, TITLE, CONTENT from BOARD
    where USER_ID like 'Socrates' and VIEW_CNT >= 30;

# 20
select BK_IDX, TITLE, AUTHOR,
    case
        when CATEGORY like 'B0%' then '문학'
        when CATEGORY like 'B1%' then '전문서적'
    end as '대분류' from BOOK;

# 21
select RB_IDX, RM_IDX, BK_IDX, REG_DATE, STATE, RETURN_DATE from RENT_BOOK where STATE like 'RE01';

# 22
# select count(rb.BK_IDX),TITLE from BOOK b join RENT_BOOK rb on (b.BK_IDX = rb.BK_IDX) group by TITLE ;
select TITLE from RENT_MASTER where RENT_BOOK_CNT >= 2;

# 23
select BK_IDX, ISBN, TITLE, REG_DATE from BOOK
    where REG_DATE between '2020-06-25' and '2020-06-30';

# 24
select USER_ID, REG_DATE, LOGIN_DATE, MODIFY_DATE, LEAVE_DATE from MEMBER_INFO where LEAVE_DATE >= '2023-12-04';