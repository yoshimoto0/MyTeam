drop table member;
create table member(
	user_id varchar2(20) primary key,
	user_pass varchar2(20) not null,
	user_name varchar2(20) not null,
	image varchar2(20) not null,
	email varchar2(50) not null,
	favor number not null,
	isadmin number default 0 not null,
	
	CONSTRAINT fk_favor FOREIGN KEY(favor) REFERENCES kind(kind_id) ON DELETE CASCADE	

);

insert into member values('admin','admin','admin','aaa.jpg','admin@email.com',1,1);
insert into member values('aaa','1234','aaa','aaa.jpg','email@email.com',1,0);
insert into member values('bbb','1234','bbb','bbb.jpg','email@email.com',1,0);
insert into member values('ccc','1234','ccc','ccc.jpg','email@email.com',1,0);

drop table kind;
create table kind(
	kind_id number primary key,
	kind_name varchar2(50) not null
);

drop sequence kind_id_seq;
create sequence kind_id_seq START WITH 0 MINVALUE 0;

insert into kind values(kind_id_seq.nextval, '영어');
insert into kind values(kind_id_seq.nextval, 'JLPT 1급');
insert into kind values(kind_id_seq.nextval, '정보처리기사');

select * from kind;

drop table word;
create table word(

	word_num number primary key,
	word varchar2(50) not null,
	meaning varchar2(4000) not null,
	kind_id number not null,

	CONSTRAINT fk_kind_id FOREIGN KEY(kind_id) REFERENCES kind(kind_id) ON DELETE CASCADE	
);

drop sequence word_num_seq;
create sequence word_num_seq START WITH 0 MINVALUE 0;

insert into word values(word_num_seq.nextval, 'aa','aaaa',1);
insert into word values(word_num_seq.nextval, 'bb','bbbb',2);
insert into word values(word_num_seq.nextval, 'cc','cccc',3);
insert into word values(word_num_seq.nextval, 'dd','dddd',1);
insert into word values(word_num_seq.nextval, 'ee','eeee',2);
insert into word values(word_num_seq.nextval, 'ff','ffff',3);
insert into word values(word_num_seq.nextval, 'gg','gggg',1);
insert into word values(word_num_seq.nextval, 'hh','hhhh',2);
insert into word values(word_num_seq.nextval, 'ii','iiii',3);
insert into word values(word_num_seq.nextval, 'jj','jjjj',1);
insert into word values(word_num_seq.nextval, 'kk','kkkk',2);
insert into word values(word_num_seq.nextval, 'll','llll',3);
insert into word values(word_num_seq.nextval, 'mm','mmmm',1);
insert into word values(word_num_seq.nextval, 'nn','nnnn',2);
insert into word values(word_num_seq.nextval, 'oo','oooo',3);
insert into word values(word_num_seq.nextval, 'pp','pppp',1);
insert into word values(word_num_seq.nextval, 'qq','qqqq',2);
insert into word values(word_num_seq.nextval, 'rr','rrrr',3);
insert into word values(word_num_seq.nextval, 'ss','ssss',1);
insert into word values(word_num_seq.nextval, 'tt','tttt',2);
insert into word values(word_num_seq.nextval, 'uu','uuuu',3);
insert into word values(word_num_seq.nextval, 'vv','vvvv',1);
insert into word values(word_num_seq.nextval, 'ww','aaaa',2);
insert into word values(word_num_seq.nextval, 'ax','aaaa',3);
insert into word values(word_num_seq.nextval, 'as','ssss',1);
insert into word values(word_num_seq.nextval, 'at','tttt',2);
insert into word values(word_num_seq.nextval, 'au','uuuu',3);
insert into word values(word_num_seq.nextval, 'av','vvvv',1);
insert into word values(word_num_seq.nextval, 'aw','aaaa',2);
insert into word values(word_num_seq.nextval, 'ax','aaaa',3);

select * from WORD;

select * from book-list where user_id = aaa;

