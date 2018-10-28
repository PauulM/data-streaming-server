package datastreaming.server.utils;

import datastreaming.server.dto.SearchDTO;

public interface SearchService {

    public SearchDTO searchEverything(String queryString);
}
