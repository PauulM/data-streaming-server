package datastreaming.server.controller.song;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.model.Song;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) throws SongNotFoundByIdException {
        return ResponseEntity.status(200).body(songService.retrieveSongById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Song>> searchSongsByName(
            @RequestParam(value = "query") String query){
        return ResponseEntity.status(200).body(songService.searchSongsByName(query));
    }
}
