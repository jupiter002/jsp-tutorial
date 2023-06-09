select * from member where id = 'a';

drop table member;


create table member(                                  --��� ���̺�ȿ� �÷���
    id               varchar2(100) unique not null,   --�ߺ�����  
    --�÷���          ������Ÿ��      ��������                                   
    name             varchar2(100) not null,
    -- name          varchar2(100)primary key,        --�ߺ�����
    password         VARCHAR2(100) not null,          --�ݵ�� �Է¹޾ƾ� �ϴ� ������ not null�� �־��ٰ�    
    email            VARCHAR2(100) not null,
    zonecode         NUMBER(5)not null,
    address          VARCHAR2(500)not null,
    detailaddress    VARCHAR2(100),
    extraaddress     VARCHAR2(100)
    );  

--crud - Create Read Update Delete
insert into member (id,name,password) values ('jupiter002','������','1234');
insert into member (id,name,password) values ('hong','ȫ�浿','5678');
delete from member ;
commit;
rollback;

--transaction: 
select count(*) as count from member where id = '';     --count ���ǿ� �´� ���� ����� �����ִ� �Լ�

select id from member;          -- id�� ��ȸ  
select * from member;           -- ��� �÷����� �� ��ȸ

delete from member where id = 'a';

update member set name = '������',email = 'jupiter002@naver.com' where id = 'jupiter002' and password = '1234';

update member set password = '1234' where id 'jupiter002' and password = '12';

//�ڵ����� auto increament my sql
create table board(
    id      number primary key,
    name    varchar2(100) not null,
    title   varchar2(300) not null,
    contents   varchar2(3000) not null,
    regdate date default sysdate,
    hit     number

);
insert into board values (seq_board.nextval,'������','������ ���ϴ�','������ ���ϴ�.',sysdate,0);
rollback;
select * from board;

