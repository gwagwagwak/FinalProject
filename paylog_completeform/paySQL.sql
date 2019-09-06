select * from member;

--------- qna list sql  -- -------------------------------------------------

select * from(select ROW_NUMBER() over(order by q_no desc)as rn, qna.* from qna) where rn >=1 and rn <=10 ;

!!!!!!!!!!!!!!!!!!!!!!!게시물 순번
전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 )
${count} -(${pager.curPage}-1) * 10 + 0(0번부터 9번까지 한페이지에 들어감) 

update MEMBER
set b_type = '비상장'
where m_email = 'sdfasdfa';

ggggg
iiiiii

select count(*) from member
		where m_type = 3 and b_type = '비상장';

	select * from member
		where m_type = 3 and b_type = '비상장'
		order by m_joindate desc;

select * from member;



SELECT ROW_NUMBER() OVER (ORDER BY q_no DESC) AS ROWNUM, qna.* FROM qna ORDER BY ROWNUM DESC

	select q_no, q_title, q_content, q_writer, m_lname, q_date, q_complete, q_replytype, q_private 
		from qna q, member 
		where q.q_writer = m.m_email and q.q_no = 15;

		
			select count(*)
		from qna
		where q_complete='답변미완료';
	
		
update qna 
set q_private='public'
where q_private='공개글';		

select * from qna;
		
select * from qnacomment;
		select *  
		from qna 
		where q_no = 14;
		q, member m
		where q.q_writer = m.m_email and q.q_no = 14;
		
		select * from member;
		
		
		select * 
			from ( SELECT ROWNUM as rn, qna.* 
					FROM(
	  					select * 
	  					from QNA
	  					where q_complete='답변완료'
	  					order by q_no desc
	  					) QNA
	  				where ROWNUM <= 10 
	 			 )
			where rn>= 1	 
		
		select * from member
		where m_type=3
		order by m_joindate desc;
		
		
		
		delete qna where q_no=15;
		
		select * from qnacomment;
		
		----qna comment sql
		select *
		from(
			select rownum as rn, A.*
			from(
		select comt_no, comt_textid, comt_content, comt_writer, comt_date
		from qnacomment c, member m
		where c.comt_writer = m.m_email and comt_textid = 25
		order by comt_no desc
		)A
		) where rn between 1 and 10
		
		
------------create table--------------------

	select count(*)
		from member
		where m_email='kkk';

select * from member
		order by m_fname;

CREATE TABLE member (
	m_email	varchar2(30)		primary key,
	m_pw	varchar2(30)		NULL,
	m_fname	varchar2(30)		NULL,
	m_lname	varchar2(30)		NULL,
	m_hp	varchar2(20)		NULL,
	m_addr	varchar2(100)		NULL,
	m_joindate	date		NULL,
	m_nation	varchar2(20)		NULL,
	m_secu	varchar2(50)		NULL,
	m_answer	varchar2(50)		NULL,
	m_type	number(2)		NULL,
	b_type	varchar2(30)		NULL,
	b_number	varchar2(30)		NULL,
	b_name		varchar2(100)	null
);
--b_type : '개인' or '상장' or '비상장'

select count(*) from member where m_email='rmfhwlt0@naver.com11';	

select * from member;

insert into member
		(m_email, m_pw, m_fname, m_lname, m_hp, m_addr, m_joindate
		,m_nation, m_type)
		values
		('email', '111', '상홍ㅇ', '황', '010', '주소', SYSDATE, 'korea', 2);
		
		
		select * from member;

CREATE TABLE qnamain (
	qm_no	number(20)		primary key,
	qm_sendername varchar2(50)	null,
	qm_sendermail varchar2(100)		null,
	qm_receivcemail	varchar2(100)		NULL,
	qm_title	varchar2(100)		NULL,
	qm_content	varchar2(1000)		NULL
);




CREATE TABLE qna(
	q_no	number(20)	primary key,
	q_title	varchar2(100)	NULL,
	q_writer varchar2(30),
	q_content	varchar2(1000)	NULL,
	q_date	date	NULL,
	q_divide varchar2(30) null,
	q_replytype	varchar2(20)	NULL,
	q_private	varchar2(20)	NULL,
	q_complete varchar2(20) null
);

select * from qna order by q_no desc;
select * from qnacomment ;



