begin;

alter table songs drop column if exists genres;
alter table songs drop column if exists creationdate;

commit;