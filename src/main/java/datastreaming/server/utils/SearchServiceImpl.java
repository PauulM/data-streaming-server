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

    private final Integer MAX_SEARCH_RESULTS = 50;

    @Override
    public SearchDTO searchEverything(String queryString, Integer limit, Integer offset) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setArtists(artistService.searchArtistsByName(queryString, prepareLimit(limit), prepareOffset(offset)));
        searchDTO.setAlbums(albumService.searchAlbumsByName(queryString, prepareLimit(limit), prepareOffset(offset)));
        searchDTO.setSongs(songService.searchSongsByName(queryString, prepareLimit(limit), prepareOffset(offset)));
        return searchDTO;
    }

    @Override
    public Integer prepareLimit(Integer limitParam) {
        if(limitParam == null || limitParam < 0 || limitParam > MAX_SEARCH_RESULTS)
            return MAX_SEARCH_RESULTS;
        else
            return limitParam;
    }

    @Override
    public Integer prepareOffset(Integer offsetParam) {
        if(offsetParam == null || offsetParam < 0)
            return 0;
        else
            return offsetParam;
    }
}
