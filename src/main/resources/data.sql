create table user(
id number,
name varchar(50),
age number
);

insert into user values(1,'Abc',34);


create table movie (
name varchar(100),
movie_id   number,
release_date date,
duration number,
star_cast varchar(1000)
); 

create table theatre (
name varchar(100),
theatre_id   number,
city_id number,
address varchar(500),
phone number,
operational char(1)
); 



create table state (
name varchar(100),
id   number
); 


create table city (
name varchar(100),
city_id   number,
state_id number
); 


create table theatre_shows(
theatre_show_id number,
theatre_id number,
show_time number,
show_date date,
operational char(1),
movie_id number,
city_id number
);




create table theatre_seat(
 id number,
 theatre_id number,
 seat_number number,
 operational char(1)
);

create table theatre_show_seat(
 id number,
 theatre_seat_id number,
 theatre_show_id number,
 occupied_status char(1)
);

create table booking(
booking_id number,
booking_date date,
user_id number,
movie_show_id number,
theatre_show_seat_id number
);


insert into state values('uttarakhand',1);
insert into city values('rishikesh',1,1);
insert into movie values('pushpa',1,null,120,'allu arjun');
insert into movie values('godfather',2,null,120,'XYZ');
insert into theatre values('SRS',1,1,'koyal ghati','123456','Y');
insert into theatre_shows values(1,1,1200,sysdate,'Y',1,1);
insert into theatre_shows values(2,1,0300,sysdate,'Y',1,1);
commit;