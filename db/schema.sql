create table posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now()
);
insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');
create table users (
id serial primary key,
login varchar(200),
password varchar(2000),
role varchar (20)
);
insert into users (login, password, role) values ('admin', '123', 'ADMIN');
insert into users (login, password, role) values ('user', '123', 'USER');