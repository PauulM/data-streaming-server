begin;

alter table appUsers add unique (userName);
drop table if exists userAuthorities;
create table userAuthorities(
  id serial primary key,
  name varchar (200) unique not null
);
drop table if exists usedUserAuthorities;
create table usedUserAuthorities(
  userAuthorityId integer references userAuthorities(id),
  appUserId integer references appUsers(userId)
);

alter table clients add unique (clientName);
drop table if exists clientAuthorities;
create table clientAuthorities(
  id serial primary key,
  name varchar (200) unique not null
);
drop table if exists usedClientAuthorities;
create table usedClientAuthorities(
  clientAuthorityId integer references clientAuthorities(id),
  clientId integer references clients(clientId)
);

commit;