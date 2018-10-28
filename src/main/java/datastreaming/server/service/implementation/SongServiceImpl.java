package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.model.Song;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> retrieveAll() {
        return Lists.newArrayList(songRepository.findAll());
    }

    @Override
    public Song retrieveSongById(Long id) throws SongNotFoundByIdException {
        Optional<Song> song = songRepository.findById(id);
        if(!song.isPresent())
            throw new SongNotFoundByIdException("Song with id " + id + " does not exist", id);
        return song.get();
    }
}
