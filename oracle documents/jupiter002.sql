select * from member where id = 'a';

drop table member;


create table member(                                  --��� ���̺�ȿ� �÷���
    id               varchar2(100) unique not null,   --�ߺ�����  
    --�÷���          ������Ÿ��      ��������                                   
    name             varchar2(100) not null,
    -- name          varchar2(100)primary key,        --�ߺ�����
    password         NUMBER(38) not null,          --�ݵ�� �Է¹޾ƾ� �ϴ� ������ not null�� �־��ٰ�    
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

