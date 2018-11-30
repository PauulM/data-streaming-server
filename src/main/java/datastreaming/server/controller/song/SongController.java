package datastreaming.server.controller.song;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.model.Song;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> getSongs(@RequestParam(value = "limit", required = false) Integer limit,
                                                  @RequestParam(value = "offset", required = false) Integer offset) {
        return ResponseEntity.status(200).body(songService.retrieveAll(limit, offset));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) throws SongNotFoundByIdException {
        return ResponseEntity.status(200).body(songService.retrieveSongById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Song>> searchSongsByName(
            @RequestParam(value = "query") String query,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset) {
        return ResponseEntity.status(200).body(songService.searchSongsByName(query, limit, offset));
    }
}
