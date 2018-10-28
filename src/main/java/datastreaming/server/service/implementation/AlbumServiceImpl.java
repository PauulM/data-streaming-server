package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.respository.AlbumRepository;
import datastreaming.server.service._interface.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> retrieveAll() {
        return Lists.newArrayList(albumRepository.findAll());
    }

    @Override
    public Album retrieveAlbumById(Long id) throws AlbumNotFoundByIdException {
        Optional<Album> album = albumRepository.findById(id);
        if(!album.isPresent())
            throw new AlbumNotFoundByIdException("Album with id " + id + " does not exist", id);
        return album.get();
    }
}
