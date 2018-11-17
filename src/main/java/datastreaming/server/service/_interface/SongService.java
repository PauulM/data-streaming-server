package datastreaming.server.service._interface;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.model.Song;

import java.util.List;

public interface SongService {
    List<Song> retrieveAll();
    Song retrieveSongById(Long id) throws SongNotFoundByIdException;
    List<Song> searchSongsByName(String queryString, Integer limit, Integer offset);
}
