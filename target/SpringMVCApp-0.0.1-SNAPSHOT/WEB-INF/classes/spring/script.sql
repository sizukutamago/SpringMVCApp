create table mymemodata (
    id integer primary key auto_increment,
    title varchar(100) not null ,
    content varchar(255)
);

insert into mymemodata (title, content) values ('hello!', 'this is sample message');
insert into mymemodata (title, content) values ('welcome', 'welcome spring mvc');