drop table book_list;
create table book_list(   

	book_id number primary key,
	book_name varchar2(20) not null,
	user_id varchar2(20) not null,		
	kind_id number not null,
	hit number default 0,
	
	CONSTRAINT fk_kind FOREIGN KEY(kind_id) REFERENCES kind(kind_id) ON DELETE CASCADE,
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES member(user_id) ON DELETE CASCADE

);


drop sequence book_id_seq;
create sequence book_id_seq START WITH 0 MINVALUE 0;

insert into book_list values(book_id_seq.nextval,'a-aaa', 'aaa', 1,0);
insert into book_list values(book_id_seq.nextval,'a-bbb', 'aaa', 2,0);
insert into book_list values(book_id_seq.nextval,'a-ccc', 'aaa', 1,0);
insert into book_list values(book_id_seq.nextval,'a-ddd', 'aaa', 3,0);
insert into book_list values(book_id_seq.nextval,'b-ccc', 'bbb', 3,0);
insert into book_list values(book_id_seq.nextval,'b-ddd', 'bbb', 1,0);
insert into book_list values(book_id_seq.nextval,'c-eee', 'ccc', 2,0);
insert into book_list values(book_id_seq.nextval,'c-fff', 'ccc', 3,0);


select * from book_list;

drop table book;
create table book(    
	user_id varchar2(20) not null,
	word_num number not null,
	book_id number not null,
	/*REFERENCES book_list (book_id),*/ 
	star number default 0,	
	
	CONSTRAINT fk_book_id2 FOREIGN KEY(book_id) REFERENCES book_list(book_id) ON DELETE CASCADE,
	CONSTRAINT fk_wordnum FOREIGN KEY(word_num) REFERENCES word(word_num) ON DELETE CASCADE,
	CONSTRAINT fk_user_id2 FOREIGN KEY(user_id) REFERENCES member(user_id) ON DELETE CASCADE
);

insert into book values('aaa', 1, 1, 0);
insert into book values('aaa', 2, 2, 0);
insert into book values('bbb', 3, 3, 0);
insert into book values('bbb', 4, 4, 0);
insert into book values('ccc', 5, 5, 0);
insert into book values('ccc', 6, 6, 0);
insert into book values('aaa', 7, 1, 0);
insert into book values('aaa', 8, 2, 0);
insert into book values('bbb', 9, 3, 0);
insert into book values('bbb', 10, 4, 0);
insert into book values('ccc', 11, 5, 0);
insert into book values('ccc', 12, 6, 0);
insert into book values('aaa', 13, 1, 0);
insert into book values('aaa', 14, 2, 0);
insert into book values('bbb', 15, 3, 0);
insert into book values('bbb', 16, 4, 0);
insert into book values('ccc', 17, 5, 0);
insert into book values('ccc', 18, 6, 0);
insert into book values('aaa', 19, 1, 0);
insert into book values('aaa', 20, 2, 0);
insert into book values('bbb', 21, 3, 0);
insert into book values('bbb', 22, 4, 0);
insert into book values('ccc', 23, 5, 0);
insert into book values('ccc', 24, 6, 0);



select * from book;
delete from book_list where book_id = 1;
select book.word_num, word, meaning, star 
from book, word where user_id = 'aaa' and book_id = 3 and book.word_num = word.num;



drop table grade;
create table grade(    
	grade_id number primary key,
	t_date date not null,   
	user_id varchar2(20) not null,
	name varchar2(20) not null,
	crr number,
	incrr number,
	
	CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES member(user_id) ON DELETE CASCADE
);

drop sequence grade_id;
create sequence grade_id START WITH 0 MINVALUE 0;


drop table notice;
create table notice(    
	notice_num number primary key,
	title varchar2(50) not null,   
	content varchar2(4000) not null,
	w_date date not null,
	writer varchar2(50) not null,
	
);

drop sequence notice_num_seq;
create sequence notice_num_seq START WITH 0 MINVALUE 0;


drop table qna;
create table qna(    
	qna_num number primary key,
	title varchar2(50) not null,   
	content varchar2(4000) not null,
	w_date date not null,
	writer varchar2(50) not null,
	ans varchar2(4000) not null
	read number default 0 not null
);

drop sequence qna_num_seq;
create sequence qna_num_seq START WITH 0 MINVALUE 0;
