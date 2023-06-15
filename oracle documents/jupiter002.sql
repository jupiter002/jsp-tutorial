select * from member where id = 'a';

drop table member;


create table member(                                  --멤버 테이블안에 컬럼들
    id               varchar2(100) unique not null,   --중복방지  
    --컬럼명          데이터타입      제약조건                                   
    name             varchar2(100) not null,
    -- name          varchar2(100)primary key,        --중복방지
    password         VARCHAR2(100) not null,          --반드시 입력받아야 하는 값에는 not null을 넣어줄것    
    email            VARCHAR2(100) not null,
    zonecode         NUMBER(5)not null,
    address          VARCHAR2(500)not null,
    detailaddress    VARCHAR2(100),
    extraaddress     VARCHAR2(100)
    );  

--crud - Create Read Update Delete
insert into member (id,name,password) values ('jupiter002','김지훈','1234');
insert into member (id,name,password) values ('hong','홍길동','5678');
delete from member ;
commit;
rollback;

--transaction: 
select count(*) as count from member where id = '';     --count 조건에 맞는 값이 몇개인지 세어주는 함수

select id from member;          -- id만 조회  
select * from member;           -- 모든 컬럼명을 다 조회

delete from member where id = 'a';

update member set name = '정형돈',email = 'jupiter002@naver.com' where id = 'jupiter002' and password = '1234';

update member set password = '1234' where id 'jupiter002' and password = '12';

//자동증가 auto increament my sql
create table board(
    id          number primary key,     --글의 고유번호
    userId      varchar2(100),          --member id를 통한 조회
    name        varchar2(100) not null, -- 게시판에서의 이름
    title       varchar2(300) not null,
    contents    varchar2(3000) not null,
    regdate     date default sysdate,
    hit         number,
    constraint  fk_userid foreign key(userId) references member (id)        --costraint: 제약
    --  constraint  사용자지정 이름 foreign key(현재테이블의 컬럼명) references member (외부에서 가져올 컬럼명)
);
drop table board;

DECLARE
NUM1 NUMBER :=1;

BEGIN
    LOOP
    INSERT INTO board VALUES (seq_board.nextval,'qw','흐엉','제목입니다','내용입니다',sysdate,0);
    NUM1 := NUM1+1; --NUM = NUM +1
    EXIT WHEN NUM1 >10; --NUM1이 10보다 크면 LOOP종료
    END LOOP;
END;

insert into board values (seq_board.nextval,'qw','흐엉','제목입니다','내용입니다',sysdate,0);



rollback;
select * from board where id;

update board set hit =hit+1; where id = 14;


select * from board id desc where id > 90 and id < 105;

--서브쿼리
select * from
    (select rownum, as no, b.* from
        (select * from board order by id desc) b) where no >= and no <= 10;     -- (~~테이블 생성) -- order by 정렬 명령어, desc 내림차순 정렬