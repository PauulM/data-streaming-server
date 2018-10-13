begin;

alter table clients add column accessTokenValidity integer not null default 3600;
comment on column clients.accessTokenValidity is 'Access token validity time [seconds]';


alter table clients add column refreshTokenValidity integer;
comment on column clients.refreshTokenValidity is 'Refresh token validity time [seconds]';

drop table if exists ClientGrantTypes;
create table ClientGrantTypes(
  id serial primary key,
  name varchar(200) unique not null
);

drop table if exists UsedClientGrantTypes;
create table UsedClientGrantTypes(
  clientId integer references clients(clientid),
  grantTypeId integer references ClientGrantTypes(id)
);

commit;