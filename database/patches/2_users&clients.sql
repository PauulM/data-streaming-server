begin;

drop table if exists appUsers;
create table appUsers(
  userId serial primary key,
  userName varchar(100) not null,
  password varchar(255) not null
);

drop table if exists clients;
create table clients(
  clientId serial primary key,
  clientName varchar(100) not null,
  clientSecret varchar(255) not null
);

commit;