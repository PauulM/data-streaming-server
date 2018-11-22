begin;

DO $$
BEGIN
  BEGIN
    ALTER TABLE songs ADD COLUMN manifestFilePath varchar(255);
    EXCEPTION
    WHEN duplicate_column THEN RAISE NOTICE 'column manifestFilePath already exists in songs';
  END;
END $$;

DO $$
BEGIN
  BEGIN
    ALTER TABLE songs ADD COLUMN segmentsNumber integer;
    EXCEPTION
    WHEN duplicate_column THEN RAISE NOTICE 'column segmentsNumber already exists in songs';
  END;
END $$;

DO $$
BEGIN
  BEGIN
    ALTER TABLE songs ADD COLUMN segmentFilePrefix varchar(255);
    EXCEPTION
    WHEN duplicate_column THEN RAISE NOTICE 'column segmentFilePrefix already exists in songs';
  END;
END $$;

commit;