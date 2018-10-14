BEGIN;


CREATE SCHEMA IF NOT EXISTS streaming_schema;
SET search_path TO streaming_schema;

DROP TABLE IF EXISTS Songs;
DROP TABLE IF EXISTS Albums;
DROP TABLE IF EXISTS Artists;


CREATE TABLE Artists(
	artistId SERIAL PRIMARY KEY,
	artistName VARCHAR(100) UNIQUE NOT NULL,
	artistPath VARCHAR(255) UNIQUE NOT NULL,
	artistArtworkFilePath VARCHAR(255)
);

COMMENT ON COLUMN Artists.artistPath IS 'absolute path to artist folder';
COMMENT ON COLUMN Artists.artistArtworkFilePath IS 'absolute path to artist artwork file';


CREATE TABLE Albums(
	albumId SERIAL PRIMARY KEY,
	artistId INTEGER REFERENCES Artists(artistId),
	albumName VARCHAR(200) NOT NULL,
	albumYear CHAR(4) NOT NULL,
	publisher VARCHAR(100),
	albumArtworkFilePath VARCHAR(255),
	albumPath VARCHAR(255)
);

COMMENT ON COLUMN Albums.albumArtworkFilePath IS 'absolute path to album artwork file';
COMMENT ON COLUMN Albums.albumPath IS 'absolute path to album folder';



CREATE TABLE Songs(
	songId SERIAL PRIMARY KEY,
	albumId INTEGER REFERENCES Albums(albumId),
	songName varchar(200) NOT NULL,
	songFilePath varchar(255) NOT NULL,
	songNo INTEGER NOT NULL,
	length VARCHAR (10) NOT NULL,
	quality CHAR (3) NOT NULL,
	genres VARCHAR (100) NOT NULL,
	format VARCHAR (10) NOT NULL,
	size DECIMAL NOT NULL,
	creationDate DATE
);

COMMENT ON COLUMN Songs.songFilePath IS 'absolute path to song file';
COMMENT ON COLUMN Songs.length IS 'song length in format m:ss';
COMMENT ON COLUMN Songs.quality IS 'bitrate in format xxx, which stand for kbps, f.e. 320 or 128';
COMMENT ON COLUMN Songs.genres IS 'comma separated song genres f.e. rock,metal,alternative,pop';
COMMENT ON COLUMN Songs.format IS 'f.e. "mp3" or "flac"';
COMMENT ON COLUMN Songs.size IS 'the size of the song in MBs f.e. 10.05 or 20.92';


COMMIT;