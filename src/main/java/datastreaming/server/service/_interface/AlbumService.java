package datastreaming.server.service._interface;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Song;

import java.util.List;

public interface AlbumService {
    List<Album> retrieveAll();
    Album retrieveAlbumById(Long id) throws AlbumNotFoundByIdException;
    List<Song> retrieveAlbumSongs(Long albumId) throws AlbumNotFoundByIdException;
    List<Album> searchAlbumsByName(String queryString, Integer limit, Integer offset);
}
