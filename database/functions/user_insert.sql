create or replace function user_insert(
	username1 varchar, 
	password_hash varchar,
	authorities varchar
) returns integer as
$$
declare
	authorities_array text[];
	new_user_id integer;
	authority_id integer;
	i text;
begin
	authorities_array := string_to_array(authorities,',');
	
	insert into appusers values (default, username1, password_hash);
	select userid into new_user_id from appusers where username = username1;
	
	foreach i in array authorities_array
	loop
		select id into authority_id from userauthorities where name = i;
		insert into useduserauthorities values (authority_id,new_user_id);
	end loop;
	
	return new_user_id;
end;

$$
language plpgsql;