### Jsp 모델2 블로그 프로젝트

## Mysql 사용자 생성
```sql
CREATE USER cos IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO cos;
GRANT CREATE TABLESPACE TO cos;
GRANT CREATE TABLE TO cos;
GRANT CREATE SEQUENCE TO cos;
GRANT select, insert, delete, update ON cos.player TO cos;
alter user cos default tablespace users quota unlimited on users;
```

## 테이블
```Mysql   
CREATE TABLE users(
	id int primary key,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null,
    address varchar(100) not null,
    userProfile varchar(200),
    userRole varchar(20),
    createDate timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE board(
	id int primary key,
    userId int,
    title varchar(100) not null,
    content tinyblob,
    readCount int default 0,
    createDate timestamp,
    foreign key (userId) references users (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE reply(
	id int primary key,
    userId int,
    boardId int,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




## 페이징 쿼리
```My sql
		SELECT /*+ INDEX_DESC(BOARD SYS_C007779)*/ id, userId, title, content, readCount, createDate 
		FROM board 	
		LIMIT 3 OFFSET ? ;
```
```Oracle
		SELECT /*+ INDEX_DESC(BOARD SYS_C007779)*/ id, userId, title, content, readCount, createDate 
		FROM board
		OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY;
