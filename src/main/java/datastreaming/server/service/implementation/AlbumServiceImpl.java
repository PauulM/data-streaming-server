package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Song;
import datastreaming.server.respository.AlbumRepository;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.AlbumService;
import datastreaming.server.utils.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SearchService searchService;

    @Override
    public List<Album> retrieveAll() {
        return Lists.newArrayList(albumRepository.findAll());
    }

    @Override
    public Album retrieveAlbumById(Long id) throws AlbumNotFoundByIdException {
        Optional<Album> album = albumRepository.findById(id);
        if (!album.isPresent())
            throw new AlbumNotFoundByIdException("Album with id " + id + " does not exist", id);
        return album.get();
    }

    @Override
    public List<Song> retrieveAlbumSongs(Long albumId) throws AlbumNotFoundByIdException {
        Album album = retrieveAlbumById(albumId);
        return songRepository.retrieveSongsByAlbumId(album.getId());
    }

    @Override
    public List<Album> searchAlbumsByName(String queryString, Integer limit, Integer offset) {
        return albumRepository.searchAlbumsByName(queryString, searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }
}
