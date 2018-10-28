package datastreaming.server.service._interface;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> retrieveAll();
    Album retrieveAlbumById(Long id) throws AlbumNotFoundByIdException;
}
