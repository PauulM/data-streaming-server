begin;

alter table songs drop column if exists format;
alter table songs drop column if exists creationdate;

commit;