drop table member;
create table member(
	user_id varchar2(20) primary key,
	user_pass varchar2(20) not null,
	user_name varchar2(20) not null,
	image varchar2(20) not null,
	email varchar2(50) not null,
	favor number not null,
	isadmin number default 0 not null
);

insert into member values('aaa','1234','aaa','aaa.jpg','email@email.com',1,0);

drop table word;
create table word(

	num number primary key,
	word varchar2(50) not null,
	meaning varchar2(4000) not null,
	kind number not null
	
);

insert into word values(word_num.nextval, 'aa','aaaa',1);
insert into word values(word_num.nextval, 'bb','bbbb',2);
insert into word values(word_num.nextval, 'cc','cccc',3);
insert into word values(word_num.nextval, 'dd','dddd',1);
insert into word values(word_num.nextval, 'ee','eeee',2);
insert into word values(word_num.nextval, 'ff','ffff',3);
insert into word values(word_num.nextval, 'gg','gggg',1);
insert into word values(word_num.nextval, 'hh','hhhh',2);
insert into word values(word_num.nextval, 'ii','iiii',3);
insert into word values(word_num.nextval, 'jj','jjjj',1);
insert into word values(word_num.nextval, 'kk','kkkk',2);
insert into word values(word_num.nextval, 'll','llll',3);
insert into word values(word_num.nextval, 'mm','mmmm',1);
insert into word values(word_num.nextval, 'nn','nnnn',2);
insert into word values(word_num.nextval, 'oo','oooo',3);
insert into word values(word_num.nextval, 'pp','pppp',1);
insert into word values(word_num.nextval, 'qq','qqqq',2);
insert into word values(word_num.nextval, 'rr','rrrr',3);
insert into word values(word_num.nextval, 'ss','ssss',1);
insert into word values(word_num.nextval, 'tt','tttt',2);
insert into word values(word_num.nextval, 'uu','uuuu',3);
insert into word values(word_num.nextval, 'vv','vvvv',1);
insert into word values(word_num.nextval, 'ww','aaaa',2);
insert into word values(word_num.nextval, 'xx','aaaa',3);

select * from WORD;

drop sequence word_num;
create sequence word_num;

drop table book_list;
create table book_list(    
	book_id number primary key,
	book_name varchar2(20) not null,
	user_id varchar2(20) not null,		
	kind number not null,
	hit number default 0

);


drop sequence book_id;
create sequence book_id;

insert into book_list values(book_id.nextval,'b-aaa', 'aaa', 1,0);
insert into book_list values(book_id.nextval,'b-bbb', 'aaa', 2,0);
insert into book_list values(book_id.nextval,'b-ccc', 'aaa', 3,0);
insert into book_list values(book_id.nextval,'b-ddd', 'aaa', 1,0);
insert into book_list values(book_id.nextval,'b-eee', 'aaa', 2,0);
insert into book_list values(book_id.nextval,'b-fff', 'aaa', 3,0);


drop table book;
create table book(    
	user_id varchar2(20) not null,
	wordnum number not null,
	book_id number not null,
	/*REFERENCES book_list (book_id),*/ 
	star number default 0,	
	
	CONSTRAINT fk_book_id FOREIGN KEY(book_id) REFERENCES book_list(book_id) ON DELETE CASCADE,
	CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES member(user_id) ON DELETE CASCADE
);

insert into book values('aaa', 1, 1, 0);
insert into book values('aaa', 2, 2, 0);
insert into book values('aaa', 3, 3, 0);
insert into book values('aaa', 4, 4, 0);
insert into book values('aaa', 5, 5, 0);
insert into book values('aaa', 6, 6, 0);
insert into book values('aaa', 7, 1, 0);
insert into book values('aaa', 8, 2, 0);
insert into book values('aaa', 9, 3, 0);
insert into book values('aaa', 10, 4, 0);
insert into book values('aaa', 11, 5, 0);
insert into book values('aaa', 12, 6, 0);
insert into book values('aaa', 13, 1, 0);
insert into book values('aaa', 14, 2, 0);
insert into book values('aaa', 15, 3, 0);
insert into book values('aaa', 16, 4, 0);
insert into book values('aaa', 17, 5, 0);
insert into book values('aaa', 18, 6, 0);
insert into book values('aaa', 19, 1, 0);
insert into book values('aaa', 20, 2, 0);
insert into book values('aaa', 21, 3, 0);
insert into book values('aaa', 22, 4, 0);
insert into book values('aaa', 23, 5, 0);
insert into book values('aaa', 24, 6, 0);

select * from book;
delete from book_list where book_id = 1;
select book.wordNum, word, meaning, star 
from book, word where user_id = 'aaa' and book_id = 3 and book.wordnum = word.num;
drop table kind;
create table kind(
	kind_id number primary key,
	kind_name varchar2(50) not null
);

drop sequence kind_id_seq;
create sequence kind_id_seq;

insert into kind values(kind_id_seq.nextval, 'eng');
insert into kind values(kind_id_seq.nextval, 'jap');
insert into kind values(kind_id_seq.nextval, 'info');

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
create sequence grade_id;


drop table notice;
create table notice(    
	num number primary key,
	title varchar2(50) not null,   
	content varchar2(4000) not null,
	w_date date not null,
	writer varchar2(50) not null,
	
);

drop sequence notice_num;
create sequence notice_num;


drop table qna;
create table qna(    
	num number primary key,
	title varchar2(50) not null,   
	content varchar2(4000) not null,
	w_date date not null,
	writer varchar2(50) not null,
	ans varchar2(4000) not null
	read number default 0 not null
);

drop sequence qna_num;
create sequence qna_num;
