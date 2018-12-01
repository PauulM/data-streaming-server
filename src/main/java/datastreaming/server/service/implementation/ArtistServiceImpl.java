package datastreaming.server.service.implementation;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.model.Song;
import datastreaming.server.respository.AlbumRepository;
import datastreaming.server.respository.ArtistRepository;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.ArtistService;
import datastreaming.server.utils.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SearchService searchService;

    @Override
    public List<Artist> retrieveAll(Integer limit, Integer offset) {
        return artistRepository.findAll(searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public Artist retrieveArtistByName(String name) {
        return artistRepository.retrieveArtistByName(name);
    }

    @Override
    public Artist retrieveArtistById(Long id) throws ArtistNotFoundByIdException {
        Optional<Artist> artist = artistRepository.findById(id);
        if (!artist.isPresent())
            throw new ArtistNotFoundByIdException("Artist with id " + id + " does not exist", id);
        return artist.get();
    }

    @Override
    public List<Album> retrieveAlbumsByArtistId(Long artistId, Integer limit, Integer offset) throws ArtistNotFoundByIdException {
        Artist artist = retrieveArtistById(artistId);
        return albumRepository.findAlbumsByArtistId(artist.getId(), searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public List<Song> retrieveSongsByArtistId(Long artistId, Integer limit, Integer offset) throws ArtistNotFoundByIdException {
        Integer correctLimit = searchService.prepareLimit(limit);
        Integer correctOffset = searchService.prepareOffset(offset);
        List<Album> albums = retrieveAlbumsByArtistId(artistId, null, null);
        List<Song> artistSongs = new LinkedList<>();
        for (Album album : albums){
            artistSongs.addAll(songRepository.retrieveSongsByAlbumId(album.getId()));
            if(artistSongs.size() >= correctLimit + correctOffset)
                break;
        }
        if(artistSongs.size() <= correctOffset)
            return new ArrayList<>();
        if (artistSongs.size() < correctLimit + correctOffset)
            return artistSongs;
        return new ArrayList<>(artistSongs.subList(correctOffset, correctLimit + correctOffset));
    }

    @Override
    public List<Artist> searchArtistsByName(String queryString, Integer limit, Integer offset) {
        return artistRepository.searchArtistsByName(queryString, searchService.prepareLimit(limit), searchService.prepareOffset(offset));
    }

    @Override
    public List<Artist> searchArtistsByNameAccurate(String queryString) {
        return artistRepository.searchArtistsByNameAccurate(queryString);
    }
}
