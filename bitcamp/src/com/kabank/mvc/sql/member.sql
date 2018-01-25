select * from tab;
select * from member;
select * from kakao;
select * from telecom;

select * from member where id like 'aaaa';
update member set addr = '서울' where id = 'aaaa';

drop sequence customer_num;
create sequence customer_num start with 1000;
create table kakao(
	customer_num int primary key,
	account_num varchar2(20) not null,
	money varchar2(20) default 0,
	id varchar2(20),
	foreign key (id) references member(id) on delete cascade
);

insert into kakao(customer_num, account_num, money, id) 
values(customer_num.nextval , '1234-5678-1234',0,'eeee');

delete from kakao where customer_num=1001;

select 
	m.id as 아이디,
	m.pass as 비번,
	m.name as 이름,
	m.ssn as 주민번호,
	m.phone as 전화번호,
	m.email as 이메일,
	m.profile as 프사,
	m.addr as 주소,
	k.customer_num as cusmtomNum,
	k.account_num as 계좌번호,
	k.money as 잔액
from member m, kakao k 
where m.id = k.id 
order by k.customer_num



