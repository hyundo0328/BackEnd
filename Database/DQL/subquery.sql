# 1
select TITLE from BOOK b
    where BK_IDX = (select BK_IDX from RENT_BOOK r where r.REG_DATE = '2023-06-18');

# 2
select AUTHOR from BOOK b
    where BK_IDX = (select BK_IDX from RENT_BOOK r where r.RETURN_DATE = '2023-06-30');

# 3
select TITLE from BOOK b
    where BK_IDX in (select BK_IDX from RENT_BOOK r where r.REG_DATE = '2023-06-28' and b.RENT_CNT > 1);

# 4
select CATEGORY from BOOK b
    where BK_IDX in (select BK_IDX from RENT_BOOK r where r.STATE = 'RE01') group by CATEGORY;

# 5
select TITLE from BOOK b
    where BK_IDX in (select BK_IDX from RENT_BOOK r where r.REG_DATE = r.RETURN_DATE);

# 6
select AUTHOR from BOOK b
    where BK_IDX in (select BK_IDX from RENT_BOOK r where r.REG_DATE = '2023-06-07' and r.RETURN_DATE = '2023-06-11');

# 7
select TITLE from BOOK b
    where BK_IDX in (select BK_IDX from RENT_BOOK r where r.REG_DATE = '2023-06-15');

# 8


# 9
select TITLE, RENT_CNT from BOOK b
    where BK_IDX in (select BK_IDX from RENT_BOOK r
        where r.REG_DATE >= '2023-06-01')
        and RENT_CNT > any(select avg(RENT_CNT) from BOOK group by RENT_CNT);

# 10


# 11
# select TITLE, length(CONTENT) as 'CONTENT_LENGTH' from BOARD order by length(CONTENT) desc limit 1;
select * from (select TITLE t, length(CONTENT) l from BOARD) e order by l desc limit 1 ;

# 12
select e.USER_ID, e.POST_COUNT
    from (select USER_ID, count(USER_ID) as 'POST_COUNT'
          from BOARD group by USER_ID) e
    order by POST_COUNT desc limit 1;

# 13
select e.TITLE, e.REG_DATE
    from (select * from BOARD order by REG_DATE desc limit 2) e;

# 14
select e.USER_ID, e.REG_DATE
    from (select * from MEMBER_INFO order by REG_DATE limit 1) e;

# 15
# select USER_ID, sum(length(CONTENT))/count(CONTENT) as 'AVG_LENGTH' from BOARD group by USER_ID order by sum(length(CONTENT))/count(CONTENT) desc limit 1;
select e.USER_ID, e.AVG_LENGTH
    from (select USER_ID, sum(length(CONTENT))/count(CONTENT) as 'AVG_LENGTH'
          from BOARD group by USER_ID) e
    order by AVG_LENGTH desc limit 1;

# 16
select e.USER_ID, e.POST_COUNT
    from (select USER_ID, count(CONTENT) as 'POST_COUNT'
          from BOARD group by USER_ID) e
    order by POST_COUNT desc limit 1;

# 17
select e.USER_ID, e.POST_COUNT
    from (select USER_ID, count(CONTENT) as 'POST_COUNT' from BOARD group by USER_ID) e
    order by POST_COUNT desc, USER_ID asc;

# 18
select e.CATEGORY, e.CATEGORY_COUNT*3 as '카테고리수필권수'
    from (select CATEGORY, count(CATEGORY) as 'CATEGORY_COUNT' from BOOK group by CATEGORY) e
    where e.CATEGORY = (select CODE from CODE where INFO like '수필');

# 19
select e.USER_ID, e.REG_DATE from (select * from MEMBER_INFO order by REG_DATE desc) e limit 1;

# 20
select b.USER_ID, b.CONTENT, b.VIEW_CNT from BOARD b
    where USER_ID = (select USER_ID from MEMBER_INFO
        where LEAVE_DATE is not null order by LEAVE_DATE desc limit 1)
    order by b.VIEW_CNT desc limit 1;
