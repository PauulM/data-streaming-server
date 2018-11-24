ALTER TABLE albums
DROP COLUMN albumartworkfilepath;
ALTER TABLE albums
ADD albumartwork bytea;
