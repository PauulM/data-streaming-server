package datastreaming.server.controller;

import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.model.Song;
import datastreaming.server.service._interface.AlbumService;
import datastreaming.server.service._interface.ArtistService;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    ArtistService artistService;

    @Autowired
    AlbumService albumService;

    @Autowired
    SongService songService;

    @GetMapping("/artist")
    public List<Artist> getAllArtists(){
        return artistService.retrieveAll();
    }

    @GetMapping("/album")
    public List<Album> getAllAlbums(){
        return albumService.retrieveAll();
    }

    @GetMapping("/song")
    public List<Song> getAllSongs(){
        return songService.retrieveAll();
    }
}