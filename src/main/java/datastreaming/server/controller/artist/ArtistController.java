package datastreaming.server.controller.artist;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.model.Song;
import datastreaming.server.service._interface.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> getArtists(@RequestParam(value = "limit", required = false) Integer limit,
                                                      @RequestParam(value = "offset", required = false) Integer offset) {
        List<Artist> artists = artistService.retrieveAll(limit, offset);
        return ResponseEntity.status(200).body(artists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) throws ArtistNotFoundByIdException {
        return ResponseEntity.status(200).body(artistService.retrieveArtistById(id));
    }

    @GetMapping("/{id}/albums")
    public ResponseEntity<List<Album>> getArtistAlbums(
            @PathVariable Long id,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset) throws ArtistNotFoundByIdException {
        List<Album> albums = artistService.retrieveAlbumsByArtistId(id, limit, offset);
        return ResponseEntity.status(200).body(albums);
    }

    @GetMapping("{id}/songs")
    public ResponseEntity<List<Song>> getArtistSongs(
            @PathVariable Long id,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset) throws ArtistNotFoundByIdException {
        List<Song> songs = artistService.retrieveSongsByArtistId(id, limit, offset);
        return ResponseEntity.status(200).body(songs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Artist>> searchArtistsByName(
            @RequestParam(value = "query") String query,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset) {
        return ResponseEntity.status(200).body(artistService.searchArtistsByName(query, limit, offset));
    }
}
