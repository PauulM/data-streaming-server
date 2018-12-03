package datastreaming.server.service.implementation;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.model.Song;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.SongService;
import datastreaming.server.utils.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SearchService searchService;

    @Override
    public List<Song> retrieveAll(Integer limit, Integer offset) {
        return songRepository.findAll(searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    @Cacheable("songs")
    public Song retrieveSongById(Long id) throws SongNotFoundByIdException {
        Optional<Song> song = songRepository.findById(id);
        if(!song.isPresent())
            throw new SongNotFoundByIdException("Song with id " + id + " does not exist", id);
        return song.get();
    }

    @Override
    public List<Song> searchSongsByName(String queryString, Integer limit, Integer offset) {
        return songRepository.searchSongsByName(queryString, searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public List<Song> searchSongsByNameAccurate(String queryString) {
        return songRepository.searchSongsByNameAccurate(queryString);
    }
}
