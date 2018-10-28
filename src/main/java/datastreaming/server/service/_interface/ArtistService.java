package datastreaming.server.service._interface;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> retrieveAll();
    Artist retrieveArtistByName(String name);
    Artist retrieveArtistById(Long id) throws ArtistNotFoundByIdException;
}
