<<<<<<< HEAD
create table bank(
id varchar(10),
name varchar(10),
age int,
tel varchar(15)
);

insert into bank values('AW','anna',19,'010-1111');
insert into bank values('BH','amy',22,'019-2222');
insert into bank values('CO','Jonh',12,'016-3333');
insert into bank values('DU','yoojin',34,'017-4444');
insert into bank values('EF','soo',69,'012-5555');
insert into bank values('FQ','tom',19,'017-6666');
insert into bank values('GA','ely',19,'011-7777');
insert into bank values('HN','nana',19,'010-8888');

select * from bank where id = '';

select * from bank;

update bank set tel = '' where id = '';

=======
create table bank(
id varchar(10),
name varchar(10),
age int,
tel varchar(15)
);

insert into bank values('AW','anna',19,'010-1111');
insert into bank values('BH','amy',22,'019-2222');
insert into bank values('CO','Jonh',12,'016-3333');
insert into bank values('DU','yoojin',34,'017-4444');
insert into bank values('EF','soo',69,'012-5555');
insert into bank values('FQ','tom',19,'017-6666');
insert into bank values('GA','ely',19,'011-7777');
insert into bank values('HN','nana',19,'010-8888');

select * from bank where id = '';

select * from bank;

update bank set tel = '' where id = '';

>>>>>>> branch 'master' of https://github.com/hn2441/bank.git
delete from bank where id = '';