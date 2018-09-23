package datastreaming.server.service._interface;

import datastreaming.server.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> retrieveAll();
}
