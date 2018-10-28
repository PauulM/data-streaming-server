package datastreaming.server.controller.album;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Song;
import datastreaming.server.service._interface.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums(){
        return ResponseEntity.status(200).body(albumService.retrieveAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) throws AlbumNotFoundByIdException {
        return ResponseEntity.status(200).body(albumService.retrieveAlbumById(id));
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<List<Song>> getAlbumSongs(@PathVariable Long id) throws AlbumNotFoundByIdException{
        return ResponseEntity.status(200).body(albumService.retrieveAlbumSongs(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Album>> searchAlbumsByName(
            @RequestParam(value = "query") String query){
        return ResponseEntity.status(200).body(albumService.searchAlbumsByName(query));
    }
}
