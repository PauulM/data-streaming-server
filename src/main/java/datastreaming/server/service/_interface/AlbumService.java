package datastreaming.server.service._interface;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Song;

import java.io.IOException;
import java.util.List;

public interface AlbumService {
    List<Album> retrieveAll(Integer limit, Integer offset);
    Album retrieveAlbumById(Long id) throws AlbumNotFoundByIdException;
    List<Song> retrieveAlbumSongs(Long albumId, Integer limit, Integer offset) throws AlbumNotFoundByIdException;
    List<Album> searchAlbumsByName(String queryString, Integer limit, Integer offset);
    List<Album> searchAlbumsByNameAccurate(String queryString);
    byte[] getAlbumArtwork(Long id) throws AlbumNotFoundByIdException, IOException;
}
