begin;

drop table if exists ClientScopes;
create table ClientScopes(
  id serial primary key,
  name varchar(200) unique not null
);

drop table if exists UsedClientScopes;
create table UsedClientScopes(
  clientId integer references clients(clientid),
  scopeId integer references ClientScopes(id)
);

commit;