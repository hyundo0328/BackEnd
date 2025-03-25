# 1
select USER_ID, REG_DATE, TITLE, CONTENT from BOARD;

# 2
select b.USER_ID, m.GRADE, b.TITLE, b.CONTENT from BOARD b
    join MEMBER m on (b.USER_ID = m.USER_ID)
    where b.IS_DEL = 0;

# 3
select b.USER_ID, m.GRADE, b.TITLE, b.CONTENT from BOARD b
    join MEMBER m on(b.USER_ID = m.USER_ID)
    where b.USER_ID like 'Socrates';

# 4
select m.USER_ID, m.EMAIL, m.GRADE from MEMBER m
    join MEMBER_INFO mi on (m.USER_ID = mi.USER_ID)
    where mi.LEAVE_DATE >= '2023-12-01' and mi.LEAVE_DATE <= '2023-12-31';

# 5
select * from RENT_MASTER r where TITLE like '%디디의 우산 :황정은 연작소설%';

# 6
select r.RM_IDX, r.USER_ID, m.REG_DATE, r.TITLE from RENT_MASTER r
    join MEMBER_INFO m on(r.USER_ID = m.USER_ID)
    where r.REG_DATE >= '2023-06-10';

# 7
select r.RM_IDX, r.USER_ID, r.TITLE, r.REG_DATE from RENT_MASTER r
    join MEMBER m on(r.USER_ID = m.USER_ID)
    where IS_RETURN = 0 and m.GRADE like 'ROLE_USER';

# 8
select m.USER_ID, m.EMAIL, r.RENT_BOOK_CNT as '대출도서수' from MEMBER m
    join RENT_MASTER r on(m.USER_ID = r.USER_ID)
    where r.RENT_BOOK_CNT >= 2;

# 9
select rb.RB_IDX, rm.USER_ID, rm.TITLE, rb.RETURN_DATE from RENT_BOOK rb
    join RENT_MASTER rm on(rb.RM_IDX = rm.RM_IDX)
    where DATEDIFF(rb.RETURN_DATE, rb.REG_DATE) <= 3;

# 10
select m.USER_ID, m.EMAIL, r.RENT_BOOK_CNT as '대출도서수' from MEMBER m
    join RENT_MASTER r on(m.USER_ID = r.USER_ID)
    where IS_LEAVE = 0
    order by r.RENT_BOOK_CNT desc limit 1;

# 11
select rm.RM_IDX, rm.USER_ID, rm.TITLE, rm.REG_DATE, '연체' as 'INFO'
    from RENT_MASTER rm join RENT_BOOK rb on(rm.RM_IDX = rb.RM_IDX)
    where rb.STATE like 'RE02'
    group by rm.RM_IDX;

# 12
select rb.RB_IDX, rm.USER_ID, rm.TITLE, rb.RETURN_DATE
    from RENT_MASTER rm join RENT_BOOK rb on(rm.RM_IDX = rb.RM_IDX)
    where rb.STATE like 'RE02' and rb.RETURN_DATE <= '2023-06-15';

# 13
select m.USER_ID, m.EMAIL from RENT_MASTER rm
    join MEMBER m on(rm.USER_ID = m.USER_ID)
    where m.GRADE like 'ROLE_USER' and rm.IS_RETURN = 1;

# 14
select rb.RM_IDX, rm.USER_ID, rm.TITLE, rm.REG_DATE
    from RENT_BOOK rb join RENT_MASTER rm on(rb.RM_IDX = rm.RM_IDX)
    where STATE like 'RE01'
    order by rm.REG_DATE asc limit 1;

# 15
select b.CATEGORY, c.INFO, sum(b.BOOK_AMT)
    from BOOK b join CODE c on(b.CATEGORY = c.CODE)
    group by b.CATEGORY;

# 16
select * from CODE c1
    join CODE c2 on(c1.CODE like 'B0__')
    where c2.INFO like '문학';

# 17
select m.USER_ID, sum(r.RENT_BOOK_CNT) as 'ADMIN_RENT_COUNT'
    from MEMBER_INFO m join RENT_MASTER r on(m.USER_ID = r.USER_ID)
    where m.LOGIN_DATE between '2023-12-01' and '2023-12-31'
    group by m.USER_ID;

# 18
select sum(rm.RENT_BOOK_CNT) as 'OVERDUE_COUNT' from RENT_MASTER rm
    join RENT_BOOK rb on(rm.RM_IDX = rb.RM_IDX)
    where rb.STATE like 'RE02';

# 19
select sum(b.BOOK_AMT), c.INFO from BOOK b
    right join CODE c on(b.CATEGORY = c.CODE)
    where c.CODE like 'B___'
    group by c.INFO;

# 20
select b.TITLE, c.INFO,
    case
        when UPPER_CODE like 'B0' then '문학'
        when UPPER_CODE like 'B1' then '전문서적'
    end as '분야'
    from BOOK b
    join CODE c on(b.CATEGORY = c.CODE);