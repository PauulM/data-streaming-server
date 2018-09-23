package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.model.Song;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> retrieveAll() {
        return Lists.newArrayList(songRepository.findAll());
    }
}
