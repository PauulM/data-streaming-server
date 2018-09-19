package datastreaming.server.service;

import datastreaming.server.model.Artist;

public interface ArtistService {
    Artist retrieveArtistByName(String name);
}
