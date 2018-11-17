package datastreaming.server.controller.search;

import datastreaming.server.dto.SearchDTO;
import datastreaming.server.utils.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public ResponseEntity<SearchDTO> searchEverything(@RequestParam(value = "query") String queryString,
                                                      @RequestParam(value = "limit", required = false) Integer limit,
                                                      @RequestParam(value = "offset", required = false) Integer offset){
        return ResponseEntity.status(200).body(searchService.searchEverything(queryString, limit, offset));
    }
}
