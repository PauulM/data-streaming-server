package datastreaming.server.service._interface;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.model.Song;

import java.util.List;

public interface ArtistService {
    List<Artist> retrieveAll(Integer limit, Integer offset);
    Artist retrieveArtistByName(String name);
    Artist retrieveArtistById(Long id) throws ArtistNotFoundByIdException;
    List<Album> retrieveAlbumsByArtistId(Long artistId, Integer limit, Integer offset) throws ArtistNotFoundByIdException;
    List<Artist> searchArtistsByName(String queryString, Integer limit, Integer offset);
    List<Song> retrieveSongsByArtistId(Long artistId, Integer limit, Integer offset) throws ArtistNotFoundByIdException;
}