insert into qna (q_no, q_title, q_content, q_writer, q_divide, q_date, q_replytype, q_complete, q_private)
		values
		(seq_qna.nextval, 'sdfsdf', '내용', 'rmfhwlt0@naver.com', '결제', sysdate, '이메일', '답변미완료', 'public');

		

		
CREATE TABLE qnacomment (
	comt_no	number(20)		primary key,
	comt_writer	varchar2(30),
	comt_content	varchar2(500)		NULL,
	comt_date	date		NULL,
	comt_flag	number(2)		NULL,
	comt_textid	number(20)		NOT NULL
);



CREATE TABLE card (
	c_number	number(20)		primary key,
	c_type	varchar2(50)		NULL,
	c_expr	date				NULL,
	c_csc	number(5)			NULL,
	c_addr	varchar2(500)	NULL,
	c_user	varchar2(30)	NOT NULL
);

CREATE TABLE paylist (
	p_no	number(20)		primary key,
	p_target	varchar2(100)		NULL,
	p_date	date		NULL,
	p_charge	number(15)		NULL,
	p_currc	varchar2(10)		NULL,
	p_type	varchar2(2)		NULL,
	p_cnumber	number(20)		NOT NULL,
	p_user	varchar2(30)		NOT NULL
);

CREATE TABLE autopay (
	a_no	number(20)		primary key,
	a_target	varchar2(100)		NULL,
	a_charge	number(15)		NULL,
	a_currc	varchar2(20)		NULL,
	a_date	date		NULL,
	a_cnumber	number(20)		NOT NULL
);

----------------------------------------------------
------drop table------------
drop table member;
drop table qna CASCADE CONSTRAINTS;			
drop table qnamain;
drop table qnacomment;
drop table card;
drop table paylist;
drop table autopay;


--select--------------------------------
select * from member;
select * from qna ;
select * from qnamain;
select * from qnacomment;
select * from paylist;
select * from card;
select * from autopay;

---alter table---


ALTER TABLE member MODIFY(b_number varchar2(50));





---insert----------------------
--member--
insert into member values('rmfhwlt0@naver.com', '111', '황', '상호', '010555544444', '서울시 강동구', SYSDATE, 'south korea', null, null, 1, null, null, null);
insert into member values('violetaplume@gmail.com', '111', '장', '희수', '01033335555', '서울시 강서구', SYSDATE, 'south korea', null, null, 1, null, null, null);
insert into member values('mjkim031@gmail.com', '111', '김', '민정', '0101112222', '서울시 강서구', SYSDATE, 'south korea', null, null, 1, null, null, null);
insert into member values('ash010@naver.com', '111', '이', '경희', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 1, null, null, null);

