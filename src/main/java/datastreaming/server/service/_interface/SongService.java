package datastreaming.server.service._interface;

import datastreaming.server.model.Song;

import java.util.List;

public interface SongService {
    List<Song> retrieveAll();
}
