package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.model.Artist;
import datastreaming.server.respository.ArtistRepository;
import datastreaming.server.service._interface.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> retrieveAll() {
        return Lists.newArrayList(artistRepository.findAll());
    }

    @Override
    public Artist retrieveArtistByName(String name) {
        return artistRepository.retrieveArtistByName(name);
    }
}