insert into member values('ㅁㄴㅇㄻㄴㅇㄹ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('ㅁㅇㄻ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('ㅓ호ㅓ호ㅓ호ㅓ, '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('sadfasdf', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('fffffff', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('ggggg', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('hhhh', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('jjjjjj', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('kkkkkk', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('dddddd', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('opopopo', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);
insert into member values('mnddiodj', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 2, null, null, null);


insert into member values('ㅇㅁㄴㅇㄹ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '개인', '1231231', '삼성');
insert into member values('ㅈㅈㅈㅈㅈ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '개인', '1231231', '삼성');
insert into member values('sdfasdf', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '개인', '1231231', '삼성');


insert into member values('ㅁㄴ어라ㅣ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '상장', '1231231', '삼성');
insert into member values('ㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '상장', '1231231', '삼성');
insert into member values('ㅁㄴ어라ㅇㄹㅇㅁ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '상장', '1231231', '삼성');
insert into member values('ㅁㄴ어라ㅇㄹㅇㄹㅇㄹㅇㄹㅁ', '111', '장', '만득', '010555544444', '서울시 강서구', SYSDATE, 'south korea', null, null, 3, '상장', '1231231', '삼성');

----qna------
비밀번호 계정설정 계정제한 결제 비지니스 솔루션

insert into qna values(seq_qna.nextval, '제목', 'ggggg', '내요내요내용내용내용', SYSDATE, '비밀번호', '웹사이트', '비밀글', '미완료');
insert into qna values(seq_qna.nextval, '제목1', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목2', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정제한', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목3', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정제한', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목4', 'ggggg', '내요내요내용내용내용', SYSDATE, '솔루션', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목5', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정제한', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목6', 'ggggg', '내요내요내용내용내용', SYSDATE, '비밀번호', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목7', 'ggggg', '내요내요내용내용내용', SYSDATE, '솔루션', '웹사이트', '공개글', '미완료');

insert into qna values(seq_qna.nextval, '제목8', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '비지니스 솔루션', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목9', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '비지니스 솔루션', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목10', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제11', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '웹사이트', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목12', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '비지니스 솔루션', '공개글', '미완료');
insert into qna values(seq_qna.nextval, '제목13', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '웹사이트', '공개글', '미완료');

insert into qna values(seq_qna.nextval, '제목23', 'ggggg', '내요내요내용내용내용', SYSDATE, '비밀번호', '웹사이트', '비밀글', '미완료');
insert into qna values(seq_qna.nextval, '제목24', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '웹사이트', '비밀글', '미완료');
insert into qna values(seq_qna.nextval, '제ㄴㅇㄹ목', 'ggggg', '내요내요내용내용내용', SYSDATE, '비지니스 솔루션', '웹사이트', '비밀글', '미완료');
insert into qna values(seq_qna.nextval, '제ㄴㅇㄹ목', 'ggggg', '내요내요내용내용내용', SYSDATE, '계정설정', '웹사이트', '비밀글', '미완료');
delete from qna;


select * from qna ;
-----다량  더미 데이터 insert---------------

declare
 i number :=1;
 begin
	while i <= 200 loop
		insert into qna(q_no, q_writer, q_title, q_content, q_date, q_divide, q_complete, q_replytype, q_private)values(seq_qna.nextval, '황상호', '제목', '얄리얄리야라셩 내용', SYSDATE, '결제', '미완료', '이메일', '비밀글');
 end 
 
 
 select * from qna order by 
 --------




-----테이블 조건 변경----------------

ALTER TABLE member ADD CONSTRAINT PK_USERS PRIMARY KEY(USERNO);

ALTER TABLE qna ADD CONSTRAINT PK_QNAPRIMARY KEY(q_no);


-----외래키 설정--------------------
alter table qna add constraint qna_fk_memail foreign key(q_writer) references member(m_email);
alter table qnacomment add constraint qnacomment_fk_qno foreign key(comt_textid) references qna(q_no);
alter table card add constraint card_fk_cusername foreign key(c_user) references member(m_email);
alter table paylist add constraint paylist_fk_cardnumber foreign key(p_cnumber) references card(c_number);
alter table paylist add constraint paylist_fk_memail foreign key(p_user) references member(m_email);
alter table autopay add constraint autopay_fk_cnumber foreign key(a_cnumber) references card(c_number);



---외래키 삭제-----------------

alter table qna drop foreign key qna_fk_memail;

--외래키 확인------
3.1 테이블 기준 확인
select * from information_schema.table_constraints where table_name = '테이블명';

3.2 데이터베이스 기준 확인
select * from information_schema.table_constraints where constraint_schema = '데이터베이스명';





--------------------------------시퀀스-------------------------------------
CREATE SEQUENCE  시퀀스명  
        START WITH n   
        INCREMENT BY n 
        MAXVALUE n |  NOMAXVALUE 
        MINVALUE n | NOMINVALUE
위의 옵션에 대해서 추가 설명을 드리자면, 

START WITH n ▶ n = 초기화 값
INCREMENT BY n ▶ n = 증가값
MAXVALUE n ▶ n = 최대값 또는 NOMAXVALUE = 무한대 값
MINVALUE n ▶ n = 최소값 또는 NOMINVALUE = 무한대 값


ALTER TABLE member RENAME COLUMN m_lame TO m_lname;


-----------------------------------------------------시퀀스---------------------------------------
CREATE SEQUENCE seq_qna START WITH 1 INCREMENT BY 1 NOMAXVALUE ;
CREATE SEQUENCE seq_qnamain START WITH 1 INCREMENT BY 1 NOMAXVALUE ;
CREATE SEQUENCE seq_qnacomment START WITH 1 INCREMENT BY 1 NOMAXVALUE ;
CREATE SEQUENCE seq_paylist START WITH 1 INCREMENT BY 1 NOMAXVALUE ;
CREATE SEQUENCE seq_autopay START WITH 1 INCREMENT BY 1 NOMAXVALUE ;


-------시퀀스 삭제-----
DROP SEQUENCE seq_qna;


-----------시퀀스 초기화--------------

alter sequence seq_qna increment by 1;


