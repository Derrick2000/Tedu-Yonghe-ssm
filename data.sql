set names gbk;
drop database if exists yonghedb;
create database if not exists yonghedb;
use yonghedb;
drop table if exists tb_order;
drop table if exists tb_door;
create table tb_door(
	id int primary key auto_increment,
	name varchar(100),
	tel varchar(100),
	addr varchar(255)
);

insert into tb_door values('1', 'PizzaHut(LA)', '113-332-3333', 'Staple Center');
insert into tb_door values('2', 'DoorDash(NY)', '434-222-4214', 'Madison');
insert into tb_door values('3', 'McDonalds(FL)', '414-222-4142', 'Disney');


create table tb_order(
	id int(11) primary key auto_increment,
	door_id int(11),
	order_no varchar(50),
	order_type varchar(50),
	pnum int,
	cashier varchar(50),
	order_time timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	pay_time timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	pay_type varchar(50),
	price double,
	foreign key(door_id) REFERENCES tb_door(id)
);


INSERT INTO tb_order VALUES ('1', '1', 'P001', 'For here', '1', 'Derrick', '2018-04-26 14:49:07', '2018-04-26 14:50:38', 'APPLE PAY', '16.00');
INSERT INTO tb_order VALUES ('2', '1', 'P003', 'TO GO', '3', 'Thomas', '2018-04-27 13:34:07', '2018-04-27 13:34:38', 'Credit Card', '20.00');
INSERT INTO tb_order VALUES ('3', '1', 'P005', 'For here', '1', 'LYF', '2019-01-22 11:59:22', '2019-01-22 11:59:22', 'Credit Card', '28.00');
INSERT INTO tb_order VALUES ('4', '1', 'P007', 'TO GO', '1', 'Wendy', '2019-01-23 13:01:26', '2019-01-23 13:01:26', 'APPLE PAY', '49.00');
