package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.respository.AlbumRepository;
import datastreaming.server.respository.ArtistRepository;
import datastreaming.server.service._interface.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Artist> retrieveAll() {
        return Lists.newArrayList(artistRepository.findAll());
    }

    @Override
    public Artist retrieveArtistByName(String name) {
        return artistRepository.retrieveArtistByName(name);
    }

    @Override
    public Artist retrieveArtistById(Long id) throws ArtistNotFoundByIdException {
        Optional<Artist> artist = artistRepository.findById(id);
        if (!artist.isPresent())
            throw new ArtistNotFoundByIdException("Artist with id " + id + " does not exist", id);
        return artist.get();
    }

    @Override
    public List<Album> retrieveAlbumsByArtistId(Long artistId) throws ArtistNotFoundByIdException {
        Artist artist = retrieveArtistById(artistId);
        return albumRepository.findAlbumsByArtistId(artist.getId());
    }
}
