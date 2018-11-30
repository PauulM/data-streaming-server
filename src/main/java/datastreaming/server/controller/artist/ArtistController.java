package datastreaming.server.controller.artist;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
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
    public ResponseEntity<List<Artist>> getAllArtists(){
        List<Artist> artists = artistService.retrieveAll();
        return ResponseEntity.status(200).body(artists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) throws ArtistNotFoundByIdException {
        return ResponseEntity.status(200).body(artistService.retrieveArtistById(id));
    }

    @GetMapping("/{id}/albums")
    public ResponseEntity<List<Album>> getArtistAlbums(@PathVariable Long id) throws ArtistNotFoundByIdException{
        List<Album> albums = artistService.retrieveAlbumsByArtistId(id);
        return ResponseEntity.status(200).body(albums);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Artist>> searchArtistsByName(
            @RequestParam(value = "query") String query,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset){
        return ResponseEntity.status(200).body(artistService.searchArtistsByName(query, limit, offset));
    }
}
