package datastreaming.server.controller.artist;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Artist;
import datastreaming.server.service._interface.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    private ResponseEntity<List<Artist>> getAllArtists(){
        List<Artist> artists = artistService.retrieveAll();
        return ResponseEntity.status(200).body(artists);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Artist> getArtistById(@PathVariable Long id) throws ArtistNotFoundByIdException {
        return ResponseEntity.status(200).body(artistService.retrieveArtistById(id));
    }
}
