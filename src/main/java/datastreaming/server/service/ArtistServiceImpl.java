package datastreaming.server.service;

import datastreaming.server.model.Artist;
import datastreaming.server.respository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Override
    public Artist retrieveArtistByName(String name) {
        return artistRepository.retrieveArtistByName(name);
    }
}
