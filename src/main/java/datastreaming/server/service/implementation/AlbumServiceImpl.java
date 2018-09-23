package datastreaming.server.service.implementation;

import com.google.common.collect.Lists;
import datastreaming.server.model.Album;
import datastreaming.server.respository.AlbumRepository;
import datastreaming.server.service._interface.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> retrieveAll() {
        return Lists.newArrayList(albumRepository.findAll());
    }
}
