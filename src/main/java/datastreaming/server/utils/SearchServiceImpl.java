package datastreaming.server.utils;

import datastreaming.server.dto.SearchDTO;
import datastreaming.server.service._interface.AlbumService;
import datastreaming.server.service._interface.ArtistService;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SongService songService;

    @Override
    public SearchDTO searchEverything(String queryString) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setArtists(artistService.searchArtistsByName(queryString));
        searchDTO.setAlbums(albumService.searchAlbumsByName(queryString));
        searchDTO.setSongs(songService.searchSongsByName(queryString));
        return searchDTO;
    }
}
