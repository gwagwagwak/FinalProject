select * from member;
drop table member;
create table MEMBER(id_no number(4),
               id varchar2(20) not null unique,
               pw varchar2(20) not null,
               name varchar2(20) not null,
               nickname varchar2(20) not null,
               gender varchar2(20) not null,
               age int not null,
               phone varchar2(20),
               email varchar2(30));
CREATE SEQUENCE member_sequence1
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOMINVALUE;
drop table review;
select * from board1;

create table REVIEW( 
                 r_id number(10) primary key,                 
                 nickname varchar2(20) not null,
                 r_content varchar2(500),
                 day varchar2(30),                 
                 game_name varchar2(30) not null,
	    rating number(10)
                 );

insert into member values(member_sequence1.NEXTVAL, 'abc','abc', '강지수', '12dsdsf32', '여', 30, '010-1111-6365', 'bvcxxws@asdad');
select * from REVIEW;
select count(*) as id from member;
select * from review;
delete from member where id='qwe';



insert into member values(member_sequence1.NEXTVAL, 'abc','abc', '강지수', '12dsdsf32', '여', 30, '010-1111-6365', 'bvcxxws@aaacad');
insert into member values(member_sequence1.NEXTVAL, 'efg','efg', '김혜수', 'trere2', '여', 12, '010-2222-6365', 'bqwess@bvxzad');
insert into member values(member_sequence1.NEXTVAL, 'hij','hij', '강지원, 'asdaf32', '남', 23, '010-1111-5535', 'bhjgs@anffsd');
insert into member values(member_sequence1.NEXTVAL, 'akln','kln', '은지원', 'eunsf32', '여', 44, '010-1241-6265', 'iyyutts@apoud');
insert into member values(member_sequence1.NEXTVAL, 'sfd','opq', '윤은혜', 'sdfdsf32', '남', 34, '010-6533-6365', 'hddttt@arev');
insert into member values(member_sequence1.NEXTVAL, 'zxcs','xsd', '조유진', 'ttddrrsf32', '여', 12, '010-7777-6365', 'fsdfsdf@kutd');
insert into member values(member_sequence1.NEXTVAL, 'asdf','asdf', '지정호', 'jijungf32', '남', 76, '010-1232-6365', 'vcncvbc@nthrd');
insert into member values(member_sequence1.NEXTVAL, 'ooyy','ooyy', '민경호', 'applef32', '여', 34, '010-1123-6365', 'bhjfyjr@ryecd');
insert into member values(member_sequence1.NEXTVAL, 'mnbv','mnbv', '조규현', 'zmxb2', '남', 30, '010-8888-6365', 'bjrrgss@dsdsad');








insert into member values(member_sequence1.NEXTVAL, 'edxs','edxs', '조규현', 'zmxb2', '남', 30, '010-8435-6365', 'ncbnss@dszxcad');
insert into member values(member_sequence1.NEXTVAL, 'gbddf','gbddf', '이규현', 'pine', '남', 30, '010-7648-6865', 'ghfghfs@dgdsad');
insert into member values(member_sequence1.NEXTVAL, 'hmgmy','hmgmy', '김주현', 'tine', '남', 30, '010-8845-1235', 'bcbgcss@dseted');
insert into member values(member_sequence1.NEXTVAL, 'vsvs','vsvs', '윤기원', 'joooo', '남', 30, '010-8348-9665', 'bjmgbs@dsdretd');
insert into member values(member_sequence1.NEXTVAL, 'mtmt','vscv', '박지수', 'park111', '남', 30, '010-5888-9765', 'rts@dsdsad');
insert into member values(member_sequence1.NEXTVAL, 'mliuiu','beebv', '조상운', 'jooo111', '남', 30, '010-6688-4445', 'sdrgss@dvdfsad');
insert into member values(member_sequence1.NEXTVAL, 'vssdf','mjttyv', '오지영', 'ohh123', '남', 30, '010-2342-1235', 'bwqgss@ddgad');
insert into member values(member_sequence1.NEXTVAL, 'mbre','mfhtr', '김홍준', 'kim1231', '남', 30, '010-8548-6755', 'bjrrgss@dsdfgd');
insert into member values(member_sequence1.NEXTVAL, 'yhn','uyuj', '신창민', 'shin11', '남', 30, '010-8448-6365', 'bjrrgss@dsdsad');
insert into member values(member_sequence1.NEXTVAL, 'msdfv','gergev', '주지훈', 'z000022', '남', 30, '010-8808-6365', 'bsas@dsdsad');
insert into member values(member_sequence1.NEXTVAL, 'mdvwv','bbfsv', '주지홍', 'fgdfgs', '남', 30, '010-9878-6365', 'bjjtmugss@srtgwresad');
insert into member values(member_sequence1.NEXTVAL, 'msdc','muyr', '이지홍', 'lee123', '남', 30, '010-8664-6453', 'bzczgss@dsdsad');
insert into member values(member_sequence1.NEXTVAL, '123','123', '박지홍', 'parkcvv', '남', 30, '010-8678-6355', 'bjsdagss@dbdfad');
insert into member values(member_sequence1.NEXTVAL, '456','456', '김규태', 'jfyhgd', '남', 30, '010-8978-7986', 'bxcvss@dvxds');
insert into member values(member_sequence1.NEXTVAL, '789','789', '방재혁', 'eers333', '남', 30, '010-8867-6787', 'bxcvss@dscbd');
insert into member values(member_sequence1.NEXTVAL, '1231','1231', '오정균', 'kyun123', '남', 30, '010-8348-6786', 'bjrrgss@dsfdad');
insert into member values(member_sequence1.NEXTVAL, '2342','2342', '조정흔', 'hun3242', '여', 30, '010-8324-7665', 'sdsggss@dhtgfrad');
insert into member values(member_sequence1.NEXTVAL, '4564','4564', '김민주', 'mjloj', '여', 30, '010-8458-1235', 'bsdfss@nfgd');
insert into member values(member_sequence1.NEXTVAL, '7855','7855', '정주현', 'sadasda', '여', 30, '010-8568-2315', 'bjxdss@tgfjhad');
delete from board1 where nickname like 'qwe';
delete from board1 where nickname like 'zxc';
delete from board1 where id='asd';



