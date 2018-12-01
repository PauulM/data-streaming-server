package datastreaming.server.utils;

import datastreaming.server.dto.SearchDTO;
import datastreaming.server.dto.SearchLimitOffsetDTO;
import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.model.Song;
import datastreaming.server.service._interface.AlbumService;
import datastreaming.server.service._interface.ArtistService;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SongService songService;

    private final Integer MAX_SEARCH_RESULTS = 50;

    @Override
    public SearchDTO searchEverything(String queryString, SearchLimitOffsetDTO searchLimitOffsetDTO) throws ArtistNotFoundByIdException, AlbumNotFoundByIdException {
        List<Artist> artists = artistService.searchArtistsByNameAccurate(queryString);
        List<Album> albums = albumService.searchAlbumsByNameAccurate(queryString);
        List<Song> songs = songService.searchSongsByNameAccurate(queryString);

        addResultsConnectedToAccurateSearch(artists, albums, songs);

        List<Artist> artistsMatchingPattern = artistService.searchArtistsByName(queryString, null, null);
        List<Album> albumsMatchingPattern = albumService.searchAlbumsByName(queryString, null, null);
        List<Song> songsMatchingPattern = songService.searchSongsByName(queryString, null, null);

        addMatchingPatternResults(artistsMatchingPattern, albumsMatchingPattern, songsMatchingPattern);

        artists.addAll(artistsMatchingPattern);
        albums.addAll(albumsMatchingPattern);
        songs.addAll(songsMatchingPattern);

        SearchDTO searchDTO = new SearchDTO(
                reduceArtistsWithLimitAndOffset(artists,
                        prepareLimit(searchLimitOffsetDTO.getArtistLimit()), prepareOffset(searchLimitOffsetDTO.getArtistOffset())),
                reduceAlbumsWithLimitAndOffset(albums,
                        prepareLimit(searchLimitOffsetDTO.getAlbumLimit()), prepareOffset(searchLimitOffsetDTO.getAlbumOffset())),
                reduceSongsWithLimitAndOffset(songs,
                        prepareLimit(searchLimitOffsetDTO.getSongLimit()), prepareOffset(searchLimitOffsetDTO.getSongOffset()))
        );
        return searchDTO;
    }

    private void addResultsConnectedToAccurateSearch(List<Artist> artists, List<Album> albums, List<Song> songs) throws ArtistNotFoundByIdException, AlbumNotFoundByIdException {
        addResultsConnectedToAccurateArtists(artists, albums, songs);
        addResultsConnectedToAccurateAlbums(artists, albums, songs);
        addResultsConnectedToAccurateSongs(artists, albums, songs);
    }

    private void addResultsConnectedToAccurateSongs(List<Artist> artists, List<Album> albums, List<Song> songs) {
        for (Song song : songs) {
            artists.add(song.getAlbum().getArtist());
            albums.add(song.getAlbum());
        }
    }

    private void addResultsConnectedToAccurateAlbums(List<Artist> artists, List<Album> albums, List<Song> songs) throws AlbumNotFoundByIdException {
        for (Album album : albums) {
            artists.add(album.getArtist());
            songs.addAll(albumService.retrieveAlbumSongs(album.getId(), null, null));
        }
    }

    private void addResultsConnectedToAccurateArtists(List<Artist> artists, List<Album> albums, List<Song> songs) throws ArtistNotFoundByIdException {
        for (Artist artist : artists) {
            albums.addAll(artistService.retrieveAlbumsByArtistId(artist.getId(), null, null));
            songs.addAll(artistService.retrieveSongsByArtistId(artist.getId(), null, null));
        }
    }

    private void addMatchingPatternResults(List<Artist> artistsMatchingPattern, List<Album> albumsMatchingPattern, List<Song> songsMatchingPattern) throws ArtistNotFoundByIdException, AlbumNotFoundByIdException {
        for (Artist artist : artistsMatchingPattern) {
            albumsMatchingPattern.addAll(artistService.retrieveAlbumsByArtistId(artist.getId(), null, null));
            songsMatchingPattern.addAll(artistService.retrieveSongsByArtistId(artist.getId(), null, null));
        }

        for (Album album : albumsMatchingPattern) {
            artistsMatchingPattern.add(album.getArtist());
            songsMatchingPattern.addAll(albumService.retrieveAlbumSongs(album.getId(), null, null));
        }

        for (Song song : songsMatchingPattern) {
            artistsMatchingPattern.add(song.getAlbum().getArtist());
            albumsMatchingPattern.add(song.getAlbum());
        }
    }

    private List<Artist> reduceArtistsWithLimitAndOffset(List<Artist> artists, Integer correctLimit, Integer correctOffset) {
        List<Artist> result = artists.stream().distinct().collect(Collectors.toList());
        if(result.size() <= correctOffset)
            return new ArrayList<>();
        if (result.size() < correctLimit + correctOffset)
            return result;
        return new ArrayList<>(result.subList(correctOffset, correctLimit + correctOffset));
    }

    private List<Album> reduceAlbumsWithLimitAndOffset(List<Album> albums, Integer correctLimit, Integer correctOffset) {
        List<Album> result = albums.stream().distinct().collect(Collectors.toList());
        if(result.size() <= correctOffset)
            return new ArrayList<>();
        if (result.size() < correctLimit + correctOffset)
            return result;
        return new ArrayList<>(result.subList(correctOffset, correctLimit + correctOffset));
    }

    private List<Song> reduceSongsWithLimitAndOffset(List<Song> artists, Integer correctLimit, Integer correctOffset) {
        List<Song> result = artists.stream().distinct().collect(Collectors.toList());
        if(result.size() <= correctOffset)
            return new ArrayList<>();
        if (result.size() < correctLimit + correctOffset)
            return result;
        return new ArrayList<>(result.subList(correctOffset, correctLimit + correctOffset));
    }

    @Override
    public Integer prepareLimit(Integer limitParam) {
        if (limitParam == null || limitParam < 0 || limitParam > MAX_SEARCH_RESULTS)
            return MAX_SEARCH_RESULTS;
        else
            return limitParam;
    }

    @Override
    public Integer prepareOffset(Integer offsetParam) {
        if (offsetParam == null || offsetParam < 0)
            return 0;
        else
            return offsetParam;
    }
}
