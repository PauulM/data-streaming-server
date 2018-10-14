create or replace function client_insert(
	client_name varchar, 
	secret_hash varchar, 
	access_token_val integer, 
	refresh_token_val integer, 
	grant_types varchar,
	scopes varchar,
	authorities varchar
) returns integer as
$$
declare
	grant_types_array text[];
	scopes_array text[];
	authorities_array text[];
	new_client_id integer;
	grant_type_id integer;
	scope_id integer;
	authority_id integer;
	i text;
begin
	grant_types_array := string_to_array(grant_types,',');
	scopes_array := string_to_array(scopes,',');
	authorities_array := string_to_array(authorities,',');
	
	insert into clients values (default, client_name, secret_hash, access_token_val, refresh_token_val);
	select clientid into new_client_id from clients where clientname = client_name;
	
	foreach i in array grant_types_array
	loop
		select id into grant_type_id from clientgranttypes where name = i;
		insert into usedclientgranttypes values (new_client_id, grant_type_id);
	end loop;
	
	foreach i in array scopes_array
	loop
		select id into scope_id from clientscopes where name = i;
		insert into usedclientscopes values (new_client_id, scope_id);
	end loop;
	
	foreach i in array authorities_array
	loop
		select id into authority_id from clientauthorities where name = i;
		insert into usedclientauthorities values (authority_id,new_client_id);
	end loop;
	
	return new_client_id;
end;

$$
language plpgsql;