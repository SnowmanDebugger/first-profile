select * from teacher where department ='计算机系';

select * from course where t_no in (select no from teacher where department ='计算机系');

select * from score where c_no in (select no from course where t_no in (select no from teacher where department ='计算机系'));

select score.s_no,student.name as student_name,score.c_no,course.name as course_name, from score,course,student where c_no in (select no from course where t_no in (select no from teacher where department ='计算机系'));


select * from teacher where department ='电子工程系' and profession not in (select profession from teacher where department='计算机系')
union
select * from teacher where department ='计算机系' and profession not in (select profession from teacher where department='电子工程系');


select degree from score where c_no ='3-245';

select * from score 
where c_no ='3-105' 
and degree > any (select degree from score where c_no ='3-245')
order by degree desc;


select name,sex,birthday from teacher
union
select name,sex,birthday from student;

select name,sex,birthday from teacher where sex='女'
union
select name,sex,birthday from student where sex='女';



select c_no,avg(degree) from score group by c_no;

select * from score a where degree<(select avg(degree) from score b where a.c_no =b.c_no);

select t_no from course;

select name,department from teacher where no in (select t_no from course);



select class from student where sex ='男' group by class having count(*)>1;


select * from student where name not like '王%';


select name,year(now())-year(birthday) as '年龄' from student;


select max(birthday) as '最大',min(birthday) as '最小' from student;


select * from student order by class desc,birthday ;


select no from teacher where sex='男';

select teacher.name as teacher_name, course.name as course_name from course,teacher where t_no in (select teacher.no from teacher where sex='男');

select * from score where degree =(select max(degree) from score);


select sex from student where name ='李军';

select name from student where sex =(select sex from student where name ='李军');

select class from student where name ='李军';

select name from student where sex=(select sex from student where name ='李军') and class =(select class from student where name ='李军');


select no from course where name='计算机导论';
select no from student where sex='男';

select * from score where c_no in (select no from course where name='计算机导论') and s_no in (select no from student where sex='男');


select * from person inner join card on person.cardid=card.id;

select * from person left join card on person.cardid=card.id;

select * from person right join card on person.cardid=card.id;

select * from person full join card on person.cardid=card.id;  #mysql不支持full join

select * from person left join card on person.cardid=card.id
union
select * from person right join card on person.cardid=card.id;  #通过这种方式实现 full join

set autocommit=0;
select @@autocommit;查询自动提交

update user set money=money-100 where name='a';
update user set money=money+100 where name='b';

begin; 或者 start transaction; #手动开启一个事务

begin;
update user set money=money-100 where name='a';
update user set money=money+100 where name='b';

start transaction;
update user set money=money-100 where name='a';
update user set money=money+100 where name='b';
#可以用commit结束当前事务
commit;


事务的四大特征:
A 原子性:事务是最小的单位，不可以再分割；
C 一致性:要求同一事务中的 SQL 语句，必须保证同时成功或者失败；
I 隔离性:事务1 和 事务2 之间是具有隔离性的；
D 持久性:事务一旦结束 ( COMMIT ) ，就不可以再返回了 ( ROLLBACK ) 。

事务开启:
1,修改默认提交 set autocommit=0;
2. begin;
3. start transaction;
事务手动提交:
commit;
事务手动回滚:
rollback;

start transaction;
update user set money= money-800 where name='小明';
update user set money= money+800 where name='淘宝店';

read uncommitted 读取未提交
在read uncommitted 会出现所谓的脏读，一个事务读取到另外一个事务还未提交的数据。这在实际开发中是不允许出现的。

read uncommitted 读取未提交
read committed 读取已提交
repeatable read 可被重复读
serializable 串行化

查看方式:  select @@global.transaction_isolation;

set global transaction isolation level read committed;

read committed 会出现读取同一个表格的数据，发现前后不一致； 不可重复读的现象

repeatable read 会出现事务a和事务b 同时操作一张表，事务a提交的数据，也不能被事务b读到，就可以造成幻读。

serializable 意思就是:假设把所有的事务都放在一个串行的队列中，那么所有的事务都会按照固定顺序执行，执行完一个事务后再继续执行下一个事务的写入操作 ( 这意味着队列中同时只能执行一个事务的写入操作 )
根据这个解释，小王在插入数据时，会出现等待状态，直到小张执行 COMMIT 结束它所处的事务，或者出现等待超时。

串行化的问题是，性能特别差 性能: read uncommitted>read committed>repeatable read >serializable;  隔离级别越高，性能越差

mysql 的默认隔离级别是 repeatable read