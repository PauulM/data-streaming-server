package datastreaming.server.controller.search;

import datastreaming.server.dto.SearchDTO;
import datastreaming.server.dto.SearchLimitOffsetDTO;
import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.exception.ArtistNotFoundByIdException;
import datastreaming.server.utils.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public ResponseEntity<SearchDTO> searchEverything(@RequestParam(value = "query") String queryString,
                                                      @RequestBody(required = false) SearchLimitOffsetDTO searchLimitOffsetDTO)
    throws ArtistNotFoundByIdException, AlbumNotFoundByIdException {
        if (searchLimitOffsetDTO == null) {
            return ResponseEntity.status(200).body(searchService.searchEverything(queryString, new SearchLimitOffsetDTO()));
        }
        return ResponseEntity.status(200).body(searchService.searchEverything(queryString, searchLimitOffsetDTO));
    }
}
