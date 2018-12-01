package datastreaming.server.service.implementation;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Song;
import datastreaming.server.respository.AlbumRepository;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.AlbumService;
import datastreaming.server.utils.FileUtil;
import datastreaming.server.utils.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public List<Album> retrieveAll(Integer limit, Integer offset) {
        return albumRepository.findAll(searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public Album retrieveAlbumById(Long id) throws AlbumNotFoundByIdException {
        Optional<Album> album = albumRepository.findById(id);
        if (!album.isPresent())
            throw new AlbumNotFoundByIdException("Album with id " + id + " does not exist", id);
        return album.get();
    }

    @Override
    public List<Song> retrieveAlbumSongs(Long albumId, Integer limit, Integer offset) throws AlbumNotFoundByIdException {
        Album album = retrieveAlbumById(albumId);
        if(limit == null) {
            return songRepository.retrieveSongsByAlbumId(albumId);
        }
        return songRepository.retrieveSongsByAlbumIdWithLimit(
                album.getId(), searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public List<Album> searchAlbumsByName(String queryString, Integer limit, Integer offset) {
        return albumRepository.searchAlbumsByName(
                queryString, searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public List<Album> searchAlbumsByNameAccurate(String queryString) {
        return albumRepository.searchAlbumsByNameAccurate(queryString);
    }

    @Override
    public byte[] getAlbumArtwork(Long id) throws AlbumNotFoundByIdException, IOException {
        Album album = retrieveAlbumById(id);
        if(album.getArtworkFilePath() == null)
            return new byte[0];
        return FileUtil.loadFile(album.getArtworkFilePath());
    }
}
